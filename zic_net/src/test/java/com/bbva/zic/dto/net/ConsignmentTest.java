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

public class ConsignmentTest {

	private static Validator validator;

	@BeforeClass
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	// TODO realizar test de validación de campos. Los test deben ser funcionales. ej. Longitud del número de una tarjeta

	@Test
	public void testValidationFailsIfConsigmentOperationDateIsInFuture() {
		Consignment consigment = new Consignment();
		consigment.setDate(getFutureDate());
		Set<ConstraintViolation<Consignment>> constraintViolations = validator.validate(consigment);
		assertEquals(1, constraintViolations.size());
	}

	@Test
	public void testValidationPassIfConsigmentOperationDateIsInPast() {
		Consignment consigment = new Consignment();
		consigment.setDate(getPastDate());
		Set<ConstraintViolation<Consignment>> constraintViolations = validator.validate(consigment);
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
