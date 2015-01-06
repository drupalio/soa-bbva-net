package com.bbva.czic.globalposition.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class GlobalPositionMapper extends ConfigurableMapper {

	private static GlobalPositionMapper instance = null;

	public static GlobalPositionMapper getInstance() {
		if (instance == null) {
			instance = new GlobalPositionMapper();
		}
		return instance;
	}

	@Override
	protected void configure(MapperFactory factory) {

		/*
		factory.classMap(DTOIntProduct.class, FormatoOZNCSNI0.class).field("numeope", "id")
				.field("fechaop", "operationDate").field("resto", "concept").field("valorop", "value")
				.field("balance", "balance").field("tipope", "operation.description").byDefault().register();

		// Mapeo FormatoOZNCSNK0
		factory.classMap(DTOIntMovement.class, FormatoOZNCSNI0.class).field("fechao", "operationDate")
				.field("resto", "concept").field("importe", "value").field("balance", "balance")
				.field("descop", "destinationReference").field("estado", "status").byDefault().register();

		// Mapeo FormatoOZNCSNJ0
		factory.classMap(DTOIntMovement.class, FormatoOZNCSNI0.class)
				.field("nomprod", "id")
						// pendiente
				.field("tipprod", "productType").field("nomprod", "name").field("saldoto", "balance.balance")

				.field("saldodi", "balance.availableBalance").field("montoso", "debt.balance")
				.field("saldope", "debt.availableBalance").field("fechave", "payment.paymentDate")
				.field("fechapa", "payment.dueDate").field("fechaco", "payment.shortDate")
				.field("honorar", "payment.fees").field("numcout", "payment.numbersOfQuota")
				.field("estado", "payment.status").byDefault().register();
				*/
	}

	public Object getMapper(Object dtoEnt, Class<?> dtoSal) {

		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

		dtoSal = mapperFactory.getMapperFacade().map(dtoEnt, dtoSal.getClass());
		return dtoSal;
	}

}