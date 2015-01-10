package com.bbva.czic.executives.business;

import com.bbva.czic.executives.business.dto.DTOIntExecutive;

public interface ISrvIntExecutives {
	public DTOIntExecutive getExecutive(String filter);
}