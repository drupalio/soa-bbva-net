package com.bbva.czic.loan.dao.mapper;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


import com.bbva.czic.dto.net.*;
import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.loan.business.dto.DTOIntMovement;
import com.bbva.czic.loan.dao.model.ozni.FormatoOZNCSNI0;
import com.bbva.czic.loan.dao.model.oznj.FormatoOZNCSNJ0;
import com.bbva.czic.loan.dao.model.oznk.FormatoOZNCSNK0;
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
			dTOIntLoan.setId(formatoSalida.getNumcont());
			dTOIntLoan.setType(formatoSalida.getTipprod());
			dTOIntLoan.setName(formatoSalida.getDesctar());

			dTOIntLoan.setBalance(setBalance(formatoSalida.getSaldoto(), formatoSalida.getPagomin()));
			dTOIntLoan.setDebt(setBalance(formatoSalida.getMntosol(), formatoSalida.getSaldope()));
			
			Calendar fechaPa = Calendar.getInstance();
			fechaPa.setTime(formatoSalida.getFechali());
			
			Calendar fechaVe = Calendar.getInstance();

			fechaVe.setTime(formatoSalida.getFechali());
			
			
			dTOIntLoan.setPayment(setPayment(fechaPa, fechaVe,formatoSalida.getFechaco(), formatoSalida.getHonorar(),
					              null, Integer.parseInt(formatoSalida.getCuotato())));
			
			dTOIntLoan.setStatus(EnumLoanStatus.valueOf(formatoSalida.getEstadot()));
			log.info("fin Mapper");
		} catch (Exception e) {
			log.error("An error happened while mapping");
			throw new BusinessServiceException("An error happened while mapping" + e.getMessage());
		}
		return dTOIntLoan;
	}
	
	/**
	 * Metodo que genera un Money con un valor con currency: COP
	 * @author Sebastian Gamba - Entelgy Col.
	 * @since 8/01/2015
	 * @param value
	 * @return
	 */
	private static Money setMoneyValue(final BigDecimal value){
		Money money = new Money();
		money.setCurrency("COP");
		money.setAmount(value);
		
		return money;
	}

	/**
	 *
	 * @param value
	 * @return
	 */
	private static Money setMoneyValue(final String value){
		Money money = new Money();
		BigDecimal moneyDecimal = new BigDecimal(value.replaceAll(",", ""));
		money.setCurrency("COP");
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
		
		payment.setDueDate(dueDate);
		payment.setFees(setMoneyValue(fees));
		payment.setMinimumPayment(setMoneyValue(minimumPayment));
		payment.setNumbersOfQuota(numbersOfQuota);
		payment.setPaymentDate(paymentDate);

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(shortDate);
		payment.setShortDate(calendar);
		
		return payment;
	}

	/**
	 *
	 * @param dtoIntLoan
	 * @return
	 */
	public static Loan getLoan(final DTOIntLoan dtoIntLoan){
		Loan loan = new Loan();
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
		return loan;
	}


	public static DTOIntMovement getDTOIntMovementByCopy(final FormatoOZNCSNI0 copy) {
		DTOIntMovement dTOIntMovement = new DTOIntMovement();
		dTOIntMovement.setId(copy.getNumeope());
		dTOIntMovement.setTransactionDate(getFormat(copy.getFechaop()));
		dTOIntMovement.setConcept(copy.getResto().toString());
		dTOIntMovement.setValue(setMoneyValue( copy.getValorop()));
		dTOIntMovement.getOperation().setDescription(copy.getTipope());

		return dTOIntMovement;
	}

	private static Date getFormat(final String fecha){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date retorno = null;
		try {
			retorno = sdf.parse(fecha);
		} catch (ParseException e) {
			return null;
		}
		return retorno;
	}

	public static DTOIntMovement getDTOIntMovementByCopy(final FormatoOZNCSNK0 copy) {
		DTOIntMovement dTOIntMovement = new DTOIntMovement();

		dTOIntMovement.setTransactionDate(getFormat(copy.getFechao()));
		dTOIntMovement.setConcept(copy.getResto().toString());
		dTOIntMovement.setValue(setMoneyValue(copy.getImporte()));
		dTOIntMovement.setBalance(new Balance(setMoneyValue(copy.getBalance())));
		dTOIntMovement.getOperation().setDescription(copy.getDescop());
		dTOIntMovement.setStatus(EnumMovementStatus.valueOf(copy.getEstado()));
		return dTOIntMovement;
	}

	public static Movement getMovementByDTOIntMovement(final DTOIntMovement dto) {
		Movement movement = new Movement();

		movement.setId(dto.getId());
		movement.setConcept(dto.getConcept());
		movement.setOffice(dto.getOffice());
		movement.setOperation(dto.getOperation());
		movement.setOperationDate(dto.getOperationDate());
		movement.setStatus(dto.getStatus());
		movement.setValue(dto.getValue());
		return movement;
	}

	public static Loan getLoanByDTOIntLoan(final DTOIntLoan dto) {
		Loan loan = new Loan();

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

		return loan;
	}
}
