package com.bbva.czic.dto.net;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class OfficeTest {

	private static Validator validator;

	@BeforeClass
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void officeFieldsAreNotNull() {
		Office office = new Office();
		Set<ConstraintViolation<Office>> constraintViolations = validator.validate(office);
		assertEquals(4, constraintViolations.size());
	}
	
	@Test
	public void officeCodeIsNotEmpty() {
		Office office = new Office();
		office.setCode("");
		Set<ConstraintViolation<Office>> constraintViolations = validator.validate(office);
		assertEquals(4, constraintViolations.size());
		
	}

	@Test
	public void officeNameIsNotEmpty() {
		Office office = new Office();
		office.setName("");
		Set<ConstraintViolation<Office>> constraintViolations = validator.validate(office);
		assertEquals(4, constraintViolations.size());
		
	}
	
	@Test
	public void officePostalAddressIsNotEmpty() {
		Office office = new Office();
		office.setPostalAddress("");
		Set<ConstraintViolation<Office>> constraintViolations = validator.validate(office);
		assertEquals(4, constraintViolations.size());
		
	}
	
	
}
