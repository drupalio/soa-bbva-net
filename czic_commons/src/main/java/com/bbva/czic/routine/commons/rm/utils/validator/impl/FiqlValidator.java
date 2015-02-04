package com.bbva.czic.routine.commons.rm.utils.validator.impl;

import org.apache.commons.lang.StringUtils;

import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

public class FiqlValidator extends Validator {

	private String filter;

	private String originFilter;

	private Integer validateCount;

	private static final String DATE_REGEX = "((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])";

	public FiqlValidator(String filter) {
		this.originFilter = filter;
		this.filter = (filter == null) ? StringUtils.EMPTY : filter;
		this.filter = this.filter.replaceAll("[()]", StringUtils.EMPTY);
		this.validateCount = 0;
	}

	public FiqlValidator exist() {

		if (originFilter == null) {
			exceptions.add(new BusinessServiceException(EnumError.INEXISTENT_FILTER.getAlias()));
		} else if (filter.isEmpty()) {
			exceptions.add(new BusinessServiceException(EnumError.FILTER_EMPTY.getAlias()));
		}
		validateCount++;
		return this;
	}

	public FiqlValidator hasGeAndLe(final String parameter) {

		final String regex = ".*" + parameter + "=ge=.*;" + parameter + "=le=.*";
		if (!this.filter.matches(regex)) {
			exceptions.add(new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias()));
		}
		validateCount++;
		return this;
	}

	public FiqlValidator hasGeOrLe(final String parameter) {

		final String regex = ".*"+ parameter + "=ge=.*," + parameter + "=le=.*";
		if (!this.filter.matches(regex)) {
			exceptions.add(new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias()));
		}
		validateCount++;
		return this;
	}

	public FiqlValidator hasGeAndLe(final String parameter, String regexValue) {

		final String regex = ".*" + parameter + "=ge=" + regexValue + ";" + parameter + "=le=" + regexValue + ".*";
		if (!this.filter.matches(regex)) {
			exceptions.add(new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias()));
		}
		validateCount++;
		return this;
	}

	public FiqlValidator hasGeAndLeDate(final String parameter) {

		final String regex = ".*" + parameter + "=ge=" + DATE_REGEX + ";" + parameter + "=le=" + DATE_REGEX + ".*";
		if (!this.filter.matches(regex)) {
			exceptions.add(new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias()));
		}
		validateCount++;
		return this;
	}

	public FiqlValidator hasGtAndLt(final String parameter) {

		final String regex = ".*" + parameter + "=gt=.*;" + parameter + "=lt=.*";

		if (!this.filter.matches(regex)) {
			exceptions.add(new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias()));
		}
		validateCount++;
		return this;
	}

	public FiqlValidator hasGtAndLt(final String parameter, String regexValue) {

		final String regex = ".*" + parameter + "=gt=" + regexValue + ";" + parameter + "=lt=" + regexValue + ".*";

		if (!this.filter.matches(regex)) {
			exceptions.add(new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias()));
		}
		validateCount++;
		return this;
	}

	public FiqlValidator hasEq(final String parameter) {

		final String regex = ".*" + parameter + "==.*";

		if (!this.filter.matches(regex)) {
			exceptions.add(new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias()));
		}
		validateCount++;
		return this;
	}

	public FiqlValidator hasEq(final String parameter, String regexValue) {

		final String regex = ".*" + parameter + "==" + regexValue;

		if (!this.filter.matches(regex)) {
			exceptions.add(new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias()));
		}
		validateCount++;
		return this;
	}

	public FiqlValidator hasNotEq(final String parameter) {

		final String regex = ".*" + parameter + "!=.*";

		if (!this.filter.matches(regex)) {
			exceptions.add(new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias()));
		}
		validateCount++;
		return this;
	}

	public FiqlValidator hasNotEq(final String parameter, String regexValue) {

		final String regex = ".*" + parameter + "!=" + regexValue;

		if (!this.filter.matches(regex)) {
			exceptions.add(new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias()));
		}
		validateCount++;
		return this;
	}

	public FiqlValidator hasRegex(String regex) {

		if (this.filter.matches(regex)) {
			exceptions.add(new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias()));
		}
		validateCount++;
		return this;
	}


	public FiqlValidator hasGe(final String parameter){

		final String regex = ".*" + parameter + "=ge=.*";
		if (!this.filter.matches(regex)){
			exceptions.add(new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias()));
		}
		validateCount++;
		return this;
	}

	public FiqlValidator validateIfExist() {

		if (!StringUtils.isEmpty(this.filter) && !"null".equals(this.filter)) {
			throwFirstExceptionIfAny();
		}
		return this;
	}

	public FiqlValidator validateAny(){
		if (validateCount.equals(exceptions.size())) {
			throwFirstExceptionIfAny();
		}
		return this;
	}
}
