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
package org.engdream.auth.service;

import org.engdream.auth.entity.UrlFilter;
import org.engdream.auth.repository.UrlFilterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author heyx
 */
@Service
public class UrlFilterService {
    @Autowired
    private UrlFilterRepository urlFilterRepository;

    @Autowired
    private ShiroFilerChainManager shiroFilerChainManager;

    public UrlFilter createUrlFilter(UrlFilter urlFilter) {
        urlFilterRepository.save(urlFilter);
        initFilterChain();
        return urlFilter;
    }

    public UrlFilter updateUrlFilter(UrlFilter urlFilter) {
        urlFilterRepository.save(urlFilter);
        initFilterChain();
        return urlFilter;
    }

    public void deleteUrlFilter(Long urlFilterId) {
        urlFilterRepository.delete(urlFilterId);
        initFilterChain();
    }

    public UrlFilter findOne(Long urlFilterId) {
        return urlFilterRepository.findOne(urlFilterId);
    }

    public List<UrlFilter> findAll() {
        return urlFilterRepository.findAll();
    }

    @PostConstruct
    public void initFilterChain() {
        shiroFilerChainManager.initFilterChains(findAll());
    }

}
