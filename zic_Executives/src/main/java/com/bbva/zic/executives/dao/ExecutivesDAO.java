package com.bbva.zic.executives.dao;

import com.bbva.zic.executives.business.dto.DTOIntExecutive;
import com.bbva.zic.executives.business.dto.DTOIntExecutivesFilter;
import com.bbva.jee.arq.spring.core.host.transporte.ExcepcionTransporte;

public interface ExecutivesDAO {

	public DTOIntExecutive getExecutive(DTOIntExecutivesFilter dtoIntExecutivesFilter)
			throws ExcepcionTransporte;

}
