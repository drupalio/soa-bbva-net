package com.bbva.czic.internationalcontracttransfer.business;

import java.util.List;

import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntFilterInternationalContractTransfers;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntInternationalContractTransfer;

public interface ISrvIntInternationalContractTransfer {

	public List<DTOIntInternationalContractTransfer> listInternationalContractTransfer(
			DTOIntFilterInternationalContractTransfers filterInternationalContractTransfer);

}