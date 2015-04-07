package com.bbva.zic.products.dao.mapper.impl;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.fluttercode.datafactory.impl.DataFactory;
import org.junit.Before;
import org.junit.Test;

import com.bbva.zic.products.business.dto.DTOIntConditions;
import com.bbva.zic.products.business.dto.DTOIntFilterMovements;
import com.bbva.zic.products.business.dto.DTOIntMovement;
import com.bbva.zic.products.business.dto.DTOIntProduct;
import com.bbva.zic.products.dao.model.oznl.FormatoOZECNLE0;
import com.bbva.zic.products.dao.model.oznl.FormatoOZECNLS0;
import com.bbva.zic.products.dao.model.oznm.FormatoOZNCENM0;
import com.bbva.zic.products.dao.model.oznm.FormatoOZNCSNM0;
import com.bbva.zic.products.dao.model.oznt.FormatoOZECNTE0;
import com.bbva.zic.products.dao.model.oznt.FormatoOZECNTS0;
import com.bbva.zic.routine.commons.rm.utils.test.SpringContextBbvaTest;

/**
 * Created by Entelgy on 14/01/2015.
 */

public class TxProductMapperImplTest extends SpringContextBbvaTest {

	TxProductMapperImpl txProductMapper;
	DataFactory dataF;

	@Before
	public void init() {
		txProductMapper = new TxProductMapperImpl();
		dataF=new DataFactory();
	}

	/**
	 * Metodo encargado de mapear un DTO interno de tipo DTOIntProduct a un DTO
	 * externo de tipo Product
	 * 
	 * @author Daniel
	 * @return
	 */
	@Test
	public void mapInOznt() {
		FormatoOZECNTE0 formatoEntrada = new FormatoOZECNTE0();
		DTOIntProduct dtoIntProduct = new DTOIntProduct();
		
		dtoIntProduct.setId(dataF.getNumberText(20));
		
		formatoEntrada = txProductMapper.mapInOznt(dtoIntProduct);
		assertEquals(dtoIntProduct.getId(), formatoEntrada.getNumprod());
	}
	
	/**Test para mapeo de salida de la transaccion al DTO interno
	 * 
	 * @author Daniel
	 */
	@Test
	public void mapOutOznt() {
		FormatoOZECNTS0 formatoSalida = new FormatoOZECNTS0();
		DTOIntConditions dtoIntConditions = new DTOIntConditions();
		
		formatoSalida.setCategor(dataF.getRandomWord(9));
		
		dtoIntConditions = txProductMapper.mapOutOznt(formatoSalida);
		assertEquals(dtoIntConditions.getCategory(), formatoSalida.getCategor());
	}

	
	@Test
	public void mapInOznm() {

		DTOIntFilterMovements filter = new DTOIntFilterMovements();
		filter.setProductId("01020304050607080900");
		filter.setProductType("AH");
		filter.setMovementId("000011123");

		FormatoOZNCENM0 entrada = txProductMapper.mapInOznm(filter);

		assertEquals(filter.getProductId(), entrada.getNocuent());
		assertEquals(filter.getProductType(), entrada.getTiprod());
		assertEquals(filter.getMovementId(), entrada.getNummov());
	}

	@Test
	public void mapOutOznm() {

		FormatoOZNCSNM0 salida = new FormatoOZNCSNM0();
		salida.setValor("10000");
		salida.setFchoper("2015-08-01");
		salida.setTipo("AH");
		salida.setSaldo("10000");
		salida.setResto("5000");
		salida.setBaloper("1350");
		salida.setCtroorg("OFICINA BOGOTA");
		salida.setDescodi("01");
		salida.setPlaza("Av chile");
		salida.setNumecta("01020304050607080900");
		salida.setFchvalr("2014-06-07");

		DTOIntMovement dtoIntMovement = txProductMapper.mapOutOznm(salida);

		//assertEquals(salida.getValor(), dtoIntMovement.getValue().getAmount()
		//		.toString());
		//assertEquals(salida.getFchoper(), dtoIntMovement.getTransactionDate()
		//		.toString());
		assertEquals(salida.getTipo(), dtoIntMovement.getProductType());
		assertEquals(salida.getResto(), dtoIntMovement.getConcept());
		//assertEquals(salida.getBaloper(), dtoIntMovement.getBalance()
		//		.getAmount().toString());
		assertEquals(salida.getDescodi(), dtoIntMovement.getOperation()
				.getDescription());
		assertEquals(salida.getNumecta(), dtoIntMovement.getId());
		//assertEquals(salida.getFchvalr(), dtoIntMovement.getOperationDate()
		//		.toString());
	}

	@Test
	public void mapInOznl() {
		DTOIntFilterMovements filter = new DTOIntFilterMovements();
		filter.setProductId("01020304050607080900");
		filter.setPaginationKey(1);
		filter.setPageSize(10);
		filter.setTransactionDateStart("2015-09-01");
		filter.setTransactionDateEnd("2015-03-03");
		filter.setValueStart("1000");
		filter.setValueEnd("2000");

		FormatoOZECNLE0 entrada = txProductMapper.mapInOznl(filter);

		assertEquals(filter.getProductId(), entrada.getNumprod());
		assertEquals(filter.getPaginationKey(), entrada.getIndpagi());
		assertEquals(filter.getPageSize(), entrada.getTampagi());
	//	assertEquals(filter.getTransactionDateStart(), entrada.getFecini());
	//	assertEquals(filter.getTransactionDateEnd(), entrada.getFecfin());
		assertEquals(filter.getValueStart(), entrada.getSalinc().toString());
		assertEquals(filter.getValueEnd(), entrada.getSalfin().toString());
	}

	@Test
	public void mapOutOznl() {
		FormatoOZECNLS0 formatOutput = new FormatoOZECNLS0();
		formatOutput.setValorop("1000000");
		formatOutput.setTipoopr("TR");
		formatOutput.setNumoper(1200304302);
		formatOutput.setFechope(new Date());
		formatOutput.setBalance("5000");
		formatOutput.setConcept("Retiro");
		formatOutput.setDescopr("Retiro dinero cajero");

		DTOIntMovement dtoIntMovement = txProductMapper
				.mapOutOznl(formatOutput);

		assertEquals(formatOutput.getNumoper().toString(), dtoIntMovement.getId());
		assertEquals(formatOutput.getFechope(),
				dtoIntMovement.getTransactionDate());
		assertEquals(formatOutput.getConcept(), dtoIntMovement.getConcept());
		assertEquals(formatOutput.getDescopr(), dtoIntMovement.getOperation()
				.getDescription());
		assertEquals(formatOutput.getTipoopr(), dtoIntMovement.getOperation()
				.getCode());
	}

}
