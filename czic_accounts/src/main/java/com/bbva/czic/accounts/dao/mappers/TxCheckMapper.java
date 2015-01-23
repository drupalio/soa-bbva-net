package com.bbva.czic.accounts.dao.mappers;

import com.bbva.czic.accounts.business.dto.*;
import com.bbva.czic.accounts.dao.model.ozna.FormatoOZNCENA0;
import com.bbva.czic.accounts.dao.model.ozna.FormatoOZNCSNA0;
import com.bbva.czic.accounts.dao.model.oznu.FormatoOZECNUE0;
import com.bbva.czic.accounts.dao.model.oznu.FormatoOZECNUS0;
import com.bbva.czic.accounts.dao.model.oznv.FormatoOZECNVE0;
import com.bbva.czic.accounts.dao.model.oznv.FormatoOZECNVS0;
import com.bbva.czic.accounts.dao.model.oznx.FormatoOZECNXE0;
import com.bbva.czic.accounts.dao.model.oznx.FormatoOZECNXS0;

import java.util.List;

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
