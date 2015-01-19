package com.bbva.czic.movements.facade.v01.utils.converter.impl;

import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.czic.movements.business.dto.DTOIntMovementsFilter;
import com.bbva.czic.movements.facade.v01.utils.converter.IFilterConverter;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.czic.routine.commons.rm.utils.validator.impl.AmountValidator;
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

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Entelgy on 17/01/2015.
 */
@Component(value = "movements-filter")
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
                dtofilter = new DTOIntMovementsFilter();
                for (PrimitiveStatement st : splitDataFilter) {
                    if(st.getProperty().equals("productId")){
                        dtofilter.setProductId((String) st.getValue());
                    }else if (st.getProperty().equals("productType")){
                        dtofilter.setProductType(EnumProductType.valueOf((String)st.getValue()));
                    }else if(st.getProperty().equals("transactionDate")){
                        if(st.getCondition().equals(ConditionType.GREATER_OR_EQUALS)){
                            dtofilter.setStartDate((Date) st.getValue());
                        }else if(st.getCondition().equals(ConditionType.LESS_OR_EQUALS)){
                            dtofilter.setEndDate((Date) st.getValue());
                        }
                    }else if(st.getProperty().equals("value")){
                        if(st.getCondition().equals(ConditionType.GREATER_OR_EQUALS)){
                            dtofilter.setBottomValue((BigDecimal) st.getValue());
                        }else if(st.getCondition().equals(ConditionType.LESS_OR_EQUALS)){
                            dtofilter.setTopValue((BigDecimal) st.getValue());
                        }
                    }
                }
                //Validaciones del filtro
                validateFilter(dtofilter);

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

    @Override
    public DTOIntMovementsFilter dtoIntMovementsFilter(String filter,String idMovement) {

        //Variables
        DTOIntMovementsFilter dtoIntFilterMovements = new DTOIntMovementsFilter();

        //Comprobamos que el id del idMovement no sea nullo dado que es obligatorio
        if(idMovement == null || idMovement.equals("null") || idMovement.isEmpty()) {
            throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias());
        }

        //Manejamos el filter
        if (filter != null && !filter.contentEquals("null")) {
            log.info("A query string (filter) has been sended: " + filter);
            SearchCondition<DTOIntMovementsFilter> sc;
            try {
                sc = new FiqlParser<DTOIntMovementsFilter>(DTOIntMovementsFilter.class).parse(filter);

                final List<PrimitiveStatement> splitDataFilter = businessToolKit.getDataFromFilter(sc);

                for (PrimitiveStatement st : splitDataFilter) {

                    String property = null;
                    String condition = null;
                    String value = null;

                    property = st.getProperty();
                    condition = st.getCondition().toString();
                    value = st.getValue().toString();

                    if(property.equals("productType")){
                        dtoIntFilterMovements.setProductType(EnumProductType.valueOf(value));
                    }
                }


            } catch (SearchParseException e) {
                log.error("SearchParseException - The query string (filter) has failed: " + e);
                throw new BusinessServiceException(EnumError.INEXISTENT_FILTER.getAlias(), filter, e.getMessage());
            } catch (IllegalArgumentException e) {
                log.error("IllegalArgumentException - The product type is an invalid type - does not exist: " + e);
                throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias(), filter, e.getMessage());
            }
        }

        dtoIntFilterMovements.setMovementId(idMovement);

        validateFilter(dtoIntFilterMovements);

        return dtoIntFilterMovements;
    }

    private void validateFilter(DTOIntMovementsFilter filter){
        if(filter != null){
            if(filter.getProductId() == null || filter.getProductId().trim().isEmpty()
                    || filter.getProductId().equalsIgnoreCase("null")){
                throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias());
            }
            if(filter.getProductType() == null){
                throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias());
            }

            // Validacion de fechas
            DateValidator dateVal = (DateValidator) new DateValidator().noFuture(filter.getStartDate())
                    .noFuture(filter.getEndDate()).validDateRange(filter.getStartDate(), filter.getEndDate()).validate();

            // Validacion de importes
            if(filter.getBottomValue() != null && filter.getTopValue() != null) {
                AmountValidator amVal = (AmountValidator) new AmountValidator()
                        .validateRange(filter.getBottomValue(),filter.getTopValue()).validate();
            }

        }else{
            throw new BusinessServiceException(EnumError.FILTER_EMPTY.getAlias());
        }
    }
}
