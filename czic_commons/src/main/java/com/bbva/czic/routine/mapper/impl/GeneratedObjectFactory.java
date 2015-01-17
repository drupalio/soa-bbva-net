package com.bbva.czic.routine.mapper.impl;

import com.bbva.czic.routine.mapper.BoundMapperFacade;
import com.bbva.czic.routine.mapper.Converter;
import com.bbva.czic.routine.mapper.MapperFacade;
import com.bbva.czic.routine.mapper.ObjectFactory;
import com.bbva.czic.routine.mapper.metadata.Type;

public abstract class GeneratedObjectFactory implements ObjectFactory<Object> {
    protected MapperFacade mapperFacade;
    protected Type<Object>[] usedTypes;
    protected Converter<Object,Object>[] usedConverters;
    protected BoundMapperFacade<Object, Object>[] usedMapperFacades;
    
    public void setMapperFacade(MapperFacade mapperFacade) {
        this.mapperFacade = mapperFacade;
    }
    
    public void setUsedTypes(Type<Object>[] usedTypes) {
        this.usedTypes = usedTypes;
    }
    
    public void setUsedConverters(Converter<Object,Object>[] usedConverters) {
    	this.usedConverters = usedConverters;
    }
    
    public void setUsedMapperFacades(BoundMapperFacade<Object, Object>[] usedMapperFacades) {
        this.usedMapperFacades = usedMapperFacades;
    }
}
