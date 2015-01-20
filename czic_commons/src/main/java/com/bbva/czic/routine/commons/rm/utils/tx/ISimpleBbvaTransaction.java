package com.bbva.czic.routine.commons.rm.utils.tx;

/**
 * @author Entelgy
 */
public interface ISimpleBbvaTransaction<I, O> {

	/**
	 * @param dtoIn
	 * @return
	 */
	O invoke(final I dtoIn);
}
