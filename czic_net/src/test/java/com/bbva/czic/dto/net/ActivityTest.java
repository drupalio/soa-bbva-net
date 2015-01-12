package com.bbva.czic.dto.net;

import static org.junit.Assert.assertEquals;

import java.util.GregorianCalendar;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class ActivityTest {

	private static Validator validator;

	@BeforeClass
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void activityFieldsAreNotNull() {
		Activity activity = new Activity();
		Set<ConstraintViolation<Activity>> constraintViolations = validator.validate(activity);
		assertEquals(5, constraintViolations.size());
	}
	
	@Test
	public void activityReferenceIsNotEmpty() {
		Activity activity = new Activity();
		activity.setReference("");
		Set<ConstraintViolation<Activity>> constraintViolations = validator.validate(activity);
		assertEquals(5, constraintViolations.size());
		
	}
	
	@Test
	public void activityOperationDateIsNotInFuture() {
		Activity activity = new Activity();
		activity.setOperationDate(new GregorianCalendar(2016,1,28,13,24,56));
		Set<ConstraintViolation<Activity>> constraintViolations = validator.validate(activity);
		assertEquals(5, constraintViolations.size());
	}
	
	@Test
	public void activityExecutionDateIsNotInFuture() {
		Activity activity = new Activity();
		activity.setExecutionDate(new GregorianCalendar(2016,1,28,13,24,56));
		Set<ConstraintViolation<Activity>> constraintViolations = validator.validate(activity);
		assertEquals(5, constraintViolations.size());
	}
	
	

}
