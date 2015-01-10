
package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Holder", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "Holder", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Holder
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty("Alias de un titular de la cuenta")
    private String alias;

    public Holder() {
        //default constructor
    }

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

    
}
