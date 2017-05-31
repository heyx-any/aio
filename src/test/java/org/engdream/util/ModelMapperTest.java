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
package org.engdream.util;

import org.engdream.auth.entity.Resource;
import org.engdream.auth.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
/**
 * @author heyx
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ModelMapperTest {
    @Autowired
    private ModelMapper modelMapper;

    @Test
    public void mapperTest(){
        User user1 = User.builder().username("admin").build();
        User user2 = modelMapper.map(user1, User.class);
        modelMapper.validate();
        assertThat(user2.getUsername()).isEqualTo(user1.getUsername());

        Resource resource1 = Resource.builder().resource("resource").build();
        Resource resource2 = modelMapper.map(resource1, Resource.class);
        modelMapper.validate();
        assertThat(resource2.getResource()).isEqualTo(resource1.getResource());

    }
}
