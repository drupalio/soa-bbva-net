package com.bbva.czic.core.collection;

import org.apache.commons.collections.Predicate;

/**
 * Predicate to avoid casting in evaluate Predicate methods
 * 
 * @author Entelgy
 * @param <T>
 */
public abstract class BbvaPredicate<T> implements Predicate {

	/**
	 * @param object
	 * @return
	 */
	protected abstract boolean eval(T object);

	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public boolean evaluate(Object object) {
		return eval((T)object);
	}

}
