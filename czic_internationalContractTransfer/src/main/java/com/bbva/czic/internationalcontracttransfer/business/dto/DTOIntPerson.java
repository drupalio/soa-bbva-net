
package com.bbva.czic.internationalcontracttransfer.business.dto;

import java.util.List;



public class DTOIntPerson {

    public final static long serialVersionUID = 1L;
    private String name;
    private List<DTOIntIdentityDocument> identityDocument;

    public DTOIntPerson() {
        //default constructor
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DTOIntIdentityDocument> getIdentityDocument() {
        return identityDocument;
    }

    public void setIdentityDocument(List<DTOIntIdentityDocument> identityDocument) {
        this.identityDocument = identityDocument;
    }

}
