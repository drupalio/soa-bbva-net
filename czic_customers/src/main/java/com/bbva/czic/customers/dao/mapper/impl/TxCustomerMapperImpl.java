package com.bbva.czic.customers.dao.mapper.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bbva.czic.customers.business.dto.DTOIntCustomer;
import com.bbva.czic.customers.dao.mapper.TxCustomerMapper;
import com.bbva.czic.customers.dao.model.oznb.FormatoOZNCENB0;
import com.bbva.czic.customers.dao.model.oznb.FormatoOZNCSNB0;
import com.bbva.czic.dto.net.ContactInfo;
import com.bbva.czic.dto.net.Email;
import com.bbva.czic.dto.net.EnumContactSourceType;
import com.bbva.czic.dto.net.EnumDwelingType;
import com.bbva.czic.dto.net.EnumSegmentType;
import com.bbva.czic.dto.net.PhoneNumber;
import com.bbva.czic.dto.net.Place;
import com.bbva.czic.routine.commons.rm.utils.converter.StringMoneyConverter;
import com.bbva.czic.routine.mapper.MapperFactory;
import com.bbva.czic.routine.mapper.impl.ConfigurableMapper;

@Component("txCustomerMapper")
public class TxCustomerMapperImpl extends ConfigurableMapper implements
		TxCustomerMapper {

	@Override
	protected void configure(MapperFactory factory) {

		/**
		 * Convert HOST FORMAT (+EEEEEEEEDD) to COP Money
		 */
		factory.getConverterFactory().registerConverter(
				new StringMoneyConverter());

		/**
		 * MAPEO DE ENTRADAS
		 */

		/**
		 * MAPEO DE SALIDAS
		 */
		// Map FormatoOZECNBS0 <-> DTOIntCustomer (OZNB)
		// Se usa mapeo manual para evitar inconvenientes por desconocimiento
		// factory.classMap(DTOIntCustomer.class, FormatoOZNCSNB0.class)
		// .field("id", "numclie").field("name", "nomclie")
		// .field("segment", "segment").field("name", "nomclie")
		// .field("stratum", "estrato").field("residenceYears", "anosvda")
		// .field("homeMembers", "nropnas")
		// .field("lastConnectionTime", "ultconx").byDefault().register();

	}

	@Override
	public FormatoOZNCENB0 mapInOznb(String customerId) {
		return map(customerId, FormatoOZNCENB0.class);
	}

	@Override
	public DTOIntCustomer mapOutOznb(FormatoOZNCSNB0 formatOutput) {
		DTOIntCustomer customer = new DTOIntCustomer();

		// Entidad contact info
		ContactInfo contacto = new ContactInfo();
		List<Email> emails = new ArrayList<Email>();
		List<PhoneNumber> phones = new ArrayList<PhoneNumber>();
		Email email = new Email();
		email.setActive(true);
		email.setAddress(formatOutput.getCorreo());
		email.setPrimary(true);
		email.setSource(EnumContactSourceType.WEB);
		emails.add(email);
		contacto.setEmails(emails);
		contacto.setPhoneNumbers(phones);

		// Entidad place para ubicacion hogar
		Place home = new Place();
		home.setCityName(formatOutput.getCiudvia());
		home.setStateName(formatOutput.getDepavia());
		home.setCountryName(formatOutput.getPaisvia());
		home.setPostalAddress(formatOutput.getDescvia());

		// Entidad place para ubicacion oficina
		Place office = new Place();
		office.setCityName(formatOutput.getCiudofi());
		office.setStateName(formatOutput.getDepaofi());
		office.setCountryName(formatOutput.getPaisofi());
		office.setPostalAddress(formatOutput.getDescofi());

		// Entidad de retorno customer
		customer.setId(formatOutput.getNumclie());
		customer.setName(formatOutput.getNomclie());
		try {
			customer.setSegment(EnumSegmentType.valueOf(formatOutput
					.getSegment()));
		} catch (IllegalArgumentException e) {
			customer.setSegment(EnumSegmentType.OTRO);
		}
		customer.setEmails(contacto);
		customer.setHomeLocation(home);
		customer.setStratum(Integer.parseInt(formatOutput.getEstrato()));
		customer.setResidenceYears(Integer.parseInt(formatOutput.getAnosvda()));
		customer.setHomeMembers(Integer.parseInt(formatOutput.getNropnas()));
		try {
			customer.setDwelingType(EnumDwelingType.valueOf(formatOutput
					.getTpovvda()));
		} catch (IllegalArgumentException e) {
			customer.setDwelingType(EnumDwelingType.VALIDAR);
		}
		customer.setOfficeLocation(office);
//		Mapear fecha de ultima conexión
		return customer;
	}

}
