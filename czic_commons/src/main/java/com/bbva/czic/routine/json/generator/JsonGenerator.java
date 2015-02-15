package com.bbva.czic.routine.json.generator;

import com.bbva.czic.dto.net.*;
import com.ibm.disthub2.impl.formats.Multi;

/**
 * Created by Entelgy on 15/02/2015.
 */
public class JsonGenerator {


    public static void main(final String[] args){
        final CustomerOperation cutOp = new CustomerOperation();

        Operation  op = new Operation();
        op.setCode("123456");

        Card card = new Card();
        card.setCardNumber("491268");
        card.setNip("654321365");

        Customer cust = new Customer();
        cust.setId("2163546");




    }

}
