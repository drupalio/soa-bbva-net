package com.bbva.czic.globalposition.facade.v01.mapper.impl;

import com.bbva.czic.dto.net.*;
import com.bbva.czic.globalposition.business.dto.*;
import com.bbva.czic.globalposition.facade.v01.mapper.IGlobalPositionMapper;
import com.bbva.czic.routine.commons.rm.utils.mappers.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component(value = "global-position-mapper")
public class GlobalPositionMapper /*extends ConfigurableMapper*/  implements IGlobalPositionMapper{

/*
    @Override
    protected void configure(MapperFactory factory) {

        // PRODUCT
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
                .field("contract", "contract");

        // CONTRACT
        factory.classMap(Contract.class, DTOIntContract.class)
                .field("number", "number");

        // BALANCE
        factory.classMap(Balance.class, DTOIntBalance.class)
                .field("total", "total")
                .field("tradeBalance", "tradeBalance")
                .field("availableBalance","availableBalance");


        // CONTACT_INFO
        factory.classMap(ContactInfo.class, DTOIntContactInfo.class)
                .field("phoneNumbers","phoneNumbers")
                .field("emails","emails");

        // PHONE_NUMBERS
        factory.classMap(PhoneNumber.class, DTOIntPhoneNumber.class)
                .field("number", "number")
                .field("countryCode", "countryCode")
                .field("regionalCode", "regionalCode")
                .field("type", "type")
                .field("primary", "primary")
                .field("active", "active")
                .field("contactSource", "contactSource");

        // EMAILS
        factory.classMap(Email.class, DTOIntEmail.class)
                .field("address", "address")
                .field("primary", "primary")
                .field("active", "active")
                .field("source", "source");

    }
*/
    @Override
    public List<Product> map(List<DTOIntProduct> intProducts) {

        List<Product> products = new ArrayList<Product>();
        Product product;

        for(DTOIntProduct intProduct : intProducts) {
            product = map(intProduct);
            products.add(product);
        }

        return products;
    }

    @Override
    public Product map(DTOIntProduct intProduct) {
        final Product product = new Product();

        product.setId(intProduct.getId());
        product.setType(intProduct.getProductType());
        product.setBalance(map(intProduct.getBalance()));
        product.setAlias(intProduct.getAlias());
        product.setName(intProduct.getName());
        product.setFinancialState(intProduct.getFinancialState());
        product.setContract(map(intProduct.getContract()));
        product.setContactInfo(map(intProduct.getContactInfo()));
        product.setVisible(intProduct.isVisible());
        product.setOperable(intProduct.isOperable());
        product.setMovement(new ArrayList<Movement>());
        return product;
    }

    @Override
    public ContactInfo map(DTOIntContactInfo intContactInfo) {
        final ContactInfo contactInfo = new ContactInfo();
        final List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();

        for (DTOIntPhoneNumber intPhoneNumber : intContactInfo.getPhoneNumbers()) {
            phoneNumbers.add(map(intPhoneNumber));
        }
        contactInfo.setPhoneNumbers(phoneNumbers);

        return contactInfo;
    }

    @Override
    public PhoneNumber map(DTOIntPhoneNumber intPhoneNumber) {
        final PhoneNumber phoneNumber = new PhoneNumber();

        phoneNumber.setNumber(intPhoneNumber.getNumber());
        phoneNumber.setType(intPhoneNumber.getType());

        return phoneNumber;
    }

    @Override
    public Contract map(DTOIntContract intContract) {
        final Contract contract = new Contract();

        contract.setNumber(intContract.getNumber());

        return contract;
    }

    @Override
    public Balance map(DTOIntBalance intBalance) {
        final Balance balance = new Balance();

        balance.setTotal(intBalance.getTotal());
        balance.setAvailableBalance(intBalance.getAvailableBalance());

        return balance;
    }

}
