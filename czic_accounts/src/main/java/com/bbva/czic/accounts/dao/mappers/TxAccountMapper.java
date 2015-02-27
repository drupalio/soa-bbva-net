package com.bbva.czic.accounts.dao.mappers;

import com.bbva.czic.accounts.business.dto.*;
import com.bbva.czic.accounts.dao.model.ozna.FormatoOZNCENA0;
import com.bbva.czic.accounts.dao.model.ozna.FormatoOZNCSNA0;
import com.bbva.czic.accounts.dao.model.ozns.FormatoOZECNSE0;
import com.bbva.czic.accounts.dao.model.ozns.FormatoOZECNSS0;
import com.bbva.czic.accounts.dao.model.oznu.FormatoOZECNUE0;
import com.bbva.czic.accounts.dao.model.oznu.FormatoOZECNUS0;
import com.bbva.czic.accounts.dao.model.oznv.FormatoOZECNVE0;
import com.bbva.czic.accounts.dao.model.oznv.FormatoOZECNVS0;
import com.bbva.czic.accounts.dao.model.ozny.FormatoOZECNYE0;
import com.bbva.czic.accounts.dao.model.ozny.FormatoOZECNYS0;

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
	 * @return
	 */
	DTOIntAccMovementsResume mapOutOznu(FormatoOZECNUS0 formatOutput);

	FormatoOZECNSE0 mapInOzns(DTOIntFilterCheckbooks dtoIn);

	DTOIntCheckbook mapOutOzns(FormatoOZECNSS0 formatOutput);

	public FormatoOZECNYE0 mapInOzny(DTOIntCheckFilter dtoIn);

	public DTOIntCheck mapOutOzny(FormatoOZECNYS0 formatOutput);

}
