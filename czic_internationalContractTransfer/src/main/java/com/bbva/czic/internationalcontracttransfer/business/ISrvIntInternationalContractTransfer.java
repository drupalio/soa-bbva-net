package com.bbva.czic.internationalcontracttransfer.business;

import java.util.List;
import javax.ws.rs.core.Response;


import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntProduct;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntIdentityDocument;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntPerson;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntDocument;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntAddress;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntContract;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntExchangeRate;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntExternalReference;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntInternationalContractTransfer;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntBank;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntCountry;



public interface ISrvIntInternationalContractTransfer {
 	public List<DTOIntInternationalContractTransfer> listInternationalContractTransfer();

	
}