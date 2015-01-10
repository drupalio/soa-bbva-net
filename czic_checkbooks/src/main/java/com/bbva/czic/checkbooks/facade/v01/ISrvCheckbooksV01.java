package com.bbva.czic.checkbooks.facade.v01;

import java.util.Calendar;
import java.util.List;

import com.bbva.czic.dto.net.Check;
import com.bbva.czic.dto.net.Checkbook;
import com.bbva.czic.dto.net.EnumCheckStatus;

public interface ISrvCheckbooksV01 {

   
   

	List<Checkbook> getCheckbooks(String idCheckbook);


//	List<Check> getChecks(String idCheck, Calendar fechini, Calendar fechfin,EnumCheckStatus status, Integer indpagi,
	//		String tampagi);


//	List<Check> getChecks(String id, Calendar fechini, Calendar fechfin,
	//		EnumCheckStatus status, Integer indpagi, Integer tampagi);


	List<Check> getChecks(String id, String filter, Integer indpagi,
			Integer tampagi);

}