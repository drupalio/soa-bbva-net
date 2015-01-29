package com.bbva.czic.customers.dao.mappers.impl;

import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResumesFilter;
import com.bbva.czic.customers.dao.model.oznq.FormatoOZECNQE0;
import com.bbva.czic.customers.dao.model.oznq.FormatoOZECNQS0;
import com.bbva.czic.routine.commons.rm.utils.mappers.AbstractBbvaTxConfigurableMapper;
import org.springframework.stereotype.Component;

import com.bbva.czic.customers.business.dto.DTOIntCustomer;
import com.bbva.czic.customers.dao.mappers.ITxCustomerMapper;
import com.bbva.czic.customers.dao.model.oznb.FormatoOZNCENB0;
import com.bbva.czic.customers.dao.model.oznb.FormatoOZNCSNB0;
import com.bbva.czic.routine.commons.rm.utils.converter.StringMoneyConverter;
import com.bbva.czic.routine.mapper.MapperFactory;
import com.bbva.czic.routine.mapper.impl.ConfigurableMapper;

@Component("txCustomerMapper")
public class TxCustomerMapper extends AbstractBbvaTxConfigurableMapper implements ITxCustomerMapper {

	@Override
	protected void configure(MapperFactory factory) {
		super.configure(factory);

		/**
		 * Convert HOST FORMAT (+EEEEEEEEDD) to COP Money
		 */
		factory.getConverterFactory().registerConverter(new StringMoneyConverter());

		/**
		 * MAPEO DE ENTRADAS
		 */
		// map customerId <-> FormatoOZNCENB0 (OZNB)
//		factory.classMap(String.class, FormatoOZNCENB0.class).field("customerId", "numprod").byDefault()
//				.register();

		/**
		 * MAPEO DE SALIDAS
		 */
		// map FormatoOZECNBS0 <-> DTOIntCustomer (OZNB)
		factory.classMap(DTOIntCustomer.class, FormatoOZNCSNB0.class)
				.field("id", "numclie")
				.field("name", "nomclie")
				.field("stratum", "estrato")
				.field("residenceYears", "anosvda")
				.field("homeMembers", "nropnas")
				.field("lastConnectionTime", "ultconx")
				.byDefault().register();

		// map DTOIntAccMovementsResumesFilter <-> FormatoOZECNQE0
		factory.classMap(DTOIntAccMovementsResumesFilter.class, FormatoOZECNQE0.class)
				.field("customerId", "idusuar")
				.field("startDate", "fechain")
				.field("endDate", "fechafi")
				.byDefault().register();

		// map FormatoOZECNQS0 <-> DTOIntAccMovementsResume
		factory.classMap(FormatoOZECNQS0.class, DTOIntAccMovementsResume.class)
				.field("valdepo", "income")
				.field("valcarg", "outcome")
				.field("saltota", "balance")
				.field("mes", "month")
				.byDefault().register();
	}
	
	@Override
	public FormatoOZNCENB0 mapInOznb(String customerId) {
		return map(customerId,FormatoOZNCENB0.class);
	}

	@Override
	public DTOIntCustomer mapOutOznb(FormatoOZNCSNB0 formatOutput) {
		return map(formatOutput,DTOIntCustomer.class);
	}

	@Override
	public FormatoOZECNQE0 mapInOznq(DTOIntAccMovementsResumesFilter accMovementsResumesFilter) {
		return map(accMovementsResumesFilter, FormatoOZECNQE0.class);
	}

	@Override
	public DTOIntAccMovementsResume mapOutOznq(FormatoOZECNQS0 formatoSalida) {
		return map(formatoSalida, DTOIntAccMovementsResume.class);
	}
}
