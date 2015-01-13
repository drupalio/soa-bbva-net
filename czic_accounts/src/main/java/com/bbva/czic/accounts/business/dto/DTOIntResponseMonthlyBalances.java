package com.bbva.czic.accounts.business.dto;

import java.util.List;

/**
 * Created by Entelgy on 12/01/2015.
 */
public class DTOIntResponseMonthlyBalances {


    private List<DTOIntMonthlyBalances> listDTOIntMonthlyBalances;

    public List<DTOIntMonthlyBalances> getListDTOIntMonthlyBalances() {
        return listDTOIntMonthlyBalances;
    }

    public void setListDTOIntMonthlyBalances(List<DTOIntMonthlyBalances> listDTOIntMonthlyBalances) {
        this.listDTOIntMonthlyBalances = listDTOIntMonthlyBalances;
    }
}
