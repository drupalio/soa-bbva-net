package com.bbva.czic.executives.facade.v01;

import com.bbva.czic.dto.net.Office;
import com.bbva.czic.executives.business.dto.DTOIntExecutive;
import com.bbva.czic.executives.dao.model.oznr.FormatoOZECNRS0;

public class ExecutivesMapper {

	/**
	 * Metodo encargado de mapear un objeto de salida a un DTO interno
	 * DTOIntExecutive
	 * 
	 * @author David Tafur
	 * @param formato
	 * @return
	 */
	public static DTOIntExecutive mapToOuter(FormatoOZECNRS0 formato) {
		DTOIntExecutive dtoIntExecutive = new DTOIntExecutive();
		dtoIntExecutive.setEmail(formato.getEmailej());
		dtoIntExecutive.setExecutiveId(formato.getIdejecu());
		dtoIntExecutive.setName(formato.getNomejec());
		Office office = new Office();
		office.setName(formato.getOfiejec());
		dtoIntExecutive.setOffice(office);
		dtoIntExecutive.setPhone(formato.getOfiejec());

		return dtoIntExecutive;
	}

}
