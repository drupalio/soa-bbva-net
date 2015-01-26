package com.bbva.czic.globalposition.facade.v01.mappers;

import com.bbva.czic.dto.net.*;
import com.bbva.czic.globalposition.business.dto.*;
import com.bbva.czic.globalposition.facade.v01.mappers.impl.GlobalPositionMapper;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GlobalPositionMapperTest {

    GlobalPositionMapper mapper;

    @Before
    public void init() {
        mapper = new GlobalPositionMapper();
    }

    @Test
    public void testMapDTOIntPhoneNumberToPhoneNumber() {
        // Setup data
        final List<Product> products;
        final List<DTOIntProduct> intProducts = new ArrayList<DTOIntProduct>();
        intProducts.add(getIntProduct());
        intProducts.add(getIntProduct());

        // SUT execution
        products = mapper.map(intProducts);

        //Validation
        assertEquals(2, products.size());
    }

    @Test
    public void testMapDTOIntProductToProductAllProducts() {
        final Product product;
        final DTOIntProduct intProduct = getIntProduct();
        final List<DTOIntProduct> intProducts = new ArrayList<DTOIntProduct>();
        intProducts.add(getIntProduct());
        intProducts.add(getIntProduct());

        product = mapper.map(intProducts).get(0);

        assertEquals(intProduct.getId(), product.getId());
        assertEquals(intProduct.getProductType(), product.getType());
        assertEquals(intProduct.getBalance().getAvailableBalance().getAmount(), product.getBalance().getAvailableBalance().getAmount());
        assertEquals(intProduct.getBalance().getTotal().getAmount(), product.getBalance().getTotal().getAmount());
        assertEquals(intProduct.getBalance().getAvailableBalance().getCurrency(), product.getBalance().getAvailableBalance().getCurrency());
        assertEquals(intProduct.getBalance().getTotal().getCurrency(), product.getBalance().getTotal().getCurrency());
        assertEquals(intProduct.getAlias(), product.getAlias());
        assertEquals(intProduct.getName(), product.getName());
        assertEquals(intProduct.getFinancialState(), product.getFinancialState());
        assertEquals(intProduct.getContract().getNumber(), product.getContract().getNumber());
        assertEquals(
                (intProduct.getContactInfo().getPhoneNumbers().get(0)).getNumber(),
                (product.getContactInfo().getPhoneNumbers().get(0)).getNumber()
        );
        assertEquals(
                (intProduct.getContactInfo().getPhoneNumbers().get(0)).getType(),
                (product.getContactInfo().getPhoneNumbers().get(0)).getType()
        );
        assertEquals(intProduct.isVisible(), product.getVisible());
        assertEquals(product.getOperable(),intProduct.isOperable());

    }

    private List<DTOIntProduct> getIntProducts() {

        List<DTOIntProduct> products = new ArrayList<DTOIntProduct>();

        for(int i = 0; i < 2; i++) {
            products.add(getIntProduct());
        }

        return products;
    }

    private DTOIntProduct getIntProduct() {
        final DTOIntProduct intProduct = new DTOIntProduct();

        intProduct.setId("0000886940");
        intProduct.setProductType(EnumProductType.AQ.name());
        intProduct.setBalance(getIntBalance());
        intProduct.setAlias("Mi cuenta");
        intProduct.setName("Broda");
        intProduct.setFinancialState(EnumFinancialStatusType.A.name());
        intProduct.setContract(getIntContract());
        intProduct.setContactInfo(getIntContactInfo());
        intProduct.setVisible(Boolean.TRUE);
        intProduct.setOperable(Boolean.FALSE);

        return intProduct;
    }

    private DTOIntContactInfo getIntContactInfo() {
        final DTOIntContactInfo contactInfo = new DTOIntContactInfo();
        final List<DTOIntPhoneNumber> phoneNumbers = new ArrayList<DTOIntPhoneNumber>();

        phoneNumbers.add(getIntPhoneNumber());
        contactInfo.setPhoneNumbers(phoneNumbers);

        return contactInfo;
    }

    private DTOIntPhoneNumber getIntPhoneNumber() {
        final DTOIntPhoneNumber phoneNumber = new DTOIntPhoneNumber();

        phoneNumber.setNumber("3193954515");
        phoneNumber.setType(EnumPhoneNumberType.MOBILE);

        return phoneNumber;
    }

    private DTOIntContract getIntContract() {
        final DTOIntContract contract = new DTOIntContract();

        contract.setNumber("52345234523452345");

        return contract;
    }

    private DTOIntBalance getIntBalance() {
        final DTOIntBalance balance = new DTOIntBalance();

        balance.setTotal(new Money(Currency.getInstance("COP"), new BigDecimal("+1234.09")));
        balance.setAvailableBalance(new Money(Currency.getInstance("COP"), new BigDecimal("-1234.09")));
        balance.setTradeBalance(new Money(Currency.getInstance("COP"), new BigDecimal("+1234.09")));

        return balance;
    }
}
