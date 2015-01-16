package com.bbva.czic.globalposition.facade.v01.mapper.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bbva.czic.dto.net.Balance;
import com.bbva.czic.dto.net.ContactInfo;
import com.bbva.czic.dto.net.Contract;
import com.bbva.czic.dto.net.Email;
import com.bbva.czic.dto.net.PhoneNumber;
import com.bbva.czic.dto.net.Product;
import com.bbva.czic.globalposition.business.dto.DTOIntBalance;
import com.bbva.czic.globalposition.business.dto.DTOIntContactInfo;
import com.bbva.czic.globalposition.business.dto.DTOIntContract;
import com.bbva.czic.globalposition.business.dto.DTOIntEmail;
import com.bbva.czic.globalposition.business.dto.DTOIntPhoneNumber;
import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.facade.v01.mapper.IGlobalPositionMapper;
import com.bbva.czic.routine.mapper.MapperFactory;
import com.bbva.czic.routine.mapper.factory.MoneyFactory;
import com.bbva.czic.routine.mapper.impl.ConfigurableMapper;
import com.bbva.czic.routine.mapper.metadata.TypeFactory;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;

@Component(value = "global-position-mapper")
public class GlobalPositionMapper extends ConfigurableMapper implements IGlobalPositionMapper {

	@Override
	protected void configure(MapperFactory factory) {

		// Add ProductDTO Factory
		factory.registerObjectFactory(new MoneyFactory(), TypeFactory.<Money> valueOf(Money.class));

		// PRODUCT
		factory.classMap(Product.class, DTOIntProduct.class).field("type", "productType").field("id", "id")
				.field("name", "name").field("alias", "alias").field("financialState", "financialState")
				.field("visible", "visible").field("operable", "operable").field("balance", "balance")
				.field("contactInfo", "contactInfo").field("contract", "contract").byDefault().register();
		// CONTRACT
		factory.classMap(Contract.class, DTOIntContract.class).field("number", "number").byDefault().register();

		// BALANCE
		factory.classMap(Balance.class, DTOIntBalance.class).field("total", "total")
				.field("availableBalance", "availableBalance").byDefault().register();

		// CONTACT_INFO
		factory.classMap(ContactInfo.class, DTOIntContactInfo.class).field("phoneNumbers", "phoneNumbers")
				.field("emails", "emails").byDefault().register();

		// PHONE_NUMBERS
		factory.classMap(PhoneNumber.class, DTOIntPhoneNumber.class).field("number", "number")
				.field("countryCode", "countryCode").field("regionalCode", "regionalCode").field("type", "type")
				.field("primary", "primary").field("active", "active").field("contactSource", "contactSource")
				.byDefault().register();
		// EMAILS
		factory.classMap(Email.class, DTOIntEmail.class).field("address", "address").field("primary", "primary")
				.field("active", "active").field("source", "source").byDefault().register();
	}

	@Override
	public List<Product> map(List<DTOIntProduct> intProducts) {
		return mapAsList(intProducts, Product.class);
	}

	public List<DTOIntProduct> mapOut(List<Product> intProducts) {
		return mapAsList(intProducts, DTOIntProduct.class);
	}

}
