package com.bbva.czic.executives.dao;

import com.bbva.czic.executives.business.dto.DTOIntExecutive;
import com.bbva.jee.arq.spring.core.host.transporte.ExcepcionTransporte;

public interface ExecutivesDAO {

	public DTOIntExecutive getExecutive(String thirdPartyId)
			throws ExcepcionTransporte;

}
