package com.bbva.czic.routine.commons.rm.utils.validator.impl;

import com.bbva.czic.routine.commons.rm.utils.test.SpringContextBbvaTest;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class FiqlValidatorTest extends SpringContextBbvaTest {

	@Test
	public void testExceptionListIsEmptyIfNoValidationIsExecuted() {
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

		Assert.assertTrue(fiqlValidator.hasException());
	}

	@Test
	public void testHasExceptionIfMandatoryFilterIsEmptyString() {
		final String filter = "";
		FiqlValidator fiqlValidator = new FiqlValidator(filter);

		fiqlValidator.exist();

		Assert.assertTrue(fiqlValidator.hasException());
	}

	@Test
	public void testThrowExceptionIfValidateWithError() {
		final String filter = null;
		FiqlValidator fiqlValidator = new FiqlValidator(filter);

		fiqlValidator.exist();

		Assert.assertTrue(fiqlValidator.hasException());
	}

	@Test(expected = BusinessServiceException.class)
	public void testThrowExceptionIfHasValidationErrors() {
		final String filter = null;
		FiqlValidator fiqlValidator = new FiqlValidator(filter);

		fiqlValidator.exist().throwFirstExceptionIfAny();
	}

	@Test(expected = BusinessServiceException.class)
	public void testThrowExceptionIfValidateWithErrors() {
		final String filter = null;
		FiqlValidator fiqlValidator = new FiqlValidator(filter);

		fiqlValidator.exist().validate();
	}

	@Test
	public void testPassValidationIfOptionalFilterNull() {
		final String filter = null;
		FiqlValidator fiqlValidator = new FiqlValidator(filter);

		fiqlValidator.validateIfExist();

		assertFalse(fiqlValidator.hasException());
	}

	@Test
	public void testHasExceptionIfHasEqIsMalformed() {
		final String filter = "typhon==34";
		FiqlValidator fiqlValidator = new FiqlValidator(filter);

		fiqlValidator.hasEq("type");

		assertTrue(fiqlValidator.hasException());
	}

	@Test
	public void testHasExceptionIfHasEqHasMalformedRegex() {
		final String filter = "type==34";
		FiqlValidator fiqlValidator = new FiqlValidator(filter);

		fiqlValidator.hasEq("type","^[a-z]{2}");

		assertTrue(fiqlValidator.hasException());
	}

	@Test
	public void testDoesntHaveExceptionIfHasEqWithValidRegex() {
		final String filter = "type==az";
		FiqlValidator fiqlValidator = new FiqlValidator(filter);

		fiqlValidator.hasEq("type","^[a-z]{2}");

		assertTrue(fiqlValidator.hasException());
	}

/*
	@Test(expected = BusinessServiceException.class)
	public void testThrowExceptionIfSetOptionalFilterBadFormed() {
		final String filter = "typo==";
		FiqlValidator fiqlValidator = new FiqlValidator(filter);

		fiqlValidator.hasEq("type").validateIfExist();
	}
	*/
}
