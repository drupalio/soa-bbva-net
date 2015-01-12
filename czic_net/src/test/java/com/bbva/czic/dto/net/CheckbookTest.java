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

public class CheckbookTest {

	private static Validator validator;

	@BeforeClass
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void checkBookFieldsAreNotNull() {
		Checkbook checkbook = new Checkbook();
		Set<ConstraintViolation<Checkbook>> constraintViolations = validator.validate(checkbook);
		assertEquals(8, constraintViolations.size());
	}
	
	@Test
	public void deliverDateIsNotInFuture() {
		Checkbook checkbook = new Checkbook();
		checkbook.setDeliveryDate(new GregorianCalendar(2016,1,28,13,24,56));
		Set<ConstraintViolation<Checkbook>> constraintViolations = validator.validate(checkbook);
		assertEquals(8, constraintViolations.size());
	}

	@Test
	public void requestDateIsNotInFuture() {
		Checkbook checkbook = new Checkbook();
		checkbook.setRequestDate(new GregorianCalendar(2016,1,28,13,24,56));
		Set<ConstraintViolation<Checkbook>> constraintViolations = validator.validate(checkbook);
		assertEquals(8, constraintViolations.size());
	}
}
