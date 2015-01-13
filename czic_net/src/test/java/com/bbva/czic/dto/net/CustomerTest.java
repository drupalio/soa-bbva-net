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

public class CustomerTest {

	private static Validator validator;

	@BeforeClass
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void customerFieldsAreNotNull() {
		Customer customer = new Customer();
		Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(customer);
		assertEquals(6, constraintViolations.size());
	}
	
	@Test
	public void customerNameIsNotEmpty() {
		Customer customer = new Customer();
		customer.setName("");
		Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(customer);
		assertEquals(6, constraintViolations.size());
		
	}
	
	@Test
	public void customerLastConnectionDateIsNotInFuture() {
		Customer customer = new Customer();
		customer.setLastConnectionTime(new GregorianCalendar(2016,1,28,13,24,56));
		Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(customer);
		assertEquals(7, constraintViolations.size());
	}
	
	@Test
	public void customerStratumIsNotNegative() {
		Customer customer = new Customer();
		customer.setStratum(-20);
		Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(customer);
		assertEquals(6, constraintViolations.size());
	}
	
	@Test
	public void customerResidenceYearsIsNotNegative() {
		Customer customer = new Customer();
		customer.setResidenceYears(-20);
		Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(customer);
		assertEquals(7, constraintViolations.size());
	}
	
	@Test
	public void customerHomeMembersIsNotNegative() {
		Customer customer = new Customer();
		customer.setHomeMembers(-20);
		Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(customer);
		assertEquals(7, constraintViolations.size());
	}

}
