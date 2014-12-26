package com.bbva.czic.loan.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.loan.dao.model.ozni.FormatoOZNCENI0;
import com.bbva.czic.loan.dao.model.ozni.FormatoOZNCSNI0;
import com.bbva.czic.loan.dao.model.ozni.PeticionTransaccionOzni;
import com.bbva.czic.loan.dao.model.ozni.RespuestaTransaccionOzni;
import com.bbva.czic.loan.dao.model.ozni.TransaccionOzni;
import com.bbva.czic.loan.dao.model.oznj.FormatoOZNCENJ0;
import com.bbva.czic.loan.dao.model.oznj.FormatoOZNCSNJ0;
import com.bbva.czic.loan.dao.model.oznj.PeticionTransaccionOznj;
import com.bbva.czic.loan.dao.model.oznj.RespuestaTransaccionOznj;
import com.bbva.czic.loan.dao.model.oznj.TransaccionOznj;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.ErrorMappingHelper;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

public class LoanDAOImpl implements LoanDAO {

	@Autowired
	private ErrorMappingHelper errorMappingHelper;

	@Override
	public List<DTOIntLoan> listRotaryQuotaMovements(Date starDate, Date endDate, String paginationKey,
			Integer pageSize, String idLoan) throws BusinessServiceException {

		DTOIntLoan dtoIntLoan = new DTOIntLoan();
		List<DTOIntLoan> loanDtoList = new ArrayList<DTOIntLoan>();

		try {
			FormatoOZNCENI0 formatoOZNCENI0 = new FormatoOZNCENI0();

			formatoOZNCENI0.setFechini(starDate);
			formatoOZNCENI0.setFechafi(endDate);
			formatoOZNCENI0.setIndpag(paginationKey);
			formatoOZNCENI0.setNotarje(idLoan);
			PeticionTransaccionOzni peticion = new PeticionTransaccionOzni();

			peticion.getCuerpo().getPartes().add(formatoOZNCENI0);
			RespuestaTransaccionOzni respuesta = new TransaccionOzni().invocar(peticion);

			BusinessServiceException exception = errorMappingHelper.toBusinessServiceException(respuesta);
			if (exception != null) throw new BusinessServiceException("loanTransactionHost");

			CopySalida outputCopy = respuesta.getCuerpo().getParte(CopySalida.class);
			if (outputCopy != null) {

				FormatoOZNCSNI0 formatoSalida = outputCopy.getCopy(FormatoOZNCSNI0.class);
				if (formatoSalida != null) {
				}
			}
		} catch (Exception e) {
		}
		return loanDtoList;
	}

	@Override
	public DTOIntLoan getRotaryQuota(String idLoan) throws BusinessServiceException {

		DTOIntLoan dTOIntLoan = new DTOIntLoan();

		try {
			FormatoOZNCENJ0 formatoOZNCENJ0 = new FormatoOZNCENJ0();

			formatoOZNCENJ0.setNoopera(idLoan);

			PeticionTransaccionOznj peticion = new PeticionTransaccionOznj();

			peticion.getCuerpo().getPartes().add(formatoOZNCENJ0);
			RespuestaTransaccionOznj respuesta = new TransaccionOznj().invocar(peticion);

			BusinessServiceException exception = errorMappingHelper.toBusinessServiceException(respuesta);
			if (exception != null) throw new BusinessServiceException("loanTransactionHost");

			CopySalida outputCopy = respuesta.getCuerpo().getParte(CopySalida.class);
			if (outputCopy != null) {

				FormatoOZNCSNJ0 formatoSalida = outputCopy.getCopy(FormatoOZNCSNJ0.class);
				if (formatoSalida != null) {

					// variable con la respuesta formatoSalida

				}
			}
		} catch (Exception e) {
		}
		return dTOIntLoan;

	}
}
