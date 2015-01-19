package com.bbva.czic.movements.facade.v01.utils.converter;

import com.bbva.czic.movements.business.dto.DTOIntMovementsFilter;

/**
 * Created by Entelgy on 17/01/2015.
 */
public interface IFilterConverter {
    DTOIntMovementsFilter toDtoIntMovementsFilter(String filter);
}
