package com.bbva.czic.loan.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.loan.business.dto.DTOIntMovement;
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
import com.bbva.czic.loan.dao.model.oznk.FormatoOZNCENK0;
import com.bbva.czic.loan.dao.model.oznk.FormatoOZNCSNK0;
import com.bbva.czic.loan.dao.model.oznk.PeticionTransaccionOznk;
import com.bbva.czic.loan.dao.model.oznk.RespuestaTransaccionOznk;
import com.bbva.czic.loan.dao.model.oznk.TransaccionOznk;
import com.bbva.czic.mapper.LoanMapper;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.ErrorMappingHelper;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

public class LoanDAOImpl implements LoanDAO {

	@Autowired
	private ErrorMappingHelper errorMappingHelper;

	@Resource(name = "loanMapper")
	private LoanMapper loanMapper;

	@Override
	public List<DTOIntMovement> listRotaryQuotaMovements(Date starDate, Date endDate, String paginationKey,
			Integer pageSize, String idLoan) throws BusinessServiceException {

		DTOIntMovement movement = new DTOIntMovement();
		List<DTOIntMovement> movementList = new ArrayList<DTOIntMovement>();

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
			if (exception != null) throw new BusinessServiceException("loanServerListRotary");

			CopySalida outputCopy = respuesta.getCuerpo().getParte(CopySalida.class);
			if (outputCopy != null) {

				FormatoOZNCSNI0 formatoSalida = outputCopy.getCopy(FormatoOZNCSNI0.class);
				if (formatoSalida != null) {

					movement = new LoanMapper().map(formatoSalida, DTOIntMovement.class);

					movementList.add(movement);
				}
			}
		} catch (Exception e) {
		}
		return movementList;
	}

	@Override
	public DTOIntLoan getRotaryQuota(String idLoan) throws BusinessServiceException {

		DTOIntLoan dTOIntLoan = new DTOIntLoan();

		try {
			FormatoOZNCENJ0 formatoOZNCENJ0 = new FormatoOZNCENJ0();
			formatoOZNCENJ0.setNumprod(idLoan);

			PeticionTransaccionOznj peticion = new PeticionTransaccionOznj();

			peticion.getCuerpo().getPartes().add(formatoOZNCENJ0);
			RespuestaTransaccionOznj respuesta = new TransaccionOznj().invocar(peticion);

			BusinessServiceException exception = errorMappingHelper.toBusinessServiceException(respuesta);
			if (exception != null) throw new BusinessServiceException("loanServergetRotaryQuota");

			CopySalida outputCopy = respuesta.getCuerpo().getParte(CopySalida.class);
			if (outputCopy != null) {

				FormatoOZNCSNJ0 formatoSalida = outputCopy.getCopy(FormatoOZNCSNJ0.class);
				if (formatoSalida != null) {

					dTOIntLoan = loanMapper.map(formatoSalida, DTOIntLoan.class);

				}
			}
		} catch (Exception e) {
		}
		return dTOIntLoan;

	}

	@Override
	public DTOIntMovement getRotaryQuotaMovement(String idMovement, String idLoan) throws BusinessServiceException {

		DTOIntMovement dtoIntMovement = new DTOIntMovement();
		FormatoOZNCENK0 formatoOZNCENK0 = new FormatoOZNCENK0();

		try {

			formatoOZNCENK0.setNommovi(idMovement);
			formatoOZNCENK0.setNomtarj(idLoan);

			PeticionTransaccionOznk peticion = new PeticionTransaccionOznk();

			peticion.getCuerpo().getPartes().add(peticion);

			RespuestaTransaccionOznk respuesta = new TransaccionOznk().invocar(peticion);

			BusinessServiceException exception = errorMappingHelper.toBusinessServiceException(respuesta);
			if (exception != null) throw new BusinessServiceException("loanPeticionRotaryMuvement");

			CopySalida outputCopy = respuesta.getCuerpo().getParte(CopySalida.class);
			if (outputCopy != null) {

				FormatoOZNCSNK0 formatoSalida = outputCopy.getCopy(FormatoOZNCSNK0.class);
				if (formatoSalida != null) {

					dtoIntMovement = loanMapper.map(formatoSalida, DTOIntMovement.class);
				}
			}
		} catch (Exception e) {
		}
		return dtoIntMovement;
	}
}
