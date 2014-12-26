package com.bbva.czic.core.stereotype;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

public abstract class AbstractConfigurableMapper extends ConfigurableMapper {

	@Override
	protected abstract void configure(MapperFactory factory);

}
