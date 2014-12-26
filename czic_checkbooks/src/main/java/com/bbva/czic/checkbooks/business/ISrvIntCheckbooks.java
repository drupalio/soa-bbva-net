package com.bbva.czic.checkbooks.business;

import com.bbva.czic.checkbooks.business.dto.DTOIntCheck;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheckbook;

import java.util.List;

public interface ISrvIntCheckbooks {
	public List<DTOIntCheck> getChecks( String idCheckbook);

	public List<DTOIntCheckbook> getCheckbooks();

}