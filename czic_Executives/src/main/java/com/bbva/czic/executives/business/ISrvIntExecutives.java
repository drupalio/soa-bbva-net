package com.bbva.czic.executives.business;

import java.util.List;
import javax.ws.rs.core.Response;


import com.bbva.czic.executives.business.dto.DTOIntOffice;
import com.bbva.czic.executives.business.dto.DTOIntExecutive;
import com.bbva.czic.executives.business.dto.DTOIntThirdParty;
import com.bbva.czic.executives.business.dto.DTOIntEnumThirdPartyType;
import com.bbva.czic.executives.business.dto.DTOIntUser;



public interface ISrvIntExecutives {
 	public List<DTOIntExecutive> executives();

	
}