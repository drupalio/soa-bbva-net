package com.bbva.czic.internationalcontracttransfer.facade.v01.mapper;

import org.springframework.beans.BeanUtils;

import com.bbva.czic.dto.net.Address;
import com.bbva.czic.dto.net.Bank;
import com.bbva.czic.dto.net.Contract;
import com.bbva.czic.dto.net.Country;
import com.bbva.czic.dto.net.Document;
import com.bbva.czic.dto.net.ExchangeRate;
import com.bbva.czic.dto.net.ExternalReference;
import com.bbva.czic.dto.net.IdentityDocument;
import com.bbva.czic.dto.net.InternationalContractTransfer;
import com.bbva.czic.dto.net.Person;
import com.bbva.czic.dto.net.Product;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntAddress;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntBank;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntContract;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntCountry;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntDocument;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntExchangeRate;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntExternalReference;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntIdentityDocument;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntInternationalContractTransfer;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntPerson;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntProduct;

public class Mapper {

	public static Product productMap(DTOIntProduct dtoIntProduct) {
		Product product = new Product();
		BeanUtils.copyProperties(dtoIntProduct, product);
		return product;
	}

	public static DTOIntProduct dtoIntProductMap(Product product) {
		DTOIntProduct dtoIntProduct = new DTOIntProduct();
		BeanUtils.copyProperties(product, dtoIntProduct);
		return dtoIntProduct;
	}

	public static IdentityDocument identityDocumentMap(DTOIntIdentityDocument dtoIntIdentityDocument) {
		IdentityDocument identityDocument = new IdentityDocument();
		BeanUtils.copyProperties(dtoIntIdentityDocument, identityDocument);
		return identityDocument;
	}

	public static DTOIntIdentityDocument dtoIntIdentityDocumentMap(IdentityDocument identityDocument) {
		DTOIntIdentityDocument dtoIntIdentityDocument = new DTOIntIdentityDocument();
		BeanUtils.copyProperties(identityDocument, dtoIntIdentityDocument);
		return dtoIntIdentityDocument;
	}

	public static Person personMap(DTOIntPerson dtoIntPerson) {
		Person person = new Person();
		BeanUtils.copyProperties(dtoIntPerson, person);
		return person;
	}

	public static DTOIntPerson dtoIntPersonMap(Person person) {
		DTOIntPerson dtoIntPerson = new DTOIntPerson();
		BeanUtils.copyProperties(person, dtoIntPerson);
		return dtoIntPerson;
	}

	public static Document documentMap(DTOIntDocument dtoIntDocument) {
		Document document = new Document();
		BeanUtils.copyProperties(dtoIntDocument, document);
		return document;
	}

	public static DTOIntDocument dtoIntDocumentMap(Document document) {
		DTOIntDocument dtoIntDocument = new DTOIntDocument();
		BeanUtils.copyProperties(document, dtoIntDocument);
		return dtoIntDocument;
	}

	public static Address addressMap(DTOIntAddress dtoIntAddress) {
		Address address = new Address();
		BeanUtils.copyProperties(dtoIntAddress, address);
		return address;
	}

	public static DTOIntAddress dtoIntAddressMap(Address address) {
		DTOIntAddress dtoIntAddress = new DTOIntAddress();
		BeanUtils.copyProperties(address, dtoIntAddress);
		return dtoIntAddress;
	}

	public static Contract contractMap(DTOIntContract dtoIntContract) {
		Contract contract = new Contract();
		BeanUtils.copyProperties(dtoIntContract, contract);
		return contract;
	}

	public static DTOIntContract dtoIntContractMap(Contract contract) {
		DTOIntContract dtoIntContract = new DTOIntContract();
		BeanUtils.copyProperties(contract, dtoIntContract);
		return dtoIntContract;
	}

	public static ExchangeRate exchangeRateMap(DTOIntExchangeRate dtoIntExchangeRate) {
		ExchangeRate exchangeRate = new ExchangeRate();
		BeanUtils.copyProperties(dtoIntExchangeRate, exchangeRate);
		return exchangeRate;
	}

	public static DTOIntExchangeRate dtoIntExchangeRateMap(ExchangeRate exchangeRate) {
		DTOIntExchangeRate dtoIntExchangeRate = new DTOIntExchangeRate();
		BeanUtils.copyProperties(exchangeRate, dtoIntExchangeRate);
		return dtoIntExchangeRate;
	}

	public static ExternalReference externalReferenceMap(DTOIntExternalReference dtoIntExternalReference) {
		ExternalReference externalReference = new ExternalReference();
		BeanUtils.copyProperties(dtoIntExternalReference, externalReference);
		return externalReference;
	}

	public static DTOIntExternalReference dtoIntExternalReferenceMap(ExternalReference externalReference) {
		DTOIntExternalReference dtoIntExternalReference = new DTOIntExternalReference();
		BeanUtils.copyProperties(externalReference, dtoIntExternalReference);
		return dtoIntExternalReference;
	}

	public static InternationalContractTransfer internationalContractTransferMap(
			DTOIntInternationalContractTransfer dtoIntInternationalContractTransfer) {
		InternationalContractTransfer internationalContractTransfer = new InternationalContractTransfer();
		BeanUtils.copyProperties(dtoIntInternationalContractTransfer, internationalContractTransfer);
		return internationalContractTransfer;
	}

	public static DTOIntInternationalContractTransfer dtoIntInternationalContractTransferMap(
			InternationalContractTransfer internationalContractTransfer) {
		DTOIntInternationalContractTransfer dtoIntInternationalContractTransfer = new DTOIntInternationalContractTransfer();
		BeanUtils.copyProperties(internationalContractTransfer, dtoIntInternationalContractTransfer);
		return dtoIntInternationalContractTransfer;
	}

	public static Bank bankMap(DTOIntBank dtoIntBank) {
		Bank bank = new Bank();
		BeanUtils.copyProperties(dtoIntBank, bank);
		return bank;
	}

	public static DTOIntBank dtoIntBankMap(Bank bank) {
		DTOIntBank dtoIntBank = new DTOIntBank();
		BeanUtils.copyProperties(bank, dtoIntBank);
		return dtoIntBank;
	}

	public static Country countryMap(DTOIntCountry dtoIntCountry) {
		Country country = new Country();
		BeanUtils.copyProperties(dtoIntCountry, country);
		return country;
	}

	public static DTOIntCountry dtoIntCountryMap(Country country) {
		DTOIntCountry dtoIntCountry = new DTOIntCountry();
		BeanUtils.copyProperties(country, dtoIntCountry);
		return dtoIntCountry;
	}

}
