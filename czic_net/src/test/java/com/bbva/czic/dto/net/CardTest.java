package com.bbva.czic.dto.net;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class CardTest {

	private static Validator validator;

	@BeforeClass
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}
	
	@Test
	public void cardFieldsAreNotNull() {
		Card card = new Card();
		Set<ConstraintViolation<Card>> constraintViolations = validator.validate(card);
		assertEquals(2, constraintViolations.size());
	}
	
	@Test
	public void cardNumberIsNotEmpty() {
		Card card = new Card();
		card.setCardNumber("");
		Set<ConstraintViolation<Card>> constraintViolations = validator.validate(card);
		assertEquals(2, constraintViolations.size());
	}

}
