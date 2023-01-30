/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.authority.checker;

import lombok.RequiredArgsConstructor;
import org.apache.shardingsphere.authority.rule.AuthorityRule;
import org.apache.shardingsphere.infra.metadata.user.Grantee;

import java.util.function.BiPredicate;

/**
 * Authentication checker.
 */
@RequiredArgsConstructor
public final class AuthenticationChecker {
    
    private final AuthorityRule rule;
    
    private final Grantee grantee;
    
    /**
     * Check Authentication with cipher.
     *
     * @param validator validator
     * @param cipher cipher
     * @return authenticated or not
     */
    public boolean isAuthenticated(final BiPredicate<Object, Object> validator, final Object cipher) {
        return rule.findUser(grantee).filter(optional -> validator.test(optional, cipher)).isPresent();
    }
}
