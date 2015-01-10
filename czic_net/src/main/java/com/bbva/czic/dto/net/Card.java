
package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Card", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "Card", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Card
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty("Numero de la tarjeta")
    private Integer cardNumber;

    public Card() {
        //default constructor
    }

	public Integer getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Integer cardNumber) {
		this.cardNumber = cardNumber;
	}

    
}
