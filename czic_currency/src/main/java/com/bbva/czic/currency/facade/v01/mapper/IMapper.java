package com.bbva.czic.currency.facade.v01.mapper;

import com.bbva.czic.currency.business.dto.DTOIntCurrency;
import com.bbva.czic.dto.net.Currency;

import java.util.List;

/**
 * Created by Entelgy on 11/12/2015.
 */
public interface IMapper {
    List<Currency> MapOutListCurrency(List<DTOIntCurrency> listDtoCurrency);
}
