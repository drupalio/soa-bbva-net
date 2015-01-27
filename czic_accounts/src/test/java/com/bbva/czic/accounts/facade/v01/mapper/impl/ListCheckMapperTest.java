package com.bbva.czic.accounts.facade.v01.mapper.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.bbva.czic.accounts.business.dto.DTOIntCheck;
import com.bbva.czic.accounts.dao.mappers.ListCheckMapper;
import com.bbva.czic.accounts.dao.model.oznx.FormatoOZECNXE0;
import com.bbva.czic.accounts.dao.model.oznx.FormatoOZECNXS0;
import com.bbva.czic.dto.net.EnumCheckStatus;

/**
 * Created by Entelgy on 12/01/201.
 */
public class ListCheckMapperTest {

	ListCheckMapper listCheckMapper;

	@Before
	public void init() {
		listCheckMapper = new ListCheckMapper();
	}

	@Test
	public void mapToInnerEntityTest() {
		FormatoOZECNXS0 outFormat = new FormatoOZECNXS0();
		outFormat.setNumprod(new String("1323123"));
		outFormat.setIndpagi(new Integer(1));
		outFormat.setNumcheq(new String("1232132"));
		outFormat.setFechemi(new Date("20140323"));
		outFormat.setValcheq(new BigDecimal("300000"));
		outFormat.setEstcheq(new String("Habilitado"));
		outFormat.setFechmod(new Date("20150923"));

		DTOIntCheck dtoIntCheck = new DTOIntCheck();
		dtoIntCheck = listCheckMapper.mapToInnerEntity(outFormat, null);

		assertEquals(outFormat.getNumprod().toString(), dtoIntCheck.getAccountId());
		assertEquals(outFormat.getIndpagi().toString(), dtoIntCheck.getpaginationKey());
		assertEquals(outFormat.getNumcheq().toString(), dtoIntCheck.getId());
		assertEquals(outFormat.getFechemi().toString(), dtoIntCheck.getIssueDate());
		assertEquals(outFormat.getValcheq().toString(), dtoIntCheck.getValue().getAmount());
		assertEquals(outFormat.getEstcheq().toString(), dtoIntCheck.getStatus());
		assertEquals(outFormat.getFechmod().toString(), dtoIntCheck.getModifiedDate());

	}

	@Test
	public void doIHaveToPaginateTest() {
		assertFalse(listCheckMapper.doIHaveToPaginate(null));
	}

	@Test
	public void mapToInnerTest() {

		DTOIntCheck dtoIntCheck = new DTOIntCheck();
		dtoIntCheck.setEndDate(new Date());
		dtoIntCheck.setStartDate(new Date());
		dtoIntCheck.setAccountId("102030");
		dtoIntCheck.setStatus("HABILITADO");

		FormatoOZECNXE0 formatoEntrada = new FormatoOZECNXE0();
		formatoEntrada = listCheckMapper.mapToInner(dtoIntCheck);

		assertEquals(dtoIntCheck.getId(), formatoEntrada.getNumprod());

	}

	public void mapToOuterTest() {

		FormatoOZECNXS0 outFormat = new FormatoOZECNXS0();
		outFormat.setNumprod("23424");
		outFormat.setIndpagi(new Integer(1));
		outFormat.setNumcheq("213421342");
		outFormat.setFechemi(new Date(20140123));
		outFormat.setValcheq(new BigDecimal("299999"));
		outFormat.setEstcheq(new String("333333"));
		outFormat.setFechmod(new Date(20150112));

		DTOIntCheck formatoSalida = listCheckMapper.mapToOuter(outFormat, null);

		assertEquals(outFormat.getNumprod(), formatoSalida.getAccountId());
		//assertEquals(outFormat.getIndpagi(), formatoSalida.getpaginationKey());
		assertEquals(outFormat.getNumcheq(), formatoSalida.getId());
		assertEquals(outFormat.getFechemi(), formatoSalida.getIssueDate());
		assertEquals(outFormat.getValcheq(), formatoSalida.getValue());
		assertEquals(outFormat.getEstcheq(), formatoSalida.getStatus());
		assertEquals(outFormat.getFechmod(), formatoSalida.getModifiedDate());

	}
}
