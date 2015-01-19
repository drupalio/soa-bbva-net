package com.bbva.czic.movements.facade.v01.utils.converter.impl;

import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.czic.movements.business.dto.DTOIntMovementsFilter;
import com.bbva.czic.movements.facade.v01.utils.converter.IFilterConverter;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;
import org.apache.cxf.jaxrs.ext.search.PrimitiveStatement;
import org.apache.cxf.jaxrs.ext.search.SearchCondition;
import org.apache.cxf.jaxrs.ext.search.SearchParseException;
import org.apache.cxf.jaxrs.ext.search.fiql.FiqlParser;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Entelgy on 17/01/2015.
 */
public class MovementsFilterConverter implements IFilterConverter {

    private static I18nLog log = I18nLogFactory.getLogI18n(MovementsFilterConverter.class, "META-INF/spring/i18n/log/mensajesLog");

    @Autowired
    BusinessServicesToolKit businessToolKit;

    @Override
    public DTOIntMovementsFilter toDtoIntMovementsFilter(String filter) {
        DTOIntMovementsFilter dtofilter = null;

        if(filter != null && !filter.trim().isEmpty()
                && !filter.contentEquals("null")){
            log.info("A query string (filter) has been sended: " + filter);
            SearchCondition<DTOIntMovementsFilter> sc;

            try {
                sc = new FiqlParser<DTOIntMovementsFilter>(DTOIntMovementsFilter.class).parse(filter);

                final List<PrimitiveStatement> splitDataFilter = businessToolKit.getDataFromFilter(sc);
                for (PrimitiveStatement st : splitDataFilter) {

                }
            }catch (SearchParseException se){
                log.error("SearchParseException - The query string (filter) has failed: " + se);
                throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias(), filter, se.getMessage());
            }catch (IllegalArgumentException ie){
                log.error("IllegalArgumentException - The product type is an invalid type - does not exist: " + ie);
                throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias(), filter, ie.getMessage());
            }
        }

        return dtofilter;
    }
}
