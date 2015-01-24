package com.bbva.czic.routine.commons.rm.utils;

import java.util.ArrayList;
import java.util.List;

import org.apache.cxf.jaxrs.ext.search.PrimitiveStatement;
import org.apache.cxf.jaxrs.ext.search.SearchCondition;

public final class FiqlUtils {

	/**
	 * Get the data from the filter.
	 * 
	 * @param sc the search condition
	 * @return the search condition splitted.
	 */
	public static <T> List<PrimitiveStatement> getDataFromFilter(SearchCondition<T> sc) {

		List<PrimitiveStatement> splitFilterLst = new ArrayList<PrimitiveStatement>();

		PrimitiveStatement statement = sc.getStatement();
		if (statement != null)
			splitFilterLst.add(statement);
		else {
			processSearchConditions(splitFilterLst, sc.getSearchConditions());
		}

		return splitFilterLst;
	}

	/**
	 * @param splitFilterLst
	 * @param searchConditions
	 */
	private static <T> void processSearchConditions(List<PrimitiveStatement> splitFilterLst,
			List<SearchCondition<T>> searchConditions) {
		if (searchConditions == null) {
			return;
		}
		for (SearchCondition<T> condition : searchConditions) {
			PrimitiveStatement statementComposite = condition.getStatement();
			if (statementComposite != null) {
				splitFilterLst.add(statementComposite);
			} else {
				processSearchConditions(splitFilterLst, condition.getSearchConditions());
			}

		}
	}

}
