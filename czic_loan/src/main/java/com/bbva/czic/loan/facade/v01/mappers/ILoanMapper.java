package com.bbva.czic.loan.facade.v01.mappers;


import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.dto.net.Movement;
import com.bbva.czic.dto.net.RotaryQuotaMove;
import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.loan.business.dto.DTOIntMovement;
import com.bbva.czic.loan.business.dto.DTOIntRotaryQuotaMove;

import java.util.List;

/**
 * Created by Entelgy on 12/01/2015.
 */
public interface ILoanMapper {

	Loan map(DTOIntLoan dtoIntLoan);

	List<Movement> map(List<DTOIntMovement> listaDtoIntMovement);

	RotaryQuotaMove map(DTOIntRotaryQuotaMove dtoIntRotaryQuotaMove);
}
