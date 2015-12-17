package com.bbva.czic.internationalcontracttransfer.facade.v01.mapper.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.bbva.czic.dto.net.InternationalContractTransfer;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntAddress;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntBank;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntContract;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntContractTransferReceiver;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntContractTransferSender;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntCountry;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntDocument;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntExchangeRate;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntExchangeRateAssessments;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntExternalReference;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntFilterInternationalContractTransfers;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntIdentityDocument;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntInternationalContractTransfer;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntMoney;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntPerson;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntProduct;
import com.bbva.czic.internationalcontracttransfer.facade.v01.mapper.IInternationalContractTransferMapper;
import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;

public class InternationalContractTransferMapperTest extends SpringContextBbvaTest {

	private IInternationalContractTransferMapper internationalMapper;

	@Before
	public void init() {
		internationalMapper = new InternationalContractTransferMapperImpl();
	}

	@Test
	public void testIntFilterInternational() {
		DTOIntFilterInternationalContractTransfers dtoFilterInternational = internationalMapper.map(
				"(referencesValue==12345,(typeName==HACIA;date=ge=2015-01-10;date=le=2015-02-12))", "1025049283", 0010,
				20, "");
		Assert.assertNotNull(dtoFilterInternational);
		Assert.assertEquals("12345", dtoFilterInternational.getReferencesValue());
		Assert.assertEquals("HACIA", dtoFilterInternational.getTypeName());
		Assert.assertEquals("2015-01-10", dtoFilterInternational.getDateStart());
		Assert.assertEquals("2015-02-12", dtoFilterInternational.getDateEnd());
		Assert.assertEquals("1025049283", dtoFilterInternational.getSenderContractParticipantsId());
		Assert.assertSame(0010, dtoFilterInternational.getPaginationKey());
		Assert.assertSame(20, dtoFilterInternational.getPageSize());
		Assert.assertEquals("", dtoFilterInternational.getExpands());
	}

	@Test
	public void testInternationalContractTransfer() {
		final DTOIntInternationalContractTransfer dtoInternationalContractTransfer = new DTOIntInternationalContractTransfer();
		dtoInternationalContractTransfer.setDate("");
		dtoInternationalContractTransfer.setTypeName("");
		final DTOIntMoney intMoney = new DTOIntMoney();
		intMoney.setCurrency("USD");
		intMoney.setAmount(new BigDecimal(10000));
		dtoInternationalContractTransfer.setAmount(intMoney);
		dtoInternationalContractTransfer.setState("En proceso");
		final DTOIntDocument formularyTransfer = new DTOIntDocument();
		formularyTransfer.setId("2021");
		dtoInternationalContractTransfer.setFormularyTransfer(formularyTransfer);

		// info sender
		final DTOIntContractTransferSender intContractTransferSender = new DTOIntContractTransferSender();
		final DTOIntContract intContractSender = new DTOIntContract();
		intContractTransferSender.setContract(intContractSender);
		final List<DTOIntPerson> listParticipants = new ArrayList<DTOIntPerson>();
		DTOIntPerson intPerson = new DTOIntPerson();
		intPerson.setId("132112421");
		DTOIntIdentityDocument identityDocument = new DTOIntIdentityDocument();
		identityDocument.setNumber("1026283049");
		List<DTOIntIdentityDocument> listIdentityDocument = new ArrayList<DTOIntIdentityDocument>();
		listIdentityDocument.add(identityDocument);
		intPerson.setIdentityDocument(listIdentityDocument);
		intPerson.setName("Pedro");
		listParticipants.add(intPerson);
		intContractSender.setParticipants(listParticipants);
		final DTOIntProduct dtoIntProduct = new DTOIntProduct();
		dtoIntProduct.setId("1234142134");
		intContractSender.setProduct(dtoIntProduct);
		dtoInternationalContractTransfer.setSender(intContractTransferSender);

		final List<DTOIntExternalReference> listIntExternalReference = new ArrayList<DTOIntExternalReference>();
		final DTOIntExternalReference intExternalReference = new DTOIntExternalReference();
		listIntExternalReference.add(intExternalReference);
		dtoInternationalContractTransfer.setReferences(listIntExternalReference);

		dtoInternationalContractTransfer.setId("1");
		dtoInternationalContractTransfer.setConcept("Transferencia");

		// Info receiver
		final DTOIntContractTransferReceiver intContractReceiver = new DTOIntContractTransferReceiver();
		final DTOIntContract intContract = new DTOIntContract();
		intPerson = new DTOIntPerson();
		intPerson.setName("Carlos");
		List<DTOIntPerson> listIntPerson = new ArrayList<DTOIntPerson>();
		listIntExternalReference.add(intExternalReference);
		intContract.setParticipants(listIntPerson);
		final DTOIntBank intBank = new DTOIntBank();
		intBank.setName("cityBank");
		intBank.setBicCode("000001");
		intContract.setBank(intBank);
		final DTOIntCountry intCountry = new DTOIntCountry();
		intCountry.setName("España");
		intContract.setCountry(intCountry);
		final DTOIntAddress intAddress = new DTOIntAddress();
		intAddress.setCity("Madrid");
		intContract.setAddress(intAddress);
		intContractReceiver.setContract(intContract);
		dtoInternationalContractTransfer.setReceiver(intContractReceiver);

		// info intermediary
		final DTOIntContract intermediaryBankAccount = new DTOIntContract();
		intBank.setName("bankIn");
		intBank.setBicCode("00002");
		intermediaryBankAccount.setBank(intBank);
		intCountry.setName("Portugal");
		intermediaryBankAccount.setCountry(intCountry);
		intAddress.setCity("Lisboa");
		dtoIntProduct.setId("896237632");
		intermediaryBankAccount.setProduct(dtoIntProduct);
		dtoInternationalContractTransfer.setIntermediaryBankAccount(intermediaryBankAccount);

		// info references
		final DTOIntExternalReference reference = new DTOIntExternalReference();
		reference.setId("ReferenciaBBVA");
		reference.setValue("01234");
		List<DTOIntExternalReference> listReference = new ArrayList<DTOIntExternalReference>();
		listReference.add(reference);
		// info exchangeRate
		final DTOIntExchangeRate exchangeRate = new DTOIntExchangeRate();
		List<DTOIntExchangeRateAssessments> listAssesments = new ArrayList<DTOIntExchangeRateAssessments>();
		DTOIntExchangeRateAssessments exchangeRateAssesments = new DTOIntExchangeRateAssessments();
		exchangeRateAssesments.setType("TasaDivisaUSD");
		exchangeRateAssesments.setValue(new BigDecimal(12345));
		listAssesments.add(exchangeRateAssesments);
		exchangeRate.setExchangeRateAssesments(exchangeRateAssesments);

		final InternationalContractTransfer internationalContractTransfer = internationalMapper
				.map(dtoInternationalContractTransfer);
		Assert.assertNotNull(internationalContractTransfer);

	}

	@Test
	public void testListInternationalContractTransfer() {

	}
}
