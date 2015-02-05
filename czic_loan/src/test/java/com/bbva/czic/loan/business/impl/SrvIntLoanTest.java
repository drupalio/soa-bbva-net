package com.bbva.czic.loan.business.impl;

import com.bbva.czic.loan.business.ISrvIntLoan;
import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class SrvIntLoanTest extends SpringContextBbvaTest {

	@Mock
	ISrvIntLoan isrvIntLoan;

	@Before
	public void init(){
		isrvIntLoan = new SrvIntLoan();
	}

	@Test
	public void getMapDtoIntToDtoExt() {

		DTOIntLoan dtoIntLoan = new DTOIntLoan();

		Mockito.when(isrvIntLoan.getRotaryQuota("123333")).thenReturn(dtoIntLoan);

		Mockito.verify(isrvIntLoan).getRotaryQuota("123");
	}
	

}
