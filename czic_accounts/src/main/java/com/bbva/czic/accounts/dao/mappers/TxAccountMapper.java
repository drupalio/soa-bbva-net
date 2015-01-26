package com.bbva.czic.accounts.dao.mappers;

import com.bbva.czic.accounts.business.dto.*;
import com.bbva.czic.accounts.dao.model.ozna.FormatoOZNCENA0;
import com.bbva.czic.accounts.dao.model.ozna.FormatoOZNCSNA0;
import com.bbva.czic.accounts.dao.model.oznu.FormatoOZECNUE0;
import com.bbva.czic.accounts.dao.model.oznu.FormatoOZECNUS0;
import com.bbva.czic.accounts.dao.model.oznv.FormatoOZECNVE0;
import com.bbva.czic.accounts.dao.model.oznv.FormatoOZECNVS0;

/**
 * @author Entelgy
 */
public interface TxAccountMapper {

	/**
	 * @param dtoIn
	 * @return
	 */
	FormatoOZNCENA0 mapInOzna(DTOIntFilterAccount dtoIn);

	/**
	 * @param dtoIn
	 * @return
	 */
	FormatoOZECNVE0 mapInOznv(DTOIntFilterAccount dtoIn);

	/**
	 * @param dtoIn
	 * @return
	 */
	FormatoOZECNUE0 mapInOznu(DTOIntFilterMovResumes dtoIn);

	/**
	 * @param formatOutput
	 * @return
	 */
	DTOIntAccount mapOutOzna(FormatoOZNCSNA0 formatOutput);

	/**
	 * @param formatOutput
	 * @return
	 */
	DTOIntMonthlyBalances mapOutOznv(FormatoOZECNVS0 formatOutput);

	/**
	 * @param formatOutput
	 * @param dtoIn
	 * @return
	 */
	DTOIntAccMovementsResume mapOutOznu(FormatoOZECNUS0 formatOutput);

}
