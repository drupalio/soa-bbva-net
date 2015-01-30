package com.bbva.czic.customers.facade.v01.mapper.impl;

import com.bbva.czic.customers.business.dto.DTOIntCustomer;
import com.bbva.czic.dto.net.Customer;

/**
 * Created by Entelgy on 30/01/2015.
 */
public interface IMapper {

    Customer map(DTOIntCustomer dtoIntCustomer);
}
