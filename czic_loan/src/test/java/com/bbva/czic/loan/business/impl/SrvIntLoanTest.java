package com.bbva.czic.loan.business.impl;

import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.dto.net.Movement;
import com.bbva.czic.loan.business.ISrvIntLoan;
import com.bbva.czic.loan.business.dto.DTOIntFilterLoan;
import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.loan.business.dto.DTOIntMovement;
import com.bbva.czic.loan.business.dto.DTOIntRotaryQuotaMove;
import com.bbva.czic.loan.facade.v01.impl.SrvLoanV01;
import com.bbva.czic.loan.facade.v01.mappers.ILoanMapper;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;
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
import static org.mockito.Mockito.when;

public class SrvIntLoanTest extends SpringContextBbvaTest {

	@Mock
	private ILoanMapper iLoanMapper;

	@Mock ISrvIntLoan iSrvIntLoan;

	@InjectMocks
	private SrvLoanV01 srvLoanV01;

	@Before
	public void init(){
		srvLoanV01 = new SrvLoanV01();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getRotaryQuotaTestOK(){

		DTOIntLoan dtoIntLoan = new DTOIntLoan();
		dtoIntLoan.setId("1234");

		when(iSrvIntLoan.getRotaryQuota("123")).thenReturn(dtoIntLoan);

		final Loan loan = srvLoanV01.getRotaryQuota("123");

		Assert.assertNull(loan);
	}

	@Test
	public void listRotaryQuotaMovementsTestOK(){

		List<DTOIntMovement> dtoIntMovement = new ArrayList<DTOIntMovement>();
		DTOIntMovement movement = new DTOIntMovement();

		movement.setId("1234");
		dtoIntMovement.add(movement);

		when(iSrvIntLoan.listRotaryQuotaMovements(any(DTOIntFilterLoan.class))).thenReturn(dtoIntMovement);

		final List<Movement> movementList = srvLoanV01.listRotaryQuotaMovements("123","3","10","filter");

		Assert.assertNull(movementList);
	}

	@Test(expected = BusinessServiceException.class)
	public void getRotaryQuotaMapperException() {

	    BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());

    	when(iLoanMapper.map(any(DTOIntLoan.class))).thenThrow(bsn);

		srvLoanV01.getRotaryQuota("1234");
	}

	@Test(expected = BusinessServiceException.class)
	public void listRotaryQuotaMovementsMapperException() {

		BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());

		when(iLoanMapper.map(any(DTOIntRotaryQuotaMove.class))).thenThrow(bsn);

		srvLoanV01.getRotaryQuotaMovement("1234", "56789");
	}

	private BusinessServiceException getBsnExeptionByAlias(String alias){
		return new BusinessServiceException(alias);
	}
	

}
