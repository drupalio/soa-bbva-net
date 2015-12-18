package com.bbva.czic.internationalcontracttransfer.dao;

import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntFilterInternationalContractTransfers;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntInternationalContractTransfer;

public interface InternationalContractTransferDAO {

	public List<DTOIntInternationalContractTransfer> getInternationalContractTransfer(DTOIntFilterInternationalContractTransfers dtoFilterInternational);
	
}

