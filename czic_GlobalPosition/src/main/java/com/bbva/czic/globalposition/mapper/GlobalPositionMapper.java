package com.bbva.czic.globalposition.mapper;

import com.bbva.czic.core.stereotype.AbstractConfigurableMapper;
import com.bbva.czic.core.stereotype.Mapper;
import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.dao.model.ozn1.FormatoOZECN1E0;
import ma.glasnost.orika.MapperFactory;

@Mapper(value = "globalPositionMapper")
public class GlobalPositionMapper extends AbstractConfigurableMapper {

	@Override
	protected void configure(MapperFactory factory) {

		factory.classMap(DTOIntProduct.class, FormatoOZECN1E0.class)
				.fieldAToB("productId", "numclie").field("", "")
				.byDefault().register();

		// factory.classMap(aType, bType)

	}


}
