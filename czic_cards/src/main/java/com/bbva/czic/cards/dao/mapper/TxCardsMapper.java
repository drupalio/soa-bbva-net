package com.bbva.czic.cards.dao.mapper;

import com.bbva.czic.cards.business.dto.DTOIntCardCharge;
import com.bbva.czic.cards.business.dto.DTOIntFilterCards;
import com.bbva.czic.cards.dao.model.ozno.FormatoOZECNOE0;
import com.bbva.czic.cards.dao.model.ozno.FormatoOZECNOS0;

import java.util.List;

/**
 * Created by Entelgy on 28/01/2015.
 */
public interface TxCardsMapper {

    FormatoOZECNOE0 mapInOzno(DTOIntFilterCards dtoIn);

    DTOIntCardCharge mapOutOzno(FormatoOZECNOS0 formatOut);
}
