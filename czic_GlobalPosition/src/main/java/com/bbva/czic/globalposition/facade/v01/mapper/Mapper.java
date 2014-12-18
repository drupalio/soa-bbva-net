package com.bbva.czic.globalposition.facade.v01.mapper;

import org.springframework.beans.BeanUtils;

import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.czic.dto.net.EnumFinancialStatusType;
import com.bbva.czic.dto.net.Product;
import com.bbva.czic.dto.net.Operation;
import com.bbva.czic.dto.net.EnumContactSourceType;
import com.bbva.czic.dto.net.PhoneNumber;
import com.bbva.czic.dto.net.ContactInformation;
import com.bbva.czic.dto.net.Email;
import com.bbva.czic.dto.net.Movement;
import com.bbva.czic.dto.net.EnumPhoneNumberType;
import com.bbva.czic.globalposition.business.dto.DTOIntEnumProductType;
import com.bbva.czic.globalposition.business.dto.DTOIntEnumFinancialStatusType;
import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.business.dto.DTOIntOperation;
import com.bbva.czic.globalposition.business.dto.DTOIntEnumContactSourceType;
import com.bbva.czic.globalposition.business.dto.DTOIntPhoneNumber;
import com.bbva.czic.globalposition.business.dto.DTOIntContactInfo;
import com.bbva.czic.globalposition.business.dto.DTOIntEmail;
import com.bbva.czic.globalposition.business.dto.DTOIntMovement;
import com.bbva.czic.globalposition.business.dto.DTOIntEnumPhoneNumberType;

import java.util.ArrayList;
import java.util.List;


public class Mapper {


	public static EnumProductType enumProductTypeMap(DTOIntEnumProductType dtoIntEnumProductType) {
		return EnumProductType.valueOf(dtoIntEnumProductType.name());
	}


	public static DTOIntEnumProductType dtoIntEnumProductTypeMap(EnumProductType enumProductType) {
		return DTOIntEnumProductType.valueOf(enumProductType.name());
	}


	public static EnumFinancialStatusType enumFinancialStatusTypeMap(DTOIntEnumFinancialStatusType dtoIntEnumFinancialStatusType) {
		return EnumFinancialStatusType.valueOf(dtoIntEnumFinancialStatusType.name());
	}


	public static DTOIntEnumFinancialStatusType dtoIntEnumFinancialStatusTypeMap(EnumFinancialStatusType enumFinancialStatusType) {
		return DTOIntEnumFinancialStatusType.valueOf(enumFinancialStatusType.name());
	}


	public static Product productMap(DTOIntProduct dtoIntProduct) {
		Product product = new Product();
		BeanUtils.copyProperties(dtoIntProduct, product);
		product.setType(EnumProductType.valueOf(dtoIntProduct.getProductType()));
		return product;
	}


	public static DTOIntProduct dtoIntProductMap(Product product) {
		DTOIntProduct dtoIntProduct = new DTOIntProduct();
		BeanUtils.copyProperties(product, dtoIntProduct);
		dtoIntProduct.setProductType(product.getType().name());
		return dtoIntProduct;
	}


	public static Operation operationMap(DTOIntOperation dtoIntOperation) {
		Operation operation = new Operation();
		BeanUtils.copyProperties(dtoIntOperation, operation);
		return operation;
	}


	public static DTOIntOperation dtoIntOperationMap(Operation operation) {
		DTOIntOperation dtoIntOperation = new DTOIntOperation();
		BeanUtils.copyProperties(operation, dtoIntOperation);
		return dtoIntOperation;
	}


	public static EnumContactSourceType enumContactSourceTypeMap(DTOIntEnumContactSourceType dtoIntEnumContactSourceType) {
		return EnumContactSourceType.valueOf(dtoIntEnumContactSourceType.name());
	}


	public static DTOIntEnumContactSourceType dtoIntEnumContactSourceTypeMap(EnumContactSourceType enumContactSourceType) {
		return DTOIntEnumContactSourceType.valueOf(enumContactSourceType.name());
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


	public static ContactInformation contactInformationMap(DTOIntContactInfo dtoIntContactInfo) {
		ContactInformation contactInformation = new ContactInformation();
		BeanUtils.copyProperties(dtoIntContactInfo, contactInformation);
		return contactInformation;
	}


	public static DTOIntContactInfo dtoIntContactInformationMap(ContactInformation contactInformation) {
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


	public static Movement movementMap(DTOIntMovement dtoIntMovement) {
		Movement movement = new Movement();
		BeanUtils.copyProperties(dtoIntMovement, movement);
		return movement;
	}


	public static DTOIntMovement dtoIntMovementMap(Movement movement) {
		DTOIntMovement dtoIntMovement = new DTOIntMovement();
		BeanUtils.copyProperties(movement, dtoIntMovement);
		return dtoIntMovement;
	}


	public static EnumPhoneNumberType enumPhoneNumberTypeMap(DTOIntEnumPhoneNumberType dtoIntEnumPhoneNumberType) {
		return EnumPhoneNumberType.valueOf(dtoIntEnumPhoneNumberType.name());
	}


	public static DTOIntEnumPhoneNumberType dtoIntEnumPhoneNumberTypeMap(EnumPhoneNumberType enumPhoneNumberType) {
		return DTOIntEnumPhoneNumberType.valueOf(enumPhoneNumberType.name());
	}

	public static List<Product> productListMap(List<DTOIntProduct> intProducts) {

		List<Product> products = new ArrayList<Product>();

		for(DTOIntProduct intProduct: intProducts) {
			products.add(productMap(intProduct));
		}
		return products;
	}

}

