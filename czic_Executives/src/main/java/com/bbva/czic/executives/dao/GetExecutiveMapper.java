package com.bbva.czic.executives.dao;

import com.bbva.czic.dto.net.Email;
import com.bbva.czic.dto.net.Executive;
import com.bbva.czic.executives.business.dto.DTOIntExecutive;

public class GetExecutiveMapper {

	/**
	 * Metodo encargado de hacer ek mapeo de un dto interno de executive a un
	 * externo
	 * 
	 * @author David Tafur
	 * @param dtoIntExecutive
	 * @return
	 */
	public static Executive mapOuter(final DTOIntExecutive dtoIntExecutive) {
		final Executive executive = new Executive();
		final Email email = new Email();
		email.setAddress(dtoIntExecutive.getEmail());
		executive.setEmail(email);
		executive.setId(dtoIntExecutive.getExecutiveId());
		executive.setName(dtoIntExecutive.getName());
		executive.setOffice(dtoIntExecutive.getOffice());
		executive.setPhone(dtoIntExecutive.getPhone());
		return executive;
	}

}
