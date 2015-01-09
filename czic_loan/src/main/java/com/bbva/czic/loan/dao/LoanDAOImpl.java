package com.bbva.czic.loan.dao;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.czic.dto.net.Balance;
import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.czic.dto.net.Payment;
import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.loan.business.dto.DTOIntMovement;
import com.bbva.czic.loan.dao.model.oznj.FormatoOZNCENJ0;
import com.bbva.czic.loan.dao.model.oznj.FormatoOZNCSNJ0;
import com.bbva.czic.loan.dao.model.oznj.PeticionTransaccionOznj;
import com.bbva.czic.loan.dao.model.oznj.RespuestaTransaccionOznj;
import com.bbva.czic.loan.dao.model.oznj.TransaccionOznj;
import com.bbva.czic.loan.dao.model.oznk.FormatoOZNCENK0;
import com.bbva.czic.loan.dao.model.oznk.FormatoOZNCSNK0;
import com.bbva.czic.loan.dao.model.oznk.PeticionTransaccionOznk;
import com.bbva.czic.loan.dao.model.oznk.RespuestaTransaccionOznk;
import com.bbva.czic.loan.dao.model.oznk.TransaccionOznk;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.ErrorMappingHelper;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;

@Component
public class LoanDAOImpl implements LoanDAO {

	@Autowired
	private ErrorMappingHelper errorMappingHelper;
	
	private static final String COP = "COP";

	@Override
	public DTOIntLoan getRotaryQuota(String idLoan)
			throws BusinessServiceException {

		DTOIntLoan dTOIntLoan = new DTOIntLoan();

		try {

			FormatoOZNCENJ0 formatoOZNCENJ0 = new FormatoOZNCENJ0();
			formatoOZNCENJ0.setNumprod(idLoan);
			PeticionTransaccionOznj peticion = new PeticionTransaccionOznj(); 
			peticion.getCuerpo().getPartes().add(formatoOZNCENJ0);
			RespuestaTransaccionOznj respuesta = new TransaccionOznj()
					.invocar(peticion);
			BusinessServiceException exception = errorMappingHelper
					.toBusinessServiceException(respuesta);
			if (exception != null)
				throw new BusinessServiceException("loanServergetRotaryQuota");
			CopySalida outputCopy = respuesta.getCuerpo().getParte(
					CopySalida.class);
			if (outputCopy != null) {

				FormatoOZNCSNJ0 formatoSalida = outputCopy
						.getCopy(FormatoOZNCSNJ0.class);
				if (formatoSalida != null) {
					//TODO mapear
				}
			}

		} catch (Exception e) {
		}
		return dTOIntLoan;

	}
}
