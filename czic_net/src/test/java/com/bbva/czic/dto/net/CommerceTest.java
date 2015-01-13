package com.bbva.czic.dto.net;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class CommerceTest {

	private static Validator validator;

	@BeforeClass
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void commerceFieldsAreNotNull() {
		Commerce commerce = new Commerce();
		Set<ConstraintViolation<Commerce>> constraintViolations = validator.validate(commerce);
		assertEquals(4, constraintViolations.size());
	}
	
	@Test
	public void commerceCodeIsNotEmpty() {
		Commerce commerce = new Commerce();
		commerce.setCode("");
		Set<ConstraintViolation<Commerce>> constraintViolations = validator.validate(commerce);
		assertEquals(4, constraintViolations.size());
	}
	
	@Test
	public void commerceNameIsNotEmpty() {
		Commerce commerce = new Commerce();
		commerce.setName("");
		Set<ConstraintViolation<Commerce>> constraintViolations = validator.validate(commerce);
		assertEquals(4, constraintViolations.size());
	}

}
