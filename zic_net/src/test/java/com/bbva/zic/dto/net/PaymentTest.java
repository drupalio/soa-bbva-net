package com.bbva.zic.dto.net;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class PaymentTest {

	private static Validator validator;

	private static int NEGATIVE_INT = -1;

	@BeforeClass
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	// TODO realizar test de validación de campos. Los test deben ser funcionales. ej. Longitud del número de una tarjeta

	@Test
	public void testValidationFailsIfPaymentNumberOfQuotasIsNegative() {
		Payment payment = new Payment();
		payment.setNumbersOfQuota(NEGATIVE_INT);
		Set<ConstraintViolation<Payment>> constraintViolations = validator.validate(payment);
		assertEquals(1, constraintViolations.size());
		
	}

}
