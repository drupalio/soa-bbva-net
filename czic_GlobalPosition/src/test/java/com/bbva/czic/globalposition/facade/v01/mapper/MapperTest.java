package com.bbva.czic.globalposition.facade.v01.mapper;

import com.bbva.czic.dto.net.Balance;
import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.czic.dto.net.Product;
import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Currency;

import static org.junit.Assert.assertEquals;

/**
 * Created by Administrador on 17/12/2014.
 */
public class MapperTest {

    @Test
    public void testMapProductTypeToDtoIntProductType() {
        Product product = new Product();
        Balance balance = new Balance();
        DTOIntProduct intProduct = new DTOIntProduct();

        balance.setAvailableBalance(new Money(Currency.getInstance("COP"), new BigDecimal(12351235)));
        balance.setTotal(new Money(Currency.getInstance("COP"), new BigDecimal(12351235)));

        product.setId("12345");
        product.setType(EnumProductType.ED);

        intProduct = Mapper.dtoIntProductMap(product);

        assertEquals(product.getId(), intProduct.getId());
        assertEquals(product.getType(), intProduct.getProductType());

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
}
