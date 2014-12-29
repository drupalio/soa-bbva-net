package com.bbva.czic.checkbooks.facade.v01;

import com.bbva.czic.dto.net.Check;

import javax.ws.rs.core.Response;
import java.util.List;

public interface ISrvCheckbooksV01 {

    List<Check> getChecks(String idCheckbook);

    Response getCheckbooks(String filter, String fields, String expands, String sort);
}
