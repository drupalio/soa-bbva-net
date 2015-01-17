package com.bbva.czic.dto.net;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class CheckTest {

	private static Validator validator;

	@BeforeClass
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	// TODO realizar test de validación de campos. Los test deben ser funcionales. ej. Longitud del número de una tarjeta

	@Test
	public void testValidationFailsIfIssueDateIsInFuture() {
		Check check = new Check();
		check.setIssueDate(getFutureDate());
		Set<ConstraintViolation<Check>> constraintViolations = validator.validate(check);
		assertEquals(1, constraintViolations.size());

	}

	@Test
	public void testValidationPassIfIssueDateIsNotInFuture() {
		Check check = new Check();
		check.setIssueDate(getPastDate());
		Set<ConstraintViolation<Check>> constraintViolations = validator.validate(check);
		assertEquals(0, constraintViolations.size());

	}
	
	@Test
	public void testValidationFailsIfModifiedDateIsInFuture() {
		Check check = new Check();
		check.setModifiedDate(getFutureDate());
		Set<ConstraintViolation<Check>> constraintViolations = validator.validate(check);
		assertEquals(1, constraintViolations.size());
	}

	@Test
	public void testValidationPassIfModifiedDateIsNotInFuture() {
		Check check = new Check();
		check.setModifiedDate(getPastDate());
		Set<ConstraintViolation<Check>> constraintViolations = validator.validate(check);
		assertEquals(0, constraintViolations.size());
	}

	private Calendar getFutureDate() {
		Calendar futureCalendar = GregorianCalendar.getInstance();
		futureCalendar.add(Calendar.MONTH, 1);
		return futureCalendar;
	}

	private Calendar getPastDate() {
		Calendar futureCalendar = GregorianCalendar.getInstance();
		futureCalendar.add(Calendar.MONTH, -1);
		return futureCalendar;
	}
}
