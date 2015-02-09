package com.bbva.czic.routine.commons.rm.utils.validator.impl;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FiqlValidatorTest {

	@Test
	public void checkFiqlValidatorOK() {

		final String filter = "(chargeDate=ge=01;chargeDate=le=10;date=ge=2014-12-01;date=le=2015-12-10;hola==pepe)";
		FiqlValidator fiqlValidator = new FiqlValidator(filter);
		fiqlValidator.hasGeAndLe("chargeDate").hasEq("hola").validate();
		fiqlValidator.hasGeAndLeDate("date").hasGeAndLe("chargeDate", "\\d\\d").hasEq("hola", "\\w.*").validate();

	}

	@Test
	public void testExceptionListEmptyIfNoValidationIsExecuted() {
		// Setup data
		final FiqlValidator fiqlValidator = new FiqlValidator(null);

		//Validation
		assertThat(false, is(fiqlValidator.hasException()));
	}

	@Test
	public void testHasExceptionIfMandatoryFilterIsNull() {
		final String filter = null;
		FiqlValidator fiqlValidator = new FiqlValidator(filter);

		fiqlValidator.exist();

		assertThat(true, is(fiqlValidator.hasException()));
	}

}
