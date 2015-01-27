package com.bbva.czic.routine.commons.rm.utils.validator;

import org.junit.Test;

import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

public class DtoValidatorTest extends SpringContextBbvaTest {

	@Test
	public void checkDTOValidatorValidateException() {

		DtoFilter dtoFilter = new DtoFilter();
		dtoFilter.setAccountId("1233-9874-6544-3213-7899");
		DtoValidator.validate(dtoFilter);
	}

	@Test(expected = BusinessServiceException.class)
	public void checkDTOValidatorValidate() {

		DtoFilter dtoFilter = new DtoFilter();
		DtoValidator.validate(dtoFilter);
	}

}
