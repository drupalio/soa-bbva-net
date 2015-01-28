package com.bbva.czic.globalposition.facade.v01.mappers.impl;

import com.bbva.czic.dto.net.*;
import com.bbva.czic.globalposition.business.dto.*;
import com.bbva.czic.globalposition.facade.v01.mappers.IGlobalPositionMapper;
import com.bbva.czic.routine.commons.rm.utils.fiql.FiqlType;
import com.bbva.czic.routine.commons.rm.utils.mappers.AbstractBbvaConfigurableMapper;
import com.bbva.czic.routine.mapper.MapperFactory;
import com.bbva.czic.routine.mapper.factory.MoneyFactory;
import com.bbva.czic.routine.mapper.metadata.TypeFactory;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value = "global-position-mapper")
public class GlobalPositionMapper extends AbstractBbvaConfigurableMapper implements IGlobalPositionMapper{

    @Override
    protected void configure(MapperFactory factory) {

        factory.registerObjectFactory(new MoneyFactory(), TypeFactory.<Money>valueOf(Money.class));

        // Map DTOIntProduct <-> Product
        factory.classMap(Product.class, DTOIntProduct.class)
                .field("id","id")
                .field("type","productType")
                .field("name","name")
                .field("alias","alias")
                .field("financialState","financialState")
                .field("visible","visible")
                .field("operable","operable")
                .field("balance","balance")
                .field("contactInfo", "contactInfo")
                .field("contract", "contract")
                .byDefault().register();

        // Map DTOIntContract <-> Contract
        factory.classMap(Contract.class, DTOIntContract.class)
                .field("number", "number")
                .byDefault().register();

        // Map DTOIntBalance <-> Balance
        factory.classMap(Balance.class, DTOIntBalance.class)
                .field("total", "total")
                .field("availableBalance", "availableBalance")
                .byDefault().register();


        // Map DTOIntContactInfo <-> ContactInfo
        factory.classMap(ContactInfo.class, DTOIntContactInfo.class)
                .field("phoneNumbers","phoneNumbers")
                .field("emails", "emails")
                .byDefault().register();

        // Map DTOIntPhoneNumber <-> PhoneNumber
        factory.classMap(PhoneNumber.class, DTOIntPhoneNumber.class)
                .field("number", "number")
                .field("countryCode", "countryCode")
                .field("regionalCode", "regionalCode")
                .field("type", "type")
                .field("primary", "primary")
                .field("active", "active")
                .field("contactSource", "contactSource")
                .byDefault().register();

        // Map DTOIntEmail <-> Email
        factory.classMap(Email.class, DTOIntEmail.class)
                .field("address", "address")
                .field("primary", "primary")
                .field("active", "active")
                .field("source", "source")
                .byDefault().register();
    }

    @Override
    public List<Product> map(final List<DTOIntProduct> intProducts) {
        return mapAsList(intProducts, Product.class);
    }

    @Override
    public DTOIntProductFilter getDTOIntFilter(final String customerId, final String filter) {
        final String productType = this.getEqValue(filter, FiqlType.productType.name());

        final DTOIntProductFilter intProductFilter = new DTOIntProductFilter();
        intProductFilter.setIdCustomer(customerId);
        intProductFilter.setProductType(productType);

        return intProductFilter;
    }

    @Override
    public Product map(DTOIntProduct intProduct) {
        return map(intProduct);
    }

    @Override
    public DTOIntProduct map(Product product) {
        return map(product);
    }

    @Override
    public DTOIntProduct getDTOInt(final String productId, final Product product) {
        final DTOIntProduct intProduct = map(product);
        intProduct.setId(productId);
        return intProduct;
    }
}
