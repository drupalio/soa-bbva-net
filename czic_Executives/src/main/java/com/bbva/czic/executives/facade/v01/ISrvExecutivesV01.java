package com.bbva.czic.executives.facade.v01;

import java.util.List;
import javax.ws.rs.core.Response;

import com.bbva.czic.dto.net.Office;
import com.bbva.czic.dto.net.Executive;
import com.bbva.czic.dto.net.ThirdParty;
import com.bbva.czic.dto.net.EnumThirdPartyType;
import com.bbva.czic.dto.net.User;


public interface ISrvExecutivesV01 {
 	public Response executives(String filter, String fields, String expands, String orderby);

	
}