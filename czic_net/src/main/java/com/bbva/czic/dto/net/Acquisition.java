
package com.bbva.czic.dto.net;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Acquisition", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "Acquisition", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Acquisition
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty(value = "Comercios relacionados a una adquirencia", required = true)
    private List<Commerce> commerces;
    @ApiModelProperty("Correos configurados para una adquirencia")
    private List<String> mail;

    public Acquisition() {
        //default constructor
    }

    public List<Commerce> getCommerces() {
        return commerces;
    }

    public void setCommerces(List<Commerce> commerces) {
        this.commerces = commerces;
    }

    public List<String> getMail() {
        return mail;
    }

    public void setMail(List<String> mail) {
        this.mail = mail;
    }

}
