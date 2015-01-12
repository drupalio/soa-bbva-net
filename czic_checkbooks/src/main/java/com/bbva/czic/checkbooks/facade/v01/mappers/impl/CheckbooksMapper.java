package com.bbva.czic.checkbooks.facade.v01.mappers.impl;

import com.bbva.czic.checkbooks.business.dto.DTOIntCheck;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheckbook;
import com.bbva.czic.dto.net.Check;
import com.bbva.czic.dto.net.Checkbook;
import com.bbva.czic.checkbooks.facade.v01.mappers.ICheckbookMapper;
import org.springframework.stereotype.Component;

@Component(value = "checkbooks-mapper")
public class CheckbooksMapper implements ICheckbookMapper {

	@Override
	public Checkbook map(DTOIntCheckbook intCheckbook) {
		return null;
	}

	@Override
	public Check map(DTOIntCheck intCheck) {
		return null;
	}

/*
	@Override
	protected void configure(MapperFactory factory) {
		// checkbooks entrada OZECNSE0

		factory.classMap(DTOIntCheckbook.class, FormatoOZECNSE0.class)
				.field("id", "numcheq")
				.byDefault().register();
		factory.classMap(Checkbook.class, DTOIntCheckbook.class)
				.field("id", "id")
				.byDefault().register();

		// checkbooks salida  OZECNSS0
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


		// checks entrada OZECNYE0

		factory.classMap(DTOIntCheckbook.class, FormatoOZECNSE0.class)
				.field("id", "numcheq")
				.byDefault().register();
		factory.classMap(Checkbook.class, DTOIntCheckbook.class)
				.field("id", "id")
				.byDefault().register();


		// checks salida  OZECNSS0
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


		// checks
		factory.classMap(DTOIntCheckbook.class, FormatoOZECNSE0.class).field("id", "numcheq")
				.field("fistCheck", "primchq").field("lastCheckl", "ultichq").field("totalCheck", "totachq")
				.field("requestDate", "fesemis").field("deliveryDate", "fecentr").field("actualState", "stachq").byDefault().register();

	}
*/
}
