package com.bbva.czic.movements.facade.v01.mapper.impl;

import com.bbva.czic.dto.net.*;
import com.bbva.czic.movements.business.dto.*;
import com.bbva.czic.movements.dao.model.oznl.FormatoOZECNLS0;
import com.bbva.czic.movements.dao.model.oznm.FormatoOZNCSNM0;
import com.bbva.czic.movements.facade.v01.mapper.IMovementsMapper;
import com.bbva.czic.routine.mapper.MapperFactory;
import com.bbva.czic.routine.mapper.factory.MoneyFactory;
import com.bbva.czic.routine.mapper.impl.ConfigurableMapper;
import com.bbva.czic.routine.mapper.metadata.TypeFactory;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;


@Component(value = "movements-mapper")
public class MovementsMapper extends ConfigurableMapper implements IMovementsMapper{

	@Override
	protected void configure(MapperFactory factory) {

		// Add ProductDTO Factory
		factory.registerObjectFactory(new MoneyFactory(), TypeFactory.<Money> valueOf(Money.class));

		// Movement
		factory.classMap(Movement.class, DTOIntMovement.class).field("id", "id").field("concept", "concept")
				.field("transactionDate", "transactionDate").field("operationDate", "operationDate").field("office", "office")
				.field("status", "status").field("value", "value").field("balance", "balance").byDefault().register();
		// Office
		factory.classMap(Office.class, DTOIntOffice.class).field("code", "code").field("name", "name").field("location", "dtoIntLocation").byDefault().register();

		// Location
		factory.classMap(Location.class, DTOIntLocation.class).field("city", "dtoIntCity").field("state", "dtoIntState").byDefault().register();

		// City
		factory.classMap(City.class, DTOIntCity.class).field("name", "name").byDefault().register();

		// State
		factory.classMap(State.class, DTOIntState.class).field("name", "name").byDefault().register();

		// Money
		factory.classMap(Money.class, Money.class).field("amount", "amount")
				.field("currency", "currency").byDefault().register();


/*factory.classMap(FormatoOZNCSNM0.class, DTOIntMovement.class).field("NUMECTA", "")
		.field("NOMOVIM", "id")
		.field("FCHOPER", "transactionDate")
		.field("RESTO", "")
		.field("VALOR", "")
		.field("BALOPER", "balance")
		.field("TIPO", "productType")
		.field("DESCODI", "")
		.field("FCHVALR", "operationDate")
		.field("PLAZA", "")
		.field("SALDO", "")
		.field("CTROORG", "")
		.field("PLAZA", "").byDefault().register();*/

		factory.classMap(FormatoOZECNLS0.class, DTOIntMovement.class).field("numoper", "id")
				.field("fechope", "transactionDate")
				.field("descopr", "operation.description")
				.field("valorop", "value")
				.field("balance", "balance")
				.field("resto", "concept")
				.field("tipoopr", "operation.code").byDefault().register();


	}

	@Override
	public Movement movementMap(DTOIntMovement dtoIntMovement) {
		return map(dtoIntMovement,Movement.class);
	}

	@Override
	public List<Movement> listMovementMap(List<DTOIntMovement> listDTOIntMovements){
		return mapAsList(listDTOIntMovements, Movement.class);
	}

	public DTOIntMovement mapOutGetMovement(FormatoOZNCSNM0 outFormat){
		return map(outFormat,DTOIntMovement.class);
	}
}

