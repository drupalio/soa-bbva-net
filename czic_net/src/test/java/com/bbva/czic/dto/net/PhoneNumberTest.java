package com.bbva.czic.dto.net;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class PhoneNumberTest {

	private static Validator validator;

	@BeforeClass
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void phoneNumberFieldsAreNotNull() {
		PhoneNumber phoneNumber = new PhoneNumber();
		Set<ConstraintViolation<PhoneNumber>> constraintViolations = validator.validate(phoneNumber);
		assertEquals(7, constraintViolations.size());
	}
	
	@Test
	public void phoneNumberCountryCodeIsNotEmpty() {
		PhoneNumber phoneNumber = new PhoneNumber();
		phoneNumber.setCountryCode("");;
		Set<ConstraintViolation<PhoneNumber>> constraintViolations = validator.validate(phoneNumber);
		assertEquals(7, constraintViolations.size());
		
	}
	
	@Test
	public void phoneNumberRegionCodeIsNotEmpty() {
		PhoneNumber phoneNumber = new PhoneNumber();
		phoneNumber.setRegionalCode("");;
		Set<ConstraintViolation<PhoneNumber>> constraintViolations = validator.validate(phoneNumber);
		assertEquals(7, constraintViolations.size());
		
	}
	
	@Test
	public void phoneNumberIsNotEmpty() {
		PhoneNumber phoneNumber = new PhoneNumber();
		phoneNumber.setNumber("");;
		Set<ConstraintViolation<PhoneNumber>> constraintViolations = validator.validate(phoneNumber);
		assertEquals(7, constraintViolations.size());
		
	}

}
