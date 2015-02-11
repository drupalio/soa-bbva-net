package com.bbva.czic.loan.dao.mappers.impl;

import com.bbva.czic.loan.business.dto.*;
import com.bbva.czic.loan.dao.mappers.TxLoanMapper;
import com.bbva.czic.loan.dao.model.oznj.FormatoOZNCENJ0;
import com.bbva.czic.loan.dao.model.oznj.FormatoOZNCSNJ0;
import com.bbva.czic.loan.dao.tx.TxGetRotaryQuota;
import com.bbva.jee.arq.spring.core.host.ServicioTransacciones;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class TxLoanMapperTest{

	@Mock
	private TxGetRotaryQuota txGetRotaryQuota;

	@InjectMocks
	private TxLoanMapper txLoanMapper;

	@Before
	public void init(){
		txLoanMapper = new TxLoanMapper();
		MockitoAnnotations.initMocks(this);
	}

    @Test
	public void mapperFormatoOZNCENJ0ToDTOIntLoan(){

		DTOIntLoan dtoIntLoan = new DTOIntLoan();
		FormatoOZNCENJ0 formatoOZNCENJ0 = new FormatoOZNCENJ0();
		formatoOZNCENJ0.setNomtarj("12334455");
		FormatoOZNCSNJ0 formatoOZNCSNJ0 = new FormatoOZNCSNJ0();
		formatoOZNCSNJ0.setSaldodi("1234");
		dtoIntLoan.setId("123");

		DTOIntLoan result = txLoanMapper.mapOutOznj(formatoOZNCSNJ0);

		Assert.assertNotNull(result);
    }
}
