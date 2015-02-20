package com.bbva.czic.products.business.dto;

import java.util.List;

public class DTOIntExtractOutput {
	
	private List<DTOIntExtract> extracts;
	
	

	@Override
	public String toString() {
		return "DTOIntExtractOutput [extracts=" + extracts + "]";
	}

	public List<DTOIntExtract> getExtracts() {
		return extracts;
	}

	public void setExtracts(List<DTOIntExtract> extracts) {
		this.extracts = extracts;
	}

}
