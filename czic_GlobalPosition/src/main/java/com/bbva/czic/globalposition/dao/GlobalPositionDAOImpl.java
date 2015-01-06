package com.bbva.czic.globalposition.dao;

import com.bbva.czic.globalposition.business.dto.DTOIntFilterProduct;
import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.business.dto.DTOIntProducts;
import com.bbva.czic.routine.commons.rm.utils.tx.IPaginatedTransaction;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.ErrorMappingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GlobalPositionDAOImpl implements GlobalPositionDAO {

	@Autowired
	@Qualifier("tx-get-extract-global-balance")
	private IPaginatedTransaction txGetExtractGlobalBalance;

	@Autowired
	private ErrorMappingHelper errorMappingHelper;

	@Override
	public DTOIntProducts getExtractGlobalBalance(final DTOIntFilterProduct filterProduct) {
		return txGetExtractGlobalBalance.invoke(filterProduct);
	}

	@Override
	public DTOIntProducts getExtractGlobalBalanceNoTC(final DTOIntFilterProduct filterProduct) {
		return txGetExtractGlobalBalance.invoke(filterProduct);
	}

	@Override
	public void updateProductVisibility(final String idProduct, final Boolean visible) {

		/*
		PeticionTransaccionOzn0 peticion = new PeticionTransaccionOzn0();
		FormatoOZNCEOM0 formatoEntrada = new FormatoOZNCEOM0();

		formatoEntrada.setNumcta(idProduct);
		if (visible) {
			formatoEntrada.setIndcta(VISIBLE);
		} else {
			formatoEntrada.setIndcta(HIDDEN);
		}

		peticion.getCuerpo().getPartes().add(formatoEntrada);

		RespuestaTransaccionOzn0 respuesta = transaccionOzn0.invocar(peticion);

		BusinessServiceException businessServiceException = errorMappingHelper.toBusinessServiceException(respuesta);

		if (businessServiceException == null) {
			throw businessServiceException;
		}*/
	}

	@Override
	public void updateProductOperability(String idProduct, Boolean operable) {
/*
		PeticionTransaccionOzn0 peticion = new PeticionTransaccionOzn0();
		FormatoOZNCEOM0 formatoEntrada = new FormatoOZNCEOM0();

		formatoEntrada.setNumcta(idProduct);
		if (operable) {
			formatoEntrada.setIndcta();
		} else {
			formatoEntrada.setIndcta();
		}

		peticion.getCuerpo().getPartes().add(formatoEntrada);

		transaccionOzn0.invocar(peticion);
*/
	}

}
