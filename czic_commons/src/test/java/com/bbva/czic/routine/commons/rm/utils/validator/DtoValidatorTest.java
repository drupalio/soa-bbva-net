package com.bbva.czic.routine.commons.rm.utils.validator;

import org.junit.Test;

public class DtoValidatorTest {

	@Test
	public void checkDtoValidator() {

		DtoFilter dtoFilter = new DtoFilter();
		DtoValidator.validate(dtoFilter);

	}
}
