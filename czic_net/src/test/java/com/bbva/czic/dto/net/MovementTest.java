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

public class MovementTest {

	private static Validator validator;

	@BeforeClass
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void movementFieldsAreNotNull() {
		Movement movement = new Movement();
		Set<ConstraintViolation<Movement>> constraintViolations = validator.validate(movement);
		assertEquals(10, constraintViolations.size());
	}
	
	@Test
	public void movementIdIsNotEmpty() {
		Movement movement = new Movement();
		movement.setId("");
		Set<ConstraintViolation<Movement>> constraintViolations = validator.validate(movement);
		assertEquals(10, constraintViolations.size());
		
	}
	
	@Test
	public void movementConceptIsNotEmpty() {
		Movement movement = new Movement();
		movement.setConcept("");
		Set<ConstraintViolation<Movement>> constraintViolations = validator.validate(movement);
		assertEquals(10, constraintViolations.size());
		
	}
	
	@Test
	public void movementSourceReferenceIsNotEmpty() {
		Movement movement = new Movement();
		movement.setSourceReference("");
		Set<ConstraintViolation<Movement>> constraintViolations = validator.validate(movement);
		assertEquals(10, constraintViolations.size());
		
	}
	
	@Test
	public void movementDestinationReferenceIsNotEmpty() {
		Movement movement = new Movement();
		movement.setDestinationReference("");
		Set<ConstraintViolation<Movement>> constraintViolations = validator.validate(movement);
		assertEquals(10, constraintViolations.size());
		
	}
	
	@Test
	public void movementOperationDateIsNotInFuture() {
		Movement movement = new Movement();
		movement.setOperationDate(new GregorianCalendar(2016,1,28,13,24,56));
		Set<ConstraintViolation<Movement>> constraintViolations = validator.validate(movement);
		assertEquals(10, constraintViolations.size());
	}
	
	@Test
	public void movementTransactionDateIsNotInFuture() {
		Movement movement = new Movement();
		movement.setTransactionDate(new GregorianCalendar(2016,1,28,13,24,56));
		Set<ConstraintViolation<Movement>> constraintViolations = validator.validate(movement);
		assertEquals(10, constraintViolations.size());
	}

}
