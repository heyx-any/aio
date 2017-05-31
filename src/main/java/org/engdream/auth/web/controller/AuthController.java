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

import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

/**
 * @author heyx
 */
@RestController
@RequestMapping
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<String> login(String username, String password){
        Assert.notNull(username, "username must not be null");
        Assert.notNull(password, "password must not be null");
        if("admin".equals(username) && "123456".equals(password)){
            return ResponseEntity.ok("success");
        }
        return ResponseEntity.ok("error");
    }

    @GetMapping("/authorize")
    public String authorize(){
        return "authorize";
    }

    @GetMapping("/unauthorized")
    public String unauthorized(){
        return "unauthorized";
    }
}
