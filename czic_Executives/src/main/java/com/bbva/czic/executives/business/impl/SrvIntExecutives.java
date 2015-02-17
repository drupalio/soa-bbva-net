package com.bbva.czic.executives.business.impl;

import com.bbva.czic.dto.net.EnumThirdPartyType;
import com.bbva.czic.executives.business.ISrvIntExecutives;
import com.bbva.czic.executives.business.dto.DTOIntExecutive;
import com.bbva.czic.executives.business.dto.DTOIntExecutivesFilter;
import com.bbva.czic.executives.dao.ExecutivesDAO;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.czic.routine.commons.rm.utils.validator.DtoValidator;
import com.bbva.czic.routine.commons.rm.utils.validator.impl.StringValidator;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;
import org.apache.cxf.jaxrs.ext.search.PrimitiveStatement;
import org.apache.cxf.jaxrs.ext.search.SearchCondition;
import org.apache.cxf.jaxrs.ext.search.SearchParseException;
import org.apache.cxf.jaxrs.ext.search.fiql.FiqlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SrvIntExecutives implements ISrvIntExecutives {

	private static I18nLog log = I18nLogFactory.getLogI18n(
			SrvIntExecutives.class, "META-INF/spring/i18n/log/mensajesLog");
	private static final String FILTERERROR = "FilterError";

	@Autowired
	BusinessServicesToolKit bussinesToolKit;
	@Resource(name = "executives-dao")
	private ExecutivesDAO executivesDAO;

	/**
	 * Metodo encargado de traer el ejecutivo
	 *
	 * @author David Tafur
	 * @param
	 *            dtoIntExecutivesFilter
	 */
	public DTOIntExecutive getExecutive(DTOIntExecutivesFilter dtoIntExecutivesFilter) {
		// 1. Validate DtoIntFilterAccount
		DtoValidator.validate(dtoIntExecutivesFilter);
		// 2. Get response
		final DTOIntExecutive result = executivesDAO.getExecutive(dtoIntExecutivesFilter);

		// 3. Validate output
		DtoValidator.validate(result);

		log.info(" getExecutive ");
		return result;
	}
}
