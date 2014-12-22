package com.bbva.czic.mapper;

import ma.glasnost.orika.MapperFactory;

import com.bbva.czic.core.stereotype.AbstractConfigurableMapper;
import com.bbva.czic.core.stereotype.Mapper;
import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.dao.model.ozn1.FormatoOZECN1E0;

@Mapper(value = "globalPositionMapper")
public class GoblalPositionMapper extends AbstractConfigurableMapper {
	@Override
	protected void configure(MapperFactory factory) {

	}
	/*
	@Override
	protected void configure(MapperFactory factory) {

		factory.classMap(DTOIntProduct.class, FormatoOZECN1E0.class).field("productId", "numclie").field("", "")
				.byDefault().register();

		// factory.classMap(aType, bType)

	}

	public static void main(String... args) {
		DTOIntProduct dto = new DTOIntProduct();
		FormatoOZECN1E0 format = new FormatoOZECN1E0();
		dto.setId("1234");
		format.setNumclie("12345678765");

		FormatoOZECN1E0 result = new GoblalPositionMapper().map(dto, FormatoOZECN1E0.class);

		DTOIntProduct result2 = new GoblalPositionMapper().map(format, DTOIntProduct.class);

		System.out.println(result2.getProductId());

	}*/
}
