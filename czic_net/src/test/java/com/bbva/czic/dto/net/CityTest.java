package com.bbva.czic.dto.net;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class CityTest {

	private static Validator validator;

	@BeforeClass
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void cityFieldsAreNotNull() {
		City city = new City();
		Set<ConstraintViolation<City>> constraintViolations = validator.validate(city);
		assertEquals(2, constraintViolations.size());
	}
	
	@Test
	public void idCityIsNotEmpty() {
		City city = new City();
		city.setId("");
		Set<ConstraintViolation<City>> constraintViolations = validator.validate(city);
		assertEquals(2, constraintViolations.size());
	}
	
	@Test
	public void nameCityIsNotEmpty() {
		City city = new City();
		city.setName("");
		Set<ConstraintViolation<City>> constraintViolations = validator.validate(city);
		assertEquals(2, constraintViolations.size());
	}

}
