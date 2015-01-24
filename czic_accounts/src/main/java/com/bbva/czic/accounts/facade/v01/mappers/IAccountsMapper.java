package com.bbva.czic.accounts.facade.v01.mappers;

import java.util.List;

import com.bbva.czic.accounts.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.accounts.business.dto.DTOIntAccount;
import com.bbva.czic.accounts.business.dto.DTOIntCheck;
import com.bbva.czic.accounts.business.dto.DTOIntCheckbook;
import com.bbva.czic.accounts.business.dto.DTOIntFilterAccount;
import com.bbva.czic.accounts.business.dto.DTOIntMonthlyBalances;
import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.Account;
import com.bbva.czic.dto.net.Check;
import com.bbva.czic.dto.net.Checkbook;
import com.bbva.czic.dto.net.MonthlyBalances;

/**
 * Created by Entelgy on 12/01/2015.
 */
public interface IAccountsMapper {

	Account map(DTOIntAccount dtoIntAccount);

	List<MonthlyBalances> mapL(List<DTOIntMonthlyBalances> listaDtoIntMonthlyBalances);

	List<AccMovementsResume> map(List<DTOIntAccMovementsResume> listaDTOIntAccMovementsResume);

	List<Check> mapChecks(List<DTOIntCheck> listaDtoIntChecks);

	Check mapCheck(DTOIntCheck intCheck);

	Checkbook mapCheckbook(DTOIntCheckbook intCheckbook);

	DTOIntFilterAccount getDTOIntFilter(String idAccount, String filter);

}
