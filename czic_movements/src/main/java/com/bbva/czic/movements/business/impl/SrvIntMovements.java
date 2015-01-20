package com.bbva.czic.movements.business.impl;

import java.util.List;

import com.bbva.czic.movements.business.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;

import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;

import com.bbva.czic.movements.business.ISrvIntMovements;


@Service
public class SrvIntMovements implements ISrvIntMovements {
	
	private static I18nLog log = I18nLogFactory.getLogI18n(SrvIntMovements.class,"META-INF/spring/i18n/log/mensajesLog");

	@Autowired
	BusinessServicesToolKit bussinesToolKit;
	
	
	@Override
	public DTOIntMovement getMovement(DTOIntMovementsFilter filter) {
		log.info("Into getMovement ...");
		log.info("getMovement params: " + filter);

		if(filter.getProductId() != null && filter.getProductType() != null){
			switch (filter.getProductType()){
				case PC:
					break;
				default:
					break;
			}
		}
		return null;
	}

		
	@Override
	public List<DTOIntMovement> listMovements(DTOIntMovementsFilter filter) {
		log.info("Into listMovements ...");
		log.info("ListMovements params: " + filter);

		if(filter.getProductId() != null && filter.getProductType() != null){
			switch (filter.getProductType()){
				case PC:
					break;
				default:
					break;
			}
		}
		return null;
	}

	

}
