package com.bbva.czic.dto.net;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.*;

public class LoanTest {

	private static Validator validator;

	@BeforeClass
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void loanFieldsAreNotNull() {
		Loan loan = new Loan();
		Set<ConstraintViolation<Loan>> constraintViolations = validator.validate(loan);
		assertEquals(4, constraintViolations.size());
	}

}
