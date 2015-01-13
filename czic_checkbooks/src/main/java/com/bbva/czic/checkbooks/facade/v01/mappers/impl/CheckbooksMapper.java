package com.bbva.czic.checkbooks.facade.v01.mappers.impl;

import com.bbva.czic.checkbooks.business.dto.DTOIntCheck;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheckbook;
import com.bbva.czic.dto.net.Check;
import com.bbva.czic.dto.net.Checkbook;
import com.bbva.czic.checkbooks.facade.v01.mappers.ICheckbookMapper;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component(value = "checkbooks-mapper")
public class CheckbooksMapper implements ICheckbookMapper {

	@Override
	public Check map(DTOIntCheck intCheck) {
		final Check check = new Check();

		check.setId(intCheck.getId());

		final Calendar issueDate = Calendar.getInstance();
		issueDate.setTime(intCheck.getIssueDate());
		check.setIssueDate(issueDate);
		check.setValue(intCheck.getValue());
		check.setStatus(intCheck.getStatus());

		final Calendar modifiedDate = Calendar.getInstance();
		modifiedDate.setTime(intCheck.getModifiedDate());
		check.setModifiedDate(modifiedDate);

		return check;
	}

	@Override
	public Checkbook map(DTOIntCheckbook intCheckbook) {
		final Checkbook checkbook = new Checkbook();

		checkbook.setId(intCheckbook.getId());
		checkbook.setFirstCheck(intCheckbook.getFirstCheck());
		checkbook.setLastCheck(intCheckbook.getLastCheck());
		checkbook.setTotalCheck(intCheckbook.getTotalCheck());

		final Calendar requestDate = Calendar.getInstance();
		requestDate.setTime(intCheckbook.getRequestDate());
		checkbook.setRequestDate(requestDate);

		final Calendar deliveryDate = Calendar.getInstance();
		deliveryDate.setTime(intCheckbook.getDeliveryDate());
		checkbook.setDeliveryDate(deliveryDate);

		checkbook.setActualState(intCheckbook.getActualState());

		return checkbook;
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
