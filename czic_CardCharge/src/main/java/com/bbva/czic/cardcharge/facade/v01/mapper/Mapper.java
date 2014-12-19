package com.bbva.czic.cardcharge.facade.v01.mapper;

import org.springframework.beans.BeanUtils;

import com.bbva.czic.dto.net.CardCharge;
import com.bbva.czic.dto.net.Excecutive;
import com.bbva.czic.cardcharge.business.dto.DTOIntCardCharge;
import com.bbva.czic.cardcharge.business.dto.DTOIntExcecutive;


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

		
 public static Excecutive excecutiveMap(DTOIntExcecutive dtoIntExcecutive) { 
 		Excecutive excecutive = new Excecutive(); 
 		BeanUtils.copyProperties(dtoIntExcecutive, excecutive); 
 		return excecutive; 
 } 

		
 public static DTOIntExcecutive dtoIntExcecutiveMap(Excecutive excecutive) { 
 		DTOIntExcecutive dtoIntExcecutive = new DTOIntExcecutive(); 
 		BeanUtils.copyProperties(excecutive, dtoIntExcecutive); 
 		return dtoIntExcecutive; 
 } 

	
	
}

