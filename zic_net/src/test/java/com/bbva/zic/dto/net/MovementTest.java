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

public class MovementTest {

	private static Validator validator;

	@BeforeClass
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	// TODO realizar test de validación de campos. Los test deben ser funcionales. ej. Longitud del número de una tarjeta

	@Test
	public void testValidationFailsIfMovementOperationDateIsInFuture() {
		Movement movement = new Movement();
		movement.setOperationDate(getFutureDate());
		Set<ConstraintViolation<Movement>> constraintViolations = validator.validate(movement);
		assertEquals(1, constraintViolations.size());
	}
	
	@Test
	public void testValidationFailsIfMovementTransactionDateIsInFuture() {
		Movement movement = new Movement();
		movement.setTransactionDate(getFutureDate());
		Set<ConstraintViolation<Movement>> constraintViolations = validator.validate(movement);
		assertEquals(1, constraintViolations.size());
	}

	private Calendar getFutureDate() {
		Calendar futureCalendar = GregorianCalendar.getInstance();
		futureCalendar.add(Calendar.MONTH, 1);
		return futureCalendar;
	}

}
