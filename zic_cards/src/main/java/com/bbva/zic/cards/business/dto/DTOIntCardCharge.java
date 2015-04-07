package com.bbva.zic.cards.business.dto;

import com.bbva.zic.dto.net.EnumCardChargeCategory;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;

public class DTOIntCardCharge {

	public final static long serialVersionUID = 1L;
	private String category;
	private Money amount;

	public DTOIntCardCharge() {
		// default constructor
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Money getAmount() {
		return amount;
	}

	public void setAmount(Money amount) {
		this.amount = amount;
	}

}
