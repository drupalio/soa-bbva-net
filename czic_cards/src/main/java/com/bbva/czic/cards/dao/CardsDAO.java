package com.bbva.czic.cards.dao;

import java.util.Date;
import java.util.List;

import com.bbva.czic.cards.business.dto.DTOIntCardCharge;
import com.bbva.jee.arq.spring.core.host.transporte.ExcepcionTransporte;

public interface CardsDAO {

	public List<DTOIntCardCharge> getCreditCardCharges(String id,
			Date startDate, Date endDate) throws ExcepcionTransporte;
}
