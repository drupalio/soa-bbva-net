package com.bbva.zic.dto.net;

import org.junit.BeforeClass;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class CardTest {

	private static Validator validator;

	@BeforeClass
	public static void init() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	// TODO realizar test de validación de campos. Los test deben ser funcionales. ej. Longitud del número de una tarjeta

}
