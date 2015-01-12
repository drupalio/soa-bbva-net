package com.bbva.czic.customers.dao.mapper;

import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.customers.business.dto.DTOIntCardCharge;
import com.bbva.czic.customers.dao.model.ozno.FormatoOZECNOS0;
import com.bbva.czic.customers.dao.model.oznq.FormatoOZECNQS0;
import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.CardCharge;

/**
 * Interfaz del mapper para customer
 * @author Sebastian Gamba - Entelgy Col. 
 * @since 10/01/2015
 */
public interface ICustomerMapper {

	DTOIntCardCharge map(FormatoOZECNOS0 formatoSalida);

	AccMovementsResume map(DTOIntAccMovementsResume item);

	DTOIntAccMovementsResume map(FormatoOZECNQS0 formatoSalida);

	CardCharge map(DTOIntCardCharge item);
}
