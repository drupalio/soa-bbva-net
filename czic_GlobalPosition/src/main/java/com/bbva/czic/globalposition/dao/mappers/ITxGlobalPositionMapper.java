package com.bbva.czic.globalposition.dao.mappers;

import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.business.dto.DTOIntProductFilter;
import com.bbva.czic.globalposition.dao.model.ozn1.FormatoOZECN1E0;
import com.bbva.czic.globalposition.dao.model.ozn1.FormatoOZECN1S0;
import com.bbva.czic.globalposition.dao.model.ozn1.FormatoOZECN1S1;

/**
 * @author Entelgy Colombia.
 */
public interface ITxGlobalPositionMapper {

    /**
     * Mapeo del DTO interno de entrada al Formato de entrada de la trasaccion.
     * @param productFilter
     * @return FormatoOZECN1E0 formato de Entrada de la transaccion.
     */
    FormatoOZECN1E0 mapInOzn1(DTOIntProductFilter productFilter);

    /**
     * Mappeo del Formato de Salida 0 al DTO Interno de Producto.
     * @param formatoOZECN1S0
     * @return DTOIntProduct DTO Interno de producto.
     */
    DTOIntProduct mapOutOzn1S0(FormatoOZECN1S0 formatoOZECN1S0);

    /**
     * Mappeo del Formato de Salida 1 al DTO Interno de Producto.
     * @param formatoOZECN1S1
     * @return DTOIntProduct DTO Interno de producto.
     */
    DTOIntProduct mapOutOzn1S1(FormatoOZECN1S1 formatoOZECN1S1);

}
