package com.bbva.czic.customers.dao.tx;

import javax.annotation.Resource;

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
		SimpleBbvaTransaction<String, FormatoOZNCENB0, DTOIntCustomer, FormatoOZNCSNB0> {

	@Resource(name="transaccionOznb")
	private transient InvocadorTransaccion<PeticionTransaccionOznb, RespuestaTransaccionOznb> transaccionOznb;
//	
//	@Resource(name="transaccionOznb")
//	private TransaccionOznb transaccionOznb;

	@Resource(name = "txCustomerMapper")
	private ITxCustomerMapper txCustomerMapper;

	@Override
	protected FormatoOZNCENB0 mapDtoInToRequestFormat(String customerId) {
		FormatoOZNCENB0 formato = new FormatoOZNCENB0();
		formato.setNumclie(customerId);
		return formato;
	}

	@Override
	protected DTOIntCustomer mapResponseFormatToDtoOut(FormatoOZNCSNB0 outFormat, String customerId) {
		return txCustomerMapper.mapOutOznb(outFormat);
	}

//	@Override
	protected InvocadorTransaccion<?, ?> getTransaction() {
		return transaccionOznb;
	}

}
