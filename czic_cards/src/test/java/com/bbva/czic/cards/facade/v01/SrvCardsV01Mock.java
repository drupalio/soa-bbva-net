package com.bbva.czic.cards.facade.v01;

import com.bbva.czic.cards.business.CardsMapper;
import com.bbva.czic.cards.business.ISrvIntCards;
import com.bbva.czic.cards.business.dto.DTOIntCardCharge;
import com.bbva.czic.dto.net.CardCharge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Entelgy on 10/01/2015.
 */
@Service
public class SrvCardsV01Mock {

    @Autowired
    ISrvIntCards iSrvIntCards;

    public List<CardCharge> getCreditCardCharges(String id,String filter,String fields,String expands,String sort) {

        List<DTOIntCardCharge> listaDtoIntCardCharge = new ArrayList<DTOIntCardCharge>();
        List<CardCharge> listaDTOCardCharge = new ArrayList<CardCharge>();

//        listaDtoIntCardCharge = iSrvIntCards.getCreditCardCharges(id, filter);

        for (DTOIntCardCharge dtoIntCardCharge : listaDtoIntCardCharge) {
            CardCharge cardCharge = new CardCharge();
            cardCharge = CardsMapper.mapOuter(dtoIntCardCharge);
            listaDTOCardCharge.add(cardCharge);
        }
        return listaDTOCardCharge;
    }
}
