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
package com.bbva.zic.routine.mapper.impl;

import com.bbva.zic.routine.mapper.MapperFactory;
import com.bbva.zic.routine.mapper.MappingContext;
import com.bbva.zic.routine.mapper.MappingContextFactory;

/**
 * @author matt.deboer@gmail.com
 * 
 */
public class NonCyclicBoundMapperFacade<A, B> extends DefaultBoundMapperFacade<A, B> {
    
    private static final class NonCyclicMappingContext extends MappingContext {
        
        public <S, D> void cacheMappedObject(S source, D destination) {
            // No-op
        }
        
        public <S, D> void cacheMappedObject(S source, java.lang.reflect.Type destinationType, D destination) {
            // No-op
        }
        
        public <S, D> boolean isAlreadyMapped(S source, java.lang.reflect.Type destinationType) {
            return false;
        }
        
        public <D> D getMappedObject(Object source, java.lang.reflect.Type destinationType) {
            return null;
        }
    }
    
    private final MappingContext nonCyclicContext;
    
    NonCyclicBoundMapperFacade(MapperFactory mapperFactory, MappingContextFactory contextFactory, java.lang.reflect.Type sourceType,
            java.lang.reflect.Type destinationType) {
        super(mapperFactory, contextFactory, sourceType, destinationType);
        this.nonCyclicContext = new NonCyclicMappingContext();
    }
    
    public B map(A source) {
        return super.map(source, nonCyclicContext);
    }
    
    public A mapReverse(B source) {
        return super.mapReverse(source, nonCyclicContext);
    }
    
    public void map(A source, B destination) {
        super.map(source, destination, nonCyclicContext);
    }
    
    public void mapReverse(B destination, A source) {
        super.mapReverse(destination, source, nonCyclicContext);
    }
}
