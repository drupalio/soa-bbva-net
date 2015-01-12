package com.bbva.czic.dto.net;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class ElectronicDepositValueTest {

	private static Validator validator;

	@BeforeClass
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void electronicDepositFieldsAreNotNull() {
		ElectronicDepositValue electronicDeposit = new ElectronicDepositValue();
		Set<ConstraintViolation<ElectronicDepositValue>> constraintViolations = validator.validate(electronicDeposit);
		assertEquals(2, constraintViolations.size());
	}

}
