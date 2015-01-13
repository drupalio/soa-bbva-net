package com.bbva.czic.dto.net;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class ContractTest {

	private static Validator validator;

	@BeforeClass
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void contractFieldsAreNotNull() {
		Contract contract = new Contract();
		Set<ConstraintViolation<Contract>> constraintViolations = validator.validate(contract);
		assertEquals(1, constraintViolations.size());
	}
	
	@Test
	public void contractReferenceIsEmpty() {
		Contract contract = new Contract();
		contract.setNumber("");
		Set<ConstraintViolation<Contract>> constraintViolations = validator.validate(contract);
		assertEquals(1, constraintViolations.size());
		
	}

}
