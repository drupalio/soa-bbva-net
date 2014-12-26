package com.bbva.czic.cardcharge.facade.v01.mapper;

import org.springframework.beans.BeanUtils;

import com.bbva.czic.dto.net.CardCharge;
import com.bbva.czic.dto.net.Executive;
import com.bbva.czic.cardcharge.business.dto.DTOIntCardCharge;
import com.bbva.czic.cardcharge.business.dto.DTOIntExecutive;


public class Mapper {

		
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

		
 public static Executive excecutiveMap(DTOIntExecutive dtoIntExecutive) { 
 		Executive excecutive = new Executive(); 
 		BeanUtils.copyProperties(dtoIntExecutive, excecutive); 
 		return excecutive; 
 } 

		
 public static DTOIntExecutive dtoIntExecutiveMap(Executive excecutive) { 
 		DTOIntExecutive dtoIntExecutive = new DTOIntExecutive(); 
 		BeanUtils.copyProperties(excecutive, dtoIntExecutive); 
 		return dtoIntExecutive; 
 } 

	
	
}

