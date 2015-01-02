package com.bbva.czic.checkbooks.dao;

import java.util.List;

import com.bbva.czic.checkbooks.business.dto.DTOIntCheckbook;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

public interface CheckbooksDAO {

	List<DTOIntCheckbook> getCheckbooks(String id) throws BusinessServiceException;
}

