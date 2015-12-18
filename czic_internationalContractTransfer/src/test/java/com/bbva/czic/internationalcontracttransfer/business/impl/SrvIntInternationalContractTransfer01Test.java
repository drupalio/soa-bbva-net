package com.bbva.czic.internationalcontracttransfer.business.impl;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ActiveProfiles;

import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

@ActiveProfiles("dev")
public class SrvIntInternationalContractTransfer01Test extends SpringContextBbvaTest {

	@InjectMocks
	SrvIntInternationalContractTransfer srv;

	@Before
	public void init() {
		srv = new SrvIntInternationalContractTransfer();
		MockitoAnnotations.initMocks(this);
	}

	
}
