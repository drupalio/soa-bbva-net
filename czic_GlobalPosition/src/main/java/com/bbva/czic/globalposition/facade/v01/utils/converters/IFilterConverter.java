package com.bbva.czic.globalposition.facade.v01.utils.converters;

import com.bbva.czic.globalposition.business.dto.DTOIntFilterProduct;

/**
 * Created by Administrador on 10/01/2015.
 */
public interface IFilterConverter {

    DTOIntFilterProduct getDTOIntFilter(String customerId, String filter);
}
