package com.bbva.czic.checkbooks.facade.v01;

import com.bbva.czic.dto.net.Check;
import com.bbva.czic.dto.net.Checkbook;

import javax.ws.rs.core.Response;

import java.util.List;

public interface ISrvCheckbooksV01 {

    List<Check> getChecks(String idCheck);

   

	List<Checkbook> getCheckbooks(String idCheckbook);
}
