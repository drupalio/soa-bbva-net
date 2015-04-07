package com.bbva.zic.accounts.facade.v01.mappers;

import java.util.List;

import com.bbva.zic.dto.net.AccMovementsResume;
import com.bbva.zic.dto.net.Account;
import com.bbva.zic.dto.net.Check;
import com.bbva.zic.dto.net.Checkbook;
import com.bbva.zic.dto.net.MonthlyBalances;
import com.bbva.zic.accounts.business.dto.*;

/**
 * Created by Entelgy on 12/01/2015.
 */
public interface IAccountsMapper {

	Account map(DTOIntAccount dtoIntAccount);

	List<MonthlyBalances> mapL(List<DTOIntMonthlyBalances> listaDtoIntMonthlyBalances);

	List<AccMovementsResume> map(List<DTOIntAccMovementsResume> listaDTOIntAccMovementsResume);

	List<Check> mapChecks(List<DTOIntCheck> listaDtoIntChecks);

	List<Checkbook> mapCheckbooks(List<DTOIntCheckbook> intCheckbook);

	DTOIntFilterAccount getDTOIntFilter(String idAccount, String filter);

	DTOIntFilterChecks getDtoIntFilterChecks(String idAccount, String filter, Integer paginationKey, Integer paginationSize);

	DTOIntFilterMovResumes getDtoIntFilterMovResumes(String idAccount, String filter);
	
	DTOIntFilterCheckbooks getDtoIntCheckbook(String idAccount, String idCheckbook);

	public DTOIntCheckFilter getDTOIntFilterChecks(String checkId,String accountId);

	public Check map(DTOIntCheck intCheck);
}
