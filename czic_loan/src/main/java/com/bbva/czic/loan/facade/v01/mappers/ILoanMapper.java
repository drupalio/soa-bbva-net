package com.bbva.czic.loan.facade.v01.mappers;


import com.bbva.czic.dto.net.Loan;
import com.bbva.czic.dto.net.Movement;
import com.bbva.czic.dto.net.RotaryQuotaMove;
import com.bbva.czic.loan.business.dto.DTOIntFilterLoan;
import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.loan.business.dto.DTOIntMovement;
import com.bbva.czic.loan.business.dto.DTOIntRotaryQuotaMove;

import java.text.ParseException;
import java.util.List;

/**
 * Created by Entelgy on 12/01/2015.
 */
public interface ILoanMapper {

	Loan map(DTOIntLoan dtoIntLoan);

	DTOIntFilterLoan getDtoIntFilter(String filter);

	List<Movement> map(List<DTOIntMovement> listaDtoIntMovement);

	Movement map(DTOIntRotaryQuotaMove dtoIntRotaryQuotaMove);
}
