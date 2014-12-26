package com.bbva.czic.executives.facade.v01.mapper;

import org.springframework.beans.BeanUtils;

import com.bbva.czic.dto.net.Office;
import com.bbva.czic.dto.net.Executive;
import com.bbva.czic.dto.net.ThirdParty;
import com.bbva.czic.dto.net.EnumThirdPartyType;
import com.bbva.czic.dto.net.User;
import com.bbva.czic.executives.business.dto.DTOIntOffice;
import com.bbva.czic.executives.business.dto.DTOIntExecutive;
import com.bbva.czic.executives.business.dto.DTOIntThirdParty;
import com.bbva.czic.executives.business.dto.DTOIntEnumThirdPartyType;
import com.bbva.czic.executives.business.dto.DTOIntUser;


public class Mapper {


	public static Office officeMap(DTOIntOffice dtoIntOffice) {
		Office office = new Office();
		BeanUtils.copyProperties(dtoIntOffice, office);
		return office;
	}


	public static DTOIntOffice dtoIntOfficeMap(Office office) {
		DTOIntOffice dtoIntOffice = new DTOIntOffice();
		BeanUtils.copyProperties(office, dtoIntOffice);
		return dtoIntOffice;
	}


	public static Executive executiveMap(DTOIntExecutive dtoIntExecutive) {
		Executive executive = new Executive();
		BeanUtils.copyProperties(dtoIntExecutive, executive);
		return executive;
	}


	public static DTOIntExecutive dtoIntExecutiveMap(Executive executive) {
		DTOIntExecutive dtoIntExecutive = new DTOIntExecutive();
		BeanUtils.copyProperties(executive, dtoIntExecutive);
		return dtoIntExecutive;
	}


	public static ThirdParty thirdPartyMap(DTOIntThirdParty dtoIntThirdParty) {
		ThirdParty thirdParty = new ThirdParty();
		BeanUtils.copyProperties(dtoIntThirdParty, thirdParty);
		return thirdParty;
	}


	public static DTOIntThirdParty dtoIntThirdPartyMap(ThirdParty thirdParty) {
		DTOIntThirdParty dtoIntThirdParty = new DTOIntThirdParty();
		BeanUtils.copyProperties(thirdParty, dtoIntThirdParty);
		return dtoIntThirdParty;
	}


	public static EnumThirdPartyType enumThirdPartyTypeMap(DTOIntEnumThirdPartyType dtoIntEnumThirdPartyType) {
		return EnumThirdPartyType.valueOf(dtoIntEnumThirdPartyType.name());
	}


	public static DTOIntEnumThirdPartyType dtoIntEnumThirdPartyTypeMap(EnumThirdPartyType enumThirdPartyType) {
		return DTOIntEnumThirdPartyType.valueOf(enumThirdPartyType.name());
	}


	public static User userMap(DTOIntUser dtoIntUser) {
		User user = new User();
		BeanUtils.copyProperties(dtoIntUser, user);
		return user;
	}


	public static DTOIntUser dtoIntUserMap(User user) {
		DTOIntUser dtoIntUser = new DTOIntUser();
		BeanUtils.copyProperties(user, dtoIntUser);
		return dtoIntUser;
	}



}

