package com.bbva.czic.routine.commons.rm.utils.validator;

import javax.validation.constraints.Pattern;

/**
 * @author Entelgy Colombia.
 */
@Pattern(regexp = "^\\d{8}$")
public @interface IsCustomerId {
}
