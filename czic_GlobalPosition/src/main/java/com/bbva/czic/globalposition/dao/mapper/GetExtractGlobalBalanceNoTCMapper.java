package com.bbva.czic.globalposition.dao.mapper;

import com.bbva.czic.globalposition.business.dto.*;
import com.bbva.czic.globalposition.dao.model.ozn1.FormatoOZECN1E0;
import com.bbva.czic.globalposition.dao.model.ozn1.FormatoOZECN1S0;
import com.bbva.czic.globalposition.dao.utils.converters.FormatBalanceToDTOBalanceConverter;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.czic.routine.commons.rm.utils.tx.IFormatNotApply;
import com.bbva.czic.routine.commons.rm.utils.tx.IPaginatedTransactionMapper;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import org.apache.commons.lang.Validate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by Administrador on 05/01/2015.
 */
@Component("tx-get-extract-global-balance-mapper")
public class GetExtractGlobalBalanceNoTCMapper
        implements IPaginatedTransactionMapper <DTOIntFilterProduct, FormatoOZECN1E0, DTOIntProducts, IFormatNotApply, DTOIntProduct, FormatoOZECN1S0, IFormatNotApply> {

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
    public DTOIntProduct mapToInnerEntity(final FormatoOZECN1S0 outFormat, final DTOIntFilterProduct dtoIn) {
        final DTOIntProduct product = new DTOIntProduct();
        final FormatBalanceToDTOBalanceConverter balanceConverter = new FormatBalanceToDTOBalanceConverter();
        final DTOIntContract contract = new DTOIntContract();

        isValidNotNullOutFormat(outFormat);

        //product.setProductType(EnumProductType.valueOf(outFormat.getTipprod()));
        product.setProductType(outFormat.getTipprod());

        product.setId(outFormat.getNumprod());

        product.setBalance(balanceConverter.convert(outFormat.getSaltota(), outFormat.getSaldisp()));

        product.setVisible(outFormat.getIndvisi().equalsIgnoreCase("v") || outFormat.getIndvisi().equalsIgnoreCase("t"));
        product.setOperable(outFormat.getIndoper().equalsIgnoreCase("v") || outFormat.getIndoper().equalsIgnoreCase("t"));
        product.setAlias(outFormat.getAlias());
        product.setName(outFormat.getNomprod());
        product.setFinancialState(outFormat.getFinstat());

        return product;
    }

    private boolean isValidNotNullOutFormat(FormatoOZECN1S0 outFormat){
        try {

            Validate.notEmpty(outFormat.getTipprod());
            Validate.notEmpty(outFormat.getNumprod());
            Validate.notEmpty(outFormat.getSaldisp());
            Validate.notEmpty(outFormat.getSaltota());
            Validate.notEmpty(outFormat.getIndvisi());
            Validate.notEmpty(outFormat.getIndoper());
            Validate.notEmpty(outFormat.getAlias());
            Validate.notEmpty(outFormat.getNomprod());
            Validate.notEmpty(outFormat.getFinstat());

        } catch (IllegalArgumentException iae) {
            throw new BusinessServiceException(EnumError.MANDATORY_PARAMETERES_MISSING.getAlias(), iae);
        }

        return true;
    }

}