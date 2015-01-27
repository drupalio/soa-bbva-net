package com.bbva.czic.customers.dao.tx;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.czic.customers.business.dto.DTOIntCustomer;
import com.bbva.czic.customers.dao.mapper.TxCustomerMapper;
import com.bbva.czic.customers.dao.model.oznb.FormatoOZNCENB0;
import com.bbva.czic.customers.dao.model.oznb.FormatoOZNCSNB0;
import com.bbva.czic.customers.dao.model.oznb.TransaccionOznb;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.SimpleBbvaTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;


@Component("tx-get-customer")
public class TxGetCustomer extends
		SimpleBbvaTransaction<String, FormatoOZNCENB0, DTOIntCustomer, FormatoOZNCSNB0> {

	@Autowired
	private TransaccionOznb transaccionOznb;

	@Resource(name = "txAccountMapper")
	private TxCustomerMapper txAccountMapper;

	@Override
	protected FormatoOZNCENB0 mapDtoInToRequestFormat(String customerId) {
		return txAccountMapper.mapInOznb(customerId);
	}

	@Override
	protected DTOIntCustomer mapResponseFormatToDtoOut(FormatoOZNCSNB0 outFormat, String customerId) {
		return txAccountMapper.mapOutOznb(outFormat);
	}

	@Override
	protected InvocadorTransaccion<?, ?> getTransaction() {
		return transaccionOznb;
	}

}
