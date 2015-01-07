package com.bbva.czic.checkbooks.business.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.cxf.jaxrs.ext.search.ConditionType;
import org.apache.cxf.jaxrs.ext.search.PrimitiveStatement;
import org.apache.cxf.jaxrs.ext.search.SearchCondition;
import org.apache.cxf.jaxrs.ext.search.SearchParseException;
import org.apache.cxf.jaxrs.ext.search.fiql.FiqlParser;
import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbva.czic.checkbooks.business.ISrvIntCheckbooks;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheck;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheckbook;
import com.bbva.czic.checkbooks.business.dto.DTOIntEnumCheckStatus;
import com.bbva.czic.checkbooks.dao.CheckbooksDAO;
import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.Check;
import com.bbva.czic.dto.net.Checkbook;
import com.bbva.czic.dto.net.EnumCheckStatus;
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
	public List<Check> getChecks(String id , String filter , Integer indpagi, Integer tampagi) {
		Calendar fechini = null ;
		Calendar fechfin = null ;
		//fechfin.set(Calendar.YEAR, 2013);  
		//fechini.set(Calendar.DAY_OF_YEAR, 2015);
		log.info(" getChecks ");
		
		Check check = null;
		try {

			if (id == null)
				throw new BusinessServiceException(
						"wrongParametersListAccountsMovementsResume");

			List<Check> listChecks = new ArrayList<Check>();
		
		
		
		
		if (filter !=null && ! filter.contentEquals("null")){
			log.info(" A query string (filter) has been sended:"
					+ filter);
			SearchCondition<DTOIntCheck> ch;
			String proper ="null";
			Object value ="null";
			ConditionType condition;
			EnumCheckStatus status= null;
			  
			
			
			try {

			

				ch = new FiqlParser <DTOIntCheck>(DTOIntCheck.class).parse(filter);
				//pm =new  FiqlParser <DTOIntCheck>(DTOIntCheck).parse(status);
				//final List<DTOIntEnumCheckStatus> splitDataFilter1 = bussinesToolKit.getDataFromFilter(ch);
				 //for (DTOIntEnumCheckStatus st: SplitFilter1) {
				//	 status = st.get
				 //}
				
				 
				
				
				final List<PrimitiveStatement> splitDataFilter = bussinesToolKit.getDataFromFilter(ch);
				 for (PrimitiveStatement st: splitDataFilter) {
					 proper = st.getProperty();
					 value = st.getValue();
					 condition = st.getCondition();
					 
					 if(proper.equals("issueDate") && condition.equals(ConditionType.GREATER_THAN)){
						 fechini = (Calendar) st.getValue();
						
					} else if(proper.equals("issueDate")&& condition.equals(ConditionType.LESS_OR_EQUALS)){
						fechfin =(Calendar) st.getValue();
					} else if (proper.equals("status")&& condition.equals(ConditionType.EQUALS))
					{
						status = (EnumCheckStatus) st.getValue();								
					}
						
					 
				 }
				/*	final String pattern = bussinesToolKit.matchesPatternFromFilter(SERVICENAME, filter);
					if (pattern != null) {
						log.info("The pattern is: " + pattern);
					}
						*/
				
				
				
				
			} catch (SearchParseException e){
				
				log.error("SearchParseException - The query string (filter) has failed: " + e);
				throw new BusinessServiceException( filter, e.getMessage());
					
				
			}
			/*final List<DTOIntCheck> intFound = sc.findAll(initialResult);

			final List<Check> found = Mapper.productListMap(intFound);
			return found;
			

			*/
			List<DTOIntCheck> dtoIntChecks= checkbookDao.getChecks(id, fechini, fechfin, status, indpagi, tampagi);
					
		     for(DTOIntCheck item:dtoIntChecks){
		    	 check =new Check();
		    	 check = checkbookMapper.map(item,Check.class);
		    	 listChecks.add(check);
		    	 
		    	 
		     }
		}
		     return listChecks;
		     		
		     
			
			
		} catch (Exception e) {
			throw new BusinessServiceException(e.getLocalizedMessage());
		}

		
	} 
	
	/*
	 * 
	 * 
	 * 
	 * 
	 * (non-Javadoc)
	 * @see com.bbva.czic.checkbooks.business.ISrvIntCheckbooks#getCheckbooks(java.lang.String)
	 */
		
	
		
	@Override
	public List<Checkbook> getCheckbooks (String id) throws BusinessServiceException {
		Checkbook checkbook= null;
		try {
	   if (id == null  ) throw new BusinessServiceException("wrongParametersCheckbooks");
		 
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
	


