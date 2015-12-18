package com.bbva.czic.internationalcontracttransfer.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntFilterInternationalContractTransfers;
import com.bbva.czic.internationalcontracttransfer.business.dto.DTOIntInternationalContractTransfer;
import com.bbva.czic.internationalcontracttransfer.dao.InternationalContractTransferDAO;
@Component(value = "internationalContractTransfer-dao")
public class InternationalContractTransferDAOImpl  implements InternationalContractTransferDAO {

	public List<DTOIntInternationalContractTransfer> listInternationalContractTransfer(DTOIntFilterInternationalContractTransfers dtoFilterInternational){
		
		List<DTOIntInternationalContractTransfer> listDTOIntInternational = new ArrayList<DTOIntInternationalContractTransfer>();
		DTOIntInternationalContractTransfer dtoIntInternational= new DTOIntInternationalContractTransfer();
		listDTOIntInternational.add(dtoIntInternational);
		return listDTOIntInternational;
	}
	
}

