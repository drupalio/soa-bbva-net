package com.bbva.czic.internationalcontracttransfer.business.dao.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;

import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntFilterInternationalContractTransfers;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntInternationalContractTransfer;
import com.bbva.czic.internationalcontracttransfer.dao.InternationalContractTransferDAO;
import com.bbva.czic.internationalcontracttransfer.dao.impl.InternationalContractTransferDAOImpl;
import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;

@ActiveProfiles("dev")
public class InternationalContractTransferDAOImplTest extends SpringContextBbvaTest {

	@InjectMocks
	InternationalContractTransferDAO internationalContractTransferDAO;

	@Before
	public void init() {
		internationalContractTransferDAO = new InternationalContractTransferDAOImpl();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetExchangeRatePurchaseOK() {
		DTOIntFilterInternationalContractTransfers dtoFilterInternational = new DTOIntFilterInternationalContractTransfers();
		dtoFilterInternational.setDateEnd("2015-10-10");
		dtoFilterInternational.setDateStart("2015-09-10");
		dtoFilterInternational.setExpands("");
		dtoFilterInternational.setPageSize(10);
		dtoFilterInternational.setPaginationKey(00010);
		dtoFilterInternational.setReferencesValue("5486");
		dtoFilterInternational.setSenderContractParticipantsId("1004928327");
		dtoFilterInternational.setTypeName("HACIA");

		List<DTOIntInternationalContractTransfer> dtoIntInternationalContractTransfer = internationalContractTransferDAO
				.listInternationalContractTransfer(dtoFilterInternational);

		Assert.assertNotNull(dtoIntInternationalContractTransfer);

	}

}
