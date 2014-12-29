package com.bbva.czic.checkbooks.facade.v01;

import com.bbva.czic.dto.net.Check;
import com.bbva.czic.dto.net.Checkbook;

import javax.ws.rs.core.Response;
import java.util.List;

public interface ISrvCheckbooksV01 {

    Check getChecks(String idCheck, String filter, String fields, String expands, String sort);

    Checkbook getCheckbooks(String checkbookId, String filter, String fields, String expands, String sort);
}
