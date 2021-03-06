/*
 * Orika - simpler, better and faster Java bean mapping
 * 
 * Copyright (C) 2011 Orika authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bbva.czic.routine.mapper.impl.mapping.strategy;

import com.bbva.czic.routine.mapper.MappingContext;
import com.bbva.czic.routine.mapper.ObjectFactory;
import com.bbva.czic.routine.mapper.metadata.Type;
import com.bbva.czic.routine.mapper.unenhance.UnenhanceStrategy;

public class InstantiateAndUseCustomMapperStrategy extends UseCustomMapperStrategy {
    
	protected final ObjectFactory<Object> objectFactory;
    
    public InstantiateAndUseCustomMapperStrategy(Type<Object> sourceType, Type<Object> destinationType, DirectionalCustomMapperReference customMapper, ObjectFactory<Object> objectFactory, UnenhanceStrategy unenhancer) {
    	super(sourceType, destinationType, customMapper, unenhancer);
        this.objectFactory = objectFactory;
    }

    protected Object getInstance(Object sourceObject, Object destinationObject, MappingContext context) {
    	return objectFactory.create(sourceObject, context);
    }
}
