package com.bbva.czic.executives.dao.mapper;

import com.bbva.czic.executives.business.dto.DTOIntExecutive;
import com.bbva.czic.executives.business.dto.DTOIntExecutivesFilter;
import com.bbva.czic.executives.dao.model.oznr.FormatoOZECNRE0;
import com.bbva.czic.executives.dao.model.oznr.FormatoOZECNRS0;

/**
 * Created by Entelgy on 26/01/2015.
 */
public interface TxExecutiveMapper {

    public FormatoOZECNRE0 mapInOznr(DTOIntExecutivesFilter dtoIn);

    public DTOIntExecutive mapOutOznr(FormatoOZECNRS0 formatOutput);
}
