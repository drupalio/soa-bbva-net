package com.bbva.czic.loan.dao;


import com.bbva.czic.loan.business.dto.DTOIntMovement;
import com.bbva.czic.loan.business.dto.DTOIntRotaryQuotaMove;
import com.bbva.czic.loan.dao.model.ozni.*;
import com.bbva.czic.loan.dao.model.oznk.*;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.loan.business.impl.SrvIntLoan;
import com.bbva.czic.loan.dao.model.oznj.FormatoOZNCENJ0;
import com.bbva.czic.loan.dao.model.oznj.FormatoOZNCSNJ0;
import com.bbva.czic.loan.dao.model.oznj.PeticionTransaccionOznj;
import com.bbva.czic.loan.dao.model.oznj.RespuestaTransaccionOznj;
import com.bbva.czic.loan.dao.model.oznj.TransaccionOznj;
import com.bbva.czic.loan.dao.mapper.LoanMapper;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.ErrorMappingHelper;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository(value = "loanDao")
public class LoanDAOImpl implements LoanDAO {
	
	private static I18nLog log = I18nLogFactory.getLogI18n(SrvIntLoan.class,
			"META-INF/spring/i18n/log/mensajesLog");

	@Autowired
	private ErrorMappingHelper errorMappingHelper;

	@Autowired
	private TransaccionOznj transaccionOznj;

	@Autowired
	private TransaccionOzni transaccionOzni;

	@Autowired
	private TransaccionOznk transaccionOznk;

	@Override
	public DTOIntLoan getRotaryQuota(final String idLoan)	throws BusinessServiceException {

		 DTOIntLoan dTOIntLoan = new DTOIntLoan();

		log.info("LoanDAOImpl.getRotaryQuota = " + idLoan);

		try {

			FormatoOZNCENJ0 formatoOZNCENJ0 = new FormatoOZNCENJ0();
			formatoOZNCENJ0.setNomtarj(idLoan);

			PeticionTransaccionOznj peticion = new PeticionTransaccionOznj();

			peticion.getCuerpo().getPartes().add(formatoOZNCENJ0);
			log.info("LoanDAOImpl.getRotaryQuota.invocar ");
			RespuestaTransaccionOznj respuesta = transaccionOznj.invocar(peticion);

			log.info("LoanDAOImpl.getRotaryQuota.respuesta = " + respuesta.getCodigoRetorno());

			BusinessServiceException exception = errorMappingHelper.toBusinessServiceException(respuesta);

			if (exception != null) {
				log.info("LoanDAOImpl.getRotaryQuota transaccion Exception = " + exception.getMessage());
				throw exception;
			}
			final CopySalida outputCopy = respuesta.getCuerpo().getParte(CopySalida.class);
			if (outputCopy != null) {
				final FormatoOZNCSNJ0 formatoSalida = outputCopy.getCopy(FormatoOZNCSNJ0.class);
				log.info("iniciando mapeo formatoSalida.... 1 of 2");

				dTOIntLoan = LoanMapper.dtoIntLoanMapper(formatoSalida);

			}else {
				throw new BusinessServiceException(EnumError.NO_DATA.getAlias());
			}
			log.info("LoanDAOImpl.getRotaryQuota.respuesta --- fin");

			return dTOIntLoan;
		} catch (BusinessServiceException bse) {
			log.error("BusinessServiceException > An error happened while calling transaction = " + bse.getMessage());
			throw bse;
		} catch (Exception e) {
			log.error("Exception > An error happened while calling transaction = " + e.getMessage());
			throw new BusinessServiceException(EnumError.TECHNICAL_ERROR.getAlias());
		}
	}

