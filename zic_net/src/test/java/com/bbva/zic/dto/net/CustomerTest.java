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

public class CustomerTest {

	private static Validator validator;

	private static int NEGATIVE_INT = -1;

	@BeforeClass
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	// TODO realizar test de validación de campos. Los test deben ser funcionales. ej. Longitud del número de una tarjeta

	@Test
	public void testValidationFailsIfCustomerStratumIsNegative() {
		Customer customer = new Customer();
		customer.setStratum(NEGATIVE_INT);
		Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(customer);
		assertEquals(1, constraintViolations.size());
	}
	
	@Test
	public void testValidationFailsIfCustomerResidenceYearsIsNegative() {
		Customer customer = new Customer();
		customer.setResidenceYears(NEGATIVE_INT);
		Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(customer);
		assertEquals(1, constraintViolations.size());
	}
	
	@Test
	public void testValidationFailsIfCustomerHomeMembersIsNegative() {
		Customer customer = new Customer();
		customer.setHomeMembers(NEGATIVE_INT);
		Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(customer);
		assertEquals(1, constraintViolations.size());
	}

	private Calendar getFutureDate() {
		Calendar futureCalendar = GregorianCalendar.getInstance();
		futureCalendar.add(Calendar.MONTH, 1);
		return futureCalendar;
	}

}
