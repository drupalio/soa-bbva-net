package com.bbva.czic.dto.net;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class MessageTest {

	private static Validator validator;

	@BeforeClass
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void messageFieldsAreNotNull() {
		Message message = new Message();
		Set<ConstraintViolation<Message>> constraintViolations = validator.validate(message);
		assertEquals(6, constraintViolations.size());
	}
	
	@Test
	public void messageIdIsNotEmpty() {
		Message message = new Message();
		message.setId("");
		Set<ConstraintViolation<Message>> constraintViolations = validator.validate(message);
		assertEquals(6, constraintViolations.size());
	}
	
	@Test
	public void messageTemplateIsNotEmpty() {
		Message message = new Message();
		message.setTemplate("");
		Set<ConstraintViolation<Message>> constraintViolations = validator.validate(message);
		assertEquals(6, constraintViolations.size());
	}
	
	@Test
	public void messageTitleIsNotEmpty() {
		Message message = new Message();
		message.setTitle("");
		Set<ConstraintViolation<Message>> constraintViolations = validator.validate(message);
		assertEquals(6, constraintViolations.size());
	}
}
