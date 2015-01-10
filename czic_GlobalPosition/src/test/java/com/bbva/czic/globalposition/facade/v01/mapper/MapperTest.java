package com.bbva.czic.globalposition.facade.v01.mapper;

import com.bbva.czic.dto.net.*;
import com.bbva.czic.globalposition.business.dto.*;
import com.bbva.czic.globalposition.facade.v01.mapper.impl.GlobalPositionMapper;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrador on 17/12/2014.
 */
public class MapperTest {

    GlobalPositionMapper mapper;

    @Test
    public void testMapDTOIntProductToProductAllProducts() {
        /*
        final DTOIntProduct product = new DTOIntProduct();
        final DTOIntBalance balance = new DTOIntBalance();
        final DTOIntContactInfo contactInfo = new DTOIntContactInfo();
        final DTOIntContract contract = new DTOIntContract();
        final DTOIntPhoneNumber phoneNumber = new DTOIntPhoneNumber();
        final List<DTOIntPhoneNumber> phoneNumbers = new ArrayList<DTOIntPhoneNumber>();

        phoneNumber.setNumber("3193954515");
        phoneNumber.setType(EnumPhoneNumberType.MOBILE);
        phoneNumbers.add(phoneNumber);
        contactInfo.setPhoneNumbers(phoneNumbers);

        balance.setAvailableBalance(new Money(Currency.getInstance("COP"), new BigDecimal(12351235)));
        balance.setTotal(new Money(Currency.getInstance("COP"), new BigDecimal(12351235)));

        product.setId("12345");
        product.setProductType(EnumProductType.ED);



        intProduct = Mapper.dtoIntProductMap(product);

        assertEquals(product.getId(), intProduct.getId());
        assertEquals(product.getType(), intProduct.getProductType());
*/
    }
/*
    @Test
    public void testDeepMappingIfDeepObjectIsSet() {
        final DTOIntProduct product = new DTOIntProduct();
        final FormatBalanceToDTOBalanceConverter balanceConverter = new FormatBalanceToDTOBalanceConverter();
        final DTOIntContract contract = new DTOIntContract();

        product.setProductType(EnumProductType.valueOf(outFormat.getTipprod()));
        product.setId(outFormat.getNumprod());

        product.setBalance(balanceConverter.convert(outFormat.getSaltota(), outFormat.getSaldisp(), null));

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

        product.setContactInfo(getDtoIntContactInfo(outFormat.getNumcelu()));
    }*/

    /**
     * {@inheritDoc}
     */
    /*
    @Override
    public DTOIntProduct mapToInnerEntity(final FormatoOZECN1S1 outFormat, final DTOIntFilterProduct dtoIn) {
        final DTOIntProduct product = new DTOIntProduct();
        final FormatBalanceToDTOBalanceConverter balanceConverter = new FormatBalanceToDTOBalanceConverter();
        final DTOIntContract contract = new DTOIntContract();

        product.setProductType(EnumProductType.valueOf(outFormat.getTipprod()));
        product.setId(outFormat.getNumprod());

        product.setBalance(balanceConverter.convert(outFormat.getSaltota(), outFormat.getSaldisp(), null));

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
*/
}
