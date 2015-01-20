package com.bbva.czic.movements.facade.v01.mapper.impl;

import com.bbva.czic.dto.net.*;
import com.bbva.czic.movements.business.dto.*;
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
		factory.classMap(City.class, DTOIntCity.class).field("id", "id").field("name", "name").byDefault().register();

		// State
		factory.classMap(State.class, DTOIntState.class).field("id", "id").field("name", "name").byDefault().register();

		// Money
		factory.classMap(Money.class, Money.class).field("amount", "amount")
				.field("currency", "currency").byDefault().register();


/*factory.classMap(FormatoOZNCSNM0.class, DTOIntMovement.class).field("NUMECTA", "")
		.field("NOMOVIM", "")
		.field("FCHOPER", "")
		.field("FCHVALR", "")
		.field("HRAOPER", "")
		.field("VALOR", "")
		.field("SALDO", "")
		.field("CHEQUE", "")
		.field("CODIGO", "")
		.field("DESCODI", "")
		.field("OBSERVA", "")
		.field("CTROORG", "")
		.field("PLAZA", "")
		.field("CTATRAS", "")
		.field("TIPO", "").byDefault().register();*/


		/*movements.id
		product.productType
		movements.concept
		movements.value
		movements.balance
		movements.operation.code
		movements.operation.description
		movements.transactionDate
		movements.operationDate
		movements.office.code
		movements.office.name
		movements.office.location.city.name
		movements.office.location.state.name
		movements.status*/

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

