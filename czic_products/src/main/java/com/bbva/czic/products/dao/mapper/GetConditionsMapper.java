package com.bbva.czic.products.dao.mapper;

import com.bbva.czic.dto.net.Conditions;
import com.bbva.czic.dto.net.Products;
import com.bbva.czic.products.business.dto.*;
import com.bbva.czic.products.dao.model.oznt.FormatoOZECN1E0;
import com.bbva.czic.products.dao.model.oznt.FormatoOZECN1S1;
import com.bbva.czic.routine.commons.rm.utils.tx.IFormatNotApply;
import com.bbva.czic.routine.commons.rm.utils.tx.IPaginatedTransactionMapper;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrador on 05/01/2015.
 */
@Component("tx-get-conditions-mapper-tc")
public class GetConditionsMapper
        implements ISimpleTransactionMapper <DTOIntFilterProduct, FormatoOZECN1E0, DTOIntProducts, IFormatNotApply, DTOIntProduct, FormatoOZECN1S1, IFormatNotApply> {

    public static final String TRUE_ES = "v";
    public static final String TRUE_EN = "t";

    /**
     * {@inheritDoc}
     */
    @Override
    public FormatoOZECN1E0 mapToInner(DTOIntFilterProduct dtoIn) {
        final FormatoOZECN1E0 formatoEntrada = new FormatoOZECN1E0();

        formatoEntrada.setNumclie(dtoIn.getIdCustomer());
        formatoEntrada.setTipprod(dtoIn.getProductType());

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

        product.setBalance(balanceConverter.convert(outFormat.getSaltota(), outFormat.getSaldisp(), null));

        product.setVisible(TRUE_ES.equalsIgnoreCase(outFormat.getIndvisi()) || TRUE_EN.equalsIgnoreCase(outFormat.getIndvisi()));
        product.setOperable(TRUE_ES.equalsIgnoreCase(outFormat.getIndoper()) || TRUE_EN.equalsIgnoreCase(outFormat.getIndoper()));
        product.setAlias(outFormat.getAlias());
        product.setName(outFormat.getNomprod());
        product.setFinancialState(EnumFinancialStatusType.valueOf(outFormat.getFinstat()));
        if (outFormat.getNumtarj() != null) {
            product.setId(outFormat.getNumtarj());
        }
        contract.setNumber(outFormat.getNumcont());
        product.setContract(contract);

        product.setContactInfo(getDtoIntContactInfo(outFormat.getNumcelu()));

        return product;
    }

    private DTOIntContactInfo getDtoIntContactInfo(final String mobilePhoneNumber) {
        final DTOIntContactInfo contactInfo = new DTOIntContactInfo();
        final DTOIntPhoneNumber phoneNumber = new DTOIntPhoneNumber();
        final List<DTOIntPhoneNumber> phoneNumbers = new ArrayList<DTOIntPhoneNumber>();

        phoneNumber.setNumber(mobilePhoneNumber);
        phoneNumber.setType(EnumPhoneNumberType.MOBILE);
        phoneNumbers.add(phoneNumber);
        contactInfo.setPhoneNumbers(phoneNumbers);
        return contactInfo;
    }

}