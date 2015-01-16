package com.bbva.czic.dto.net;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class ProductTest {

	private static Validator validator;

	@BeforeClass
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void productFieldsAreNotNull() {
		Product product = new Product();
		product.setMovement(null);
		Set<ConstraintViolation<Product>> constraintViolations = validator.validate(product);
		assertEquals(1, constraintViolations.size());
	}
	
	@Test
	public void productIdIsNotEmpty() {
		Product product = new Product();
		product.setId("");
		Set<ConstraintViolation<Product>> constraintViolations = validator.validate(product);
		assertEquals(0, constraintViolations.size());
		
	}
	
	@Test
	public void productNameIsNotEmpty() {
		Product product = new Product();
		product.setName("");
		Set<ConstraintViolation<Product>> constraintViolations = validator.validate(product);
		assertEquals(1, constraintViolations.size());
		
	}

}