	@Override
	public List<DTOIntMovement> listRotaryQuotaMovements(final String idLoan, final String paginationKey, final String pageSize,
														final Date fechaInicial, Date fechaFinal) throws BusinessServiceException {

		log.info("ingreso LoanDAOImpl.listRotaryQuotaMovements");

		List<DTOIntMovement> movementList = new ArrayList<DTOIntMovement>();

		try {
		log.info("ingreso preInvocar LoanDAOImpl.listRotaryQuotaMovements.filters = " + idLoan + ", " + fechaInicial + ", " + fechaFinal + ", " + paginationKey + ", " + pageSize);

			FormatoOZNCENI0 formatoOZNCENI0 = new FormatoOZNCENI0();
			formatoOZNCENI0.setFechini(fechaInicial);
			formatoOZNCENI0.setFechafi(fechaFinal);
			formatoOZNCENI0.setIndpag(paginationKey);
			formatoOZNCENI0.setNotarje(idLoan);

			PeticionTransaccionOzni peticion = new PeticionTransaccionOzni();

			peticion.getCuerpo().getPartes().add(formatoOZNCENI0);
			log.info("ingreso preInvocar LoanDAOImpl.listRotaryQuotaMovements");

			RespuestaTransaccionOzni respuesta = transaccionOzni.invocar(peticion);

			log.info("Fin preInvocar LoanDAOImpl.listRotaryQuotaMovements");
			BusinessServiceException exception = errorMappingHelper.toBusinessServiceException(respuesta);

			if (exception != null) {
				log.info("fin preInvocar LoanDAOImpl.getRotaryQuotaMovement.Exception" + exception.getErrorMessage());
				throw exception;
			}

			final List<CopySalida> outputCopyList = respuesta.getCuerpo().getPartes(CopySalida.class);

			if(CollectionUtils.isEmpty(outputCopyList)) {
				throw new BusinessServiceException(EnumError.NO_DATA.getAlias());
			}
			log.info("LoanDAOImpl.listRotaryQuotaMovements.list = " + outputCopyList.size());

			for (CopySalida item : outputCopyList) {
				DTOIntMovement movement = new DTOIntMovement();

		       	FormatoOZNCSNI0 formatoSalida = item.getCopy(FormatoOZNCSNI0.class);
			   	movement = LoanMapper.getDTOIntMovementByCopy(formatoSalida);

			  	movementList.add(movement);
			}
			return movementList;
		} catch (BusinessServiceException bex) {
			log.error("fin preInvocar LoanDAOImpl.getRotaryQuotaMovement.BusinesServiceException" + bex.getMessage());
			throw bex;
		} catch (Exception ex) {
			log.error("fin preInvocar LoanDAOImpl.getRotaryQuotaMovement.Exception" + ex.getMessage());
			throw new BusinessServiceException(EnumError.TECHNICAL_ERROR.getAlias());
		}
	}


	@Override
	public DTOIntRotaryQuotaMove getRotaryQuotaMovement(final Integer idMovement, final String idLoan) throws BusinessServiceException {

		DTOIntRotaryQuotaMove rotaryQuotaMove = new DTOIntRotaryQuotaMove();
		FormatoOZNCENK0 formatoOZNCENK0 = new FormatoOZNCENK0();
		try {
			log.info("LoanDAOImpl.getRotaryQuotaMovement " + idMovement + ", " +idLoan);
			formatoOZNCENK0.setNommovi(idMovement);
			formatoOZNCENK0.setNomtarj(idLoan);

			PeticionTransaccionOznk peticion = new PeticionTransaccionOznk();

			peticion.getCuerpo().getPartes().add(formatoOZNCENK0);

			RespuestaTransaccionOznk respuesta = transaccionOznk.invocar(peticion);

			log.info("Finaliza peticion exitosa LoanDAOImpl.getRotaryQuotaMovement = " + respuesta.getCodigoRetorno());

			BusinessServiceException exception = errorMappingHelper.toBusinessServiceException(respuesta);
			if (exception != null){
				log.info("LoanDAOImpl.getRotaryQuotaMovement = exception -> " + exception.getErrorMessage() );
				throw exception;
			}

			final CopySalida outputCopy = respuesta.getCuerpo().getParte(CopySalida.class);
			if (outputCopy != null) {
				final FormatoOZNCSNK0 formatoSalida =  outputCopy.getCopy(FormatoOZNCSNK0.class);

				rotaryQuotaMove = LoanMapper.getDTOIntMovementByCopy(formatoSalida);
			}else{
				throw new BusinessServiceException(EnumError.NO_DATA.getAlias());
			}
			return rotaryQuotaMove;
		}
		catch(BusinessServiceException bex) {
			log.info("LoanDAOImpl.getRotaryQuotaMovement.BusinessServiceException ->" + bex.getMessage());
			throw bex;
		}
		catch (Exception e) {
			log.info("LoanDAOImpl.getRotaryQuotaMovement.exception ->" + e.getMessage() );
			throw new BusinessServiceException(EnumError.TECHNICAL_ERROR.getAlias());
		}
	}
}
