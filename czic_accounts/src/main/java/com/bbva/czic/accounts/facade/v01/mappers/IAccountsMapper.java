package com.bbva.czic.accounts.facade.v01.mappers;

import com.bbva.czic.accounts.business.dto.*;
import com.bbva.czic.dto.net.*;

import java.util.List;

/**
 * Created by Entelgy on 12/01/2015.
 */
public interface IAccountsMapper {

    public Account map(DTOIntAccount dtoIntAccount);

    public List<MonthlyBalances> mapL(List<DTOIntMonthlyBalances> listaDtoIntMonthlyBalances);

    public List<AccMovementsResume> map(List<DTOIntAccMovementsResume> listaDTOIntAccMovementsResume);

    public Balance map(DTOIntBalance intBalance) ;

    public List<Checkbook> mapLCheckbook(List<DTOIntCheckbook> listaDTOIntCheckbook);

    public Check mapChecks(List<DTOIntCheck> listaDtoIntChecks);

}
