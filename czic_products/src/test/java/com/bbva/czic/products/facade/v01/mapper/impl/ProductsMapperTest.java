package com.bbva.czic.products.facade.v01.mapper.impl;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.bbva.czic.dto.net.Conditions;
import com.bbva.czic.dto.net.Extract;
import com.bbva.czic.products.business.dto.DTOIntConditions;
import com.bbva.czic.products.business.dto.DTOIntExtract;
import com.bbva.czic.products.business.dto.DTOIntFilterExtract;
import com.bbva.czic.products.business.dto.DTOIntProduct;
import com.bbva.czic.products.facade.v01.impl.SrvProductsV01Test;
import com.bbva.czic.products.facade.v01.mapper.IProductsMapper;

/**
 * Created by Entelgy on 06/02/2015.
 */
public class ProductsMapperTest {
	
	IProductsMapper productsMapper;

	@Before
	public void init() {
		productsMapper = new ProductsMapper();
	}
	
//  ------------------ listExtracts ------------------
	
	@Test
	public void mapOutListExtractsTest(){
		List<DTOIntExtract> listDto = SrvProductsV01Test.mockDTOIntExtractsEntity();
		List<Extract> extract = productsMapper.mapExtracts(listDto);
		assertEquals(listDto.size(),extract.size());
		assertEquals(listDto.get(0).getExtCode(),extract.get(0).getExternalCode());
		assertEquals(listDto.get(0).getMonth(),extract.get(0).getMonth());
		assertEquals(listDto.get(0).getYear(),extract.get(0).getYear());
		assertEquals(listDto.get(0).getUrl(),extract.get(0).getUrl());
	}
	
	@Test
	public void mapInListExtractsTest(){
		String productId = "00130693000100000010";
		String extractId = "123456789";
		String filter = "(month=ge=01;month=le=02;year=ge=2014;year=le=2014)";
		DTOIntFilterExtract dtoFilter = productsMapper.getDtoIntFilterExtract(productId,extractId, filter);
		assertEquals(productId,dtoFilter.getProductId());
		assertEquals(extractId,dtoFilter.getExtractId());
		assertEquals("02",dtoFilter.getEndMonth());
		assertEquals("01",dtoFilter.getStartMonth());
		assertEquals("2014",dtoFilter.getEndYear());
		assertEquals("2014",dtoFilter.getStartYear());
	}
	
//  ------------------ getConditions ------------------
	
	@Test
	public void mapOutGetConditionsTest(){
//		DTOIntConditions dtoCond = SrvProductsV01Test.mockDTOIntConditionsEntity();
//		Conditions conditions = productsMapper.map(dtoCond);
//		assertEquals(conditions.getOpeningDate(), conditions.getOpeningDate());
//		assertEquals(conditions.getCategory(),dtoCond.getCategory());
//		assertEquals(conditions.getDescription(),dtoCond.getDescription());
//		assertEquals(conditions.getCommission(), dtoCond.getCommission());
	}
	
	@Test
	public void mapInGetConditionsTest(){
		String productId = "00130693000100000010";
		DTOIntProduct dtoFilter = productsMapper.getDtoIntConditions(productId);
		assertEquals(productId,dtoFilter.getId());
	}
}
