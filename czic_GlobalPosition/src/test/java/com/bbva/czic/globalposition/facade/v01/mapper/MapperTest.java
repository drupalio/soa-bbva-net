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
        assertEquals(product.getType().name(), intProduct.getProductType());

    }
}
