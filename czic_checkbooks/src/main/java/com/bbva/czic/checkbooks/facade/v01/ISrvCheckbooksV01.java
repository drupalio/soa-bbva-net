package com.bbva.czic.checkbooks.facade.v01;

import com.bbva.czic.dto.net.Check;
import com.bbva.czic.dto.net.Checkbook;
import com.bbva.jee.arq.spring.core.servicing.annotations.SMC;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.apache.cxf.jaxrs.model.wadl.ElementClass;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

public interface ISrvCheckbooksV01 {

	Checkbook  getCheckbook(String checkbookId,String accountId);

	Check getCheck(String checkId);
}