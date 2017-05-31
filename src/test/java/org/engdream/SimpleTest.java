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
package org.engdream;

import org.engdream.auth.entity.User;
import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
/**
 * @author heyx
 */
public class SimpleTest {
    @Test
    public void test(){
        User user1 = User.builder().username("admin").build();
        user1.setId(1L);
        User user2 = User.builder().username("admin").build();
        user2.setId(2L);
        System.out.println(user1);
        assertThat(user1).isEqualTo(user2);
    }
}
