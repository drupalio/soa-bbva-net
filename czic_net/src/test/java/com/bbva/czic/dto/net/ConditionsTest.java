package com.bbva.czic.dto.net;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class ConditionsTest {

	private static Validator validator;

	@BeforeClass
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void conditionsFieldsAreNotNull() {
		Conditions conditions = new Conditions();
		Set<ConstraintViolation<Conditions>> constraintViolations = validator.validate(conditions);
		assertEquals(6, constraintViolations.size());
	}
	
	@Test
	public void conditionsDescriptionIsEmpty() {
		Conditions conditions = new Conditions();
		conditions.setDescription("");
		Set<ConstraintViolation<Conditions>> constraintViolations = validator.validate(conditions);
		assertEquals(6, constraintViolations.size());
	}
	
	@Test
	public void conditionsCategoryIsEmpty() {
		Conditions conditions = new Conditions();
		conditions.setCategory("");
		Set<ConstraintViolation<Conditions>> constraintViolations = validator.validate(conditions);
		assertEquals(6, constraintViolations.size());
	}
	
	@Test
	public void conditionsCommissionIsEmpty() {
		Conditions conditions = new Conditions();
		conditions.setCommission("");
		Set<ConstraintViolation<Conditions>> constraintViolations = validator.validate(conditions);
		assertEquals(6, constraintViolations.size());
	}

}
