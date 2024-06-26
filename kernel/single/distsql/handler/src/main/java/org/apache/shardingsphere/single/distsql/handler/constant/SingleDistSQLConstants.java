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

package org.apache.shardingsphere.single.distsql.handler.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Single DistSQL constants.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SingleDistSQLConstants {
    
    public static final String COMMA = ", ";
    
    public static final String SEMI = ";";
    
    public static final String LOAD_SINGLE_TABLE = "LOAD SINGLE TABLE ";
    
    public static final String DATASOURCE_AND_TABLE = "%s.%s";
}
