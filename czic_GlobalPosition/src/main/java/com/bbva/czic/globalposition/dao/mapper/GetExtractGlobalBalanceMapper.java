package com.bbva.czic.globalposition.dao.mapper;

import com.bbva.czic.dto.net.EnumFinancialStatusType;
import com.bbva.czic.dto.net.EnumPhoneNumberType;
import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.czic.globalposition.business.dto.*;
import com.bbva.czic.globalposition.dao.model.ozn1.FormatoOZECN1E0;
import com.bbva.czic.globalposition.dao.model.ozn1.FormatoOZECN1S1;
import com.bbva.czic.globalposition.dao.utils.converters.FormatBalanceToDTOBalanceConverter;
import com.bbva.czic.routine.commons.rm.utils.tx.IFormatNotApply;
import com.bbva.czic.routine.commons.rm.utils.tx.IPaginatedTransactionMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrador on 05/01/2015.
 */
@Component("tx-get-extract-global-balance-mapper-tc")
public class GetExtractGlobalBalanceMapper
        implements IPaginatedTransactionMapper <DTOIntFilterProduct, FormatoOZECN1E0, DTOIntProducts, IFormatNotApply, DTOIntProduct, FormatoOZECN1S1, IFormatNotApply> {

    /**
     * {@inheritDoc}
     */
    @Override
    public FormatoOZECN1E0 mapToInner(DTOIntFilterProduct dtoIn) {
        final FormatoOZECN1E0 formatoEntrada = new FormatoOZECN1E0();

        formatoEntrada.setNumclie(dtoIn.getIdCustomer());
        formatoEntrada.setTipprod(dtoIn.getProductType().name());

        return formatoEntrada;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DTOIntProducts mapToOuter(IFormatNotApply outFormat, DTOIntFilterProduct dtoIn) {
        final DTOIntProducts productsWrappers = new DTOIntProducts();
        productsWrappers.setProducts(new ArrayList<DTOIntProduct>());
        return productsWrappers;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addPaginationInfo(IFormatNotApply paginationOutFormat, DTOIntFilterProduct dtoIn) {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean doIHaveToPaginate(DTOIntFilterProduct dtoIn) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DTOIntProduct mapToInnerEntity(final FormatoOZECN1S1 outFormat, final DTOIntFilterProduct dtoIn) {
        final DTOIntProduct product = new DTOIntProduct();
        final FormatBalanceToDTOBalanceConverter balanceConverter = new FormatBalanceToDTOBalanceConverter();
        final DTOIntContract contract = new DTOIntContract();

        product.setProductType(EnumProductType.valueOf(outFormat.getTipprod()));
        product.setId(outFormat.getNumprod());

        product.setBalance(balanceConverter.convert(outFormat.getSaltota(), outFormat.getSaldisp()));

        product.setVisible(outFormat.getIndvisi().equalsIgnoreCase("v") || outFormat.getIndvisi().equalsIgnoreCase("t"));
        product.setOperable(outFormat.getIndoper().equalsIgnoreCase("v") || outFormat.getIndoper().equalsIgnoreCase("t"));
        product.setAlias(outFormat.getAlias());
        product.setName(outFormat.getNomprod());
        product.setFinancialState(EnumFinancialStatusType.valueOf(outFormat.getFinstat()));
        if (outFormat.getNumtarj() != null) {
            product.setId(outFormat.getNumtarj());
        }
        contract.setNumber(outFormat.getNumcont());
        product.setContract(contract);

        product.setContactInfo(getDtoIntContactInfo(outFormat));

        return product;
    }

    private DTOIntContactInfo getDtoIntContactInfo(final FormatoOZECN1S1 outFormat) {
        final DTOIntContactInfo contactInfo = new DTOIntContactInfo();
        final DTOIntPhoneNumber phoneNumber = new DTOIntPhoneNumber();
        final List<DTOIntPhoneNumber> phoneNumbers = new ArrayList<DTOIntPhoneNumber>();

        phoneNumber.setNumber(outFormat.getNumcelu());
        phoneNumber.setType(EnumPhoneNumberType.MOBILE);
        phoneNumbers.add(phoneNumber);
        contactInfo.setPhoneNumbers(phoneNumbers);
        return contactInfo;
    }

}