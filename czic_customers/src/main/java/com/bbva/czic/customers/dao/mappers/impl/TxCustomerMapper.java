package com.bbva.czic.customers.dao.mappers.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResumesFilter;
import com.bbva.czic.customers.business.dto.DTOIntCardCharge;
import com.bbva.czic.customers.business.dto.DTOIntCardChargeFilter;
import com.bbva.czic.customers.business.dto.DTOIntCustomer;
import com.bbva.czic.customers.business.dto.DTOIntCustomerFilter;
import com.bbva.czic.customers.dao.converters.CardChargeCategoryConverter;
import com.bbva.czic.customers.dao.mappers.ITxCustomerMapper;
import com.bbva.czic.customers.dao.model.oznb.FormatoOZNCENB0;
import com.bbva.czic.customers.dao.model.oznb.FormatoOZNCSNB0;
import com.bbva.czic.customers.dao.model.oznp.FormatoOZECNPE0;
import com.bbva.czic.customers.dao.model.oznp.FormatoOZECNPS0;
import com.bbva.czic.customers.dao.model.oznq.FormatoOZECNQE0;
import com.bbva.czic.customers.dao.model.oznq.FormatoOZECNQS0;
import com.bbva.czic.dto.net.ContactInfo;
import com.bbva.czic.dto.net.Email;
import com.bbva.czic.dto.net.EnumContactSourceType;
import com.bbva.czic.dto.net.PhoneNumber;
import com.bbva.czic.routine.commons.rm.utils.EDateFormat;
import com.bbva.czic.routine.commons.rm.utils.converter.MonthEnumConverter;
import com.bbva.czic.routine.commons.rm.utils.converter.StringMoneyConverter;
import com.bbva.czic.routine.commons.rm.utils.mappers.AbstractBbvaTxConfigurableMapper;
import com.bbva.czic.routine.mapper.MapperFactory;
import com.bbva.czic.routine.mapper.converter.builtin.DateToStringConverter;

@Component("txCustomerMapper")
public class TxCustomerMapper extends AbstractBbvaTxConfigurableMapper implements ITxCustomerMapper {

	public static final String MONTH_CONVERTER = "monthConverter";

	public static final String SIMPLE_DATE_CONVERTER = "simpleDateConverter";

	public static final String CARD_CHARGE_CATEGORY_CONVERTER = "cardChargeCategoryConverter";

	@Override
	protected void configure(MapperFactory factory) {
		super.configure(factory);

		factory.getConverterFactory().registerConverter(SIMPLE_DATE_CONVERTER,
				new DateToStringConverter(EDateFormat.ANIO_MES_DIA.getPattern()));
		factory.getConverterFactory().registerConverter(MONTH_CONVERTER, new MonthEnumConverter());
		factory.getConverterFactory().registerConverter(CARD_CHARGE_CATEGORY_CONVERTER,
				new CardChargeCategoryConverter());

		/**
		 * Convert HOST FORMAT (+EEEEEEEEDD) to COP Money
		 */
		factory.getConverterFactory().registerConverter(new StringMoneyConverter());

		factory.classMap(DTOIntCustomerFilter.class, FormatoOZNCENB0.class).field("id", "numclie").byDefault()
				.register();

		// map FormatoOZECNBS0 <-> DTOIntCustomer (OZNB)
		factory.classMap(DTOIntCustomer.class, FormatoOZNCSNB0.class).field("id", "numclie").field("name", "nomclie")
				.field("segment", "segment").field("stratum", "estrato").field("homeLocation.cityName", "ciudvia")
				.field("homeLocation.stateName", "depavia").field("homeLocation.countryName", "paisvia")
				.field("homeLocation.postalAddress", "descvia").field("residenceYears", "anosvda")
				.field("homeMembers", "nropnas").field("dwelingType", "tpovvda")
				.field("officeLocation.cityName", "ciudofi").field("officeLocation.stateName", "depaofi")
				.field("officeLocation.countryName", "paisofi").field("officeLocation.postalAddress", "descofi")
				.field("lastConnectionTime", "ultconx").byDefault().register();

		// map DTOIntAccMovementsResumesFilter <-> FormatoOZECNQE0
		factory.classMap(DTOIntAccMovementsResumesFilter.class, FormatoOZECNQE0.class).field("startDate", "fechain")
				.field("endDate", "fechafi").byDefault().register();

		// map FormatoOZECNQS0 <-> DTOIntAccMovementsResume
		factory.classMap(FormatoOZECNQS0.class, DTOIntAccMovementsResume.class).field("valdepo", "income")
				.field("valcarg", "outcome").field("saltota", "balance").fieldMap("mes", "month")
				.converter(MONTH_CONVERTER).add().byDefault().register();

		// map DTOIntCardChargeFilter <-> FormatoOZECNPE0
		factory.classMap(DTOIntCardChargeFilter.class, FormatoOZECNPE0.class)
				.fieldMap("startDate", "fechain").converter(SIMPLE_DATE_CONVERTER).add().fieldMap("endDate", "fechafi")
				.converter(SIMPLE_DATE_CONVERTER).add().byDefault().register();

		factory.classMap(FormatoOZECNPS0.class, DTOIntCardCharge.class).fieldMap("categor", "category")
				.converter(CARD_CHARGE_CATEGORY_CONVERTER).add().field("valcate", "amount").byDefault().register();

	}

	@Override
	public FormatoOZNCENB0 mapInOznb(DTOIntCustomerFilter customerFilter) {
		return map(customerFilter, FormatoOZNCENB0.class);
	}

	@Override
	public DTOIntCustomer mapOutOznb(FormatoOZNCSNB0 formatOutput) {
		DTOIntCustomer dtoIntCustomer = map(formatOutput, DTOIntCustomer.class);
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
		return dtoIntCustomer;
	}

	@Override
	public FormatoOZECNQE0 mapInOznq(DTOIntAccMovementsResumesFilter accMovementsResumesFilter) {
		return map(accMovementsResumesFilter, FormatoOZECNQE0.class);
	}

	@Override
	public DTOIntAccMovementsResume mapOutOznq(FormatoOZECNQS0 formatoSalida) {
		return map(formatoSalida, DTOIntAccMovementsResume.class);
	}

	@Override
	public FormatoOZECNPE0 mapInOznp(DTOIntCardChargeFilter cardChargeFilter) {
		return map(cardChargeFilter, FormatoOZECNPE0.class);
	}

	@Override
	public DTOIntCardCharge mapOutOznp(FormatoOZECNPS0 formatoSalida) {
		return map(formatoSalida, DTOIntCardCharge.class);
	}
}
