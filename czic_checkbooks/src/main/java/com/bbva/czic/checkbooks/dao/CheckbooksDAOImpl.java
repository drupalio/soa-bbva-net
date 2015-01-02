package com.bbva.czic.checkbooks.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

import com.bbva.czic.checkbooks.business.dto.DTOIntCheck;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheckbook;
import com.bbva.czic.checkbooks.business.dto.DTOIntEnumCheckbookStatus;
import com.bbva.czic.checkbooks.dao.model.ozns.FormatoOZECNSE0;
import com.bbva.czic.checkbooks.dao.model.ozns.FormatoOZECNSS0;
import com.bbva.czic.checkbooks.dao.model.ozns.PeticionTransaccionOzns;
import com.bbva.czic.checkbooks.dao.model.ozns.RespuestaTransaccionOzns;
import com.bbva.czic.checkbooks.dao.model.ozns.TransaccionOzns;
import com.bbva.czic.mapper.CheckbooksMapper;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.ErrorMappingHelper;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

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
}


