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

public class UserTest {

	private static Validator validator;

	@BeforeClass
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void userFieldsAreNotNull() {
		User user = new User();
		Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
		assertEquals(7, constraintViolations.size());
	}
	
	@Test
	public void userCustomerIdIsNotEmpty() {
		User user = new User();
		user.setCustomerId("");
		Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
		assertEquals(7, constraintViolations.size());
		
	}
	
	@Test
	public void userNameIsNotEmpty() {
		User user = new User();
		user.setName("");
		Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
		assertEquals(7, constraintViolations.size());
		
	}
	
	@Test
	public void userOperationDateIsNotInFuture() {
		User user = new User();
		user.setLastAccessDate(new GregorianCalendar(2016,1,28,13,24,56));
		Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
		assertEquals(7, constraintViolations.size());
	}

}
