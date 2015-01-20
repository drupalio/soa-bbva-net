package com.bbva.czic.loan.dao.mapper;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


import com.bbva.czic.dto.net.*;
import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.loan.business.dto.DTOIntMovement;
import com.bbva.czic.loan.business.dto.DTOIntRotaryQuotaMove;
import com.bbva.czic.loan.dao.model.ozni.FormatoOZNCSNI0;
import com.bbva.czic.loan.dao.model.oznj.FormatoOZNCSNJ0;
import com.bbva.czic.loan.dao.model.oznk.FormatoOZNCSNK0;
import com.bbva.czic.routine.commons.rm.utils.converter.UtilsConverter;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;

public class LoanMapper {

	private static I18nLog log = I18nLogFactory.getLogI18n(LoanMapper.class,
			"META-INF/spring/i18n/log/mensajesLog");

	/**
	 * Metodo temporal para el mapeo del formato de salida a el DtoInterno
	 * @author Sebastian Gamba - Entelgy Col.
	 * @since 9/01/2015
	 * @param formatoSalida
	 * @return
	 */
	public static DTOIntLoan dtoIntLoanMapper(final FormatoOZNCSNJ0 formatoSalida) throws BusinessServiceException{
		DTOIntLoan dTOIntLoan = new DTOIntLoan();
		try {
			log.info("inicio Mapper");

			log.info("inicio Mapper datos----------------");
			log.info("formatoSalida.getSaldoto = " + formatoSalida.getSaldoto() + ", formatoSalida.getPagomin = " + formatoSalida.getPagomin() + ", formatoSalida.getMntosol = " + formatoSalida.getMntosol() +
					", formatoSalida.getSaldope = " + formatoSalida.getSaldope() + ", formatoSalida.getFechali = " + formatoSalida.getFechali() + ", formatoSalida.getFechali = " + formatoSalida.getFechali() +
					", formatoSalida.getFechaco = " + formatoSalida.getFechaco() + ", formatoSalida.getHonorar = " + formatoSalida.getHonorar() + ", formatoSalida.getCuotato = " + formatoSalida.getCuotato() +
					", formatoSalida.getEstadot = " + formatoSalida.getEstadot());
			dTOIntLoan.setId(formatoSalida.getNumcont());
			dTOIntLoan.setType(formatoSalida.getTipprod());
			dTOIntLoan.setName(formatoSalida.getDesctar());

			dTOIntLoan.setBalance(setBalance(formatoSalida.getSaldoto(), formatoSalida.getPagomin()));
			dTOIntLoan.setDebt(setBalance(formatoSalida.getMntosol(), formatoSalida.getSaldope()));

			Calendar fechaPa = Calendar.getInstance();

			if (formatoSalida.getFechali() != null){
				fechaPa.setTime(formatoSalida.getFechali());
		    }

			Calendar fechaVe = Calendar.getInstance();

			if(formatoSalida.getFechali() != null) {
				fechaVe.setTime(formatoSalida.getFechali());
			}
			
			dTOIntLoan.setPayment(setPayment(fechaPa, fechaVe,formatoSalida.getFechaco(), formatoSalida.getHonorar(),
					              null, Integer.parseInt(formatoSalida.getCuotato())));
			
			dTOIntLoan.setStatus(formatoSalida.getEstadot());
			log.info("fin Mapper");
		} catch (Exception e) {
			log.error("An error happened while mapping");
			throw new BusinessServiceException(EnumError.NO_DATA.getAlias());
		}
		return dTOIntLoan;
	}

	/**
	 *
	 * @param value
	 * @return
	 */
	private static Money setMoneyValue(final String value){
		Money money = new Money();
		BigDecimal moneyDecimal = new BigDecimal(value.replaceAll(",", ""));
		money.setCurrency(java.util.Currency.getInstance("COP").getCurrencyCode());
		money.setAmount(moneyDecimal);

		return money;
	}
	
	/**
	 * Metodo que retorna un balance segun unos valores: total, disponible y canje
	 * @author Sebastian Gamba - Entelgy Col.
	 * @since 8/01/2015
	 * @param total
	 * @param available
	 * @return
	 */
	private static Balance setBalance(final String total, final String available){
		Balance auxBalance = new Balance();
		if(total != null){
			auxBalance.setAvailableBalance(setMoneyValue(available));
		}
		if(available != null){
			auxBalance.setTotal(setMoneyValue(total));
		}
		
		return auxBalance;
	}
	
	/**
	 * Metodo que setea un Payment con sus valores
	 * @author Sebastian Gamba - Entelgy Col.
	 * @since 8/01/2015
	 * @param dueDate
	 * @param paymentDate
	 * @param shortDate
	 * @param fees
	 * @param minimumPayment
	 * @param numbersOfQuota
	 * @return
	 */
	private static Payment setPayment(final Calendar dueDate, final Calendar paymentDate,
			final Date shortDate, final String fees, final BigDecimal minimumPayment, final Integer numbersOfQuota){
		Payment payment = new Payment();
		log.info("inicio mapeo setPayment.Payment");
		payment.setDueDate(dueDate);
		payment.setFees(setMoneyValue(fees));
		payment.setMinimumPayment(UtilsConverter.getMoneyDTO((minimumPayment)));
		payment.setNumbersOfQuota(numbersOfQuota);
		payment.setPaymentDate(paymentDate);

		Calendar calendar = Calendar.getInstance();

		if(shortDate != null) {
			calendar.setTime(shortDate);
		}
		payment.setShortDate(calendar);
		log.info("fin mapeo setPayment.Payment");
		return payment;
	}

