package com.bbva.czic.dto.net;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class CurrencyTest {

	private static Validator validator;

	@BeforeClass
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void currencyFieldsAreNotNull() {
		Currency currency = new Currency();
		Set<ConstraintViolation<Currency>> constraintViolations = validator.validate(currency);
		assertEquals(3, constraintViolations.size());
	}
	
	@Test
	public void currencyidIsNotEmpty() {
		Currency currency = new Currency();
		currency.setId("");
		Set<ConstraintViolation<Currency>> constraintViolations = validator.validate(currency);
		assertEquals(3, constraintViolations.size());
	}
	
	@Test
	public void currencyCodeIsNotEmpty() {
		Currency currency = new Currency();
		currency.setCode("");
		Set<ConstraintViolation<Currency>> constraintViolations = validator.validate(currency);
		assertEquals(3, constraintViolations.size());
	}
	
	@Test
	public void currencyNameIsNotEmpty() {
		Currency currency = new Currency();
		currency.setName("");
		Set<ConstraintViolation<Currency>> constraintViolations = validator.validate(currency);
		assertEquals(3, constraintViolations.size());
	}
}
