package com.bbva.czic.internationalcontracttransfer.facade.v01.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bbva.czic.dto.net.Address;
import com.bbva.czic.dto.net.Bank;
import com.bbva.czic.dto.net.Contract;
import com.bbva.czic.dto.net.ContractTransferReceiver;
import com.bbva.czic.dto.net.ContractTransferSender;
import com.bbva.czic.dto.net.Country;
import com.bbva.czic.dto.net.Document;
import com.bbva.czic.dto.net.ExchangeRate;
import com.bbva.czic.dto.net.ExchangeRateAssessments;
import com.bbva.czic.dto.net.ExternalReference;
import com.bbva.czic.dto.net.IdentityDocument;
import com.bbva.czic.dto.net.InternationalContractTransfer;
import com.bbva.czic.dto.net.OptionsList;
import com.bbva.czic.dto.net.Participant;
import com.bbva.czic.dto.net.Product;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntExchangeRateAssessments;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntExternalReference;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntFilterInternationalContractTransfers;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntIdentityDocument;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntInternationalContractTransfer;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntPerson;
import com.bbva.czic.internationalcontracttransfer.facade.v01.mapper.IInternationalContractTransferMapper;
import com.bbva.czic.routine.commons.rm.utils.mappers.AbstractBbvaConfigurableMapper;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;