	/**
	 *
	 * @param dtoIntLoan
	 * @return
	 */
	public static Loan getLoan(final DTOIntLoan dtoIntLoan){
		Loan loan = new Loan();
		log.info("inicio mapeo getLoan.Loan");
		loan.setType(dtoIntLoan.getType());
		loan.setName(dtoIntLoan.getName());
		loan.setBalance(dtoIntLoan.getBalance());
		loan.setDebt(dtoIntLoan.getDebt());
		loan.setPayment(dtoIntLoan.getPayment());
		loan.setStatus(dtoIntLoan.getStatus());
		loan.setConditions(dtoIntLoan.getConditions());
		loan.setFinancialState(dtoIntLoan.getFinancialState());
		loan.setContactInfo(dtoIntLoan.getContactInfo());
		loan.setVisible(dtoIntLoan.getVisible());
		loan.setOperable(dtoIntLoan.getOperable());
		loan.setId(dtoIntLoan.getId());
		log.info("fin mapeo getLoan.Loan");
		return loan;
	}


	public static DTOIntMovement getDTOIntMovementByCopy(final FormatoOZNCSNI0 copy) {
		DTOIntMovement dTOIntMovement = new DTOIntMovement();
		Calendar calendar = Calendar.getInstance();

		log.info("inicio mapeo getDTOIntMovementByCopy.DTOIntMovement");

		if(copy.getFechaop() != null) {
			calendar.setTime(copy.getFechaop());
		}
		dTOIntMovement.setId(copy.getNumeope());
		dTOIntMovement.setTransactionDate(calendar);
		dTOIntMovement.setConcept(copy.getResto().toString());
		dTOIntMovement.setValue(setMoneyValue((copy.getValorop())));
		dTOIntMovement.setOperation(new Operation(copy.getTipope()));
		log.info("fin mapeo getDTOIntMovementByCopy.DTOIntMovement");
		return dTOIntMovement;
	}

	public static DTOIntRotaryQuotaMove getDTOIntMovementByCopy(final FormatoOZNCSNK0 copy) {
		DTOIntRotaryQuotaMove dtoIntRotaryQuotaMove = new DTOIntRotaryQuotaMove();
		log.info("inicio mapeo getDTOIntMovementByCopy.DTOIntRotaryQuotaMove");
        Calendar calendar = Calendar.getInstance();

		if(copy.getFechaop() != null) {
			calendar.setTime(copy.getFechaop());
		}
		dtoIntRotaryQuotaMove.setTransactionDate(calendar);
		dtoIntRotaryQuotaMove.setConcept(copy.getResto());
		dtoIntRotaryQuotaMove.setValue(setMoneyValue(copy.getImporte()));
		dtoIntRotaryQuotaMove.setBalance(setMoneyValue((copy.getBalance())));
		dtoIntRotaryQuotaMove.setOperation(new Operation(copy.getDescop()));
		dtoIntRotaryQuotaMove.setStatus(copy.getEstado());

		log.info("inicio mapeo getDTOIntMovementByCopy.DTOIntRotaryQuotaMove");
		return dtoIntRotaryQuotaMove;
	}

	public static RotaryQuotaMove getMovementByDTOIntMovement(final DTOIntRotaryQuotaMove dto) {
		RotaryQuotaMove rotaryQuotaMove = new RotaryQuotaMove();
        log.info("inicio mapeo getMovementByDTOIntMovement.RotaryQuotaMove");
		rotaryQuotaMove.setId(dto.getId());
		rotaryQuotaMove.setTransactionDate(dto.getTransactionDate());
		rotaryQuotaMove.setConcept(dto.getConcept());
		rotaryQuotaMove.setValue(dto.getValue());
		rotaryQuotaMove.setBalance(dto.getBalance());

		rotaryQuotaMove.setOperation(new Operation(dto.getOperation().getDescription()));
		rotaryQuotaMove.setStatus(dto.getStatus());
		rotaryQuotaMove.setOperation(dto.getOperation());
		log.info("fin mapeo getMovementByDTOIntMovement.RotaryQuotaMove");
		return rotaryQuotaMove;
	}

	public static Movement getMovementByDTOIntMovement(final DTOIntMovement dto) {
		Movement Movement = new Movement();
		log.info("inicio mapeo getMovementByDTOIntMovement.Movement");
		Movement.setId(dto.getId());
		Movement.setTransactionDate(dto.getTransactionDate());
		Movement.setConcept(dto.getConcept());
		Movement.setValue(dto.getValue());
		Movement.setBalance(dto.getBalance());
		Movement.setStatus(dto.getStatus());
		Movement.setOperation(dto.getOperation());
		log.info("fin mapeo getMovementByDTOIntMovement.Movement");
		return Movement;
	}

	public static Loan getLoanByDTOIntLoan(final DTOIntLoan dto) {
		Loan loan = new Loan();
		log.info("inicio mapeo getLoanByDTOIntLoan.Loan");
		loan.setPayment(dto.getPayment());
		loan.setDebt(dto.getDebt());
		loan.setStatus(dto.getStatus());
		loan.setAlias(dto.getAlias());
		loan.setConditions(dto.getConditions());
		loan.setContactInfo(dto.getContactInfo());
		loan.setFinancialState(dto.getFinancialState());
		loan.setId(dto.getId());
		loan.setName(dto.getName());
		loan.setOperable(dto.getOperable());
		log.info("fin  mapeo getLoanByDTOIntLoan.Loan");
		return loan;
	}
}
