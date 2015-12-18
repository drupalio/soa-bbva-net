package com.bbva.czic.internationalcontracttransfer.dao;

import java.util.List;

import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntFilterInternationalContractTransfers;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntInternationalContractTransfer;

public interface InternationalContractTransferDAO {

	public List<DTOIntInternationalContractTransfer> listInternationalContractTransfer(
			DTOIntFilterInternationalContractTransfers dtoFilterInternational);

}
