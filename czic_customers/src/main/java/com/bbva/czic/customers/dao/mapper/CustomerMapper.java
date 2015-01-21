package com.bbva.czic.customers.dao.mapper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.customers.business.dto.DTOIntCardCharge;
import com.bbva.czic.customers.business.dto.DTOIntCustomer;
import com.bbva.czic.customers.business.dto.DTOIntEnumMonth;
import com.bbva.czic.customers.dao.model.oznb.FormatoOZNCSNB0;
import com.bbva.czic.customers.dao.model.oznp.FormatoOZECNPS0;
import com.bbva.czic.customers.dao.model.oznq.FormatoOZECNQS0;
import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.CardCharge;
import com.bbva.czic.dto.net.ContactInfo;
import com.bbva.czic.dto.net.Customer;
import com.bbva.czic.dto.net.Email;
import com.bbva.czic.dto.net.EnumContactSourceType;
import com.bbva.czic.dto.net.EnumDwelingType;
import com.bbva.czic.dto.net.EnumMonth;
import com.bbva.czic.dto.net.EnumSegmentType;
import com.bbva.czic.dto.net.PhoneNumber;
import com.bbva.czic.dto.net.Place;
import com.bbva.czic.routine.commons.rm.utils.converter.UtilsConverter;

@Component("customerMapper")
public class CustomerMapper implements ICustomerMapper{

	@Override
	public DTOIntCardCharge map(FormatoOZECNPS0 formatoSalida) {
		DTOIntCardCharge dto = new DTOIntCardCharge();
		dto.setAmount(UtilsConverter.getMoneyDTO(formatoSalida.getValcate()));
		dto.setCategory(formatoSalida.getCategor());
		return dto;
	}


	@Override
	public AccMovementsResume map(DTOIntAccMovementsResume item) {
		AccMovementsResume resume = new AccMovementsResume();
		resume.setBalance(item.getBalance());
		resume.setIncome(item.getIncome());
		Calendar cal = Calendar.getInstance();
		cal.setTime(item.getMonth());
		resume.setMonth(EnumMonth.getByCode("" + cal.get(Calendar.MONTH)));
		resume.setOutcome(item.getOutcome());
		return resume;
	}


	@Override
	public DTOIntAccMovementsResume map(FormatoOZECNQS0 formatoSalida) {
		DTOIntAccMovementsResume resume = new DTOIntAccMovementsResume();
		resume.setBalance(UtilsConverter.getMoneyDTO(formatoSalida.getSaltota()));
		resume.setOutcome(UtilsConverter.getMoneyDTO(formatoSalida.getValcarg()));
		resume.setIncome(UtilsConverter.getMoneyDTO(formatoSalida.getValdepo()));
		resume.setMonth(DTOIntEnumMonth.getBycode(formatoSalida.getMes()));
		return resume;
	}


	@Override
	public CardCharge map(DTOIntCardCharge item) {
		CardCharge cardCharge  = new CardCharge();
		cardCharge.setAmount(item.getAmount());
		cardCharge.setCategory(item.getCategory());
		return cardCharge;
	}


	@Override
	public Customer map(DTOIntCustomer item) {
		Customer customer = new Customer();
		customer.setId(item.getId());
		customer.setName(item.getName());
		customer.setUsername(item.getUsername());
		customer.setDocument(item.getDocument());
		customer.setContactInfo(item.getEmails());
		customer.setDwelingType(item.getDwelingType());
		customer.setHomeLocation(item.getHomeLocation());
		customer.setHomeMembers(item.getHomeMembers());
		customer.setName(item.getName());
		customer.setOfficeLocation(item.getOfficeLocation());
		customer.setResidenceYears(item.getResidenceYears());
		customer.setStratum(item.getStratum());
		return customer;
	}


	public static DTOIntCustomer mapToOuter(FormatoOZNCSNB0 formatoSalida) {
		DTOIntCustomer customer = new DTOIntCustomer();
		
//		Entidad contact info
		ContactInfo contacto = new ContactInfo();
		List<Email> emails = new ArrayList<Email>();
		List<PhoneNumber> phones = new ArrayList<PhoneNumber>();
		Email email = new Email();
		email.setActive(true);
		email.setAddress(formatoSalida.getCorreo());
		email.setPrimary(true);
		email.setSource(EnumContactSourceType.WEB);
		emails.add(email);
		contacto.setEmails(emails);
		contacto.setPhoneNumbers(phones);
		
//		Entidad place para ubicacion hogar
		Place home = new Place();
		home.setCityName(formatoSalida.getCiudvia());
		home.setStateName(formatoSalida.getDepavia());
		home.setCountryName(formatoSalida.getPaisvia());
		home.setPostalAddress(formatoSalida.getDescvia());
		
//		Entidad place para ubicacion oficina
		Place office = new Place();
		office.setCityName(formatoSalida.getCiudofi());
		office.setStateName(formatoSalida.getDepaofi());
		office.setCountryName(formatoSalida.getPaisofi());
		office.setPostalAddress(formatoSalida.getDescofi());
		
//		Entidad de retorno customer
		customer.setId(formatoSalida.getNumclie());
		customer.setName(formatoSalida.getNomclie());
		try {
			customer.setSegment(EnumSegmentType.valueOf(formatoSalida.getSegment()));
		} catch (IllegalArgumentException e) {
			customer.setSegment(EnumSegmentType.OTRO);
		}
		customer.setEmails(contacto);
		customer.setHomeLocation(home);
		customer.setStratum(Integer.parseInt(formatoSalida.getEstrato()));
		customer.setResidenceYears(Integer.parseInt(formatoSalida.getAnosvda()));
		customer.setHomeMembers(Integer.parseInt(formatoSalida.getNropnas()));
		try {
			customer.setDwelingType(EnumDwelingType.valueOf(formatoSalida.getTpovvda()));
		} catch (IllegalArgumentException e) {
			customer.setDwelingType(EnumDwelingType.VALIDAR);
		}
		customer.setOfficeLocation(office);
		return customer;
	}

}
