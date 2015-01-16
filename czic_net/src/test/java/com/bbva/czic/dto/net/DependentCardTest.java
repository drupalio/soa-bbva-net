package com.bbva.czic.dto.net;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class DependentCardTest {

	private static Validator validator;

	@BeforeClass
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void dependentCardFieldsAreNotNull() {
		DependentCard dependentCard = new DependentCard();
		Set<ConstraintViolation<DependentCard>> constraintViolations = validator.validate(dependentCard);
		assertEquals(3, constraintViolations.size());
	}
	
	@Test
	public void dependentCardHolderIsNotEmpty() {
		DependentCard dependentCard = new DependentCard();
		dependentCard.setAccountHolder("");
		Set<ConstraintViolation<DependentCard>> constraintViolations = validator.validate(dependentCard);
		assertEquals(3, constraintViolations.size());
		
	}

}
