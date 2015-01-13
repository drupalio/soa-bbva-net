package com.bbva.czic.dto.net;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class DocumentTest {

	private static Validator validator;

	@BeforeClass
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void documentFieldsAreNotNull() {
		Document document = new Document();
		Set<ConstraintViolation<Document>> constraintViolations = validator.validate(document);
		assertEquals(2, constraintViolations.size());
	}
	
	@Test
	public void documentNumberIsNotEmpty() {
		Document document = new Document();
		document.setNumber("");
		Set<ConstraintViolation<Document>> constraintViolations = validator.validate(document);
		assertEquals(2, constraintViolations.size());
		
	}

}
