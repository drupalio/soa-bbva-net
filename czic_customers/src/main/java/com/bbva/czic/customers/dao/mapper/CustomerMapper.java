package com.bbva.czic.customers.dao.mapper;

import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.customers.business.dto.DTOIntCardCharge;
import com.bbva.czic.customers.business.dto.DTOIntEnumCardChargeCategory;
import com.bbva.czic.customers.business.dto.DTOIntEnumMonth;
import com.bbva.czic.customers.dao.model.ozno.FormatoOZECNOS0;
import com.bbva.czic.customers.dao.model.oznq.FormatoOZECNQS0;
import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.CardCharge;
import com.bbva.czic.dto.net.EnumCardChargeCategory;
import com.bbva.czic.dto.net.EnumMonth;
import com.bbva.czic.routine.commons.rm.utils.converter.UtilsConverter;
import com.bbva.czic.routine.commons.rm.utils.mappers.Mapper;

@Mapper("customerMapper")
public class CustomerMapper implements ICustomerMapper{

	@Override
	public DTOIntCardCharge map(FormatoOZECNOS0 formatoSalida) {
		DTOIntCardCharge dto = new DTOIntCardCharge();
		dto.setAmount(UtilsConverter.getMoneyDTO(formatoSalida.getValcate()));
		dto.setCategory(DTOIntEnumCardChargeCategory.valueOf(formatoSalida.getCategor()));
		return dto;
	}


	@Override
	public AccMovementsResume map(DTOIntAccMovementsResume item) {
		AccMovementsResume resume = new AccMovementsResume();
		resume.setBalance(item.getBalance());
		resume.setIncome(item.getIncome());
		resume.setMonth(EnumMonth.valueOf(item.getMonth().name()));
		resume.setOutcome(item.getOutcome());
		return resume;
	}


	@Override
	public DTOIntAccMovementsResume map(FormatoOZECNQS0 formatoSalida) {
		DTOIntAccMovementsResume resume = new DTOIntAccMovementsResume();
		resume.setBalance(UtilsConverter.getMoneyDTO(formatoSalida.getSaltota()));
		resume.setOutcome(UtilsConverter.getMoneyDTO(formatoSalida.getValcarg()));
		resume.setIncome(UtilsConverter.getMoneyDTO(formatoSalida.getValdepo()));
		resume.setMonth(DTOIntEnumMonth.valueOf(formatoSalida.getMes()));
		return resume;
	}


	@Override
	public CardCharge map(DTOIntCardCharge item) {
		CardCharge cardCharge  = new CardCharge();
		cardCharge.setAmount(item.getAmount());
		cardCharge.setCategory(EnumCardChargeCategory.valueOf(item.getCategory().name()));
		return cardCharge;
	}

}
