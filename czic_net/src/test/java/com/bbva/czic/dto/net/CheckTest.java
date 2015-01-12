package com.bbva.czic.dto.net;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class CheckTest {

	private static Validator validator;

	@BeforeClass
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void checkFieldsAreNotNull() {
		Check check = new Check();
		Set<ConstraintViolation<Check>> constraintViolations = validator.validate(check);
		assertEquals(5, constraintViolations.size());
	}

	@Test
	public void idCheckIsNotEmpty() {
		Check check = new Check();
		check.setId("");
		Set<ConstraintViolation<Check>> constraintViolations = validator.validate(check);
		assertEquals(5, constraintViolations.size());
		
	}
	
	@Test
	public void issueDateIsNotInFuture() {
		Check check = new Check();
		check.setIssueDate(new GregorianCalendar(2016,1,28,13,24,56));
		Set<ConstraintViolation<Check>> constraintViolations = validator.validate(check);
		assertEquals(5, constraintViolations.size());
		
	}
	
	@Test
	public void modifiedDateIsNotInFuture() {
		Check check = new Check();
		check.setModifiedDate(new GregorianCalendar(2016,1,28,13,24,56));
		Set<ConstraintViolation<Check>> constraintViolations = validator.validate(check);
		assertEquals(5, constraintViolations.size());
		
	}
}
