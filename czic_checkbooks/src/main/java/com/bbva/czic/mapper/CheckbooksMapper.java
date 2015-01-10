package com.bbva.czic.mapper;
import ma.glasnost.orika.MapperFactory;

import com.bbva.czic.core.stereotype.AbstractConfigurableMapper;
import com.bbva.czic.core.stereotype.Mapper;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheckbook;
import com.bbva.czic.checkbooks.dao.model.ozns.FormatoOZECNSE0;
import com.bbva.czic.checkbooks.dao.model.ozns.FormatoOZECNSS0;
import com.bbva.czic.dto.net.Checkbook;

@Mapper(value = "checkbookMapper")
public class CheckbooksMapper extends AbstractConfigurableMapper {

	@Override
	protected void configure(MapperFactory factory) {
		//***********************checkbooks entrada OZECNSE0******************************************

		factory.classMap(DTOIntCheckbook.class, FormatoOZECNSE0.class)
		.field("id", "numcheq")
		.byDefault().register();
		factory.classMap(Checkbook.class, DTOIntCheckbook.class)
		.field("id", "id")
		.byDefault().register();
		
		//************************checkbooks salida  OZECNSS0******************************************
		factory.classMap(DTOIntCheckbook.class, FormatoOZECNSS0.class)
		.field("fistCheck", "primchq")
		.field("lastCheckl", "ultichq")
		.field("totalCheck", "totachq")
		.field("requestDate", "fesemis")
		.field("deliveryDate", "fecentr")
		.field("actualState", "stachq")
		.byDefault().register();
		
		factory.classMap(Checkbook.class, DTOIntCheckbook.class)
		.field("firstCheck", "fistCheck")
		.field("lastCheckL", "lastCheckl")
		.field("totalCheck", "totalCheck")
		.field("requestDate", "requestDate")
		.field("deliveryDate", "deliveryDate")
		.field("actualState", "actualState")
		.field("checks", "checks")
		.byDefault().register();
		
		
		//***********************checks entrada OZECNYE0 **********************************/
		
		factory.classMap(DTOIntCheckbook.class, FormatoOZECNSE0.class)
		.field("id", "numcheq")
		.byDefault().register();
		factory.classMap(Checkbook.class, DTOIntCheckbook.class)
		.field("id", "id")
		.byDefault().register();
		
		
		//************************checks salida  OZECNSS0******************************************
				factory.classMap(DTOIntCheckbook.class, FormatoOZECNSS0.class)
				.field("issueDate", "fechemi")
				.field("value", "valchq")
				.field("status", "estchq")
				.field("modifiedDate", "fechmod")
				.byDefault().register();
				
				factory.classMap(Checkbook.class, DTOIntCheckbook.class)
				.field("issueDate", "issueDate")
				.field("value", "value")
				.field("status", "status")
				.field("modifiedDate", "modifiedDatez")
				.byDefault().register();;
	
	/*	DTOIntEnumCheckbookStatus 
       //***********************checks****************************************
		factory.classMap(DTOIntCheckbook.class, FormatoOZECNSE0.class).field("id", "numcheq")
		.field("fistCheck", "primchq").field("lastCheckl", "ultichq").field("totalCheck", "totachq")
		.field("requestDate", "fesemis").field("deliveryDate", "fecentr").field("actualState", "stachq").byDefault().register();
*/
	}

	/*public static void main(String... args) {
		DTOIntCheckbook dto = new DTOIntCheckbook();
		FormatoOZECNSE0 format = new FormatoOZECNSE0();
		dto.setId("1234");
		format.Numcheq("12345678765");

		FormatoOZECNSE0 result = new CheckbooksMapper().map(dto, FormatoOZECNSE0.class);

		DTOIntCheckbook result2 = new CheckbooksMapper().map(format, DTOIntCheckbook.class);

		System.out.println(result2.getId());

	}*/
}
