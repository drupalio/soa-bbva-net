package com.bbva.czic.movements.facade.v01.mapper.impl;

import com.bbva.czic.dto.net.*;
import com.bbva.czic.movements.business.dto.*;
import com.bbva.czic.movements.facade.v01.mapper.IMovementsMapper;
import com.bbva.czic.routine.mapper.MapperFactory;
import com.bbva.czic.routine.mapper.factory.MoneyFactory;
import com.bbva.czic.routine.mapper.impl.ConfigurableMapper;
import com.bbva.czic.routine.mapper.metadata.TypeFactory;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;


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
		// CONTRACT
		factory.classMap(Office.class, DTOIntOffice.class).field("number", "number").byDefault().register();

		// BALANCE
		factory.classMap(Money.class, Money.class).field("amount", "amount")
				.field("currency", "currency").byDefault().register();
	}

	@Override
	public Movement movementMap(DTOIntMovement dtoIntMovement) {
		return null;
	}

}

