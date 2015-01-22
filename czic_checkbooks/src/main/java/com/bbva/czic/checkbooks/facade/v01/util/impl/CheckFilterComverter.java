package com.bbva.czic.checkbooks.facade.v01.util.impl;

import com.bbva.czic.checkbooks.business.dto.DTOIntCheck;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheckFilter;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.czic.routine.commons.rm.utils.validator.impl.DateValidator;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;
import org.apache.cxf.jaxrs.ext.search.ConditionType;
import org.apache.cxf.jaxrs.ext.search.PrimitiveStatement;
import org.apache.cxf.jaxrs.ext.search.SearchCondition;
import org.apache.cxf.jaxrs.ext.search.SearchParseException;
import org.apache.cxf.jaxrs.ext.search.fiql.FiqlParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Entelgy on 22/01/2015.
 */
@Component(value = "check-filter-converter")
public class CheckFilterComverter {

    private static I18nLog log = I18nLogFactory.getLogI18n(CheckFilterComverter.class, "META-INF/spring/i18n/log/mensajesLog");

    @Autowired
    BusinessServicesToolKit businessToolKit;

    public DTOIntCheck getDTOIntFilter(final String checkId, final String filter) {

        //Variables
        final DTOIntCheck dtoIntFilterCheck = new DTOIntCheck();
        String stado = "";

        dtoIntFilterCheck.setId(checkId);
        //Manejamos el filter
        if (filter != null && !filter.contentEquals("null")) {
            log.info("A query string (filter) has been sended Loan ---> : " + filter);
            SearchCondition<DTOIntCheck> sc;
            try {
                sc = new FiqlParser<DTOIntCheck>(DTOIntCheck.class).parse(filter);

                List<PrimitiveStatement> splitDataFilter = businessToolKit.getDataFromFilter(sc);

                for (PrimitiveStatement st : splitDataFilter) {

                    String property = st.getProperty();
                    String condition = st.getCondition().toString();
                    String value = st.getValue().toString();

                    if (property.toLowerCase().equals("status") && condition.equals(ConditionType.EQUALS.toString())) {
                        stado = value;
                    }
                }

				/*
				 * Se hace la comprobacion de que los dos parametros del filtros
				 * tengan valor
				 */
                if (stado == null || stado.trim().isEmpty()) {
                    throw new BusinessServiceException(EnumError.FILTER_EMPTY.getAlias());
                }

                dtoIntFilterCheck.setStatus(stado);

            } catch (SearchParseException e) {
                log.error("SearchParseException - The query string (filter) has failed: " + e.getMessage());
                throw new BusinessServiceException(EnumError.INEXISTENT_FILTER.getAlias(), filter, e.getMessage());
            } catch (IllegalArgumentException e) {
                log.error("IllegalArgumentException - The product type is an invalid type - does not exist: " + e.getMessage());
                throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias(), filter, e.getMessage());
            }
        }

        return dtoIntFilterCheck;

    }
}
