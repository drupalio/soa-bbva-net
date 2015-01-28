package com.bbva.czic.customers.dao.mapper.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.czic.customers.business.dto.DTOIntCustomer;
import com.bbva.czic.customers.dao.mapper.TxCustomerMapper;
import com.bbva.czic.customers.dao.model.oznb.FormatoOZNCENB0;
import com.bbva.czic.customers.dao.model.oznb.FormatoOZNCSNB0;
import com.bbva.czic.customers.dao.model.oznb.TransaccionOznb;
import com.bbva.czic.routine.commons.rm.utils.converter.StringMoneyConverter;
import com.bbva.czic.routine.mapper.MapperFactory;
import com.bbva.czic.routine.mapper.impl.ConfigurableMapper;

@Component("txCustomerMapper")
public class TxCustomerMapperImpl extends ConfigurableMapper implements
		TxCustomerMapper {

	@Override
	protected void configure(MapperFactory factory) {

		/**
		 * Convert HOST FORMAT (+EEEEEEEEDD) to COP Money
		 */
		factory.getConverterFactory().registerConverter(
				new StringMoneyConverter());

		/**
		 * MAPEO DE ENTRADAS
		 */
		// Map customerId <-> FormatoOZNCENB0 (OZNB)
		// factory.classMap(String.class,
		// FormatoOZNCENB0.class).field("customerId", "numprod").byDefault()
		// .register();

		/**
		 * MAPEO DE SALIDAS
		 */
		// Map FormatoOZECNBS0 <-> DTOIntCustomer (OZNB)
		factory.classMap(DTOIntCustomer.class, FormatoOZNCSNB0.class)
				.field("id", "numclie").field("name", "nomclie")
				/*.field("stratum", "estrato").field("residenceYears", "anosvda")
				.field("homeMembers", "nropnas")
				.field("lastConnectionTime", "ultconx")*/.byDefault().register();

	}

	@Override
	public FormatoOZNCENB0 mapInOznb(String customerId) {
		return map(customerId, FormatoOZNCENB0.class);
	}

	@Override
	public DTOIntCustomer mapOutOznb(FormatoOZNCSNB0 formatOutput) {
		return map(formatOutput, DTOIntCustomer.class);
	}

}
