package com.bbva.czic.executives.facade.v01.mapper;

import com.bbva.czic.dto.net.Executive;
import com.bbva.czic.executives.business.dto.DTOIntExecutive;
import com.bbva.czic.executives.business.dto.DTOIntExecutivesFilter;

/**
 * Created by Entelgy on 26/01/2015.
 */
public interface IExecutivesMapper {

    public DTOIntExecutivesFilter getDTOIntFilter(String filter);
    public Executive map(DTOIntExecutive dtoIntExecutive);
}
