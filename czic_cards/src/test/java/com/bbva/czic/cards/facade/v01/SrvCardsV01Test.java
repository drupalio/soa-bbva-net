package com.bbva.czic.cards.facade.v01;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.bbva.czic.cards.business.ISrvIntCards;
import com.bbva.czic.cards.business.dto.DTOIntCardCharge;
import com.bbva.czic.dto.net.CardCharge;

public class SrvCardsV01Test {

	@Mock
	ISrvIntCards srvIntMock;

	@InjectMocks
	@Autowired
	ISrvCardsV01 srv;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test()
	public void testSrvCardsV01() {
		List<DTOIntCardCharge> listaDtoIntCardCharge = new ArrayList<DTOIntCardCharge>();
		listaDtoIntCardCharge.add(new DTOIntCardCharge());
		listaDtoIntCardCharge.add(new DTOIntCardCharge());

		List<CardCharge> listaDTOCardCharge = null;
		listaDTOCardCharge = srv.getCreditCardCharges("1", "", "", "", "");

		// setUp - data
		List<DTOIntCardCharge> initialResultList = new ArrayList<DTOIntCardCharge>();
		DTOIntCardCharge dtoIntCardCharge = new DTOIntCardCharge();
		initialResultList.add(dtoIntCardCharge);

		// setUp - expectation
		when(srvIntMock.getCreditCardCharges("1", "1")).thenReturn(
				listaDtoIntCardCharge);

		// SUT's excecution
		listaDTOCardCharge = srv.getCreditCardCharges("1", "1", null, null,
				null);

		// validation
		assertEquals(2, listaDTOCardCharge.size());
	}
}
