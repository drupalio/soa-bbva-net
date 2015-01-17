package com.bbva.czic.accounts.facade.v01.utils.impl;

import com.bbva.czic.accounts.business.dto.DTOIntCheck;
import com.bbva.czic.accounts.business.dto.DTOIntFilterChecks;
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
    public DTOIntFilterChecks getDTOIntFilter(String accountId, String filter, String status, String paginationKey, String pageSize) {

        //Variables
        final DTOIntFilterChecks dtoIntFilterChecks = new DTOIntFilterChecks();
        String startDate = "";
        String endDate = "";

        //Comprobamos que el id account no sea nullo dado que es obligatorio
        if(accountId == null || accountId.trim().isEmpty() || status == null || status.trim().isEmpty() || pageSize
                == null || pageSize.trim().isEmpty() || paginationKey == null || paginationKey.trim().isEmpty()) {
            throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias());
        }

        //Manejamos el filter
        if (filter != null && !filter.contentEquals("null")) {
            log.info("A query string (filter) has been sended: " + filter);
            SearchCondition<DTOIntCheck> sc;
            try {
                sc = new FiqlParser<DTOIntCheck>(DTOIntCheck.class).parse(filter);

                final List<PrimitiveStatement> splitDataFilter = businessToolKit.getDataFromFilter(sc);

                for (PrimitiveStatement st : splitDataFilter) {

                    String property = null;
                    String condition = null;
                    String value = null;

                    property = st.getProperty();
                    condition = st.getCondition().toString();
                    value = st.getValue().toString();

                    if (property.toLowerCase().equals("issueDate")
                            && condition.equals(ConditionType.GREATER_OR_EQUALS
                            .toString())) {
                        startDate = value;
                    } else if (property.toLowerCase().equals("issueDate")
                            && condition.equals(ConditionType.LESS_OR_EQUALS
                            .toString())) {
                        endDate = value;
                    }
                }

				/*
				 * Se hace la comprobacion de que los dos parametros del filtros
				 * tengan valor
				 */
                if (startDate == null || endDate == null
                        || startDate.equals("") || endDate.equals("")) {
                    throw new BusinessServiceException(EnumError.FILTER_EMPTY.getAlias());
                }

				/*
				 * Transformacion de fechas
				 */
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                Date startDateFilter = null;
                Date endDateFilter = null;
                try {
                    startDateFilter = formato.parse(startDate);
                    endDateFilter = formato.parse(endDate);
                } catch (ParseException ex) {
                    throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias());
                }

                log.info(" Filter starDateFilter: "+startDateFilter+" SMC : listChecks SN Account ");
                System.out.println(startDate);
                log.info(" Filter endDateFilter: "+endDateFilter+" SMC : listChecks SN Account ");
                System.out.println(endDate);

                dtoIntFilterChecks.setStartDate(startDateFilter);
                dtoIntFilterChecks.setStartDate(startDateFilter);

            } catch (SearchParseException e) {
                log.error("SearchParseException - The query string (filter) has failed: " + e);
                throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias(), filter, e.getMessage());
            } catch (IllegalArgumentException e) {
                log.error("IllegalArgumentException - The product type is an invalid type - does not exist: " + e);
                throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias(), filter, e.getMessage());
            }
        }

        dtoIntFilterChecks.setAccountId(accountId);

        return dtoIntFilterChecks;

    }

}

