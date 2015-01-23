package com.bbva.czic.routine.commons.rm.utils.validator.impl;

import org.junit.Test;

public class FiqlValidatorTest {

	@Test
	public void checkFiqlValidatorOK() {

		final String filter = "(chargeDate=ge=01;chargeDate=le=10;date=ge=2014-12-01;date=le=2015-12-10;hola==pepe)";
		FiqlValidator fiqlValidator = new FiqlValidator(filter);
		fiqlValidator.hasGeAndLe("chargeDate").hasEq("hola").validate();
		fiqlValidator.hasGeAndLeDate("date").hasGeAndLe("chargeDate", "\\d\\d").hasEq("hola", "\\w.*").validate();

	}

}
