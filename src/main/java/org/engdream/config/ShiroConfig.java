/*
 * Copyright (c) 2017 https://github.com/heyx-any
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *   
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.engdream.config;

import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.engdream.auth.shiro.filter.OAuth2AuthenticationFilter;
import org.engdream.auth.shiro.filter.mgt.CustomDefaultFilterChainManager;
import org.engdream.auth.shiro.filter.mgt.CustomPathMatchingFilterChainResolver;
import org.engdream.auth.shiro.realm.UserRealm;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author heyx
 */
@Configuration
public class ShiroConfig {
    @Bean
    public Realm realm() {
        return new UserRealm();
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
        daap.setProxyTargetClass(true);
        return daap;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager() {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(realm());
        return defaultWebSecurityManager;
    }

    @Bean
    public Filter getOAuth2Filter(){
        return new OAuth2AuthenticationFilter();
    }
/*
    @Bean("shiroFilterFactoryBean")
    public ShiroFilterFactoryBean getShiroFilterFactoryBean() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean
                .setSecurityManager(getDefaultWebSecurityManager());
        shiroFilterFactoryBean.setLoginUrl("/login");
        shiroFilterFactoryBean.setSuccessUrl("/index");
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");

        Map<String, Filter> filters = new HashMap<>();
        filters.put("oauth2", getOAuth2Filter());
        shiroFilterFactoryBean.setFilters(filters);

        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/manager*//**", "authc");
        filterChainDefinitionMap.put("*//**", "anon");
        shiroFilterFactoryBean
                .setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }*/

    @Bean("filterChainManager")
    public CustomDefaultFilterChainManager getCustomDefaultFilterChainManager() {
        CustomDefaultFilterChainManager filterChainManager = new CustomDefaultFilterChainManager();
        filterChainManager.setLoginUrl("/login");
        filterChainManager.setSuccessUrl("/");
        filterChainManager.setUnauthorizedUrl("/unauthorized");

        Map<String, Filter> filters = new HashMap<>();
        filters.put("oauth2", getOAuth2Filter());
        filterChainManager.setCustomFilters(filters);

        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/manager/**", "authc");
        filterChainDefinitionMap.put("/**", "anon");
        filterChainManager.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return filterChainManager;
    }

    @Bean("filterChainResolver")
    public PathMatchingFilterChainResolver getPathMatchingFilterChainResolver() {
        CustomPathMatchingFilterChainResolver filterChainResolver = new CustomPathMatchingFilterChainResolver();
        filterChainResolver.setCustomDefaultFilterChainManager(getCustomDefaultFilterChainManager());
        return filterChainResolver;
    }

    @Bean(name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

}
