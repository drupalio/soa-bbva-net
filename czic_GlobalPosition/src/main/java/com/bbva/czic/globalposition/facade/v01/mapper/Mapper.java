package com.bbva.czic.globalposition.facade.v01.mapper;

import com.bbva.czic.dto.net.*;
import com.bbva.czic.globalposition.business.dto.*;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;


public class Mapper {

	public static Product productMap(DTOIntProduct dtoIntProduct) {
		Product product = new Product();
		BeanUtils.copyProperties(dtoIntProduct, product);
		product.setType(dtoIntProduct.getType());
		return product;
	}


	public static DTOIntProduct dtoIntProductMap(Product product) {
		DTOIntProduct dtoIntProduct = new DTOIntProduct();
		BeanUtils.copyProperties(product, dtoIntProduct);
		dtoIntProduct.setType(product.getType());
		return dtoIntProduct;
	}

	public static PhoneNumber phoneNumberMap(DTOIntPhoneNumber dtoIntPhoneNumber) {
		PhoneNumber phoneNumber = new PhoneNumber();
		BeanUtils.copyProperties(dtoIntPhoneNumber, phoneNumber);
		return phoneNumber;
	}


	public static DTOIntPhoneNumber dtoIntPhoneNumberMap(PhoneNumber phoneNumber) {
		DTOIntPhoneNumber dtoIntPhoneNumber = new DTOIntPhoneNumber();
		BeanUtils.copyProperties(phoneNumber, dtoIntPhoneNumber);
		return dtoIntPhoneNumber;
	}


	public static ContactInfo contactInformationMap(DTOIntContactInfo dtoIntContactInfo) {
		ContactInfo contactInformation = new ContactInfo();
		BeanUtils.copyProperties(dtoIntContactInfo, contactInformation);
		return contactInformation;
	}


	public static DTOIntContactInfo dtoIntContactInformationMap(ContactInfo contactInformation) {
		DTOIntContactInfo dtoIntContactInfo = new DTOIntContactInfo();
		BeanUtils.copyProperties(contactInformation, dtoIntContactInfo);
		return dtoIntContactInfo;
	}


	public static Email emailMap(DTOIntEmail dtoIntEmail) {
		Email email = new Email();
		BeanUtils.copyProperties(dtoIntEmail, email);
		return email;
	}


	public static DTOIntEmail dtoIntEmailMap(Email email) {
		DTOIntEmail dtoIntEmail = new DTOIntEmail();
		BeanUtils.copyProperties(email, dtoIntEmail);
		return dtoIntEmail;
	}

	public static List<Product> productListMap(List<DTOIntProduct> intProducts) {

		List<Product> products = new ArrayList<Product>();

		for(DTOIntProduct intProduct: intProducts) {
			products.add(productMap(intProduct));
		}
		return products;
	}

}

