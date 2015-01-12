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

public class ConsignmentTest {

	private static Validator validator;

	@BeforeClass
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void consigmentFieldsAreNotNull() {
		Consignment consigment = new Consignment();
		Set<ConstraintViolation<Consignment>> constraintViolations = validator.validate(consigment);
		assertEquals(3, constraintViolations.size());
	}
	
	@Test
	public void consigmentReferenceIsEmpty() {
		Consignment consigment = new Consignment();
		consigment.setNumber("");
		Set<ConstraintViolation<Consignment>> constraintViolations = validator.validate(consigment);
		assertEquals(3, constraintViolations.size());		
	}
	
	@Test
	public void consigmentOperationDateIsNotInFuture() {
		Consignment consigment = new Consignment();
		consigment.setDate(new GregorianCalendar(2016,1,28,13,24,56));
		Set<ConstraintViolation<Consignment>> constraintViolations = validator.validate(consigment);
		assertEquals(3, constraintViolations.size());
	}

}
