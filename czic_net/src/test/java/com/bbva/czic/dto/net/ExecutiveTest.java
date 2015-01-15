package com.bbva.czic.dto.net;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class ExecutiveTest {

	private static Validator validator;

	@BeforeClass
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void executiveFieldsAreNotNull() {
		Executive executive = new Executive();
		executive.setCustomer(null);
		Set<ConstraintViolation<Executive>> constraintViolations = validator.validate(executive);
		assertEquals(6, constraintViolations.size());
	}
	
	@Test
	public void executiveIdIsNotEmpty() {
		Executive executive = new Executive();
		executive.setId("");
		Set<ConstraintViolation<Executive>> constraintViolations = validator.validate(executive);
		assertEquals(5, constraintViolations.size());
	}

	@Test
	public void executiveNameIsNotEmpty() {
		Executive executive = new Executive();
		executive.setName("");
		Set<ConstraintViolation<Executive>> constraintViolations = validator.validate(executive);
		assertEquals(5, constraintViolations.size());
	}

	@Test
	public void executiveEmailIsNotEmpty() {
		Executive executive = new Executive();
		executive.setEmail("");
		Set<ConstraintViolation<Executive>> constraintViolations = validator.validate(executive);
		assertEquals(5, constraintViolations.size());
	}
	
	@Test
	public void executiveEmailIsValidEmail() {
		Executive executive = new Executive();
		executive.setEmail("fadss");
		Set<ConstraintViolation<Executive>> constraintViolations = validator.validate(executive);
		assertEquals(5, constraintViolations.size());
	}

	@Test
	public void executivePhoneIsNotEmpty() {
		Executive executive = new Executive();
		executive.setPhone("");
		Set<ConstraintViolation<Executive>> constraintViolations = validator.validate(executive);
		assertEquals(5, constraintViolations.size());
	}
}
