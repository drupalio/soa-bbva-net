package com.bbva.czic.dto.net;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

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
		assertEquals(10, constraintViolations.size());
	}
	
	@Test
	public void dependentCardHolderIsNotEmpty() {
		DependentCard dependentCard = new DependentCard();
		dependentCard.setAccountHolder("");
		Set<ConstraintViolation<DependentCard>> constraintViolations = validator.validate(dependentCard);
		assertEquals(10, constraintViolations.size());
		
	}

}
