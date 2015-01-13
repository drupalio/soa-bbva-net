package com.bbva.czic.dto.net;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class CountryTest {

	private static Validator validator;

	@BeforeClass
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void countryFieldsAreNotNull() {
		Country country = new Country();
		Set<ConstraintViolation<Country>> constraintViolations = validator.validate(country);
		assertEquals(3, constraintViolations.size());
	}
	
	@Test
	public void idCountryIsNotEmpty() {
		Country country = new Country();
		country.setId("");
		Set<ConstraintViolation<Country>> constraintViolations = validator.validate(country);
		assertEquals(3, constraintViolations.size());
	}
	
	@Test
	public void nameCountryIsNotEmpty() {
		Country country = new Country();
		country.setName("");
		Set<ConstraintViolation<Country>> constraintViolations = validator.validate(country);
		assertEquals(3, constraintViolations.size());
	}
}
