package com.bbva.czic.cards.dao.mapper.impl;

import com.bbva.czic.cards.business.dto.DTOIntCardCharge;
import com.bbva.czic.cards.business.dto.DTOIntFilterCards;
import com.bbva.czic.cards.dao.mapper.TxCardsMapper;
import com.bbva.czic.cards.dao.model.ozno.FormatoOZECNOE0;
import com.bbva.czic.cards.dao.model.ozno.FormatoOZECNOS0;
import com.bbva.czic.routine.commons.rm.utils.mappers.AbstractBbvaTxConfigurableMapper;
import com.bbva.czic.routine.commons.rm.utils.mappers.Mapper;
import com.bbva.czic.routine.mapper.MapperFactory;

import java.util.List;

/**
 * Created by Entelgy on 28/01/2015.
 */
@Mapper(value = "txCardsMapper")
public class TxCardsMapperImpl extends AbstractBbvaTxConfigurableMapper implements TxCardsMapper {

    @Override
    protected void configure(MapperFactory factory) {

        super.configure(factory);

        factory.classMap(DTOIntFilterCards.class, FormatoOZECNOE0.class)
                .field("productId", "numprod")
                .field("startDate", "fechain")
                .field("endDate", "fechafi")
                .byDefault().register();

        factory.classMap(FormatoOZECNOS0.class, DTOIntCardCharge.class)
                .field("categor", "category")
                .field("valcate", "amount")
                .byDefault().register();
    }

    @Override
    public FormatoOZECNOE0 mapInOzno(DTOIntFilterCards dtoIn) {
        return map(dtoIn, FormatoOZECNOE0.class);
    }

    @Override
    public DTOIntCardCharge mapOutOzno(FormatoOZECNOS0 formatOut) {
        return map(formatOut, DTOIntCardCharge.class);
    }
}
