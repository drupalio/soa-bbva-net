package com.bbva.zic.executives.facade.v01.mapper;

import com.bbva.zic.dto.net.Executive;
import com.bbva.zic.executives.business.dto.DTOIntExecutive;
import com.bbva.zic.executives.business.dto.DTOIntExecutivesFilter;

/**
 * Created by Entelgy on 26/01/2015.
 */
public interface IExecutivesMapper {

    public DTOIntExecutivesFilter getDTOIntFilter(String filter);
    public Executive map(DTOIntExecutive dtoIntExecutive);
}
