package com.bbva.czic.cardcharge.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;

import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;

import com.bbva.czic.cardcharge.business.dto.DTOIntCardCharge;
import com.bbva.czic.cardcharge.business.dto.DTOIntExcecutive;
import com.bbva.czic.cardcharge.business.ISrvIntCardCharge;


@Service
public class SrvIntCardCharge implements ISrvIntCardCharge {
	
	private static I18nLog log = I18nLogFactory.getLogI18n(SrvIntCardCharge.class,"META-INF/spring/i18n/log/mensajesLog");

	@Autowired
	BusinessServicesToolKit bussinesToolKit;
	
	
	@Override
	public List<DTOIntCardCharge> getCreditCardCharges() {
		//TODO: autogenerated, complete implementation using DAO
		return null;
	}

	

}
