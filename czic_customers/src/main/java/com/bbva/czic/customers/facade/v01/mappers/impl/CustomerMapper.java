package com.bbva.czic.customers.facade.v01.mappers.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResumesFilter;
import com.bbva.czic.customers.business.dto.DTOIntCardCharge;
import com.bbva.czic.customers.business.dto.DTOIntCardChargeFilter;
import com.bbva.czic.customers.business.dto.DTOIntCustomer;
import com.bbva.czic.customers.business.dto.DTOIntCustomerFilter;
import com.bbva.czic.customers.business.dto.DTOIntCustomerOperation;
import com.bbva.czic.customers.dao.converters.CardChargeCategoryConverter;
import com.bbva.czic.customers.facade.v01.mappers.ICustomerMapper;
import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.CardCharge;
import com.bbva.czic.dto.net.Customer;
import com.bbva.czic.dto.net.CustomerOperation;
import com.bbva.czic.dto.net.Document;
import com.bbva.czic.routine.commons.rm.utils.converter.EmailStringConverter;
import com.bbva.czic.routine.commons.rm.utils.fiql.FiqlType;
import com.bbva.czic.routine.commons.rm.utils.mappers.AbstractBbvaConfigurableMapper;
import com.bbva.czic.routine.mapper.MapperFactory;

/**
 * @author Entelgy Colombia.
 */
@Component("customerMapper")
public class CustomerMapper extends AbstractBbvaConfigurableMapper implements ICustomerMapper {

    public static final String CARD_CHARGE_CATEGORY_CONVERTER = "cardChargeCategoryConverter";

    @Override
    protected void configure(final MapperFactory factory) {
        super.configure(factory);

        factory.getConverterFactory().registerConverter(CARD_CHARGE_CATEGORY_CONVERTER, new CardChargeCategoryConverter());
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

        factory.classMap(CardCharge.class, DTOIntCardCharge.class)
                .fieldMap("category", "category").converter("cardChargeCategoryConverter").add()
                .field("amount", "amount")
                .byDefault().register();

        factory.classMap(Customer.class, DTOIntCustomer.class)

                .byDefault().register();
    }

    @Override
    public DTOIntAccMovementsResumesFilter getDTOIntMovementResumesFilter(final String filter) {
        final String startDate = this.getGeValue(filter, FiqlType.month.name());
        final String endDate = this.getLeValue(filter, FiqlType.month.name());

        final DTOIntAccMovementsResumesFilter intFilterCustomerResumes = new DTOIntAccMovementsResumesFilter();

        intFilterCustomerResumes.setStartDate(startDate);
        intFilterCustomerResumes.setEndDate(endDate);

        return intFilterCustomerResumes;
    }

    @Override
    public List<AccMovementsResume> mapAccMovementsResume(List<DTOIntAccMovementsResume> accMovementsResumes) {
        return mapAsList(accMovementsResumes, AccMovementsResume.class);
    }

    @Override
    public List<CardCharge> mapCardCharges(final List<DTOIntCardCharge> intCardCharges) {
        return mapAsList(intCardCharges, CardCharge.class);
    }

    @Override
    public DTOIntCardChargeFilter getCreditCardChargesFilter(final String filter) {
        final String startDate = this.getGeValue(filter, FiqlType.chargeDate.name());
        final String endDate = this.getLeValue(filter, FiqlType.chargeDate.name());

        final DTOIntCardChargeFilter cardChargeFilter = new DTOIntCardChargeFilter();

        cardChargeFilter.setStartDate(startDate);
        cardChargeFilter.setEndDate(endDate);

        return cardChargeFilter;
    }

    @Override
    public DTOIntCustomerOperation map(final CustomerOperation operation) {
        DTOIntCustomerOperation dto = map(operation, DTOIntCustomerOperation.class);
        dto.setDocumentType(operation.getCustomer().getDocument().getType().getCode());
        return dto;
    }

    @Override
    public Customer mapCustomer(final DTOIntCustomer intCustomer) {
        return map(intCustomer, Customer.class);
    }

    @Override
    public DTOIntCustomerFilter mapDTOIntCustomerFilter(final String filter) {
        final DTOIntCustomerFilter customerFilter = new DTOIntCustomerFilter();
        final String idDocument = this.getEqValue(filter,"document");
        customerFilter.setIdDocument(idDocument);
        return customerFilter;
    }

}
