package com.bbva.czic.cards.business.dto;

import com.bbva.czic.dto.net.EnumCardChargeCategory;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;

public class DTOIntCardCharge {

	public final static long serialVersionUID = 1L;
	private EnumCardChargeCategory category;
	private Money amount;

	public DTOIntCardCharge() {
		// default constructor
	}

	public EnumCardChargeCategory getCategory() {
		return category;
	}

	public void setCategory(EnumCardChargeCategory category) {
		this.category = category;
	}

	public Money getAmount() {
		return amount;
	}

	public void setAmount(Money amount) {
		this.amount = amount;
	}

}
