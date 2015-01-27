package com.bbva.czic.executives.dao.impl;

import com.bbva.czic.executives.business.dto.DTOIntExecutive;
import com.bbva.czic.executives.business.dto.DTOIntExecutivesFilter;
import com.bbva.czic.executives.dao.ExecutivesDAO;
import com.bbva.czic.executives.dao.tx.TxGetExecutive;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.ErrorMappingHelper;
import com.bbva.jee.arq.spring.core.host.transporte.ExcepcionTransporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository(value = "executives-dao")
public class ExecutivesDAOImpl implements ExecutivesDAO {

	@Autowired
	private ErrorMappingHelper errorMappingHelper;

	@Resource(name = "tx-get-executive")
	private TxGetExecutive txGetExecutive;


	@Override
	public DTOIntExecutive getExecutive(DTOIntExecutivesFilter dtoIntExecutivesFilter) throws ExcepcionTransporte {
		return txGetExecutive.invoke(dtoIntExecutivesFilter);
	}
}
