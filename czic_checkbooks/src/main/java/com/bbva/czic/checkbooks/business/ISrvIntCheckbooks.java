package com.bbva.czic.checkbooks.business;

import java.util.List;
import javax.ws.rs.core.Response;


import com.bbva.czic.checkbooks.business.dto.DTOIntEnumCheckStatus;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheck;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheckbook;
import com.bbva.czic.checkbooks.business.dto.DTOIntEnumCheckbookStatus;



public interface ISrvIntCheckbooks {
 	public List<DTOIntCheck> getChecks( String idCheckbook);

		public List<DTOIntCheckbook> getCheckbooks();

	
}