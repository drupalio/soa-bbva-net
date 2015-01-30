package com.bbva.czic.customers.facade.v01.mapper;

import com.bbva.czic.customers.business.dto.*;
import com.bbva.czic.customers.facade.v01.mapper.impl.IMapper;
import com.bbva.czic.dto.net.*;
import com.bbva.czic.routine.commons.rm.utils.mappers.AbstractBbvaConfigurableMapper;
import com.bbva.czic.routine.mapper.MapperFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component(value = "account-mapper")
public class Mapper  extends AbstractBbvaConfigurableMapper implements IMapper{

	/**
	 *
	 * @param factory
	 */
	@Override
	protected void configure(MapperFactory factory) {

		super.configure(factory);

		//implementacion de mapeos

	}

		
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
	 return EnumCardChargeCategory.valueOf(dtoIntEnumCardChargeCategory.name());
 } 

		
 public static DTOIntEnumCardChargeCategory dtoIntEnumCardChargeCategoryMap(EnumCardChargeCategory enumCardChargeCategory) {
	 return DTOIntEnumCardChargeCategory.valueOf(enumCardChargeCategory.name());
 } 

		
 public static EnumMonth enumMonthMap(DTOIntEnumMonth dtoIntEnumMonth) {
	 return EnumMonth.valueOf(dtoIntEnumMonth.name());
 } 

		
 public static DTOIntEnumMonth dtoIntEnumMonthMap(EnumMonth enumMonth) {
	 return DTOIntEnumMonth.valueOf(enumMonth.name());
 }

	@Override
	public Customer map(DTOIntCustomer dtoIntCustomer) {
		return map(dtoIntCustomer, Customer.class);
	}
}

