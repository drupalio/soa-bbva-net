package com.bbva.czic.accounts.facade.v01.mappers;

import java.util.List;

import com.bbva.czic.accounts.business.dto.*;
import com.bbva.czic.dto.net.*;

/**
 * Created by Entelgy on 12/01/2015.
 */
public interface IAccountsMapper {

	Account map(DTOIntAccount dtoIntAccount);

	List<MonthlyBalances> mapL(List<DTOIntMonthlyBalances> listaDtoIntMonthlyBalances);

	List<AccMovementsResume> map(List<DTOIntAccMovementsResume> listaDTOIntAccMovementsResume);

	List<Check> mapChecks(List<DTOIntCheck> listaDtoIntChecks);

	public Check mapCheck(DTOIntCheck intCheck);
	public Checkbook mapCheckbook(DTOIntCheckbook intCheckbook) ;

}
