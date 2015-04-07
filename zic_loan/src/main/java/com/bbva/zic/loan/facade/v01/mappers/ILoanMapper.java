package com.bbva.zic.loan.facade.v01.mappers;


import com.bbva.zic.dto.net.Loan;
import com.bbva.zic.dto.net.Movement;
import com.bbva.zic.dto.net.RotaryQuotaMove;
import com.bbva.zic.loan.business.dto.DTOIntFilterLoan;
import com.bbva.zic.loan.business.dto.DTOIntLoan;
import com.bbva.zic.loan.business.dto.DTOIntMovement;
import com.bbva.zic.loan.business.dto.DTOIntRotaryQuotaMove;

import java.util.List;

/**
 * Created by Entelgy on 12/01/2015.
 */
public interface ILoanMapper {

	Loan map(DTOIntLoan dtoIntLoan);

	DTOIntFilterLoan getDtoIntFilter(String filter);

	List<Movement> map(List<DTOIntMovement> listaDtoIntMovement);

	RotaryQuotaMove map(DTOIntRotaryQuotaMove dtoIntRotaryQuotaMove);

	String getMovementNumber(final String filter);
}
