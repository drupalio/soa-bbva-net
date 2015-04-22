package com.bbva.czic.loan.facade.v01.mappers.impl;

import com.bbva.czic.dto.net.*;

import com.bbva.czic.loan.business.dto.*;
import com.bbva.czic.loan.facade.v01.mappers.ILoanMapper;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LoanMapperTest {


	private ILoanMapper loanMapper;

	@Before
	public void init(){
		loanMapper = new LoanMapper();
	}

	@Test
	public void verifyMappingDTOIntLoanToLoanTest(){

		final DTOIntLoan dtoIntLoan = new DTOIntLoan();
		dtoIntLoan.setId("20684968230915840285");
		dtoIntLoan.setType("QA");
		dtoIntLoan.setName("Credito");
		dtoIntLoan.setBalance(new Balance(new Money()));
		dtoIntLoan.setDebt(new Balance(new Money()));
		dtoIntLoan.setPayment(new Payment());
		dtoIntLoan.setStatus("ok");

		final Loan result = loanMapper.map(dtoIntLoan);

		Assert.assertEquals(result.getId(), dtoIntLoan.getId());
		Assert.assertEquals(result.getType(), dtoIntLoan.getType());
		Assert.assertEquals(result.getName(), dtoIntLoan.getName());
		Assert.assertEquals(result.getStatus(), dtoIntLoan.getStatus());
	}

	@Test
	public void verifyMappingDTOIntMovementToMovementTest(){

		final List<DTOIntMovement> dtoIntMovementList = new ArrayList<DTOIntMovement>();

		final DTOIntMovement dtoIntMovement = new DTOIntMovement();
		dtoIntMovement.setId("234567654");
		dtoIntMovement.setConcept("Pago");

		dtoIntMovementList.add(dtoIntMovement);

		final List<Movement> result = loanMapper.map(dtoIntMovementList);

		Assert.assertEquals(result.get(0).getId(), dtoIntMovementList.get(0).getId());
		Assert.assertEquals(result.get(0).getConcept(), dtoIntMovementList.get(0).getConcept());
	}

	@Test
	public void verifyMappingDTOIntRotaryQuotaMoveToRotaryQuotaMoveTest(){

		final DTOIntRotaryQuotaMove dtoIntRotaryQuotaMove = new DTOIntRotaryQuotaMove();
		dtoIntRotaryQuotaMove.setId("1234567654");


		final RotaryQuotaMove result = loanMapper.map(dtoIntRotaryQuotaMove);

		Assert.assertEquals(result.getId(), dtoIntRotaryQuotaMove.getId());

	}
}