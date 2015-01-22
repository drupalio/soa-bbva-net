package com.bbva.czic.checkbooks.facade.v01.mappers.impl;

import com.bbva.czic.checkbooks.business.dto.DTOIntCheck;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheckbook;
import com.bbva.czic.dto.net.Check;
import com.bbva.czic.dto.net.Checkbook;
import com.bbva.czic.checkbooks.facade.v01.mappers.ICheckbookMapper;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component(value = "checkbooks-mapper")
public class CheckbooksMapper implements ICheckbookMapper {

	@Override
	public Check map(DTOIntCheck intCheck) {
		final Check check = new Check();

		check.setId(intCheck.getId());

		final Calendar issueDate = Calendar.getInstance();
		issueDate.setTime(intCheck.getIssueDate());
		check.setIssueDate(issueDate);
		check.setValue(intCheck.getValue());
		check.setStatus(intCheck.getStatus());

		final Calendar modifiedDate = Calendar.getInstance();
		modifiedDate.setTime(intCheck.getModifiedDate());
		check.setModifiedDate(modifiedDate);

		return check;
	}
}
