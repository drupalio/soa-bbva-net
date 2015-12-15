
package com.bbva.czic.dto.net;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "person", namespace = "urn:com:bbva:czic:internationalcontracttransfer:facade:v01:dto")
@XmlType(name = "person", namespace = "urn:com:bbva:czic:internationalcontracttransfer:facade:v01:dto")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty("Nombre de la persona o Razon social de la empresa")
    private String name;
    @ApiModelProperty("Listado de documentos utilizados para identificar una persona")
    private List<IdentityDocument> identityDocument;

    public Person() {
        //default constructor
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<IdentityDocument> getIdentityDocument() {
        return identityDocument;
    }

    public void setIdentityDocument(List<IdentityDocument> identityDocument) {
        this.identityDocument = identityDocument;
    }

}
