package com.bbva.czic.routine.commons.rm.utils.tx;

public interface ISimplePutBbvaTransaction<I> {

	/**
	 * @param dtoIn
	 * @return
	 */
	void invoke(final I dtoIn);

}
