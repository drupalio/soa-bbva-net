package com.bbva.czic.customers.dao.tx;

import javax.annotation.Resource;

import com.bbva.czic.customers.facade.v01.impl.DTOIntCustomerFilter;
import org.springframework.stereotype.Component;

import com.bbva.czic.customers.business.dto.DTOIntCustomer;
import com.bbva.czic.customers.dao.mappers.ITxCustomerMapper;
import com.bbva.czic.customers.dao.model.oznb.FormatoOZNCENB0;
import com.bbva.czic.customers.dao.model.oznb.FormatoOZNCSNB0;
import com.bbva.czic.customers.dao.model.oznb.PeticionTransaccionOznb;
import com.bbva.czic.customers.dao.model.oznb.RespuestaTransaccionOznb;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.SimpleBbvaTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;


@Component("tx-get-customer")
public class TxGetCustomer extends
		SimpleBbvaTransaction<DTOIntCustomerFilter, FormatoOZNCENB0, DTOIntCustomer, FormatoOZNCSNB0> {

	@Resource(name="transaccionOznb")
	private transient InvocadorTransaccion<PeticionTransaccionOznb, RespuestaTransaccionOznb> transaccionOznb;

	@Resource(name = "txCustomerMapper")
	private ITxCustomerMapper txCustomerMapper;

	@Override
	protected FormatoOZNCENB0 mapDtoInToRequestFormat(DTOIntCustomerFilter customer) {
		return txCustomerMapper.mapInOznb(customer);
	}

	@Override
	protected DTOIntCustomer mapResponseFormatToDtoOut(FormatoOZNCSNB0 outFormat, DTOIntCustomerFilter customer) {
		return txCustomerMapper.mapOutOznb(outFormat);
	}

//	@Override
	protected InvocadorTransaccion<?, ?> getTransaction() {
		return transaccionOznb;
	}

}
