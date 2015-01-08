package com.bbva.czic.accounts.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.bbva.czic.accounts.business.dto.DTOIntAccount;
import com.bbva.czic.accounts.business.dto.DTOIntMovement;
import com.bbva.czic.accounts.dao.model.oznu.FormatoOZECNUE0;
import com.bbva.czic.accounts.dao.model.oznu.PeticionTransaccionOznu;
import com.bbva.czic.accounts.dao.model.oznu.RespuestaTransaccionOznu;
import com.bbva.czic.accounts.dao.model.oznu.TransaccionOznu;
import com.bbva.czic.accounts.dao.model.oznv.FormatoOZECNVE0;
import com.bbva.czic.accounts.dao.model.oznv.FormatoOZECNVS0;
import com.bbva.czic.accounts.dao.model.oznv.PeticionTransaccionOznv;
import com.bbva.czic.accounts.dao.model.oznv.RespuestaTransaccionOznv;
import com.bbva.czic.accounts.dao.model.oznv.TransaccionOznv;
import com.bbva.czic.mapper.*;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.ErrorMappingHelper;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

public abstract class AccountsDAOImpl<AccountMapper> implements AccountsDAO {

	@Autowired
	private ErrorMappingHelper errorMappingHelper;

	@Resource(name = "accountsMapper")
	private AccountMapper accountsMapper;

	// Inicio evolucion de un saldo de cuenta - Movs getAccountMonthlyBalance //
	@Override
	public DTOIntAccount getAccountMonthlyBalance(String id, Date startMonth,
			Date endMonth) throws BusinessServiceException {

		DTOIntAccount dtoIntAccount = new DTOIntAccount();
		List<DTOIntAccount> accountList = new ArrayList<DTOIntAccount>();

		try {

			FormatoOZECNVE0 formatoOZECNVE0 = new FormatoOZECNVE0();

			PeticionTransaccionOznv peticion = new PeticionTransaccionOznv();

			peticion.getCuerpo().getPartes().add(peticion);

			RespuestaTransaccionOznv respuesta = new TransaccionOznv()
					.invocar(peticion);

			BusinessServiceException exception = errorMappingHelper
					.toBusinessServiceException(respuesta);
			if (exception != null)
				throw new BusinessServiceException("wrongParameters");

			CopySalida outputCopy = respuesta.getCuerpo().getParte(
					CopySalida.class);
			if (outputCopy != null) {

				FormatoOZECNVE0 formatoSalida = outputCopy
						.getCopy(FormatoOZECNVE0.class);
				if (formatoSalida != null) {

					//dtoIntAccount = accountsMapper().map(formatoSalida,DTOIntAccount.class);
				}
			}
		} catch (Exception e) {
		}
		return dtoIntAccount;
	}
	// Fin evolucion de un saldo de cuenta - Movs getAccountMonthlyBalance //

	// Inicio listado de resumenes de balance de la cuenta por mes - Movs
	// getAccMovementResume //
	@Override
	public DTOIntAccount getAccMovementResume(String id, Date startMonth,
			Date endMonth) throws BusinessServiceException {

		DTOIntAccount dtoIntAccount = new DTOIntAccount();
		List<DTOIntAccount> accountList = new ArrayList<DTOIntAccount>();

		try {

			FormatoOZECNUE0 formatoOZECNUE0 = new FormatoOZECNUE0();

			PeticionTransaccionOznu peticion = new PeticionTransaccionOznu();

			peticion.getCuerpo().getPartes().add(peticion);

			RespuestaTransaccionOznu respuesta = new TransaccionOznu()
					.invocar(peticion);

			BusinessServiceException exception = errorMappingHelper
					.toBusinessServiceException(respuesta);
			if (exception != null)
				throw new BusinessServiceException("wrongParameters");

			CopySalida outputCopy = respuesta.getCuerpo().getParte(
					CopySalida.class);
			if (outputCopy != null) {

				FormatoOZECNUE0 formatoSalida = outputCopy
						.getCopy(FormatoOZECNUE0.class);
				if (formatoSalida != null) {

					// dtoIntAccount = accountsMapper.map(formatoSalida,DTOIntAccount.class);
				}
			}
		} catch (Exception e) {
		}
		return dtoIntAccount;
	}
	// Fin listado de resumenes de balance de la cuenta por mes - Movs
	// getAccMovementResume //

}
