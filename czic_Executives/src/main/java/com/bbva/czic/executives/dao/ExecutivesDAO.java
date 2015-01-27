package com.bbva.czic.executives.dao;

import com.bbva.czic.executives.business.dto.DTOIntExecutive;
import com.bbva.czic.executives.business.dto.DTOIntExecutivesFilter;
import com.bbva.jee.arq.spring.core.host.transporte.ExcepcionTransporte;

public interface ExecutivesDAO {

	public DTOIntExecutive getExecutive(DTOIntExecutivesFilter dtoIntExecutivesFilter)
			throws ExcepcionTransporte;

}
