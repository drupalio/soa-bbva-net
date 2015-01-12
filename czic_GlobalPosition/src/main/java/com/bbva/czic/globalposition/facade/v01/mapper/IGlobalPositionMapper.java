package com.bbva.czic.globalposition.facade.v01.mapper;

import com.bbva.czic.dto.net.*;
import com.bbva.czic.globalposition.business.dto.*;

import java.util.List;

public interface IGlobalPositionMapper {

    List<Product> map(List<DTOIntProduct> products);

    Product map(DTOIntProduct intProduct);

    ContactInfo map(DTOIntContactInfo intContactInfo);

    PhoneNumber map(DTOIntPhoneNumber intPhoneNumber);

    Contract map(DTOIntContract intContract);

    Balance map(DTOIntBalance intBalance);
}