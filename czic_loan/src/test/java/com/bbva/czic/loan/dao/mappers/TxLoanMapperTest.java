package com.bbva.czic.loan.dao.mappers;

import com.bbva.czic.loan.business.dto.*;
import com.bbva.czic.loan.dao.mappers.TxLoanMapper;
import com.bbva.czic.loan.dao.model.ozni.FormatoOZNCENI0;
import com.bbva.czic.loan.dao.model.ozni.FormatoOZNCSNI0;
import com.bbva.czic.loan.dao.model.oznj.FormatoOZNCENJ0;
import com.bbva.czic.loan.dao.model.oznk.FormatoOZNCSNK0;
import com.bbva.czic.loan.dao.tx.TxGetRotaryQuota;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class TxLoanMapperTest{

	@Mock
	private TxGetRotaryQuota txGetRotaryQuota;

	@Mock
	private TxLoanMapper txLoanMapper;

	@Before
	public void init(){
		txLoanMapper = new TxLoanMapper();
		MockitoAnnotations.initMocks(this);
	}

    @Test
	public void mapperFormatoOZNCENJ0ToDTOIntLoan(){

		DTOIntLoan dtoIntLoan = new DTOIntLoan();
		dtoIntLoan.setId("123");

		FormatoOZNCENJ0 formatoOZNCENJ0 = new FormatoOZNCENJ0();
		formatoOZNCENJ0.setNomtarj("1234");

		DTOIntFilterLoan dtoIntFilterLoan = new DTOIntFilterLoan();

		when(txLoanMapper.mapInOznj(any(DTOIntFilterLoan.class))).thenReturn(formatoOZNCENJ0);

		final FormatoOZNCENJ0 result = txLoanMapper.mapInOznj(dtoIntFilterLoan);

		Assert.assertNotNull(result);
    }

	@Test
	public void mapperFormatoOZNCENI0ToDTOIntLoan(){

		DTOIntMovement dtoIntMovement = new DTOIntMovement();
		dtoIntMovement.setId("123");

		FormatoOZNCSNI0 formatoOZNCSNI0 = new FormatoOZNCSNI0();

		when(txLoanMapper.mapOutOzni(any(FormatoOZNCSNI0.class))).thenReturn(dtoIntMovement);

		final DTOIntMovement result = txLoanMapper.mapOutOzni(formatoOZNCSNI0);

		Assert.assertNotNull(result);
	}

	@Test
	public void mapperFormatoOZNCENK0ToDTOIntLoan(){

		DTOIntRotaryQuotaMove dtoIntRotaryQuotaMove = new DTOIntRotaryQuotaMove();

		FormatoOZNCSNK0 formatoOZNCSNK0 = new FormatoOZNCSNK0();
		formatoOZNCSNK0.setEstado("Activo");

		when(txLoanMapper.mapOutOznk(any(FormatoOZNCSNK0.class))).thenReturn(dtoIntRotaryQuotaMove);

		final DTOIntRotaryQuotaMove result = txLoanMapper.mapOutOznk(formatoOZNCSNK0);

		Assert.assertNotNull(result);
	}
}
