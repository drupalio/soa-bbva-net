package com.bbva.czic.checkbooks.dao;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.bbva.czic.checkbooks.business.dto.DTOIntCheck;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheckbook;
import com.bbva.czic.checkbooks.dao.model.ozns.FormatoOZECNSE0;
import com.bbva.czic.checkbooks.dao.model.ozns.FormatoOZECNSS0;
import com.bbva.czic.checkbooks.dao.model.ozny.FormatoOZECNYE0;
import com.bbva.czic.checkbooks.dao.model.ozny.FormatoOZECNYS0;
import com.bbva.czic.checkbooks.dao.model.ozny.PeticionTransaccionOzny;
import com.bbva.czic.checkbooks.dao.model.ozny.RespuestaTransaccionOzny;
import com.bbva.czic.checkbooks.dao.model.ozny.TransaccionOzny;
import com.bbva.czic.checkbooks.dao.model.ozns.PeticionTransaccionOzns;
import com.bbva.czic.checkbooks.dao.model.ozns.RespuestaTransaccionOzns;
import com.bbva.czic.checkbooks.dao.model.ozns.TransaccionOzns;
import com.bbva.czic.checkbooks.facade.v01.mappers.impl.CheckbooksMapper;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.ErrorMappingHelper;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.czic.dto.net.EnumCheckStatus;

	public class CheckbooksDAOImpl  implements CheckbooksDAO {
		
	@Resource (name ="CheckbooksMapper")
	private CheckbooksMapper checkbookMapper;

		@Autowired
		private ErrorMappingHelper errorMappingHelper;

		@Override
		public List<DTOIntCheckbook> getCheckbooks (String id) throws BusinessServiceException {

			DTOIntCheckbook dtoIntCheckbook = new DTOIntCheckbook();
			List<DTOIntCheckbook> checkbookDtoList = new ArrayList<DTOIntCheckbook>();

			try {
				FormatoOZECNSE0 FormatoOZECNSE0 = new FormatoOZECNSE0();

				FormatoOZECNSE0.setNumcheq(id);
				
		        PeticionTransaccionOzns peticion = new PeticionTransaccionOzns();

				peticion.getCuerpo().getPartes().add(FormatoOZECNSE0);
				RespuestaTransaccionOzns respuesta = new TransaccionOzns().invocar(peticion);
				
			BusinessServiceException exception = errorMappingHelper.toBusinessServiceException(respuesta);
			if (exception != null) throw new BusinessServiceException("noDataCheckbooks");
			CopySalida outputCopy = respuesta.getCuerpo().getParte(CopySalida.class);
			if (outputCopy != null) {
				FormatoOZECNSS0 formatoSalida = outputCopy.getCopy(FormatoOZECNSS0.class);
				if (formatoSalida != null) {
					dtoIntCheckbook = checkbookMapper.map(formatoSalida, DTOIntCheckbook.class);
				}
			}
			return  checkbookDtoList; 
		}

		catch (Exception e) {
			throw new BusinessServiceException(e.getMessage());
		}

	}
		
		
	@Override
	 public List<DTOIntCheck> getChecks(String id, Calendar fechini, Calendar fechfin, EnumCheckStatus status, Integer indpagi,
			Integer tampagi) throws BusinessServiceException{
	
		DTOIntCheck dtoIntCheck = new DTOIntCheck();
		List<DTOIntCheck> checkbookDtoList = new ArrayList<DTOIntCheck>();
		
		try{
			FormatoOZECNYE0 formatoOZECNYE0 =new FormatoOZECNYE0();
			
			PeticionTransaccionOzny peticion =new PeticionTransaccionOzny();
		
			
		peticion.getCuerpo().getPartes().add(formatoOZECNYE0);
		RespuestaTransaccionOzny respuesta = new TransaccionOzny().invocar(peticion);
		BusinessServiceException exception = errorMappingHelper.toBusinessServiceException(respuesta);
		if (exception != null) throw new BusinessServiceException("noDataChecks");
		List<CopySalida> outputCopies = respuesta.getCuerpo().getPartes(CopySalida.class);
		
		for (CopySalida outputCopy : outputCopies) {
			FormatoOZECNYS0 formatoSalida = outputCopy.getCopy(FormatoOZECNYS0.class);
			dtoIntCheck = checkbookMapper.map(formatoSalida, DTOIntCheck.class);
			checkbookDtoList.add(dtoIntCheck);
			
		}

		//FormatoOZECNOS0 formatoSalida = outputCopy.getCopy(FormatoOZECNOS0.class);		
		
	} catch (Exception e) {
		throw new BusinessServiceException(e.getMessage());
	}
	return null;
}

}



