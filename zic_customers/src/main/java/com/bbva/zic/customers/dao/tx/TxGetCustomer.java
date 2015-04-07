package com.bbva.zic.customers.dao.tx;

import javax.annotation.Resource;

import com.bbva.zic.customers.business.dto.DTOIntCustomerFilter;
import com.bbva.zic.customers.business.dto.DTOIntCustomer;
import com.bbva.zic.customers.dao.mappers.ITxCustomerMapper;
import com.bbva.zic.customers.dao.model.oznb.RespuestaTransaccionOznb;
import org.springframework.stereotype.Component;

import com.bbva.zic.customers.dao.model.oznb.FormatoOZNCENB0;
import com.bbva.zic.customers.dao.model.oznb.FormatoOZNCSNB0;
import com.bbva.zic.customers.dao.model.oznb.PeticionTransaccionOznb;
import com.bbva.zic.routine.commons.rm.utils.tx.impl.SimpleBbvaTransaction;
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
