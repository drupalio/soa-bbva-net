package com.bbva.czic.currency.facade.v01.mapper;

import com.bbva.czic.currency.business.dto.DTOIntCurrency;
import com.bbva.czic.dto.net.Currency;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import java.util.List;

/**
 * Interfaz para el mapeo de los objetos internos del servicio en los objetos de salida de los servicios.
 * Created by Entelgy on 11/12/2015.
 */
public interface IMapper {
    /**
     * Metodo Encargado de mapear una lista de tipo DTOIntCurrency en una lista de tipo Currency
     * @param List<DTOIntCurrency> listDtoCurrency
     * @return  List<Currency>
     */
    @ApiOperation(value="Metodo Encargado de mapear una lista de tipo DTOIntCurrency en una lista de tipo Currency", notes="Metodo Encargado de mapear una lista de tipo DTOIntCurrency en una lista de tipo Currency",response=List.class)
    List<Currency> MapOutListCurrency(List<DTOIntCurrency> listDtoCurrency);
}
