package com.bbva.czic.dto.net;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class ContactInfoTest {

	private static Validator validator;

	@BeforeClass
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void contactInfoFieldsAreNotNull() {
		ContactInfo contactInfo = new ContactInfo();
		Set<ConstraintViolation<ContactInfo>> constraintViolations = validator.validate(contactInfo);
		assertEquals(2, constraintViolations.size());
	}

}
