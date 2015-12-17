package com.bbva.czic.internationalcontracttransfer.facade.v01.mapper;

import java.util.List;

import com.bbva.czic.dto.net.InternationalContractTransfer;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntFilterInternationalContractTransfers;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntInternationalContractTransfer;

public interface IInternationalContractTransferMapper {

	public DTOIntFilterInternationalContractTransfers map(String filter, String senderContractParticipantsId,
			Integer paginationKey, Integer pageSize, String expands);

	public InternationalContractTransfer map(DTOIntInternationalContractTransfer dtoInternationalContractTransfer);

	public List<InternationalContractTransfer> mapList(
			List<DTOIntInternationalContractTransfer> dtoListInternationalContractTransfer);
}
