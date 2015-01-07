package com.bbva.czic.checkbooks.business;

import java.util.List;

import com.bbva.czic.dto.net.Check;
import com.bbva.czic.dto.net.Checkbook;

public interface ISrvIntCheckbooks {


	public List<Checkbook> getCheckbooks(String id);

	// public List<Check> getChecks(String id, String filter, Integer indpagi,
		//	Integer tampagi) throws BusinessServiceException;

	//public List<Check> getChecks(String id, Calendar fechfin,
		//	Calendar fechfin2, Integer indpagi, Integer tampagi);

	List<Check> getChecks(String id, String filter, Integer indpagi,
			Integer tampagi);



}