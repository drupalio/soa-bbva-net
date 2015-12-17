package com.bbva.czic.internationalcontracttransfer.facade.v01;

import java.util.List;

import com.bbva.czic.dto.net.InternationalContractTransfer;

public interface ISrvInternationalContractTransferV01 {

	public List<InternationalContractTransfer> listInternationalContractTransfer(String filter,
			String senderContractParticipantsId, Integer paginationKey, Integer pageSize, String expands);

}