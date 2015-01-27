package com.bbva.czic.globalposition.dao.mappers.impl;

import com.bbva.czic.dto.net.EnumPhoneNumberType;
import com.bbva.czic.globalposition.business.dto.*;
import com.bbva.czic.globalposition.dao.mappers.ITxGlobalPositionMapper;
import com.bbva.czic.globalposition.dao.model.ozn1.FormatoOZECN1E0;
import com.bbva.czic.globalposition.dao.model.ozn1.FormatoOZECN1S0;
import com.bbva.czic.globalposition.dao.model.ozn1.FormatoOZECN1S1;
import com.bbva.czic.globalposition.dao.utils.converters.FormatBalanceToDTOBalanceConverter;
import com.bbva.czic.globalposition.dao.utils.converters.StringOperabilityConverter;
import com.bbva.czic.globalposition.dao.utils.converters.StringVisibilityConverter;
import com.bbva.czic.routine.commons.rm.utils.converter.StringMoneyConverter;
import com.bbva.czic.routine.commons.rm.utils.mappers.AbstractBbvaTxConfigurableMapper;
import com.bbva.czic.routine.commons.rm.utils.mappers.Mapper;
import com.bbva.czic.routine.mapper.MapperFactory;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Entelgy Colombia.
 */
@Mapper(value = "txGlobalPositionMapper")
public class TxGlobalPositionMapper extends AbstractBbvaTxConfigurableMapper implements ITxGlobalPositionMapper {

    private static I18nLog log = I18nLogFactory.getLogI18n(TxGlobalPositionMapper.class, "META-INF/spring/i18n/log/mensajesLog");

    @Override
    protected void configure(MapperFactory factory) {

        factory.getConverterFactory().registerConverter(new StringOperabilityConverter());
        factory.getConverterFactory().registerConverter(new StringVisibilityConverter());

        /*
         * DTOIntProductFilter <-> FormatoOZECN1E0
         */
        factory.classMap(DTOIntProductFilter.class, FormatoOZECN1E0.class)
                .field("idCustomer", "numclie")
                .field("productType", "tipprod")
                .byDefault().register();

        /*
         * DTOIntProduct <-> FormatoOZECN1S0
         */
        factory.classMap(DTOIntProduct.class, FormatoOZECN1S0.class)
                .field("id", "numprod")
                .field("productType", "tipprod")
                .field("balance.total", "saltota")
                .field("balance.availableBalance", "saldisp")
                .field("balance.tradeBalance", "salcanj")
                .field("visible", "indvisi")
                .field("operable", "indoper")
                .field("alias", "alias")
                .field("financialState", "finstat")
                .byDefault().register();

        /*
         * DTOIntProduct <-> FormatoOZECN1S1
         */
        factory.classMap(DTOIntProduct.class, FormatoOZECN1S1.class)
                .field("id", "numprod")
                .field("productType", "tipprod")
                .field("balance.total", "saltota")
                .field("balance.availableBalance", "saldisp")
                .field("visible", "indvisi")
                .field("operable", "indoper")
                .field("alias", "alias")
                .field("name", "nomprod")
                .field("financialState", "finstat")
                .field("contract.number", "numcont")
                .byDefault().register();

    }

    @Override
    public FormatoOZECN1E0 mapInOzn1(DTOIntProductFilter productFilter) {
        log.info("TxGlobalPositionMapper#mapInOzn1 - dtoInt: " + productFilter);

        return map(productFilter, FormatoOZECN1E0.class);
    }

    @Override
    public DTOIntProduct mapOutOzn1S0(FormatoOZECN1S0 formatoOZECN1S0) {
        log.info("INICIO - TxGlobalPositionMapper#mapOutOzn1S0 - outFormat: " + formatoOZECN1S0);

        return map(formatoOZECN1S0, DTOIntProduct.class);
    }

    @Override
    public DTOIntProduct mapOutOzn1S1(FormatoOZECN1S1 formatoOZECN1S1) {
        log.info("INICIO - TxGlobalPositionMapper#mapOutOzn1S1 - outFormat: " + formatoOZECN1S1);
        final DTOIntProduct product = map(formatoOZECN1S1, DTOIntProduct.class);

        if (formatoOZECN1S1.getNumtarj() != null && !formatoOZECN1S1.getNumtarj().isEmpty()) {
            product.setId(formatoOZECN1S1.getNumtarj());
        }
        product.setContactInfo(getDtoIntContactInfo(formatoOZECN1S1.getNumcelu()));
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
