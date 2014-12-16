package com.bbva.czic.globalposition.business;

import java.util.List;
import javax.ws.rs.core.Response;


import com.bbva.czic.globalposition.business.dto.DTOIntEnumProductType;
import com.bbva.czic.globalposition.business.dto.DTOIntEnumFinancialStatusType;
import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.business.dto.DTOIntOperation;
import com.bbva.czic.globalposition.business.dto.DTOIntEnumContactSourceType;
import com.bbva.czic.globalposition.business.dto.DTOIntPhoneNumber;
import com.bbva.czic.globalposition.business.dto.DTOIntContactInformation;
import com.bbva.czic.globalposition.business.dto.DTOIntEmail;
import com.bbva.czic.globalposition.business.dto.DTOIntMovement;
import com.bbva.czic.globalposition.business.dto.DTOIntEnumPhoneNumberType;



public interface ISrvIntGlobalPosition {
 	public List<DTOIntProduct> getExtractGlobalBalance();

		public void update(String idProduct, DTOIntProduct infoProduct);

	
}