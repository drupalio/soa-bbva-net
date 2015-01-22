package com.bbva.czic.globalposition.facade.v01.utils.converters;

import com.bbva.czic.globalposition.business.dto.DTOIntProductFilter;

/**
 * Created by Administrador on 10/01/2015.
 */
public interface IFilterConverter {

    DTOIntProductFilter getDTOIntFilter(String customerId, String filter);
}
