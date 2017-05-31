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
package org.engdream.auth.web.controller;

import io.swagger.annotations.ApiOperation;
import org.engdream.auth.entity.User;
import org.engdream.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author heyx
 */
@RestController
@RequestMapping("api/v1/auth/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "get user by id")
    @GetMapping("/{userId}")
    public User getUser(@PathVariable Long userId){
        return userService.findById(userId);
    }

    @ApiOperation(value = "create user")
    @PostMapping
    public User createUser(User user){
        return userService.save(user);
    }
}
