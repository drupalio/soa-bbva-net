package com.bbva.czic.currency.facade.v01;

import java.util.List;
import javax.ws.rs.core.Response;

import com.bbva.czic.dto.net.Currency;
import com.wordnik.swagger.annotations.ApiOperation;

/**
 * Interfaz encargada de establecer los metodos que serviran de entrada al servicio
 * Created by Entelgy on 10/12/2015.
 */
public interface ISrvCurrencyV01 {

	@ApiOperation(value="Metodo que se encarga de retornar una lista de todos los tipos de monedas que se manejan.", notes="Metodo que se encarga de retornar una lista de todos los tipos de monedas que se manejan.",response=List.class)
 	public List<Currency> listCurrencies();

	
}