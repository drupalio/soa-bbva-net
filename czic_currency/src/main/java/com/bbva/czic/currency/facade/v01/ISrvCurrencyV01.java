package com.bbva.czic.currency.facade.v01;

import java.util.List;
import javax.ws.rs.core.Response;

import com.bbva.czic.dto.net.Currency;


public interface ISrvCurrencyV01 {
 	public List<Currency> listCurrencies();

	
}