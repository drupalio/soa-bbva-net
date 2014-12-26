package com.bbva.czic.customers.business;

import java.util.List;
import javax.ws.rs.core.Response;


import com.bbva.czic.customers.business.dto.DTOIntCreditCard;


import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResume;






public interface ISrvIntCustomers {
 	public List<DTOIntCreditCard> getlistCreditCardsCharges(String idUser);

		public List<DTOIntAccMovementsResume> getlistAccountsMovementsResume(String idUser);

	
}