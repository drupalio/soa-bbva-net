package com.bbva.czic.loan.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.loan.business.impl.SrvIntLoan;
import com.bbva.czic.loan.dao.model.oznj.FormatoOZNCENJ0;
import com.bbva.czic.loan.dao.model.oznj.FormatoOZNCSNJ0;
import com.bbva.czic.loan.dao.model.oznj.PeticionTransaccionOznj;
import com.bbva.czic.loan.dao.model.oznj.RespuestaTransaccionOznj;
import com.bbva.czic.loan.dao.model.oznj.TransaccionOznj;
import com.bbva.czic.mapper.LoanMapper;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.ErrorMappingHelper;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

@Repository
public class LoanDAOImpl implements LoanDAO {
	
	private static I18nLog log = I18nLogFactory.getLogI18n(SrvIntLoan.class,
			"META-INF/spring/i18n/log/mensajesLog");

	@Autowired
	private ErrorMappingHelper errorMappingHelper;
	
	private static final String COP = "COP";

	@Override
	public DTOIntLoan getRotaryQuota(String idLoan)	throws BusinessServiceException {

		DTOIntLoan dTOIntLoan = new DTOIntLoan();

		log.info("LoanDAOImpl.getRotaryQuota = " + idLoan);

		try {

			FormatoOZNCENJ0 formatoOZNCENJ0 = new FormatoOZNCENJ0();
			formatoOZNCENJ0.setNumprod(idLoan);
			PeticionTransaccionOznj peticion = new PeticionTransaccionOznj(); 
			peticion.getCuerpo().getPartes().add(formatoOZNCENJ0);
			RespuestaTransaccionOznj respuesta = new TransaccionOznj().invocar(peticion);

			log.info("LoanDAOImpl.getRotaryQuota.respuesta = " + respuesta.getCodigoRetorno());

			BusinessServiceException exception = errorMappingHelper.toBusinessServiceException(respuesta);
			
			if (exception != null)
				throw new BusinessServiceException("loanServergetRotaryQuota");
			
			CopySalida outputCopy = respuesta.getCuerpo().getParte(CopySalida.class);
			if (outputCopy != null) {

				FormatoOZNCSNJ0 formatoSalida = outputCopy.getCopy(FormatoOZNCSNJ0.class);
				if (formatoSalida != null) {
					dTOIntLoan = LoanMapper.dtoIntLoanMapper(formatoSalida);
				}
			}

		} catch (BusinessServiceException bse) {
			log.error("BusinessServiceException > An error happened while calling transaction ", bse);
			throw bse;
		} catch (Exception e) {
			log.error("Exception > An error happened while calling transaction ",e);
			throw new BusinessServiceException(EnumError.TECHNICAL_ERROR.getAlias(), e);
		}
		return dTOIntLoan;

	}
}
