package com.bbva.czic.globalposition.dao.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.bbva.czic.globalposition.business.dto.DTOIntFilterProduct;
import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.business.dto.DTOIntProducts;
import com.bbva.czic.globalposition.dao.model.ozn1.FormatoOZECN1E0;
import com.bbva.czic.globalposition.dao.model.ozn1.FormatoOZECN1S1;
import com.bbva.czic.globalposition.dao.model.ozn1.PeticionTransaccionOzn1;
import com.bbva.czic.globalposition.dao.model.ozn1.RespuestaTransaccionOzn1;
import com.bbva.czic.globalposition.dao.model.ozn1.TransaccionOzn1;
import com.bbva.czic.routine.commons.rm.utils.tx.IFormatNotApply;
import com.bbva.czic.routine.commons.rm.utils.tx.IPaginatedTransactionMapper;
import com.bbva.czic.routine.commons.rm.utils.tx.impl.PaginatedTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;

/**
 * Created by Administrador on 05/01/2015.
 */
@Component("tx-get-extract-global-balance")
public class TxGetExtractGlobalBalance extends PaginatedTransaction<PeticionTransaccionOzn1, RespuestaTransaccionOzn1> {

	@Autowired
	private transient TransaccionOzn1 transaccionOzn1;

	@Autowired
	@Qualifier("tx-get-extract-global-balance-mapper-tc")
	private transient IPaginatedTransactionMapper<DTOIntFilterProduct, FormatoOZECN1E0, DTOIntProducts, IFormatNotApply, DTOIntProduct, FormatoOZECN1S1, IFormatNotApply> txGetExtractGlobalBalanceMapper;

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected InvocadorTransaccion<PeticionTransaccionOzn1, RespuestaTransaccionOzn1> getInvoker() {
		return transaccionOzn1;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	protected IPaginatedTransactionMapper<DTOIntFilterProduct, FormatoOZECN1E0, DTOIntProducts, IFormatNotApply, DTOIntProduct, FormatoOZECN1S1, IFormatNotApply> getMapper() {
		return txGetExtractGlobalBalanceMapper;
	}
}
