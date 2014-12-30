package com.bbva.czic.customers.facade.v01.mapper;

import org.springframework.beans.BeanUtils;

import com.bbva.czic.dto.net.CreditCard;
import com.bbva.czic.dto.net.Product;
import com.bbva.czic.dto.net.CardCharge;
import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.User;
import com.bbva.czic.dto.net.EnumCardChargeCategory;
import com.bbva.czic.dto.net.EnumMonth;
import com.bbva.czic.customers.business.dto.DTOIntCreditCard;
import com.bbva.czic.customers.business.dto.DTOIntProduct;
import com.bbva.czic.customers.business.dto.DTOIntCardCharge;
import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.customers.business.dto.DTOIntUser;
import com.bbva.czic.customers.business.dto.DTOIntEnumCardChargeCategory;
import com.bbva.czic.customers.business.dto.DTOIntEnumMonth;


public class Mapper {

		
 public static CreditCard creditCardMap(DTOIntCreditCard dtoIntCreditCard) { 
 		CreditCard creditCard = new CreditCard(); 
 		BeanUtils.copyProperties(dtoIntCreditCard, creditCard); 
 		return creditCard; 
 } 

		
 public static DTOIntCreditCard dtoIntCreditCardMap(CreditCard creditCard) { 
 		DTOIntCreditCard dtoIntCreditCard = new DTOIntCreditCard(); 
 		BeanUtils.copyProperties(creditCard, dtoIntCreditCard); 
 		return dtoIntCreditCard; 
 } 

		
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

		
 public static CardCharge cardChargeMap(DTOIntCardCharge dtoIntCardCharge) { 
 		CardCharge cardCharge = new CardCharge(); 
 		BeanUtils.copyProperties(dtoIntCardCharge, cardCharge); 
 		return cardCharge; 
 } 

		
 public static DTOIntCardCharge dtoIntCardChargeMap(CardCharge cardCharge) { 
 		DTOIntCardCharge dtoIntCardCharge = new DTOIntCardCharge(); 
 		BeanUtils.copyProperties(cardCharge, dtoIntCardCharge); 
 		return dtoIntCardCharge; 
 } 

		
 public static AccMovementsResume accMovementsResumeMap(DTOIntAccMovementsResume dtoIntAccMovementsResume) { 
 		AccMovementsResume accMovementsResume = new AccMovementsResume(); 
 		BeanUtils.copyProperties(dtoIntAccMovementsResume, accMovementsResume); 
 		return accMovementsResume; 
 } 

		
 public static DTOIntAccMovementsResume dtoIntAccMovementsResumeMap(AccMovementsResume accMovementsResume) { 
 		DTOIntAccMovementsResume dtoIntAccMovementsResume = new DTOIntAccMovementsResume(); 
 		BeanUtils.copyProperties(accMovementsResume, dtoIntAccMovementsResume); 
 		return dtoIntAccMovementsResume; 
 } 

		
 public static User userMap(DTOIntUser dtoIntUser) { 
 		User user = new User(); 
 		BeanUtils.copyProperties(dtoIntUser, user); 
 		return user; 
 } 

		
 public static DTOIntUser dtoIntUserMap(User user) { 
 		DTOIntUser dtoIntUser = new DTOIntUser(); 
 		BeanUtils.copyProperties(user, dtoIntUser); 
 		return dtoIntUser; 
 } 

		
 public static EnumCardChargeCategory enumCardChargeCategoryMap(DTOIntEnumCardChargeCategory dtoIntEnumCardChargeCategory) { 
 		EnumCardChargeCategory enumCardChargeCategory = new EnumCardChargeCategory(); 
 		BeanUtils.copyProperties(dtoIntEnumCardChargeCategory, enumCardChargeCategory); 
 		return enumCardChargeCategory; 
 } 

		
 public static DTOIntEnumCardChargeCategory dtoIntEnumCardChargeCategoryMap(EnumCardChargeCategory enumCardChargeCategory) { 
 		DTOIntEnumCardChargeCategory dtoIntEnumCardChargeCategory = new DTOIntEnumCardChargeCategory(); 
 		BeanUtils.copyProperties(enumCardChargeCategory, dtoIntEnumCardChargeCategory); 
 		return dtoIntEnumCardChargeCategory; 
 } 

		
 public static EnumMonth enumMonthMap(DTOIntEnumMonth dtoIntEnumMonth) { 
 		EnumMonth enumMonth = new EnumMonth(); 
 		BeanUtils.copyProperties(dtoIntEnumMonth, enumMonth); 
 		return enumMonth; 
 } 

		
 public static DTOIntEnumMonth dtoIntEnumMonthMap(EnumMonth enumMonth) { 
 		DTOIntEnumMonth dtoIntEnumMonth = new DTOIntEnumMonth(); 
 		BeanUtils.copyProperties(enumMonth, dtoIntEnumMonth); 
 		return dtoIntEnumMonth; 
 } 

	
	
}

