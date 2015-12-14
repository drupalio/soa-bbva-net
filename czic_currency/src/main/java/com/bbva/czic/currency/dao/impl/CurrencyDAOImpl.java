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
        DTOIntCurrency dtoIntCurrency=new DTOIntCurrency();
        dtoIntCurrency.setId("CAD");
        dtoIntCurrency.setName("DÓLAR CANADIENSE");
        dtoIntCurrencyList.add(dtoIntCurrency);

        dtoIntCurrency=new DTOIntCurrency();
        dtoIntCurrency.setId("CHF");
        dtoIntCurrency.setName("FRANCO SUIZO");
        dtoIntCurrencyList.add(dtoIntCurrency);

        dtoIntCurrency=new DTOIntCurrency();
        dtoIntCurrency.setId("CNY");
        dtoIntCurrency.setName("YUAN");
        dtoIntCurrencyList.add(dtoIntCurrency);

        dtoIntCurrency=new DTOIntCurrency();
        dtoIntCurrency.setId("COP");
        dtoIntCurrency.setName("PESO COLOMBIANO");
        dtoIntCurrencyList.add(dtoIntCurrency);

        dtoIntCurrency=new DTOIntCurrency();
        dtoIntCurrency.setId("EUR");
        dtoIntCurrency.setName("EURO");
        dtoIntCurrencyList.add(dtoIntCurrency);

        dtoIntCurrency=new DTOIntCurrency();
        dtoIntCurrency.setId("GBP");
        dtoIntCurrency.setName("LIBRA ESTERLINA");
        dtoIntCurrencyList.add(dtoIntCurrency);

        dtoIntCurrency=new DTOIntCurrency();
        dtoIntCurrency.setId("JPY");
        dtoIntCurrency.setName("YEN JAPONÉS");
        dtoIntCurrencyList.add(dtoIntCurrency);

        dtoIntCurrency=new DTOIntCurrency();
        dtoIntCurrency.setId("MXN");
        dtoIntCurrency.setName("PESO MEXICANO");
        dtoIntCurrencyList.add(dtoIntCurrency);

        dtoIntCurrency=new DTOIntCurrency();
        dtoIntCurrency.setId("SEK");
        dtoIntCurrency.setName("CORONA SUECA");
        dtoIntCurrencyList.add(dtoIntCurrency);

        dtoIntCurrency=new DTOIntCurrency();
        dtoIntCurrency.setId("USD");
        dtoIntCurrency.setName("DÓLAR AMERICANO");
        dtoIntCurrencyList.add(dtoIntCurrency);

        return dtoIntCurrencyList;
    }
}

