package com.bbva.czic.globalposition.dao.mappers.impl;

import com.bbva.czic.dto.net.EnumPhoneNumberType;
import com.bbva.czic.globalposition.business.dto.*;
import com.bbva.czic.globalposition.dao.mappers.ITxGlobalPositionMapper;
import com.bbva.czic.globalposition.dao.model.ozn1.FormatoOZECN1E0;
import com.bbva.czic.globalposition.dao.model.ozn1.FormatoOZECN1S0;
import com.bbva.czic.globalposition.dao.model.ozn1.FormatoOZECN1S1;
import com.bbva.czic.globalposition.dao.utils.converters.FormatBalanceToDTOBalanceConverter;
import com.bbva.czic.routine.commons.rm.utils.mappers.Mapper;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Entelgy Colombia.
 */
@Mapper(value = "txGlobalPositionMapper")
public class TxGlobalPositionMapper implements ITxGlobalPositionMapper {

    private static I18nLog log = I18nLogFactory.getLogI18n(TxGlobalPositionMapper.class, "META-INF/spring/i18n/log/mensajesLog");

    public static final String TRUE = "C";

    @Override
    public FormatoOZECN1E0 mapInOzn1(DTOIntProductFilter productFilter) {
        log.info("INICIO - TxGlobalPositionMapper#mapInOzn1 - dtoInt: " + productFilter);
        final FormatoOZECN1E0 formatoEntrada = new FormatoOZECN1E0();

        formatoEntrada.setNumclie(productFilter.getIdCustomer());
        formatoEntrada.setTipprod(productFilter.getProductType());

        log.info("INICIO - TxGlobalPositionMapper#mapInOzn1 - dtoInt: " + productFilter);

        return formatoEntrada;
    }

    @Override
    public DTOIntProduct mapOutOzn1S0(FormatoOZECN1S0 formatoOZECN1S0) {
        log.info("INICIO - TxGlobalPositionMapper#mapOutOzn1S0 - outFormat: " + formatoOZECN1S0);
        final DTOIntProduct product = new DTOIntProduct();
        final FormatBalanceToDTOBalanceConverter balanceConverter = new FormatBalanceToDTOBalanceConverter();

        // isValidNotNullOutFormat(outFormat);

        //product.setProductType(EnumProductType.valueOf(outFormat.getTipprod()));
        product.setProductType(formatoOZECN1S0.getTipprod());

        product.setId(formatoOZECN1S0.getNumprod());

        product.setBalance(balanceConverter.convert(formatoOZECN1S0.getSaltota(), formatoOZECN1S0.getSaldisp()));

        product.setVisible(TRUE.equalsIgnoreCase(formatoOZECN1S0.getIndoper()));
        product.setOperable(TRUE.equalsIgnoreCase(formatoOZECN1S0.getIndoper()));
        product.setAlias(formatoOZECN1S0.getAlias());
        product.setName(formatoOZECN1S0.getNomprod());
        product.setFinancialState(formatoOZECN1S0.getFinstat());

        log.info("FIN - TxGlobalPositionMapper#mapOutOzn1S0 - outFormat: " + formatoOZECN1S0 + " - product: " + product);

        return product;
    }

    @Override
    public DTOIntProduct mapOutOzn1S1(FormatoOZECN1S1 formatoOZECN1S1) {
        log.info("INICIO - TxGlobalPositionMapper#mapOutOzn1S1 - outFormat: " + formatoOZECN1S1);
        final DTOIntProduct product = new DTOIntProduct();
        final FormatBalanceToDTOBalanceConverter balanceConverter = new FormatBalanceToDTOBalanceConverter();
        final DTOIntContract contract = new DTOIntContract();

        //product.setProductType(EnumProductType.valueOf(outFormat.getTipprod()));
        product.setProductType(formatoOZECN1S1.getTipprod());
        product.setId(formatoOZECN1S1.getNumprod());

        product.setBalance(balanceConverter.convert(formatoOZECN1S1.getSaltota(), formatoOZECN1S1.getSaldisp()));

        product.setVisible(TRUE.equalsIgnoreCase(formatoOZECN1S1.getIndvisi()));
        product.setOperable(TRUE.equalsIgnoreCase(formatoOZECN1S1.getIndoper()));
        product.setAlias(formatoOZECN1S1.getAlias());
        product.setName(formatoOZECN1S1.getNomprod());
        product.setFinancialState(formatoOZECN1S1.getFinstat());
        if (formatoOZECN1S1.getNumtarj() != null) {
            product.setId(formatoOZECN1S1.getNumtarj());
        }
        contract.setNumber(formatoOZECN1S1.getNumcont());
        product.setContract(contract);

        product.setContactInfo(getDtoIntContactInfo(formatoOZECN1S1.getNumcelu()));

        log.info("FIN - TxGlobalPositionMapper#mapOutOzn1S1 - outFormat: " + formatoOZECN1S1 + " product: " + product);

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


/*    @Override
    protected void configure(MapperFactory factory) {
        *//**
     * MAPEO DE ENTRADAS
     *//*
        factory.classMap(DTOIntProductFilter.class, FormatoOZECN1E0.class)
                .field("idCustomer", "numclie")
                .field("productType", "tipprod")
                .byDefault().register();

        *//**
     * MAPEO DE SALIDAS
     *//*
        factory.classMap(DTOIntProduct.class, FormatoOZECN1S1.class)
                .field("id", "numprod")
                .field("productType", "tipprod")
                .field("balance.total", "saltota")
                .field("balance.availableBalance", "saldisp")
                .field("visible", "indvisi")
                .field("operable", "indoper")
                .field("alias", "alias")
                .field("financialState", "finstat")
                .field("", "");


    }*/
}
