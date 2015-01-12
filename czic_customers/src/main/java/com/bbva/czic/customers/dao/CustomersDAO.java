package com.bbva.czic.customers.dao;

import java.util.Date;
import java.util.List;

import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.customers.business.dto.DTOIntCardCharge;
import com.bbva.czic.customers.business.dto.DTOIntFilterCustomerResumes;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

public interface CustomersDAO {

	public List<DTOIntAccMovementsResume> getlistAccountsMovementsResume(
			DTOIntFilterCustomerResumes filter) throws BusinessServiceException;

	public List<DTOIntCardCharge> getlistCreCardCharges(
			DTOIntFilterCustomerResumes filter) throws BusinessServiceException;
}

