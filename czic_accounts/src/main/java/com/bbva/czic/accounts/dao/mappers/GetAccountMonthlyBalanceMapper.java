package com.bbva.czic.accounts.dao.mappers;

import com.bbva.czic.accounts.business.dto.DTOIntEnumMonth;
import com.bbva.czic.accounts.business.dto.DTOIntFilterAccount;
import com.bbva.czic.accounts.business.dto.DTOIntMonthlyBalances;
import com.bbva.czic.accounts.business.dto.DTOIntResponseMonthlyBalances;
import com.bbva.czic.accounts.dao.model.oznu.FormatoOZECNUE0;
import com.bbva.czic.accounts.dao.model.oznv.FormatoOZECNVE0;
import com.bbva.czic.accounts.dao.model.oznv.FormatoOZECNVS0;
import com.bbva.czic.dto.net.EnumFinancialStatusType;
import com.bbva.czic.dto.net.EnumMonth;
import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.czic.routine.commons.rm.utils.tx.IFormatNotApply;
import com.bbva.czic.routine.commons.rm.utils.tx.IPaginatedTransactionMapper;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by Entelgy on 12/01/2015.
 */
@Component("tx-get-account-monthly-balance-mapper")
public class GetAccountMonthlyBalanceMapper    implements IPaginatedTransactionMapper <DTOIntFilterAccount, FormatoOZECNVE0, DTOIntResponseMonthlyBalances, IFormatNotApply, DTOIntMonthlyBalances, FormatoOZECNVS0, IFormatNotApply>{

    @Override
    public DTOIntMonthlyBalances mapToInnerEntity(FormatoOZECNVS0 outFormat, DTOIntFilterAccount dtoIn) {
        final DTOIntMonthlyBalances dtoIntMonthlyBalances = new DTOIntMonthlyBalances();

        Money money = new Money();
        money.setAmount(outFormat.getSalddis());
        dtoIntMonthlyBalances.setBalance(money);
        DTOIntEnumMonth dtoIntEnumMonth = new DTOIntEnumMonth();
        dtoIntEnumMonth.setMes(outFormat.getMes());
        dtoIntMonthlyBalances.setMonth(dtoIntEnumMonth);

        return dtoIntMonthlyBalances;
    }

    @Override
    public void addPaginationInfo(IFormatNotApply paginationOutFormat, DTOIntFilterAccount dtoIn) {

    }

    @Override
    public boolean doIHaveToPaginate(DTOIntFilterAccount dtoIn) {
        return false;
    }

    @Override
    public FormatoOZECNVE0 mapToInner(DTOIntFilterAccount dtoIn) {
        FormatoOZECNVE0 formatoEntrada = new FormatoOZECNVE0();
        formatoEntrada.setMesini(dtoIn.getStartMonth().toString());
        formatoEntrada.setMesfin(dtoIn.getEndMonth().toString());
        formatoEntrada.setNumcta(dtoIn.getAccountId());
        return formatoEntrada;
    }

    @Override
    public DTOIntResponseMonthlyBalances mapToOuter(IFormatNotApply outFormat, DTOIntFilterAccount dtoIn) {
        final DTOIntResponseMonthlyBalances productsWrappers = new DTOIntResponseMonthlyBalances();
        productsWrappers.setListDTOIntMonthlyBalances(new ArrayList<DTOIntMonthlyBalances>());
        return productsWrappers;
    }
}
