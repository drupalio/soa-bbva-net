package com.bbva.czic.routine.commons.rm.utils.validator;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;

import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

public class DtoValidator {

	/**
	 * @param dto
	 */
	public static <T> void validate(T dto) {

		final Set<ConstraintViolation<T>> violationsSet = Validation.buildDefaultValidatorFactory().getValidator()
				.validate(dto);

		// Si hay alguna violacion de los datos de salida se devuelve la excepción
		if (hasViolations(violationsSet)) {

			final ConstraintViolation<T> violation = violationsSet.iterator().next();

			final String propertyViolated = violation.getPropertyPath().toString();
			final String message = propertyViolated + " " + violation.getMessage();

			throwBusinessException(violation, message);
			//
			//
		}
	}

	/**
	 * @param violationsSet
	 * @return
	 */
	private static final <T> boolean hasViolations(Set<ConstraintViolation<T>> violationsSet) {

		return (violationsSet != null && !violationsSet.isEmpty() && violationsSet.iterator().next() != null);
	}

	/**
	 * @param violation
	 */
	private static final <T> void throwBusinessException(final ConstraintViolation<T> violation, final String message) {

		final Class<?> validatorClazz = violation.getConstraintDescriptor().getConstraintValidatorClasses().get(0);

		if (validatorClazz == org.hibernate.validator.constraints.impl.NotNullValidator.class) {
			throw new BusinessServiceException(EnumError.MANDATORY_PARAMETERES_MISSING.getAlias(), message);
		}

	}
}
