package com.bbva.czic.checkbooks.facade.v01.mappers;

import com.bbva.czic.checkbooks.business.dto.DTOIntCheck;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheckFilter;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheckbook;
import com.bbva.czic.dto.net.Check;
import com.bbva.czic.dto.net.Checkbook;


public interface ICheckbookMapper {

    Check map(DTOIntCheck intCheck);
    public DTOIntCheckFilter getDTOIntFilter(String checkId,String accountId);

}
