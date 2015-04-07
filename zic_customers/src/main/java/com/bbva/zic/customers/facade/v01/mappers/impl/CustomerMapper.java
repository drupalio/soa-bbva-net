package com.bbva.zic.customers.facade.v01.mappers.impl;

import java.util.List;

import com.bbva.zic.customers.business.dto.DTOIntCardCharge;
import com.bbva.zic.customers.business.dto.DTOIntCardChargeFilter;
import com.bbva.zic.customers.business.dto.DTOIntCustomer;
import com.bbva.zic.customers.business.dto.DTOIntCustomerFilter;
import org.springframework.stereotype.Component;

import com.bbva.zic.customers.business.dto.DTOIntAccMovementsResume;
import com.bbva.zic.customers.business.dto.DTOIntAccMovementsResumesFilter;
import com.bbva.zic.customers.business.dto.DTOIntCustomerOperation;
import com.bbva.zic.customers.business.dto.DTOIntDocument;
import com.bbva.zic.customers.dao.converters.CardChargeCategoryConverter;
import com.bbva.zic.customers.facade.v01.mappers.ICustomerMapper;
import com.bbva.zic.dto.net.AccMovementsResume;
import com.bbva.zic.dto.net.CardCharge;
import com.bbva.zic.dto.net.Customer;
import com.bbva.zic.dto.net.CustomerOperation;
import com.bbva.zic.routine.commons.rm.utils.converter.EmailStringConverter;
import com.bbva.zic.routine.commons.rm.utils.fiql.FiqlType;
import com.bbva.zic.routine.commons.rm.utils.mappers.AbstractBbvaConfigurableMapper;
import com.bbva.zic.routine.mapper.MapperFactory;

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
        		.field("contactInfo","emails")
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
    	Customer c = map(intCustomer, Customer.class);
        return c;
    }

    @Override
    public DTOIntCustomerFilter mapDTOIntCustomerFilter(final String filter) {
        DTOIntCustomerFilter customerFilter = new DTOIntCustomerFilter();
        final String idDocument = this.getEqValue(filter,"document");
        final String username = this.getEqValue(filter,"username");
        final String documentType = this.getEqValue(filter,"documentType");
        customerFilter.setDocument(new DTOIntDocument());
        customerFilter.getDocument().setNumber(idDocument);
        customerFilter.getDocument().setType(documentType);
        customerFilter.setUsername(username);
        customerFilter.setConcat(customerFilter.getUsername()+customerFilter.getDocument().getType()+customerFilter.getDocument().getNumber());
        return customerFilter;
    }

}
