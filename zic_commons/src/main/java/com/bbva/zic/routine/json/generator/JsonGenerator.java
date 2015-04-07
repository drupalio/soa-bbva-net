package com.bbva.zic.routine.json.generator;

import com.bbva.zic.dto.net.*;

import com.bbva.zic.routine.commons.rm.utils.file.FileBbvaUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Entelgy on 15/02/2015.
 */
public class JsonGenerator {


    public static void main(final String[] args){
        final CustomerOperation cutOp = new CustomerOperation();

        Operation op = new Operation();
        op.setCode("123456");

        Card card = new Card();
        card.setCardNumber("491268");
        card.setNip("654321365");

        Document doc = new Document();
        doc.setNumber("123456789");
        doc.setType(EnumDocumentType.CEDULACIUDADANIA);

        ContactInfo contactInfo = new ContactInfo();
        List<Email> emails = new ArrayList<Email>();
        Email em = new Email();
        em.setAddress("prueba@test.com");
        emails.add(em);
        contactInfo.setEmails(emails);

        Customer cust = new Customer();
        cust.setId("2163546");
        cust.setDocument(doc);
        cust.setContactInfo(contactInfo);

        cutOp.setCard(card);
        cutOp.setCustomer(cust);
        cutOp.setOperation(op);

        String string = FileBbvaUtils.getJsonString(cutOp);

        System.out.println(string);
    }

}
