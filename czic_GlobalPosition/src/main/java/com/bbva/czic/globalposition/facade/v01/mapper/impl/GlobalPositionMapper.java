package com.bbva.czic.globalposition.facade.v01.mapper.impl;

import com.bbva.czic.dto.net.Balance;
import com.bbva.czic.dto.net.ContactInfo;
import com.bbva.czic.dto.net.Contract;
import com.bbva.czic.dto.net.Product;
import com.bbva.czic.globalposition.business.dto.DTOIntBalance;
import com.bbva.czic.globalposition.business.dto.DTOIntContactInfo;
import com.bbva.czic.globalposition.business.dto.DTOIntContract;
import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.facade.v01.mapper.IGlobalPositionMapper;
import com.bbva.czic.routine.commons.rm.utils.mappers.Mapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Mapper("global-position-mapper")
public class GlobalPositionMapper extends ConfigurableMapper  implements IGlobalPositionMapper{

    @Override
    protected void configure(MapperFactory factory) {

        // PRODUCT
        factory.classMap(Product.class, DTOIntProduct.class)
                .field("id","id")
                .field("productType","productType")
                .field("name","name")
                .field("alias","alias")
                .field("financialState","financialState")
                .field("visible","visible")
                .field("operable","operable")
                .field("balance","balance")
                .field("contactInfo", "contactInfo")
                .field("contract", "contract");

        // CONTRACT
        factory.classMap(Contract.class, DTOIntContract.class)
                .field("number", "number");

        // BALANCE
        factory.classMap(Balance.class, DTOIntBalance.class)
                .field("phoneNumbers", "phoneNumbers")
                .field("emails","emails");


        // CONTACT_INFO
        factory.classMap(ContactInfo.class, DTOIntContactInfo.class)
                .field("phoneNumbers","phoneNumbers")
                .field("emails","emails");

        // PHONE_NUMBERS
        factory.classMap(ContactInfo.class, DTOIntContactInfo.class)
                .field("number", "number")
                .field("countryCode", "countryCode")
                .field("regionalCode", "regionalCode")
                .field("type", "type")
                .field("primary", "primary")
                .field("active", "active")
                .field("contactSource", "contactSource");

        // EMAILS
        factory.classMap(ContactInfo.class, DTOIntContactInfo.class)
                .field("address", "address")
                .field("primary", "primary")
                .field("active", "active")
                .field("source", "source");

    }

}
