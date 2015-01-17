package com.bbva.czic.globalposition.dao.impl;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.mockito.Mockito;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.bbva.czic.globalposition.business.dto.DTOIntFilterProduct;
import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.business.dto.DTOIntProducts;
import com.bbva.czic.globalposition.dao.IGlobalPositionDAO;

@Repository(value = "global-position-dao")
@Profile(value = "dev")
public class GlobalPositionDAOMock implements IGlobalPositionDAO {

	private GlobalPositionDAOMock mock;

	public GlobalPositionDAOMock() throws JsonParseException, JsonMappingException, IOException {

		DTOIntProducts products = null;

		products = new ObjectMapper().readValue(
				this.getClass().getClassLoader().getResourceAsStream("mock/DTOIntProducts.json"), DTOIntProducts.class);

		mock = Mockito.mock(GlobalPositionDAOMock.class);
		Mockito.when(getExtractGlobalBalance(Mockito.any(DTOIntFilterProduct.class))).thenReturn(products);

	}

	@Override
	public DTOIntProducts getExtractGlobalBalance(DTOIntFilterProduct filterProduct) {
		return mock.getExtractGlobalBalance(filterProduct);
	}

	@Override
	public void updateProductVisibility(DTOIntProduct product) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateProductOperability(DTOIntProduct product) {
		// TODO Auto-generated method stub

	}

}
