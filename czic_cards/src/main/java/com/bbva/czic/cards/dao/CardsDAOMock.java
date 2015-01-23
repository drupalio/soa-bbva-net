package com.bbva.czic.cards.dao;

import com.bbva.czic.cards.business.dto.DTOIntCardCharge;
import com.bbva.jee.arq.spring.core.host.transporte.ExcepcionTransporte;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.mockito.Mockito;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Entelgy on 23/01/2015.
 */
//@Repository(value = "cards-dao")
//@Profile(value = "dev")
public class CardsDAOMock implements CardsDAO{

    private CardsDAOMock mock;

    public CardsDAOMock() throws JsonParseException, JsonMappingException, IOException {

        List<DTOIntCardCharge> listDTOIntCardCharge = new ArrayList<DTOIntCardCharge>();
        DTOIntCardCharge dtoIntCardCharge = new DTOIntCardCharge();
        Money ammount = new Money();
        ammount.setAmount(new BigDecimal("1000"));
        dtoIntCardCharge.setAmount(ammount);
        dtoIntCardCharge.setCategory("PC");
        listDTOIntCardCharge.add(dtoIntCardCharge);
        listDTOIntCardCharge.add(dtoIntCardCharge);
        listDTOIntCardCharge.add(dtoIntCardCharge);

    }


    @Override
    public List<DTOIntCardCharge> getCreditCardCharges(String id, Date startDate, Date endDate) throws ExcepcionTransporte {
        return null;
    }
}
