package com.bbva.zic.routine.commons.rm.utils.validator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author Entelgy Colombia.
 */
@NotNull
@Pattern(regexp = "null")
public @interface StringNotNull {
}
