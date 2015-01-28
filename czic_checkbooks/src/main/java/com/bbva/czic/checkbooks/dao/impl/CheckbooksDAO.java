package com.bbva.czic.checkbooks.dao.impl;

import com.bbva.czic.checkbooks.business.dto.DTOIntCheck;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheckFilter;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheckbook;
import com.bbva.czic.checkbooks.dao.ICheckbooksDAO;
import com.bbva.czic.checkbooks.dao.tx.TxGetCheck;
import com.bbva.czic.routine.commons.rm.utils.tx.ISimpleTransaction;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.ErrorMappingHelper;
import com.bbva.jee.arq.spring.core.host.transporte.ExcepcionTransporte;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository ("checkbooks-dao")
public class CheckbooksDAO implements ICheckbooksDAO {

	@Autowired
	private ErrorMappingHelper errorMappingHelper;

	@Resource(name = "tx-get-check")
	private TxGetCheck txGetCheck;

	@Override
	public DTOIntCheck getChecks(DTOIntCheckFilter dtoIntCheckFilter) {
		return txGetCheck.invoke(dtoIntCheckFilter);
	}

}



