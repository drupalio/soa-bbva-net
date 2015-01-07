package com.bbva.czic.executives.facade.v01;

import com.bbva.czic.dto.net.Executive;

public interface ISrvExecutivesV01 {
	public Executive getExecutive(String filter, String fields, String expands,
			String sort);

}