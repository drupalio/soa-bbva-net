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
import com.bbva.czic.dto.net.City;
import com.bbva.czic.dto.net.ContactInfo;
import com.bbva.czic.dto.net.Country;
import com.bbva.czic.dto.net.Customer;
import com.bbva.czic.dto.net.Document;
import com.bbva.czic.dto.net.Email;
import com.bbva.czic.dto.net.EnumContactSourceType;
import com.bbva.czic.dto.net.EnumDocumentType;
import com.bbva.czic.dto.net.EnumDwelingType;
import com.bbva.czic.dto.net.EnumMonth;
import com.bbva.czic.dto.net.Location;
import com.bbva.czic.dto.net.PhoneNumber;
import com.bbva.czic.dto.net.State;
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
		customer.setDocument(item.getDocument());
		customer.setContactInfo(item.getContactInfo());
		customer.setDwelingType(item.getDwelingType());
		customer.setHomeLocation(item.getHomeLocation());
		customer.setHomeMembers(item.getHomeMembers());
		customer.setLastConnectionTime(item.getLastConnectionTime());
		customer.setName(item.getName());
		customer.setOfficeLocation(item.getOfficeLocation());
		customer.setResidenceYears(item.getResidenceYears());
		customer.setStratum(item.getStratum());
		return customer;
	}


	public static DTOIntCustomer mapToOuter(FormatoOZNCSNB0 formatoSalida) {
		DTOIntCustomer customer = new DTOIntCustomer();
		Document document = new Document();
		ContactInfo contacto = new ContactInfo();
		List<Email> emails = new ArrayList<Email>();
		List<PhoneNumber> phones = new ArrayList<PhoneNumber>();
		List<City> cities = new ArrayList<City>();
		List<State> states = new ArrayList<State>();
		Location home = new Location();
		Location office = new Location();
		Country country = new Country();
		State state = new State();
		City city = new City();
		city.setName(formatoSalida.getCiudvia());
		city.setId("1");
		cities.add(city);
		state.setName(formatoSalida.getDepavia());
		state.setId("1");
		state.setCities(cities);
		country.setName(formatoSalida.getPaisvia());
		country.setId("0013");
		country.setStates(states);
		home.setPostalAddress(formatoSalida.getDescvia());
		
		cities.clear();
		states.clear();
		
		city.setName(formatoSalida.getCiudofi());
		city.setId("1");
		cities.add(city);
		state.setName(formatoSalida.getDepaofi());
		state.setId("1");
		state.setCities(cities);
		country.setName(formatoSalida.getPaisofi());
		country.setId("0013");
		country.setStates(states);
		home.setPostalAddress(formatoSalida.getDescofi());
		
		Email email = new Email();
		email.setActive(true);
		email.setAddress("contractor@bbva.com");
		email.setPrimary(true);
		email.setSource(EnumContactSourceType.WEB);
		emails.add(email);
		contacto.setEmails(emails);
		contacto.setPhoneNumbers(phones);
		document.setNumber(formatoSalida.getNumclie());
		document.setType(EnumDocumentType.CEDULACIUDADANIA);
		customer.setDocument(document);
		customer.setName("Nombre");
		customer.setContactInfo(contacto);
		customer.setHomeLocation(home);
		customer.setStratum(Integer.parseInt(formatoSalida.getEstrato()));
		customer.setResidenceYears(formatoSalida.getAnosvda().intValue());
		customer.setHomeMembers(formatoSalida.getNropnas());
		customer.setDwelingType(EnumDwelingType.valueOf(formatoSalida.getTpovvda()));
		if(customer.getDwelingType()==null){
			customer.setDwelingType(EnumDwelingType.VALIDAR);
		}
		customer.setOfficeLocation(office);
		return customer;
	}

}