@Component(value = "internationalContractTransfer-mapper")
public class InternationalContractTransferMapperImpl extends AbstractBbvaConfigurableMapper implements
		IInternationalContractTransferMapper {

	@Override
	public InternationalContractTransfer map(DTOIntInternationalContractTransfer dtoInternationalContractTransfer) {
		InternationalContractTransfer internationalContractTransfer = new InternationalContractTransfer();
		internationalContractTransfer.setDate(dtoInternationalContractTransfer.getDate());
		internationalContractTransfer.setId(dtoInternationalContractTransfer.getId());
		internationalContractTransfer.setConcept(dtoInternationalContractTransfer.getConcept());
		Money money = new Money();
		money.setCurrency(dtoInternationalContractTransfer.getAmount().getCurrency());
		money.setAmount(dtoInternationalContractTransfer.getAmount().getAmount());
		internationalContractTransfer.setAmount(money);
		OptionsList optionsList = new OptionsList();
		optionsList.setName(dtoInternationalContractTransfer.getState());
		internationalContractTransfer.setState(optionsList);
		internationalContractTransfer.setDate(dtoInternationalContractTransfer.getDate());
		Document docFormulary = new Document();
		docFormulary.setId(dtoInternationalContractTransfer.getFormularyTransfer().getId());
		internationalContractTransfer.setFormularyTransfer(docFormulary);

		optionsList = new OptionsList();
		optionsList.setName(dtoInternationalContractTransfer.getTypeName());
		internationalContractTransfer.setType(optionsList);

		// info referenceValue
		List<ExternalReference> references = new ArrayList<ExternalReference>();
		for (DTOIntExternalReference intReferences : dtoInternationalContractTransfer.getReferences()) {
			ExternalReference reference = new ExternalReference();
			reference.setId(intReferences.getId());
			reference.setValue(intReferences.getValue());
			references.add(reference);
		}
		internationalContractTransfer.setReferences(references);

		// info sender
		ContractTransferSender sender = new ContractTransferSender();
		Contract contractSender = new Contract();
		List<Participant> participants = new ArrayList<Participant>();

		for (int i = 0; i < dtoInternationalContractTransfer.getSender().getContract().getParticipants().size(); i++) {
			Participant participant = new Participant();
			participant.setId(dtoInternationalContractTransfer.getSender().getContract().getParticipants().get(i)
					.getId());
			participant.setName(dtoInternationalContractTransfer.getSender().getContract().getParticipants().get(i)
					.getName());

			List<IdentityDocument> listIdentityDocument = new ArrayList<IdentityDocument>();
			for (DTOIntIdentityDocument intIdentity : dtoInternationalContractTransfer.getSender().getContract()
					.getParticipants().get(i).getIdentityDocument()) {
				IdentityDocument document = new IdentityDocument();
				document.setNumber(intIdentity.getNumber());
				listIdentityDocument.add(document);
			}
			participant.setIdentityDocument(listIdentityDocument);
			participants.add(participant);
		}
		contractSender.setParticipants(participants);
		Product product = new Product();
		product.setId(dtoInternationalContractTransfer.getSender().getContract().getProduct().getId());
		contractSender.setProduct(product);
		Country country = new Country();
		country.setName(dtoInternationalContractTransfer.getSender().getContract().getCountry().getName());
		contractSender.setCountry(country);
		sender.setContract(contractSender);
		internationalContractTransfer.setSender(sender);

		// info receiver
		ContractTransferReceiver receiver = new ContractTransferReceiver();
		Contract contractReceiver = new Contract();
		participants = new ArrayList<Participant>();
		for (DTOIntPerson intParticipant : dtoInternationalContractTransfer.getReceiver().getContract()
				.getParticipants()) {
			Participant participant = new Participant();
			participant.setName(intParticipant.getName());
			participants.add(participant);
		}
		contractReceiver.setParticipants(participants);
		Bank bank = new Bank();
		bank.setName(dtoInternationalContractTransfer.getReceiver().getContract().getBank().getName());
		bank.setBicCode(dtoInternationalContractTransfer.getReceiver().getContract().getBank().getBicCode());
		contractReceiver.setBank(bank);
		country = new Country();
		country.setName(dtoInternationalContractTransfer.getReceiver().getContract().getCountry().getName());
		contractReceiver.setCountry(country);
		Address address = new Address();
		address.setCity(dtoInternationalContractTransfer.getReceiver().getContract().getAddress().getCity());
		contractReceiver.setAddress(address);
		receiver.setContract(contractReceiver);
		internationalContractTransfer.setReceiver(receiver);

		// info intermediary
		Contract intermediary = new Contract();
		bank = new Bank();
		bank.setName(dtoInternationalContractTransfer.getIntermediaryBankAccount().getBank().getName());
		bank.setBicCode(dtoInternationalContractTransfer.getIntermediaryBankAccount().getBank().getBicCode());
		intermediary.setBank(bank);
		country = new Country();
		country.setName(dtoInternationalContractTransfer.getIntermediaryBankAccount().getCountry().getName());
		intermediary.setCountry(country);
		address.setCity(dtoInternationalContractTransfer.getIntermediaryBankAccount().getAddress().getCity());
		intermediary.setAddress(address);
		product = new Product();
		product.setId(dtoInternationalContractTransfer.getIntermediaryBankAccount().getProduct().getId());
		intermediary.setProduct(product);
		internationalContractTransfer.setIntermediaryBankAccount(intermediary);

		// info exchangeRate
		ExchangeRate exchangeRate = new ExchangeRate();
		List<ExchangeRateAssessments> exchangeRateAssessments = new ArrayList<ExchangeRateAssessments>();
		for (DTOIntExchangeRateAssessments intAssessments : dtoInternationalContractTransfer.getExchangeRate()
				.getExchangeRateAssesments()) {
			ExchangeRateAssessments exchangeRateAssessment = new ExchangeRateAssessments();
			exchangeRateAssessment.setType(intAssessments.getType());
			exchangeRateAssessment.setValue(intAssessments.getValue());
			exchangeRateAssessments.add(exchangeRateAssessment);
		}
		exchangeRate.setExchangeRateAssessments(exchangeRateAssessments);
		internationalContractTransfer.setExchangeRate(exchangeRate);
		return internationalContractTransfer;
	}

	@Override
	public List<InternationalContractTransfer> mapList(
			List<DTOIntInternationalContractTransfer> dtoListInternationalContractTransfer) {

		List<InternationalContractTransfer> listInternationalContractTransfer = new ArrayList<InternationalContractTransfer>();
		for (DTOIntInternationalContractTransfer intInternational : dtoListInternationalContractTransfer) {
			InternationalContractTransfer internationalContractTransfer = map(intInternational);
			listInternationalContractTransfer.add(internationalContractTransfer);
		}
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
