package com.bbva.czic.currency.dao.impl;

import com.bbva.czic.currency.business.dto.DTOIntCurrency;
import com.bbva.czic.currency.dao.CurrencyDAO;
import com.bbva.czic.dto.net.Currency;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component(value = "CurrencyDAO")
public class CurrencyDAOImpl  implements CurrencyDAO {

    @Override
    public List<DTOIntCurrency> listCurrencies() {
        List<DTOIntCurrency> dtoIntCurrencyList=new ArrayList<DTOIntCurrency>();
        String currencyString="COP";
        for(int i=0;i<10;i++){
            DTOIntCurrency dtoIntCurrency=new DTOIntCurrency();
            dtoIntCurrency.setId(String.valueOf(i));
            dtoIntCurrency.setName(currencyString + i);
            dtoIntCurrencyList.add(dtoIntCurrency);
        }
        return dtoIntCurrencyList;
    }
}

