package com.bbva.czic.checkbooks.dao.impl;

import com.bbva.czic.checkbooks.business.dto.DTOIntCheck;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheckbook;
import com.bbva.czic.checkbooks.dao.ICheckbooksDAO;
import com.bbva.czic.routine.commons.rm.utils.tx.ISimpleTransaction;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository ("checkbooks-dao")
public class CheckbooksDAO implements ICheckbooksDAO {

	@Resource(name = "tx-get-checkbook")
	ISimpleTransaction txGetCheckbook;

	@Resource(name = "tx-get-check")
	ISimpleTransaction txGetCheck;

	@Override
	public DTOIntCheckbook getCheckbooks(DTOIntCheckbook intCheckbook) {
		return txGetCheckbook.invoke(intCheckbook);
	}

	@Override
	public DTOIntCheck getChecks(DTOIntCheck intCheck) {
		return txGetCheck.invoke(intCheck);
	}
}



