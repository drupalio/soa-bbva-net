package com.bbva.czic.customers.dao.mapper;

import com.bbva.czic.customers.business.dto.DTOIntCustomer;
import com.bbva.czic.customers.dao.model.oznb.FormatoOZNCENB0;
import com.bbva.czic.customers.dao.model.oznb.FormatoOZNCSNB0;

/**
 * 
 * @author Entelgy
 *
 */
public interface TxCustomerMapper {
	
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

}
