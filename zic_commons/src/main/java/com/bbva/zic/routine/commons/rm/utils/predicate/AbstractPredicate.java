package com.bbva.zic.routine.commons.rm.utils.predicate;

import org.apache.commons.collections.Predicate;

public abstract class AbstractPredicate<T> implements Predicate {

	/**
	 * @param object
	 * @return
	 */
	protected abstract boolean eval(T object);

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean evaluate(Object object) {
		return eval((T)object);
	}

}
