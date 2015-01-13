package com.bbva.czic.dto.net;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class ThirdPartyTest {

	private static Validator validator;

	@BeforeClass
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void thirdPartyFieldsAreNotNull() {
		ThirdParty thirdParty = new ThirdParty();
		Set<ConstraintViolation<ThirdParty>> constraintViolations = validator.validate(thirdParty);
		assertEquals(2, constraintViolations.size());
	}
	
}
