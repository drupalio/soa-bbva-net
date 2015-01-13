package com.bbva.czic.dto.net;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class StateTest {

	private static Validator validator;

	@BeforeClass
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void stateFieldsAreNotNull() {
		State state = new State();
		Set<ConstraintViolation<State>> constraintViolations = validator.validate(state);
		assertEquals(3, constraintViolations.size());
	}
	
	@Test
	public void idStateIsNotEmpty() {
		State state = new State();
		state.setId("");
		Set<ConstraintViolation<State>> constraintViolations = validator.validate(state);
		assertEquals(3, constraintViolations.size());
	}
	
	@Test
	public void nameStateIsNotEmpty() {
		State state = new State();
		state.setName("");
		Set<ConstraintViolation<State>> constraintViolations = validator.validate(state);
		assertEquals(3, constraintViolations.size());
	}
}
