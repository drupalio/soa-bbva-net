package com.bbva.zic.executives.business;

import com.bbva.zic.executives.business.dto.DTOIntExecutive;
import com.bbva.zic.executives.business.dto.DTOIntExecutivesFilter;

public interface ISrvIntExecutives {
	public DTOIntExecutive getExecutive(DTOIntExecutivesFilter dtoIntExecutivesFilter);
}