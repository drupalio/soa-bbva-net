package com.bbva.czic.executives.business;

import com.bbva.czic.executives.business.dto.DTOIntExecutive;
import com.bbva.czic.executives.business.dto.DTOIntExecutivesFilter;

public interface ISrvIntExecutives {
	public DTOIntExecutive getExecutive(DTOIntExecutivesFilter dtoIntExecutivesFilter);
}