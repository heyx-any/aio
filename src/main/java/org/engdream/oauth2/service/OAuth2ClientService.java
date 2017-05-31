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
package org.engdream.oauth2.service;

import org.engdream.oauth2.entity.OAuth2Client;
import org.engdream.oauth2.repository.OAuth2ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author heyx
 */
@Service
public class OAuth2ClientService {
    @Autowired
    private OAuth2ClientRepository oAuth2ClientRepository;

    public OAuth2Client findByClientId(String clientId) {
        return oAuth2ClientRepository.findByClientId(clientId);
    }

    public OAuth2Client findByClientSecret(String clientSecret) {
        return oAuth2ClientRepository.findByClientSecret(clientSecret);
    }
}
