package com.bbva.zic.dto.net;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Balance", namespace = "urn:com:bbva:zic:dto:net")
@XmlType(name = "Balance", namespace = "urn:com:bbva:zic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Balance implements Serializable {

	public final static long serialVersionUID = 1L;
	//@XmlJavaTypeAdapter(MoneyAdapter.class)
	@XmlElement(type = Money.class)
	@ApiModelProperty("Saldo total del producto")
	private Money total;
	//@XmlJavaTypeAdapter(MoneyAdapter.class)
	@XmlElement(type = Money.class)
	@ApiModelProperty("Saldo disponible del producto")
	private Money availableBalance;

	public Balance() {
		// default constructor
	}

	public Balance(Money total) {
		this.total = total;
	}

	public Money getTotal() {
		return total;
	}

	public void setTotal(Money total) {
		this.total = total;
	}

	public Money getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(Money availableBalance) {
		this.availableBalance = availableBalance;
	}

}
