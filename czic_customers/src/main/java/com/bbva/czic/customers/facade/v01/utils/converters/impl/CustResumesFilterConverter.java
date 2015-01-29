package com.bbva.czic.customers.facade.v01.utils.converters.impl;

import java.util.Date;
import java.util.List;

import org.apache.cxf.jaxrs.ext.search.ConditionType;
import org.apache.cxf.jaxrs.ext.search.PrimitiveStatement;
import org.apache.cxf.jaxrs.ext.search.SearchCondition;
import org.apache.cxf.jaxrs.ext.search.SearchParseException;
import org.apache.cxf.jaxrs.ext.search.fiql.FiqlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.customers.business.dto.DTOIntCardCharge;
import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResumesFilter;
import com.bbva.czic.customers.facade.v01.utils.converters.IFilterConverter;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.czic.routine.commons.rm.utils.validator.impl.DateValidator;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;

@Component(value = "customer-resumes-filter-converter")
public class CustResumesFilterConverter implements IFilterConverter {

	private static I18nLog log = I18nLogFactory.getLogI18n(CustResumesFilterConverter.class,
			"META-INF/spring/i18n/log/mensajesLog");

	@Autowired
	BusinessServicesToolKit businessToolKit;

	public void setBusinessToolKit(BusinessServicesToolKit businessToolKit) {
		this.businessToolKit = businessToolKit;
	}

	@Override
	public DTOIntAccMovementsResumesFilter toCardChargeFilter(String filter) throws BusinessServiceException {
		DTOIntAccMovementsResumesFilter filterDto = null;
		try {

			log.info("A query string (filter) has been sended: " + filter);
			SearchCondition<DTOIntCardCharge> sc;

			sc = new FiqlParser<DTOIntCardCharge>(DTOIntCardCharge.class).parse(filter);
			final List<PrimitiveStatement> splitDataFilter = businessToolKit.getDataFromFilter(sc);

			filterDto = new DTOIntAccMovementsResumesFilter();

			for (PrimitiveStatement st : splitDataFilter) {
				if (st.getCondition().equals(ConditionType.GREATER_OR_EQUALS)) {
					filterDto.setStartDate((Date)st.getValue());
				} else if (st.getCondition().equals(ConditionType.LESS_OR_EQUALS)) {
					filterDto.setEndDate((Date)st.getValue());
				}

			}

			if (filterDto.getEndDate() == null) {
				filterDto.setEndDate(new Date());
			}
			if (filterDto.getStartDate() == null) {
				throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias());
			}

			DateValidator validator = (DateValidator)new DateValidator().noFuture(filterDto.getStartDate())
					.noFuture(filterDto.getEndDate()).validDateRange(filterDto.getStartDate(), filterDto.getEndDate())
					.validate();
		} catch (BusinessServiceException bse) {
			log.error("BusinessServiceException - The query string (filter) has failed: " + bse);
			throw bse;
		} catch (SearchParseException e) {
			log.error("SearchParseException - The query string (filter) has failed: " + e);
			throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias(), e.getMessage());
		}
		return filterDto;
	}

	@Override
	public DTOIntAccMovementsResumesFilter toAccountMovementFilter(String filter) throws BusinessServiceException {
		DTOIntAccMovementsResumesFilter filterDto = null;
		try {

			log.info("A query string (filter) has been sended: " + filter);
			SearchCondition<DTOIntAccMovementsResume> sc;

			sc = new FiqlParser<DTOIntAccMovementsResume>(DTOIntAccMovementsResume.class).parse(filter);
			final List<PrimitiveStatement> splitDataFilter = businessToolKit.getDataFromFilter(sc);

			filterDto = new DTOIntAccMovementsResumesFilter();

			for (PrimitiveStatement st : splitDataFilter) {
				if (st.getCondition().equals(ConditionType.GREATER_OR_EQUALS)) {
					filterDto.setStartDate((Date)st.getValue());
				} else if (st.getCondition().equals(ConditionType.LESS_OR_EQUALS)) {
					filterDto.setEndDate((Date)st.getValue());
				}

			}

			if (filterDto.getEndDate() == null) {
				filterDto.setEndDate(new Date());
			}
			if (filterDto.getStartDate() == null) {
				throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias());
			}

			DateValidator validator = (DateValidator)new DateValidator().noFuture(filterDto.getStartDate())
					.noFuture(filterDto.getEndDate()).validDateRange(filterDto.getStartDate(), filterDto.getEndDate())
					.validate();

		} catch (BusinessServiceException bse) {
			log.error("BusinessServiceException - The query string (filter) has failed: " + bse);
			throw bse;
		} catch (SearchParseException e) {
			log.error("SearchParseException - The query string (filter) has failed: " + e);
			throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias(), e.getMessage());
		}
		return filterDto;
	}
}
