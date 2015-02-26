package com.bbva.czic.loan.dao.mappers;

import com.bbva.czic.loan.business.dto.*;
import com.bbva.czic.loan.dao.mappers.TxLoanMapper;
import com.bbva.czic.loan.dao.model.ozni.FormatoOZNCENI0;
import com.bbva.czic.loan.dao.model.ozni.FormatoOZNCSNI0;
import com.bbva.czic.loan.dao.model.oznj.FormatoOZNCENJ0;
import com.bbva.czic.loan.dao.model.oznj.FormatoOZNCSNJ0;
import com.bbva.czic.loan.dao.model.oznk.FormatoOZNCENK0;
import com.bbva.czic.loan.dao.model.oznk.FormatoOZNCSNK0;
import com.bbva.czic.loan.dao.tx.TxGetRotaryQuota;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

public class TxLoanMapperTest{

	private TxLoanMapper txLoanMapper;

	@Before
	public void init(){
		txLoanMapper = new TxLoanMapper();
	}

    @Test
	public void mapperFormatoOZNCENJ0ToDTOIntLoan(){
		final DTOIntFilterLoan dtoIntFilterLoan = new DTOIntFilterLoan();
		dtoIntFilterLoan.setIdLoan("1234");

		final FormatoOZNCENJ0 result = txLoanMapper.mapInOznj(dtoIntFilterLoan);

		Assert.assertNotNull(result);
    }

	@Test
	public void mapOutOznj(){
		txLoanMapper.mapOutOznj(new FormatoOZNCSNJ0());
	}

	@Test
	public void callMapInOznkTest(){

		final DTOIntFilterRotaryMovement dtoIntFilterRotaryMovement = new DTOIntFilterRotaryMovement();
		dtoIntFilterRotaryMovement.setIdLoan("12345");
		dtoIntFilterRotaryMovement.setIdMovement(3);

		final FormatoOZNCENK0 result = txLoanMapper.mapInOznk(dtoIntFilterRotaryMovement);

		Assert.assertNotNull(result);
	}

	@Test
	public void callmapInOzniTest(){

		final DTOIntFilterLoan dtoIntFilterLoan = new DTOIntFilterLoan();
		dtoIntFilterLoan.setIdLoan("12345");
		dtoIntFilterLoan.setFechaInicial(new Date());
		dtoIntFilterLoan.setFechaFinal(new Date());
		dtoIntFilterLoan.setPaginationKey(3);

		final FormatoOZNCENI0 result = txLoanMapper.mapInOzni(dtoIntFilterLoan);

		Assert.assertNotNull(result);
	}

	@Test
	public void mapperFormatoOZNCENI0ToDTOIntLoan(){

		FormatoOZNCSNI0 formatoOZNCSNI0 = new FormatoOZNCSNI0();
		formatoOZNCSNI0.setResto("12345");
		formatoOZNCSNI0.setValorop("20300");
		formatoOZNCSNI0.setNumeope("2345");
		formatoOZNCSNI0.setTipope("Pago");

		final DTOIntMovement result = txLoanMapper.mapOutOzni(formatoOZNCSNI0);

		Assert.assertNotNull(result);
	}

	@Test
	public void mapperFormatoOZNCENK0ToDTOIntLoan(){

		final FormatoOZNCSNK0 formatoOZNCSNK0 = new FormatoOZNCSNK0();
		formatoOZNCSNK0.setEstado("Activo");
		formatoOZNCSNK0.setNumemov("23");
		formatoOZNCSNK0.setFechaop(new Date(20140313));
		formatoOZNCSNK0.setResto("234");
		formatoOZNCSNK0.setImporte("8000");
		formatoOZNCSNK0.setDescop("500");
		formatoOZNCSNK0.setCoutaf("23400");
		formatoOZNCSNK0.setCoutat("3");
		formatoOZNCSNK0.setEstado("Activa");

		final DTOIntRotaryQuotaMove result = txLoanMapper.mapOutOznk(formatoOZNCSNK0);

		Assert.assertEquals(result.getId(), formatoOZNCSNK0.getNumemov());
		Assert.assertEquals(result.getConcept(), formatoOZNCSNK0.getResto());
		Assert.assertEquals(result.getRemainingQuotas().toString(), formatoOZNCSNK0.getCoutaf());
		Assert.assertEquals(result.getNumbersOfQuota().toString(), formatoOZNCSNK0.getCoutat());
		Assert.assertEquals(result.getStatus(), formatoOZNCSNK0.getEstado());
	}
}
