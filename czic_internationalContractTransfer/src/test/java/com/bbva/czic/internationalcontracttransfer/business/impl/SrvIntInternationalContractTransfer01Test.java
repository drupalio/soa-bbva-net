package com.bbva.czic.internationalcontracttransfer.business.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;

import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntFilterInternationalContractTransfers;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntInternationalContractTransfer;
import com.bbva.czic.internationalcontracttransfer.dao.InternationalContractTransferDAO;
import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;

@ActiveProfiles("dev")
public class SrvIntInternationalContractTransfer01Test extends SpringContextBbvaTest {

	@Mock
	private InternationalContractTransferDAO internationalContractTransferDAO;

	@InjectMocks
	SrvIntInternationalContractTransfer srv;

	@Before
	public void init() {
		srv = new SrvIntInternationalContractTransfer();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testListInternationalContractTransfer() {
		DTOIntFilterInternationalContractTransfers dtoFilterInternational = new DTOIntFilterInternationalContractTransfers();
		dtoFilterInternational.setDateEnd("2015-10-10");
		dtoFilterInternational.setDateStart("2015-09-10");
		dtoFilterInternational.setExpands("");
		dtoFilterInternational.setPageSize(10);
		dtoFilterInternational.setPaginationKey(00010);
		dtoFilterInternational.setReferencesValue("5486");
		dtoFilterInternational.setSenderContractParticipantsId("1004928327");
		dtoFilterInternational.setTypeName("HACIA");
		List<DTOIntInternationalContractTransfer> listDTOIntInternationalContractTransfer = new ArrayList<DTOIntInternationalContractTransfer>();
		Mockito.when(internationalContractTransferDAO.listInternationalContractTransfer(dtoFilterInternational))
				.thenReturn(listDTOIntInternationalContractTransfer);

		final List<DTOIntInternationalContractTransfer> respuesta = srv
				.listInternationalContractTransfer(dtoFilterInternational);
		Assert.assertNotNull(respuesta);
	}
}
