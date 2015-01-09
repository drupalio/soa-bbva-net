package com.bbva.czic.accounts.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.bbva.czic.accounts.business.dto.DTOIntAccount;
import com.bbva.czic.accounts.dao.model.ozna.FormatoOZNCENA0;
import com.bbva.czic.accounts.dao.model.ozna.FormatoOZNCSNA0;
import com.bbva.czic.accounts.dao.model.ozna.PeticionTransaccionOzna;
import com.bbva.czic.accounts.dao.model.ozna.RespuestaTransaccionOzna;
import com.bbva.czic.accounts.dao.model.ozna.TransaccionOzna;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.ErrorMappingHelper;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

public class AccountsDAOImpl implements AccountsDAO {

	@Autowired
	private ErrorMappingHelper errorMappingHelper;

	@Override
	public DTOIntAccount getAccountMonthlyBalance(String id, Date startMonth, Date endMonth) throws BusinessServiceException {

		DTOIntAccount dtoIntAccount = new DTOIntAccount();
		List<DTOIntAccount> accountList = new ArrayList<DTOIntAccount>();

		try {

			FormatoOZECNVE0 formatoOZECNVE0 = new FormatoOZECNVE0();

			PeticionTransaccionOznv peticion = new PeticionTransaccionOznv();

			peticion.getCuerpo().getPartes().add(peticion);

			RespuestaTransaccionOznv respuesta = new TransaccionOznv().invocar(peticion);

			BusinessServiceException exception = errorMappingHelper.toBusinessServiceException(respuesta);
			if (exception != null)
				throw new BusinessServiceException("wrongParameters");

			CopySalida outputCopy = respuesta.getCuerpo().getParte(CopySalida.class);
			if (outputCopy != null) {

				FormatoOZECNVE0 formatoSalida = outputCopy.getCopy(FormatoOZECNVE0.class);
				if (formatoSalida != null) {

					// dtoIntAccount =
					// accountsMapper().map(formatoSalida,DTOIntAccount.class);
				}
			}
		} catch (Exception e) {
		}
		return dtoIntAccount;
	}

	@Override
	public DTOIntAccount getAccMovementResume(String id, Date startMonth, Date endMonth) throws BusinessServiceException {

		DTOIntAccount dtoIntAccount = new DTOIntAccount();
		List<DTOIntAccount> accountList = new ArrayList<DTOIntAccount>();

		try {

			FormatoOZECNUE0 formatoOZECNUE0 = new FormatoOZECNUE0();

			PeticionTransaccionOznu peticion = new PeticionTransaccionOznu();

			peticion.getCuerpo().getPartes().add(peticion);

			RespuestaTransaccionOznu respuesta = new TransaccionOznu().invocar(peticion);

			BusinessServiceException exception = errorMappingHelper.toBusinessServiceException(respuesta);
			if (exception != null)
				throw new BusinessServiceException("wrongParameters");

			CopySalida outputCopy = respuesta.getCuerpo().getParte(CopySalida.class);
			if (outputCopy != null) {

				FormatoOZECNUE0 formatoSalida = outputCopy.getCopy(FormatoOZECNUE0.class);
				if (formatoSalida != null) {

					// dtoIntAccount =
					// accountsMapper.map(formatoSalida,DTOIntAccount.class);
				}
			}
		} catch (Exception e) {
		}
		return dtoIntAccount;
	}

	@Override
	public DTOIntAccount getAccount(String accountId) throws BusinessServiceException {

		DTOIntAccount account = new DTOIntAccount();

		try {

			FormatoOZNCENA0 formatoEntrada = new FormatoOZNCENA0();
			PeticionTransaccionOzna peticion = new PeticionTransaccionOzna();
			peticion.getCuerpo().getParte(FormatoOZNCSNA0.class);
			RespuestaTransaccionOzna respuesta = new TransaccionOzna().invocar(peticion);
			BusinessServiceException exception = errorMappingHelper.toBusinessServiceException(respuesta);
			if (exception != null)
				throw new BusinessServiceException("getAccount");
			CopySalida outputCopy = respuesta.getCuerpo().getParte(CopySalida.class);
			if (outputCopy != null) {
				FormatoOZNCSNA0 formatoSalida = outputCopy.getCopy(FormatoOZNCSNA0.class);
				// Mapeamos

			}

		} catch (Exception e) {
		}
		return account;
	}
}
