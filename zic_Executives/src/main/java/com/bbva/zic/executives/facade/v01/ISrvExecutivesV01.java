package com.bbva.zic.executives.facade.v01;

import com.bbva.zic.dto.net.Executive;

public interface ISrvExecutivesV01 {
	public Executive getExecutive(String filter, String fields, String expands,
			String sort);

}