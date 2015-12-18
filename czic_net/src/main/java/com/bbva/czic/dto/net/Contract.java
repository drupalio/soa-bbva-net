package com.bbva.czic.dto.net;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.validator.constraints.NotBlank;

import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Contract", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "Contract", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Contract implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "Identificador del contrato", required = true)
	private String number;
	@ApiModelProperty(value = "Identificador del contrato")
	private Bank bank;
	@ApiModelProperty(value = "Identificador del contrato")
	private Country country;
	@ApiModelProperty(value = "Identificador del contrato")
	private Address address;
	@ApiModelProperty(value = "Identificador del contrato")
	private Product product;
	@ApiModelProperty(value = "Identificador del contrato")
	private List<Participant> participants;
	
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}
    
}
