package com.bbva.czic.loan.facade.v01.mappers.impl;

import com.bbva.czic.dto.net.*;
import com.bbva.czic.loan.business.ISrvIntLoan;
import com.bbva.czic.loan.business.dto.*;
import com.bbva.czic.loan.dao.LoanDAOImpl;
import com.bbva.czic.loan.facade.v01.ISrvLoanV01;
import com.bbva.czic.loan.facade.v01.mappers.ILoanMapper;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.czic.routine.commons.rm.utils.mappers.Mapper;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@Mapper(value = "loan-mapper")
public class LoanMapperTest {

	@Mock
	private ISrvIntLoan iSrvIntLoan;

	@Mock
	private ISrvLoanV01 srvLoanV01;

	@Mock
	private LoanMapper loanMapper;

	@Before
	public void init(){
		loanMapper = new LoanMapper();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void verifyMappingDTOIntLoanToLoanTest(){

		final Loan loan = new Loan();
		loan.setId("1123556");

		final DTOIntLoan dtoIntLoan = new DTOIntLoan();
		dtoIntLoan.setId("20684968230915840285");
		dtoIntLoan.setType("QA");
		dtoIntLoan.setName("Credito");
		dtoIntLoan.setBalance(new Balance());
		dtoIntLoan.setDebt(new Balance());
		dtoIntLoan.setPayment(new Payment());
		dtoIntLoan.setStatus("ok");

		when(loanMapper.map(any(DTOIntLoan.class))).thenReturn(loan);

		final Loan result = loanMapper.map(any(DTOIntLoan.class));

		Assert.assertNotNull(result);
	}

	@Test
	public void verifyMappingDTOIntMovementToMovementTest(){

		final List<Movement> movementList = new ArrayList<Movement>();
		final List<DTOIntMovement> dtoIntMovementList = new ArrayList<DTOIntMovement>();

		when(loanMapper.map(anyList())).thenReturn(movementList);

		final List<Movement> result = loanMapper.map(dtoIntMovementList);

		Assert.assertNotNull(result);
	}

	@Test
	public void verifyMappingDTOIntRotaryQuotaMoveToRotaryQuotaMoveTest(){

		final DTOIntRotaryQuotaMove dtoIntRotaryQuotaMove = new DTOIntRotaryQuotaMove();
		final RotaryQuotaMove  rotaryQuotaMove = new RotaryQuotaMove();

		when(loanMapper.map(any(DTOIntRotaryQuotaMove.class))).thenReturn(rotaryQuotaMove);

		final RotaryQuotaMove result = loanMapper.map(dtoIntRotaryQuotaMove);

		Assert.assertNotNull(result);
	}

}