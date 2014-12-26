package com.bbva.czic.executives.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;

import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;

import com.bbva.czic.executives.business.dto.DTOIntOffice;
import com.bbva.czic.executives.business.dto.DTOIntExecutive;
import com.bbva.czic.executives.business.dto.DTOIntThirdParty;
import com.bbva.czic.executives.business.dto.DTOIntEnumThirdPartyType;
import com.bbva.czic.executives.business.dto.DTOIntUser;
import com.bbva.czic.executives.business.ISrvIntExecutives;


@Service
public class SrvIntExecutives implements ISrvIntExecutives {
	
	private static I18nLog log = I18nLogFactory.getLogI18n(SrvIntExecutives.class,"META-INF/spring/i18n/log/mensajesLog");

	@Autowired
	BusinessServicesToolKit bussinesToolKit;
	
	
	@Override
	public List<DTOIntExecutive> executives() {
		//TODO: autogenerated, complete implementation using DAO
		return null;
	}

	

}
