package com.bbva.czic.globalposition.utils;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class OrikaMapper {

	public Object getMapperObject(Object obj, Class<?> objMapper) {

		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

		objMapper = (Class<?>)mapperFactory.getMapperFacade().map(obj, objMapper);
		return objMapper;
	}
}
