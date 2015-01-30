package com.bbva.czic.customers.facade.v01.mappers.impl;

import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResumesFilter;
import com.bbva.czic.customers.business.dto.DTOIntCardCharge;
import com.bbva.czic.customers.business.dto.DTOIntCardChargeFilter;
import com.bbva.czic.customers.business.dto.DTOIntCustomerOperation;
import com.bbva.czic.customers.facade.v01.mappers.ICustomerMapper;
import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.CardCharge;
import com.bbva.czic.dto.net.CustomerOperation;
import com.bbva.czic.routine.commons.rm.utils.converter.EmailStringConverter;
import com.bbva.czic.routine.commons.rm.utils.fiql.FiqlType;
import com.bbva.czic.routine.commons.rm.utils.mappers.AbstractBbvaConfigurableMapper;
import com.bbva.czic.routine.mapper.MapperFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Entelgy Colombia.
 */
@Component("customerMapper")
public class CustomerMapper extends AbstractBbvaConfigurableMapper implements ICustomerMapper {

    @Override
    protected void configure(MapperFactory factory) {
        super.configure(factory);

        
        factory.getConverterFactory().registerConverter(new EmailStringConverter());

        // mapAccMovementsResume DTOIntFilterCustomerResumes <-> AccMovementsResume
        factory.classMap(DTOIntAccMovementsResume.class, AccMovementsResume.class)
                .field("income", "income")
                .field("outcome", "outcome")
                .field("balance", "balance")
                .field("month", "month")
                .byDefault().register();

        factory.classMap(CustomerOperation.class, DTOIntCustomerOperation.class)
                .field("operation.code", "code")
                .field("card.cardNumber", "cardNumber")
                .field("card.nip", "cardNip")
                .field("customer.id", "customerId")
                .field("customer.document.number", "documentNumber")
                .field("customer.document.type", "documentType")
                .field("customer.contactInfo.emails", "emails")
                .byDefault().register();

    }

    @Override
    public DTOIntAccMovementsResumesFilter getDTOIntMovementResumesFilter(final String customerId, final String filter) {
        final String startDate = this.getGeValue(filter, FiqlType.month.name());
        final String endDate = this.getLeValue(filter, FiqlType.month.name());

        final DTOIntAccMovementsResumesFilter intFilterCustomerResumes = new DTOIntAccMovementsResumesFilter();

        intFilterCustomerResumes.setStartDate(startDate);
        intFilterCustomerResumes.setEndDate(endDate);

        intFilterCustomerResumes.setCustomerId(customerId);

        return intFilterCustomerResumes;
    }

    @Override
    public List<AccMovementsResume> mapAccMovementsResume(List<DTOIntAccMovementsResume> accMovementsResumes) {
        return mapAsList(accMovementsResumes, AccMovementsResume.class);
    }

    @Override
    public List<CardCharge> mapCardCharges(List<DTOIntCardCharge> intCardCharges) {
        return null;
    }

    @Override
    public DTOIntCardChargeFilter getCreditCardChargesFilter(String customerId, String filter) {
        final String startDate = this.getGeValue(filter, FiqlType.chargeDate.name());
        final String endDate = this.getLeValue(filter, FiqlType.chargeDate.name());

        final DTOIntCardChargeFilter cardChargeFilter = new DTOIntCardChargeFilter();

        cardChargeFilter.setCustomerId(customerId);
        cardChargeFilter.setStartDate(startDate);
        cardChargeFilter.setEndDate(endDate);

        return cardChargeFilter;
    }

    @Override
    public DTOIntCustomerOperation map(CustomerOperation operation) {
        return map(operation, DTOIntCustomerOperation.class);
    }

}
