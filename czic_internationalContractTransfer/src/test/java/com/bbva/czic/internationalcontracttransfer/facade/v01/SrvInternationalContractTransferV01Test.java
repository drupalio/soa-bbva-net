package com.bbva.czic.internationalcontracttransfer.facade.v01;

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

import com.bbva.czic.dto.net.InternationalContractTransfer;
import com.bbva.czic.internationalcontracttransfer.business.ISrvIntInternationalContractTransfer;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntFilterInternationalContractTransfers;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntInternationalContractTransfer;
import com.bbva.czic.internationalcontracttransfer.facade.v01.impl.SrvInternationalContractTransferV01;
import com.bbva.czic.internationalcontracttransfer.facade.v01.mapper.IInternationalContractTransferMapper;
import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;

@ActiveProfiles("dev")
public class SrvInternationalContractTransferV01Test extends SpringContextBbvaTest {

	@Mock
	private ISrvIntInternationalContractTransfer srvInternationalContractTransfer;

	@Mock
	private IInternationalContractTransferMapper iInternationaContractTransferMapper;

	@InjectMocks
	SrvInternationalContractTransferV01 srv;

	@Before
	public void init() {
		srv = new SrvInternationalContractTransferV01();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testListInternationalContractTransfer() {
		final List<DTOIntInternationalContractTransfer> listDTOIntInternational = new ArrayList<DTOIntInternationalContractTransfer>();
		final List<InternationalContractTransfer> listInternational = new ArrayList<InternationalContractTransfer>();

		Mockito.when(
				srvInternationalContractTransfer.listInternationalContractTransfer(Mockito
						.any(DTOIntFilterInternationalContractTransfers.class))).thenReturn(listDTOIntInternational);
		Mockito.when(iInternationaContractTransferMapper.mapList(Mockito.anyList())).thenReturn(listInternational);

		final List<InternationalContractTransfer> internationalContractTransfe = srv.listInternationalContractTransfer(
				"(referencesValue==12345,(typeName==HACIA;date=ge=2015-01-10;date=le=2015-02-12))", "1025049283", 0010,
				10, "");
		Assert.assertNotNull(internationalContractTransfe);
	}
}
