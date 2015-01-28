package com.bbva.czic.checkbooks.dao;

import java.util.Calendar;
import java.util.List;

import com.bbva.czic.checkbooks.business.dto.DTOIntCheck;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheckFilter;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheckbook;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.czic.checkbooks.business.dto.DTOIntEnumCheckStatus;
import com.bbva.czic.dto.net.EnumCheckStatus;

public interface ICheckbooksDAO {

	DTOIntCheck getChecks(DTOIntCheckFilter dtoIntCheckFilter);

}

