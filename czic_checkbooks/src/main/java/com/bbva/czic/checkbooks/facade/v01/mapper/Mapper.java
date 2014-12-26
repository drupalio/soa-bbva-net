package com.bbva.czic.checkbooks.facade.v01.mapper;

import org.springframework.beans.BeanUtils;

import com.bbva.czic.dto.net.EnumCheckStatus;
import com.bbva.czic.dto.net.Check;
import com.bbva.czic.dto.net.Checkbook;
import com.bbva.czic.dto.net.EnumCheckbookStatus;
import com.bbva.czic.checkbooks.business.dto.DTOIntEnumCheckStatus;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheck;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheckbook;
import com.bbva.czic.checkbooks.business.dto.DTOIntEnumCheckbookStatus;


public class Mapper {

		
 public static EnumCheckStatus enumCheckStatusMap(DTOIntEnumCheckStatus dtoIntEnumCheckStatus) { 
 		EnumCheckStatus enumCheckStatus = new EnumCheckStatus(); 
 		BeanUtils.copyProperties(dtoIntEnumCheckStatus, enumCheckStatus); 
 		return enumCheckStatus; 
 } 

		
 public static DTOIntEnumCheckStatus dtoIntEnumCheckStatusMap(EnumCheckStatus enumCheckStatus) { 
 		DTOIntEnumCheckStatus dtoIntEnumCheckStatus = new DTOIntEnumCheckStatus(); 
 		BeanUtils.copyProperties(enumCheckStatus, dtoIntEnumCheckStatus); 
 		return dtoIntEnumCheckStatus; 
 } 

		
 public static Check checkMap(DTOIntCheck dtoIntCheck) { 
 		Check check = new Check(); 
 		BeanUtils.copyProperties(dtoIntCheck, check); 
 		return check; 
 } 

		
 public static DTOIntCheck dtoIntCheckMap(Check check) { 
 		DTOIntCheck dtoIntCheck = new DTOIntCheck(); 
 		BeanUtils.copyProperties(check, dtoIntCheck); 
 		return dtoIntCheck; 
 } 

		
 public static Checkbook checkbookMap(DTOIntCheckbook dtoIntCheckbook) { 
 		Checkbook checkbook = new Checkbook(); 
 		BeanUtils.copyProperties(dtoIntCheckbook, checkbook); 
 		return checkbook; 
 } 

		
 public static DTOIntCheckbook dtoIntCheckbookMap(Checkbook checkbook) { 
 		DTOIntCheckbook dtoIntCheckbook = new DTOIntCheckbook(); 
 		BeanUtils.copyProperties(checkbook, dtoIntCheckbook); 
 		return dtoIntCheckbook; 
 } 

		
 public static EnumCheckbookStatus enumCheckbookStatusMap(DTOIntEnumCheckbookStatus dtoIntEnumCheckbookStatus) { 
 		EnumCheckbookStatus enumCheckbookStatus = new EnumCheckbookStatus(); 
 		BeanUtils.copyProperties(dtoIntEnumCheckbookStatus, enumCheckbookStatus); 
 		return enumCheckbookStatus; 
 } 

		
 public static DTOIntEnumCheckbookStatus dtoIntEnumCheckbookStatusMap(EnumCheckbookStatus enumCheckbookStatus) { 
 		DTOIntEnumCheckbookStatus dtoIntEnumCheckbookStatus = new DTOIntEnumCheckbookStatus(); 
 		BeanUtils.copyProperties(enumCheckbookStatus, dtoIntEnumCheckbookStatus); 
 		return dtoIntEnumCheckbookStatus; 
 } 

	
	
}

