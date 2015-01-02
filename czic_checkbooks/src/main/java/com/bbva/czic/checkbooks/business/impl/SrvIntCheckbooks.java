package com.bbva.czic.checkbooks.business.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbva.czic.checkbooks.business.ISrvIntCheckbooks;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheck;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheckbook;
import com.bbva.czic.checkbooks.dao.CheckbooksDAO;
import com.bbva.czic.dto.net.Checkbook;
import com.bbva.czic.mapper.CheckbooksMapper;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;


@Service
public class SrvIntCheckbooks implements ISrvIntCheckbooks {
	
	private static I18nLog log = I18nLogFactory.getLogI18n(SrvIntCheckbooks.class,"META-INF/spring/i18n/log/mensajesLog");

	@Autowired
	BusinessServicesToolKit bussinesToolKit;
	
	private CheckbooksDAO checkbookDao;
	
	@Resource (name ="CheckbooksMapper")
	
	private CheckbooksMapper checkbookMapper;

	
	
	@Override
	public List<DTOIntCheck> getChecks(String idCheckbook) {
		return null;
	}

		
	@Override
	public List<Checkbook> getCheckbooks (String id) throws BusinessServiceException {
		Checkbook checkbook= null;
		try {
	   if (id == null) throw new BusinessServiceException("wrongParametersCheckbooks");
		 
		List<Checkbook> listCheckbooks= new ArrayList<Checkbook>();
		checkbookDao.getCheckbooks(id);
		List<DTOIntCheckbook> dtoIntCheckbook = checkbookDao.getCheckbooks(id);
		for (DTOIntCheckbook item : dtoIntCheckbook) {
			checkbook = new Checkbook();
			checkbook = checkbookMapper.map(item, Checkbook.class);
			listCheckbooks.add(checkbook); 
        
		}
			return 	listCheckbooks;
		} catch (Exception e) {
			throw new BusinessServiceException(e.getMessage());
		}
	}
}
	


