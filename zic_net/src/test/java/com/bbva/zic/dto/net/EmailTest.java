package com.bbva.zic.dto.net;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class EmailTest {

	private static Validator validator;

	@BeforeClass
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@Test
	public void testValidationPassIfAddressWellFormed() {
		Email email = new Email();
		email.setAddress("this@is.mail");
		Set<ConstraintViolation<Email>> constraintViolations = validator.validate(email);
		assertEquals(0, constraintViolations.size());
		
	}
	
	@Test
	public void testValidationFailIfMalformedAddress() {
		Email email = new Email();
		email.setAddress("adsadsasd");
		Set<ConstraintViolation<Email>> constraintViolations = validator.validate(email);
		assertEquals(1, constraintViolations.size());
		
	}

}
