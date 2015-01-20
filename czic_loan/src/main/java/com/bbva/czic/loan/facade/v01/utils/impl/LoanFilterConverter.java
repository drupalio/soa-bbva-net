package com.bbva.czic.loan.facade.v01.utils.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.bbva.czic.loan.business.dto.DTOIntFilterLoan;
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


/**
 * Created by Entelgy on 12/01/2015.
 */
@Component(value = "loan-filter-converter")
public class LoanFilterConverter{

    private static I18nLog log = I18nLogFactory.getLogI18n(LoanFilterConverter.class, "META-INF/spring/i18n/log/mensajesLog");

    @Autowired
    BusinessServicesToolKit businessToolKit;

    /**
     * Metodo encargado de hacer el manejo del filter para retornar un DTO de tipo filtro el cual sera enviado
     * a los servicios de negocio
     * @author David Bernal
     * @param loanId
     * @param filter
     * @return
     */
    public DTOIntFilterLoan getDTOIntFilter(String loanId, String filter) {

        //Variables
        final DTOIntFilterLoan dtoIntFilterLoan = new DTOIntFilterLoan();
        String fechaInicial = "";
        String fechaFinal = "";
        
        //Comprobamos que el id del loan no sea nullo dado que es obligatorio
        if(loanId == null || loanId.equals("null") || loanId.isEmpty()) {
            throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias());
        }
        dtoIntFilterLoan.setIdLoan(loanId);
        //Manejamos el filter
        if (filter != null && !filter.contentEquals("null")) {
            log.info("A query string (filter) has been sended Loan ---> : " + filter);
            SearchCondition<DTOIntFilterLoan> sc;
            try {
                sc = new FiqlParser<DTOIntFilterLoan>(DTOIntFilterLoan.class).parse(filter);

                List<PrimitiveStatement> splitDataFilter = businessToolKit.getDataFromFilter(sc);

                for (PrimitiveStatement st : splitDataFilter) {

                    String property = null;
                    String condition = null;
                    String value = null;

                    property = st.getProperty();
                    condition = st.getCondition().toString();
                    value = st.getValue().toString();

                    if (property.toLowerCase().equals("transactiondate") && condition.equals(ConditionType.GREATER_OR_EQUALS.toString())) {
                    	fechaInicial = value;
                    } else if (property.toLowerCase().equals("transactiondate") && condition.equals(ConditionType.LESS_OR_EQUALS.toString())) {
                    	fechaFinal = value;
                    }
                }

				/*
				 * Se hace la comprobacion de que los dos parametros del filtros
				 * tengan valor
				 */
                if (fechaInicial == null || fechaInicial.trim().isEmpty() || fechaFinal == null || fechaFinal.trim().isEmpty()) {
                    throw new BusinessServiceException(EnumError.FILTER_EMPTY.getAlias());
                }

				/*
				 * Transformacion de fechas
				 */
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
                Date startDateFilter = null;
                Date endtDateFilter = null;
                
                try {
                	startDateFilter = formato.parse(fechaInicial);
                	endtDateFilter = formato.parse(fechaInicial);
                } catch (ParseException ex) {
                    throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias());
                }

                log.info(" Filter starDateFilter: "+startDateFilter+" SMC : getCreditCardCharges SN Cards ");              
                      
                dtoIntFilterLoan.setFechaInicial(startDateFilter);
                dtoIntFilterLoan.setFechaFianl(endtDateFilter);

            } catch (SearchParseException e) {
                log.error("SearchParseException - The query string (filter) has failed: " + e.getMessage());
                throw new BusinessServiceException(EnumError.INEXISTENT_FILTER.getAlias(), filter, e.getMessage());
            } catch (IllegalArgumentException e) {
                log.error("IllegalArgumentException - The product type is an invalid type - does not exist: " + e.getMessage());
                throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias(), filter, e.getMessage());
            }
        }        

        return dtoIntFilterLoan;

    }

}

