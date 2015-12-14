package com.bbva.czic.currency.business;

import java.util.List;
import javax.ws.rs.core.Response;


import com.bbva.czic.currency.business.dto.DTOIntCurrency;
import com.wordnik.swagger.annotations.ApiOperation;


/**
 * Interfaz encargada de establecer los metodos que serviran al servicio para canalizar las comunicaciones hacia DAO
 * Created by Entelgy on 10/12/2015.
 */
public interface ISrvIntCurrency {

	@ApiOperation(value="Metodo que se comunica con la transacción y retorna la lista de tipos de modedas manejadas", notes="Metodo que se comunica con la transacción y retorna la lista de tipos de modedas manejadas",response=List.class)
 	public List<DTOIntCurrency> listCurrencies();

	
}