package com.bbva.czic.accounts.facade.v01.utils.impl;

import com.bbva.czic.accounts.business.dto.DTOIntCheck;
import com.bbva.czic.accounts.business.dto.DTOIntFilterChecks;
import com.bbva.czic.accounts.business.dto.DTOIntListCheck;
import com.bbva.czic.accounts.facade.v01.utils.IListCheckFilterConverter;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Entelgy on 14/01/2015.
 */
@Component(value = "listCheck-filter-converter")
public class ListCheckFilterConverter implements IListCheckFilterConverter{

    private static I18nLog log = I18nLogFactory.getLogI18n(ListCheckFilterConverter.class, "META-INF/spring/i18n/log/mensajesLog");

    @Autowired
    BusinessServicesToolKit businessToolKit;

    /**
     * Metodo encargado de hacer el manejo del filter para retornar un DTO de tipo filtro el cual sera enviado
     * a los servicios de negocio
     * @author Cristian Rojas
     * @param accountId
     * @param filter
     * @return
     */
    public DTOIntFilterChecks getDTOIntFilter(String accountId, String filter, Integer paginationKey, Integer pageSize) {

        //Variables
        final DTOIntFilterChecks dtoIntFilterChecks = new DTOIntFilterChecks();


        dtoIntFilterChecks.setAccountId(accountId);
        dtoIntFilterChecks.setPaginationKey(paginationKey);
        dtoIntFilterChecks.setPageSize(pageSize);

        log.info("A query string (filter) has been sended: " + filter);
        SearchCondition<DTOIntListCheck> sc;
        try {
            sc = new FiqlParser<DTOIntListCheck>(DTOIntListCheck.class).parse(filter);

            final List<PrimitiveStatement> splitDataFilter = businessToolKit.getDataFromFilter(sc);

            for (PrimitiveStatement st : splitDataFilter) {

                String property = st.getProperty();
                ConditionType condition = st.getCondition();
                DTOIntCheck value = (DTOIntCheck) st.getValue();

                if (property.equalsIgnoreCase("check.issueDate")
                        && condition.equals(ConditionType.GREATER_OR_EQUALS)) {
                    dtoIntFilterChecks.setStartDate(value.getIssueDate());
                } else if (property.equalsIgnoreCase("check.issueDate")
                        && condition.equals(ConditionType.LESS_OR_EQUALS)) {
                    dtoIntFilterChecks.setEndDate(value.getIssueDate());
                } else if (property.equalsIgnoreCase("check.status")
                        && condition.equals(ConditionType.EQUALS)) {
                    dtoIntFilterChecks.setStatus(value.getStatus());
                }
            }

            log.info(" Filter starDateFilter: "+dtoIntFilterChecks.getStartDate()+" SMC : listChecks SN Account ");
            log.info(" Filter endDateFilter: " + dtoIntFilterChecks.getEndDate()+" SMC : listChecks SN Account ");


        } catch (SearchParseException e) {
            log.error("SearchParseException - The query string (filter) has failed: " + e);
            throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias(), filter, e.getMessage());
        } catch (IllegalArgumentException e) {
            log.error("IllegalArgumentException - The product type is an invalid type - does not exist: " + e);
            throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias(), filter, e.getMessage());
        }

        return dtoIntFilterChecks;

    }

}

