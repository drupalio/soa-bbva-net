package com.bbva.czic.globalposition.facade.v01.utils.converters.impl;

import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.czic.globalposition.business.dto.DTOIntFilterProduct;
import com.bbva.czic.globalposition.facade.v01.utils.converters.IFilterConverter;
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
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Entelgy Colombia.
 */
@Component(value = "global-position-filter-converter")
public class GlobalPositionFilterConverter implements IFilterConverter {

    private static I18nLog log = I18nLogFactory.getLogI18n(GlobalPositionFilterConverter.class, "META-INF/spring/i18n/log/mensajesLog");

    @Autowired
    BusinessServicesToolKit businessToolKit;

    @Override
    public DTOIntFilterProduct getDTOIntFilter(String customerId, String filter) {

        final DTOIntFilterProduct filterProduct = new DTOIntFilterProduct();
        filterProduct.setProductType(null);

        if(customerId == null || customerId.equals("null") || customerId.isEmpty()) {
            throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias());
        }
        if (filter != null && !filter.contentEquals("null")) {
            log.info("A query string (filter) has been sended: " + filter);
            SearchCondition<DTOIntFilterProduct> sc;
            try {
                sc = new FiqlParser<DTOIntFilterProduct>(DTOIntFilterProduct.class).parse(filter);

                final List<PrimitiveStatement> splitDataFilter = businessToolKit.getDataFromFilter(sc);
                for (PrimitiveStatement st : splitDataFilter) {
                    if (st.getProperty().equalsIgnoreCase("productType")) {
                        filterProduct.setProductType(EnumProductType.valueOf(st.getValue().toString()).name());
                    }
                }

            } catch (SearchParseException e) {
                log.error("SearchParseException - The query string (filter) has failed: " + e);
                throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias(), filter, e.getMessage());
            } catch (IllegalArgumentException e) {
                log.error("IllegalArgumentException - The product type is an invalid type - does not exist: " + e);
                throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias(), filter, e.getMessage());
            }
        }

        filterProduct.setIdCustomer(customerId);

        return filterProduct;

    }

}
