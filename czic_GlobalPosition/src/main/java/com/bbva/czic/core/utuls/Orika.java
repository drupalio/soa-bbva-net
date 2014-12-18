package com.bbva.czic.core.utuls;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class Orika {

	public Object mapperObject(Object obj, Class<?> objMapper) {

		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

		// Object object = mapperFactory.getMapperFacade().map(obj, objMapper.getClasses());
		return null;

	}
}
