package com.bbva.czic.checkbooks.business;

import java.util.List;

import com.bbva.czic.checkbooks.business.dto.DTOIntCheck;
import com.bbva.czic.dto.net.Checkbook;

public interface ISrvIntCheckbooks {
	public List<DTOIntCheck> getChecks( String idCheckbook);

	public List<Checkbook> getCheckbooks(String id);

}