package com.bbva.zic.accounts.dao.mappers;

import com.bbva.zic.accounts.business.dto.DTOIntCheck;
import com.bbva.zic.accounts.business.dto.DTOIntFilterChecks;
import com.bbva.zic.accounts.dao.model.oznx.FormatoOZECNXE0;
import com.bbva.zic.accounts.dao.model.oznx.FormatoOZECNXS0;

/**
 * @author Entelgy
 */
public interface TxCheckMapper {

	/**
	 * @param dtoIn
	 * @return
	 */
	FormatoOZECNXE0 mapInOznx(DTOIntFilterChecks dtoIn);


	/**
	 * @param formatOutput
	 * @return
	 */
	DTOIntCheck mapOutOznx(FormatoOZECNXS0 formatOutput);

}
