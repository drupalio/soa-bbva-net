package com.bbva.czic.dto.net;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class PaymentTest {

	private static Validator validator;

	@BeforeClass
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void paymentFieldsAreNotNull() {
		Payment payment = new Payment();
		Set<ConstraintViolation<Payment>> constraintViolations = validator.validate(payment);
		assertEquals(5, constraintViolations.size());
	}
	
	@Test
	public void paymentNumberOfQuotasIsNotNegative() {
		Payment payment = new Payment();
		payment.setNumbersOfQuota(-20);
		Set<ConstraintViolation<Payment>> constraintViolations = validator.validate(payment);
		assertEquals(6, constraintViolations.size());
		
	}
}
