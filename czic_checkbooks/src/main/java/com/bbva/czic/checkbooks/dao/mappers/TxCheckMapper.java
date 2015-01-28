package com.bbva.czic.checkbooks.dao.mappers;

import com.bbva.czic.checkbooks.business.dto.DTOIntCheck;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheckFilter;
import com.bbva.czic.checkbooks.dao.model.ozny.FormatoOZECNYE0;
import com.bbva.czic.checkbooks.dao.model.ozny.FormatoOZECNYS0;

/**
 * Created by Entelgy on 28/01/2015.
 */
public interface TxCheckMapper {

    public DTOIntCheck mapOutOzny(FormatoOZECNYS0 formatOutput);
    public FormatoOZECNYE0 mapInOzny(DTOIntCheckFilter dtoIn);

}
