package com.bbva.czic.executives.business;

import com.bbva.czic.dto.net.Executive;
import com.bbva.czic.executives.business.dto.DTOIntExecutive;

public class ExecutivesExtMapper {

	/**
	 * Metodo encargado de hacer ek mapeo de un dto interno de executive a un
	 * externo
	 * 
	 * @author David Tafur
	 * @param dtoIntExecutive
	 * @return
	 */
	public static Executive mapOuter(DTOIntExecutive dtoIntExecutive) {
		Executive executive = new Executive();
		executive.setEmail(dtoIntExecutive.getEmail());
		executive.setId(dtoIntExecutive.getExecutiveId());
		executive.setName(dtoIntExecutive.getName());
		executive.setOffice(dtoIntExecutive.getOffice());
		executive.setPhone(dtoIntExecutive.getPhone());
		return executive;
	}

}
