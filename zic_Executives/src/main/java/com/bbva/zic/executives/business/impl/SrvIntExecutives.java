package com.bbva.zic.executives.business.impl;

import com.bbva.zic.executives.business.ISrvIntExecutives;
import com.bbva.zic.executives.business.dto.DTOIntExecutive;
import com.bbva.zic.executives.business.dto.DTOIntExecutivesFilter;
import com.bbva.zic.executives.dao.ExecutivesDAO;
import com.bbva.zic.routine.commons.rm.utils.validator.DtoValidator;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
