package com.bbva.czic.globalposition.facade.v01;

import java.util.List;
import javax.ws.rs.core.Response;

import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.czic.dto.net.EnumFinancialStatusType;
import com.bbva.czic.dto.net.Product;
import com.bbva.czic.dto.net.Operation;
import com.bbva.czic.dto.net.EnumContactSourceType;
import com.bbva.czic.dto.net.PhoneNumber;
import com.bbva.czic.dto.net.ContactInformation;
import com.bbva.czic.dto.net.Email;
import com.bbva.czic.dto.net.Movement;


public interface ISrvGlobalPositionV01 {
 	public List<Product> getExtractGlobalBalance(String customerId, String filter, String fields, String expands, String orderby);

		public Response update(String idProduct, Product infoProduct);

	
}