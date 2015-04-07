package com.bbva.zic.dto.net;

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

public class ActivityTest {

	private static Validator validator;

	@BeforeClass
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	// TODO realizar test de validación de campos. Los test deben ser funcionales. ej. Longitud del número de una tarjeta

	@Test
	public void testValidationFailsIfActivityOperationDateIsInFuture() {
		Activity activity = new Activity();
		activity.setOperationDate(getFutureDate());
		Set<ConstraintViolation<Activity>> constraintViolations = validator.validate(activity);
		assertEquals(1, constraintViolations.size());
	}

	@Test
	public void testValidationPassIfActivityOperationDateIsInPast() {
		Activity activity = new Activity();
		activity.setOperationDate(getPastDate());
		Set<ConstraintViolation<Activity>> constraintViolations = validator.validate(activity);
		assertEquals(0, constraintViolations.size());
	}

	@Test
	public void testValidatioFailsIfActivityExecutionDateIsInFuture() {
		Activity activity = new Activity();
		activity.setExecutionDate(getFutureDate());
		Set<ConstraintViolation<Activity>> constraintViolations = validator.validate(activity);
		assertEquals(1, constraintViolations.size());
	}

	@Test
	public void testValidatioFailsIfActivityExecutionDateIsInPast() {
		Activity activity = new Activity();
		activity.setExecutionDate(getPastDate());
		Set<ConstraintViolation<Activity>> constraintViolations = validator.validate(activity);
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
