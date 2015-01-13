package com.bbva.czic.accounts.business;

import java.util.Date;
import java.util.List;

import com.bbva.czic.accounts.business.dto.*;
import com.bbva.czic.accounts.dao.AccountsDAO;

public interface ISrvIntAccounts<Account> {

	public List<DTOIntMonthlyBalances> getAccountMonthlyBalance(DTOIntFilterAccount dtoIntFilterAccount) ;

	public List<DTOIntAccMovementsResume> getAccMovementResume(DTOIntFilterAccount dtoIntFilterAccount);

	public DTOIntAccount getAccount(DTOIntFilterAccount dtoIntFilterAccount) ;

}