package com.bbva.czic.globalposition.dao.tx;

import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.business.dto.DTOIntProductFilter;
import com.bbva.czic.globalposition.dao.mappers.ITxGlobalPositionMapper;
import com.bbva.czic.globalposition.dao.model.ozn1.FormatoOZECN1E0;
import com.bbva.czic.globalposition.dao.model.ozn1.FormatoOZECN1S1;
import com.bbva.czic.globalposition.dao.tx.TxGetExtractGlobalBalance;

import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.any;

public class TxGetExtractGlobalBalanceNoTCTest  {

	@Mock
	private ITxGlobalPositionMapper txGlobalPositionMapper;

	@InjectMocks
	private TxGetExtractGlobalBalance txGetExtractGlobalBalance;

	@Before
	public void init(){
		txGetExtractGlobalBalance = new TxGetExtractGlobalBalance();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void callMapDtoInToRequestFormatOk(){

		final DTOIntProductFilter dtoIntProductFilter = new DTOIntProductFilter();
		dtoIntProductFilter.setProductType("QA");
		dtoIntProductFilter.setIdCustomer("12345");

		final FormatoOZECN1E0 formatoOZECN1E0 = new FormatoOZECN1E0();
		formatoOZECN1E0.setNumclie("12345");
		formatoOZECN1E0.setTipprod("QA");

		Mockito.when(txGetExtractGlobalBalance.mapDtoInToRequestFormat(any(DTOIntProductFilter.class))).thenReturn(formatoOZECN1E0);

		final FormatoOZECN1E0 result = txGetExtractGlobalBalance.mapDtoInToRequestFormat(dtoIntProductFilter);

		Assert.assertNotNull(result);
	}

	@Test
	public void callMapResponseFormatToDtoOutOk(){

		final DTOIntProduct dtoIntProduct = new DTOIntProduct();
		dtoIntProduct.setId("3456787543");
		dtoIntProduct.setName("Credito");
		dtoIntProduct.setAlias("Credito");
		dtoIntProduct.setProductType("QA");

		final FormatoOZECN1S1 formatoOZECN1S1 = new FormatoOZECN1S1();
		formatoOZECN1S1.setNomprod("Credito");
		formatoOZECN1S1.setTipprod("QA");
		formatoOZECN1S1.setAlias("Credito");
		formatoOZECN1S1.setNumtarj("3456787543");

		Mockito.when(txGetExtractGlobalBalance.mapResponseFormatToDtoOut(formatoOZECN1S1,
				any(DTOIntProductFilter.class))).thenReturn(dtoIntProduct);

		final DTOIntProduct result = txGetExtractGlobalBalance.mapResponseFormatToDtoOut(formatoOZECN1S1, new DTOIntProductFilter());

		Assert.assertEquals(result.getId(), formatoOZECN1S1.getNumtarj());
		Assert.assertEquals(result.getName(), formatoOZECN1S1.getNomprod());
		Assert.assertEquals(result.getAlias(), formatoOZECN1S1.getAlias());
		Assert.assertEquals(result.getProductType(), formatoOZECN1S1.getTipprod());
	}

	@Test
	public void InvocadorTransaccionTest(){
		txGetExtractGlobalBalance.getTransaction();
	}
}