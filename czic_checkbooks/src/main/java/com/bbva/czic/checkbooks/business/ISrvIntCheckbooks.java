package com.bbva.czic.checkbooks.business;

import java.util.List;

import com.bbva.czic.checkbooks.business.dto.DTOIntCheck;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheckFilter;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheckbook;
import com.bbva.czic.dto.net.Check;
import com.bbva.czic.dto.net.Checkbook;

public interface ISrvIntCheckbooks {

	DTOIntCheck getChecks(DTOIntCheckFilter dtoIntCheckFilter);

}