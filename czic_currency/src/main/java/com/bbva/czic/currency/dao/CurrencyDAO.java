package com.bbva.czic.currency.dao;

import com.bbva.czic.currency.business.dto.DTOIntCurrency;
import com.wordnik.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * Interfaz encargada de establecer los metodos que tiene la capa Dao para retornar información que requiera el servicio
 */
public interface CurrencyDAO {
	/**
	 *
	 * @return List<DTOIntCurrency>
	 */
	@ApiOperation(value="Metodo que se comunica con la transacción y retorna la lista de tipos de modedas manejadas", notes="Metodo que se comunica con la transacción y retorna la lista de tipos de modedas manejadas",response=List.class)
	public List<DTOIntCurrency> listCurrencies();
	
}

