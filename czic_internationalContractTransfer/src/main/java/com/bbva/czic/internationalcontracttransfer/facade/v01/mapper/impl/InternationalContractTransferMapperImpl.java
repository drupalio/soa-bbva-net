package com.bbva.czic.internationalcontracttransfer.facade.v01.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bbva.czic.dto.net.Contract;
import com.bbva.czic.dto.net.ContractTransferSender;
import com.bbva.czic.dto.net.InternationalContractTransfer;
import com.bbva.czic.dto.net.OptionsList;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntFilterInternationalContractTransfers;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntInternationalContractTransfer;
import com.bbva.czic.internationalcontracttransfer.facade.v01.mapper.IInternationalContractTransferMapper;
import com.bbva.czic.routine.commons.rm.utils.mappers.AbstractBbvaConfigurableMapper;

@Component(value = "internationalContractTransfer-mapper")
public class InternationalContractTransferMapperImpl extends AbstractBbvaConfigurableMapper implements
		IInternationalContractTransferMapper {

	@Override
	public InternationalContractTransfer map(DTOIntInternationalContractTransfer dtoInternationalContractTransfer) {
		InternationalContractTransfer internationalContractTransfer = new InternationalContractTransfer();
		internationalContractTransfer.setDate(dtoInternationalContractTransfer.getDate());
		OptionsList optionsList = new OptionsList();
		optionsList.setName(dtoInternationalContractTransfer.getTypeName());
		internationalContractTransfer.setType(optionsList);

		// info sender
		ContractTransferSender sender = new ContractTransferSender();
		Contract contractSender = new Contract();
		// contractSender.s
		// sender.setContract(contractSender);
		internationalContractTransfer.setSender(sender);
		// info receiver

		// info intermediary

		// info exchangeRate

		return internationalContractTransfer;
	}

	@Override
	public List<InternationalContractTransfer> mapList(
			List<DTOIntInternationalContractTransfer> dtoListInternationalContractTransfer) {
		List<InternationalContractTransfer> listInternationalContractTransfer = new ArrayList<InternationalContractTransfer>();
		return listInternationalContractTransfer;
	}

	@Override
	public DTOIntFilterInternationalContractTransfers map(String filter, String senderContractParticipantsId,
			Integer paginationKey, Integer pageSize, String expands) {

		DTOIntFilterInternationalContractTransfers filterInternational = new DTOIntFilterInternationalContractTransfers();
		if (filter != null) {
			final String referencesValue = this.getEqValue(filter, "referencesValue");
			final String typeName = this.getEqValue(filter, "typeName");
			final String dateStart = this.getGeValue(filter, "date");
			final String dateEnd = this.getLeValue(filter, "date");
			filterInternational.setReferencesValue(referencesValue);
			filterInternational.setTypeName(typeName);
			filterInternational.setDateStart(dateStart);
			filterInternational.setDateEnd(dateEnd);
		}
		filterInternational.setSenderContractParticipantsId(senderContractParticipantsId);
		filterInternational.setPaginationKey(paginationKey);
		filterInternational.setPageSize(pageSize);
		filterInternational.setExpands(expands);
		return filterInternational;
	}

}
