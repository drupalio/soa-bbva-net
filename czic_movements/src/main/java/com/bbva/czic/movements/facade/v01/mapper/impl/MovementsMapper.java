package com.bbva.czic.movements.facade.v01.mapper.impl;

import com.bbva.czic.dto.net.*;
import com.bbva.czic.movements.business.dto.*;
import com.bbva.czic.movements.facade.v01.mapper.IMovementsMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;


@Component(value = "movements-mapper")
public class MovementsMapper implements IMovementsMapper{

	@Override
	public  DTOIntEnumProductType dtoIntEnumProductTypeMap(EnumProductType enumProductType) {
		DTOIntEnumProductType dtoIntEnumProductType = new DTOIntEnumProductType();
		BeanUtils.copyProperties(enumProductType, dtoIntEnumProductType);
		return dtoIntEnumProductType;
	}


	@Override
	public  Office officeMap(DTOIntOffice dtoIntOffice) {
		Office office = new Office();
		BeanUtils.copyProperties(dtoIntOffice, office);
		return office;
	}


	@Override
	public  DTOIntOffice dtoIntOfficeMap(Office office) {
		DTOIntOffice dtoIntOffice = new DTOIntOffice();
		BeanUtils.copyProperties(office, dtoIntOffice);
		return dtoIntOffice;
	}


	@Override
	public  Operation operationMap(DTOIntOperation dtoIntOperation) {
		Operation operation = new Operation();
		BeanUtils.copyProperties(dtoIntOperation, operation);
		return operation;
	}


	@Override
	public  DTOIntOperation dtoIntOperationMap(Operation operation) {
		DTOIntOperation dtoIntOperation = new DTOIntOperation();
		BeanUtils.copyProperties(operation, dtoIntOperation);
		return dtoIntOperation;
	}


	@Override
	public  AccMoveDetail accMoveDetailMap(DTOIntAccMoveDetail dtoIntAccMoveDetail) {
		AccMoveDetail accMoveDetail = new AccMoveDetail();
		BeanUtils.copyProperties(dtoIntAccMoveDetail, accMoveDetail);
		return accMoveDetail;
	}


	@Override
	public  DTOIntAccMoveDetail dtoIntAccMoveDetailMap(AccMoveDetail accMoveDetail) {
		DTOIntAccMoveDetail dtoIntAccMoveDetail = new DTOIntAccMoveDetail();
		BeanUtils.copyProperties(accMoveDetail, dtoIntAccMoveDetail);
		return dtoIntAccMoveDetail;
	}


	@Override
	public  Movement movementMap(DTOIntMovement dtoIntMovement) {
		Movement movement = new Movement();
		BeanUtils.copyProperties(dtoIntMovement, movement);
		return movement;
	}


	@Override
	public  DTOIntMovement dtoIntMovementMap(Movement movement) {
		DTOIntMovement dtoIntMovement = new DTOIntMovement();
		BeanUtils.copyProperties(movement, dtoIntMovement);
		return dtoIntMovement;
	}


	@Override
	public  DTOIntEnumAccountMoveStatus dtoIntEnumAccountMoveStatusMap(EnumAccountMoveStatus enumAccountMoveStatus) {
		DTOIntEnumAccountMoveStatus dtoIntEnumAccountMoveStatus = new DTOIntEnumAccountMoveStatus();
		BeanUtils.copyProperties(enumAccountMoveStatus, dtoIntEnumAccountMoveStatus);
		return dtoIntEnumAccountMoveStatus;
	}

	@Override
	public  DTOIntEnumAccountState dtoIntEnumAccountStateMap(EnumAccountState enumAccountState) {
		DTOIntEnumAccountState dtoIntEnumAccountState = new DTOIntEnumAccountState();
		BeanUtils.copyProperties(enumAccountState, dtoIntEnumAccountState);
		return dtoIntEnumAccountState;
	}



}

