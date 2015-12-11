package com.bbva.czic.currency.business;

import java.util.List;
import javax.ws.rs.core.Response;


import com.bbva.czic.currency.business.dto.DTOIntCurrency;



public interface ISrvIntCurrency {
 	public List<DTOIntCurrency> listCurrencies();

	
}