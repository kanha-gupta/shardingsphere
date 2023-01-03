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

package org.apache.shardingsphere.sharding.route.engine.condition.engine.impl;

import java.util.List;

import org.apache.shardingsphere.infra.binder.statement.SQLStatementContext;
import org.apache.shardingsphere.infra.binder.statement.dml.InsertStatementContext;
import org.apache.shardingsphere.infra.metadata.database.ShardingSphereDatabase;
import org.apache.shardingsphere.sharding.route.engine.condition.ShardingCondition;
import org.apache.shardingsphere.sharding.route.engine.condition.engine.ShardingConditionEngine;
import org.apache.shardingsphere.sharding.rule.ShardingRule;

/**
 * Default implementation of the sharding condition engine.
 */
public final class DefaultShardingConditionEngine implements ShardingConditionEngine<SQLStatementContext<?>> {
    
    private ShardingRule shardingRule;
    
    private ShardingSphereDatabase database;
    
    @Override
    public void init(final ShardingRule shardingRule, final ShardingSphereDatabase database) {
        this.shardingRule = shardingRule;
        this.database = database;
    }
    
    @Override
    public List<ShardingCondition> createShardingConditions(final SQLStatementContext<?> sqlStatementContext, final List<Object> parameters) {
        if (sqlStatementContext instanceof InsertStatementContext) {
            return new InsertClauseShardingConditionEngine(shardingRule, database).createShardingConditions((InsertStatementContext) sqlStatementContext, parameters);
        }
        return new WhereClauseShardingConditionEngine(shardingRule, database).createShardingConditions(sqlStatementContext, parameters);
    }
}