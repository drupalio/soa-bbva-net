package com.bbva.czic.customers.dao.mappers;

import com.bbva.czic.customers.business.dto.*;
import com.bbva.czic.customers.dao.model.oznb.FormatoOZNCENB0;
import com.bbva.czic.customers.dao.model.oznb.FormatoOZNCSNB0;
import com.bbva.czic.customers.dao.model.oznp.FormatoOZECNPE0;
import com.bbva.czic.customers.dao.model.oznp.FormatoOZECNPS0;
import com.bbva.czic.customers.dao.model.oznq.FormatoOZECNQE0;
import com.bbva.czic.customers.dao.model.oznq.FormatoOZECNQS0;
import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.CardCharge;
import com.bbva.czic.dto.net.Customer;

/**
 * 
 * @author Entelgy
 *
 */
public interface ITxCustomerMapper {
	
	/**
	 * 
	 * @param customerId
	 * @return
	 */
	FormatoOZNCENB0 mapInOznb(String customerId);
	
	/***
	 * 
	 * @param formatOutput
	 * @return
	 */
	DTOIntCustomer mapOutOznb(FormatoOZNCSNB0 formatOutput);

	FormatoOZECNQE0 mapInOznq(DTOIntAccMovementsResumesFilter accMovementsResumesFilter);

	DTOIntAccMovementsResume mapOutOznq(FormatoOZECNQS0 formatoSalida);

	FormatoOZECNPE0 mapInOznp(DTOIntCardChargeFilter cardChargeFilter);

	DTOIntCardCharge mapOutOznp(FormatoOZECNPS0 formatoSalida);
}