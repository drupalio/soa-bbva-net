package com.bbva.czic.customers.dao.mapper;

import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.customers.business.dto.DTOIntCardCharge;
import com.bbva.czic.customers.dao.model.oznp.FormatoOZECNPS0;
import com.bbva.czic.customers.business.dto.DTOIntCustomer;
import com.bbva.czic.customers.dao.model.oznq.FormatoOZECNQS0;
import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.CardCharge;
import com.bbva.czic.dto.net.Customer;

/**
 * Interfaz del mapper para customer
 * @author Sebastian Gamba - Entelgy Col. 
 * @since 10/01/2015
 */
public interface ICustomerMapper {

	DTOIntCardCharge map(FormatoOZECNPS0 formatoSalida);

	AccMovementsResume map(DTOIntAccMovementsResume item);

	DTOIntAccMovementsResume map(FormatoOZECNQS0 formatoSalida);

	CardCharge map(DTOIntCardCharge item);
	
	Customer map(DTOIntCustomer item);
}
