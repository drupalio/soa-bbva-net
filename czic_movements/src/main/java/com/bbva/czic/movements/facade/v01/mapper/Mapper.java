package com.bbva.czic.movements.facade.v01.mapper;

import com.bbva.czic.dto.net.*;
import com.bbva.czic.movements.business.dto.*;
import org.springframework.beans.BeanUtils;


public class Mapper {

 public static DTOIntEnumProductType dtoIntEnumProductTypeMap(EnumProductType enumProductType) { 
 		DTOIntEnumProductType dtoIntEnumProductType = new DTOIntEnumProductType(); 
 		BeanUtils.copyProperties(enumProductType, dtoIntEnumProductType); 
 		return dtoIntEnumProductType; 
 } 

		
 public static Office officeMap(DTOIntOffice dtoIntOffice) {
 		Office office = new Office(); 
 		BeanUtils.copyProperties(dtoIntOffice, office); 
 		return office; 
 } 

		
 public static DTOIntOffice dtoIntOfficeMap(Office office) { 
 		DTOIntOffice dtoIntOffice = new DTOIntOffice(); 
 		BeanUtils.copyProperties(office, dtoIntOffice); 
 		return dtoIntOffice; 
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

		
 public static AccMoveDetail accMoveDetailMap(DTOIntAccMoveDetail dtoIntAccMoveDetail) {
 		AccMoveDetail accMoveDetail = new AccMoveDetail(); 
 		BeanUtils.copyProperties(dtoIntAccMoveDetail, accMoveDetail); 
 		return accMoveDetail; 
 } 

		
 public static DTOIntAccMoveDetail dtoIntAccMoveDetailMap(AccMoveDetail accMoveDetail) { 
 		DTOIntAccMoveDetail dtoIntAccMoveDetail = new DTOIntAccMoveDetail(); 
 		BeanUtils.copyProperties(accMoveDetail, dtoIntAccMoveDetail); 
 		return dtoIntAccMoveDetail; 
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

		
 public static DTOIntEnumAccountMoveStatus dtoIntEnumAccountMoveStatusMap(EnumAccountMoveStatus enumAccountMoveStatus) { 
 		DTOIntEnumAccountMoveStatus dtoIntEnumAccountMoveStatus = new DTOIntEnumAccountMoveStatus(); 
 		BeanUtils.copyProperties(enumAccountMoveStatus, dtoIntEnumAccountMoveStatus); 
 		return dtoIntEnumAccountMoveStatus; 
 } 

 public static DTOIntEnumAccountState dtoIntEnumAccountStateMap(EnumAccountState enumAccountState) { 
 		DTOIntEnumAccountState dtoIntEnumAccountState = new DTOIntEnumAccountState(); 
 		BeanUtils.copyProperties(enumAccountState, dtoIntEnumAccountState); 
 		return dtoIntEnumAccountState; 
 } 

	
	
}

