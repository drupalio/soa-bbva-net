package com.bbva.czic.dto.net;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class EmailTest {

	private static Validator validator;

	@BeforeClass
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void emailFieldsAreNotNull() {
		Email email = new Email();
		Set<ConstraintViolation<Email>> constraintViolations = validator.validate(email);
		assertEquals(4, constraintViolations.size());
	}
	
	@Test
	public void emailAddressIsNotEmpty() {
		Email email = new Email();
		email.setAddress("");
		Set<ConstraintViolation<Email>> constraintViolations = validator.validate(email);
		assertEquals(4, constraintViolations.size());
		
	}
	
	@Test
	public void emailAddressIsValidEmail() {
		Email email = new Email();
		email.setAddress("adsadsasd");
		Set<ConstraintViolation<Email>> constraintViolations = validator.validate(email);
		assertEquals(4, constraintViolations.size());
		
	}

}
