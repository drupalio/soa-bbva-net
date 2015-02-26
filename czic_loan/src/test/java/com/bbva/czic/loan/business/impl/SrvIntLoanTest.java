package com.bbva.czic.loan.business.impl;

import com.bbva.czic.dto.net.Balance;
import com.bbva.czic.dto.net.Operation;
import com.bbva.czic.dto.net.Payment;
import com.bbva.czic.loan.business.ISrvIntLoan;
import com.bbva.czic.loan.business.dto.*;
import com.bbva.czic.loan.dao.LoanDAOImpl;
import com.bbva.czic.loan.dao.impl.LoanDAO;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;
import com.bbva.czic.routine.commons.rm.utils.validator.DtoValidator;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class SrvIntLoanTest extends SpringContextBbvaTest {

	@Mock
	private LoanDAO loanDAO;

	@InjectMocks
	private ISrvIntLoan srvIntLoan;

	@Before
	public void init(){
		srvIntLoan = new SrvIntLoan();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void callGetRotaryQuotaWithAllParametersOkTest(){

		DTOIntLoan dtoIntLoan = new DTOIntLoan();
		dtoIntLoan.setId("20684968230915840285");
		dtoIntLoan.setType("QA");
		dtoIntLoan.setName("Credito");
		dtoIntLoan.setBalance(new Balance());
		dtoIntLoan.setDebt(new Balance());
		dtoIntLoan.setPayment(new Payment());
		dtoIntLoan.setStatus("ok");

		when(loanDAO.getRotaryQuota(anyString())).thenReturn(dtoIntLoan);

		DTOIntLoan loan = srvIntLoan.getRotaryQuota("123");

		Assert.assertNotNull(loan);
	}

	@Test(expected = BusinessServiceException.class)
	public void callGetRotaryQuotaWithParametersWrongThrowsTest(){

		BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());

		when(loanDAO.getRotaryQuota(anyString())).thenThrow(bsn);

		srvIntLoan.getRotaryQuota("123");
	}

	@Test
	public void callListRotaryQuotaMovementsWithAllParametresOkTest(){

		List<DTOIntMovement> dtoIntMovementList = new ArrayList<DTOIntMovement>();

		DTOIntMovement dtoIntMovement = new DTOIntMovement();
		dtoIntMovement.setId("123");
		dtoIntMovement.setConcept("Pago");
		dtoIntMovement.setBalance(new Money());
		dtoIntMovement.setValue(new Money());
		dtoIntMovement.setOperation(new Operation());
		Calendar calendar = Calendar.getInstance();
		dtoIntMovement.setTransactionDate(calendar);

		dtoIntMovementList.add(dtoIntMovement);

		DTOIntFilterLoan dtoIntFilterLoan = new DTOIntFilterLoan();
		dtoIntFilterLoan.setIdLoan("123");
		dtoIntFilterLoan.setPageSize(5);
		dtoIntFilterLoan.setPaginationKey(3);
		dtoIntFilterLoan.setFechaFinal(new Date(20140112));
		dtoIntFilterLoan.setFechaInicial(new Date(20140115));

		when(loanDAO.listRotaryQuotaMovements(any(DTOIntFilterLoan.class))).thenReturn(dtoIntMovementList);

		List<DTOIntMovement> result = srvIntLoan.listRotaryQuotaMovements(dtoIntFilterLoan);

		Assert.assertNotNull(result);
	}

	@Test(expected = BusinessServiceException.class)
	public void callListRotaryQuotaMovementsWithParametresWrongThrowsTest(){

		DTOIntFilterLoan dtoIntFilterLoan = new DTOIntFilterLoan();

		BusinessServiceException bsn = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());

		when(loanDAO.listRotaryQuotaMovements(any(DTOIntFilterLoan.class))).thenThrow(bsn);

		srvIntLoan.listRotaryQuotaMovements(dtoIntFilterLoan);
	}

	@Test
	public void callGetRotaryQuotaMovementWithAllParametersOkTest(){

		DTOIntRotaryQuotaMove dtoIntRotaryQuotaMove = new DTOIntRotaryQuotaMove();
		dtoIntRotaryQuotaMove.setId("123456789");
		dtoIntRotaryQuotaMove.setConcept("Pago");
		Calendar calendar = Calendar.getInstance();
		dtoIntRotaryQuotaMove.setTransactionDate(calendar);
		dtoIntRotaryQuotaMove.setOperation(new Operation());
		dtoIntRotaryQuotaMove.setStatus("Ok");
		dtoIntRotaryQuotaMove.setValue(new Money());
		dtoIntRotaryQuotaMove.setBalance(new Balance());
		dtoIntRotaryQuotaMove.setNumbersOfQuota(new Integer(12));
		dtoIntRotaryQuotaMove.setRemainingQuotas(new Integer(12));

		DTOIntFilterRotaryMovement dtoIntFilterRotaryMovement = new DTOIntFilterRotaryMovement();
		dtoIntFilterRotaryMovement.setIdLoan("20684968230915840285");
		dtoIntFilterRotaryMovement.setIdMovement(456734);

		when(loanDAO.getRotaryQuotaMovement(any(DTOIntFilterRotaryMovement.class))).thenReturn(dtoIntRotaryQuotaMove);

		DTOIntRotaryQuotaMove result = srvIntLoan.getRotaryQuotaMovement(dtoIntFilterRotaryMovement);

		Assert.assertNotNull(result);
	}

	@Test(expected = BusinessServiceException.class)
	public void callGetRotaryQuotaMovementWithParametresWrongThrowsTest(){

		DTOIntFilterRotaryMovement dtoIntFilterRotaryMovement = new DTOIntFilterRotaryMovement();

		BusinessServiceException bse = getBsnExeptionByAlias(EnumError.NO_DATA.getAlias());

		when(loanDAO.getRotaryQuotaMovement(any(DTOIntFilterRotaryMovement.class))).thenThrow(bse);

		srvIntLoan.getRotaryQuotaMovement(dtoIntFilterRotaryMovement);
	}

	private BusinessServiceException getBsnExeptionByAlias(String alias){
		return new BusinessServiceException(alias);
	}
}
