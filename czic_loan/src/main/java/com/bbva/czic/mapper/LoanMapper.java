package com.bbva.czic.mapper;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.bbva.czic.dto.net.Balance;
import com.bbva.czic.dto.net.EnumLoanStatus;
import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.czic.dto.net.Payment;
import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.loan.dao.model.oznj.FormatoOZNCSNJ0;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;

public class LoanMapper {//extends AbstractConfigurableMapper {

	private static I18nLog log = I18nLogFactory.getLogI18n(LoanMapper.class,
			"META-INF/spring/i18n/log/mensajesLog");
	// TODO :: David.Bernal : explicar cual es la funcionalidad de esta configuracion :: Sebastian.Gamba 09-01-2015
//	private static LoanMapper instance = null;
//
//	public static LoanMapper getInstance() {
//		if (instance == null) {
//			instance = new LoanMapper();
//		}
//		return instance;
//	}
//
//	@Override
//	protected void configure(MapperFactory factory) {
//
//		factory.classMap(DTOIntMovement.class, FormatoOZNCSNI0.class).field("numeope", "id")
//				.field("fechaop", "operationDate").field("resto", "concept").field("valorop", "value")
//				.field("balance", "balance").field("tipope", "operation.description").byDefault().register();
//
//		/* Mapeo FormatoOZNCSNK0 */
//		factory.classMap(DTOIntMovement.class, FormatoOZNCSNI0.class).field("fechao", "operationDate")
//				.field("resto", "concept").field("importe", "value").field("balance", "balance")
//				.field("descop", "destinationReference").field("estado", "status").byDefault().register();
//
//		/* Mapeo FormatoOZNCSNJ0 */
//		factory.classMap(DTOIntMovement.class, FormatoOZNCSNI0.class)
//				.field("nomprod", "id")
//				// pendiente
//				.field("tipprod", "productType").field("nomprod", "name").field("saldoto", "balance.balance")
//
//				.field("saldodi", "balance.availableBalance").field("montoso", "debt.balance")
//				.field("saldope", "debt.availableBalance").field("fechave", "payment.paymentDate")
//				.field("fechapa", "payment.dueDate").field("fechaco", "payment.shortDate")
//				.field("honorar", "payment.fees").field("numcout", "payment.numbersOfQuota")
//				.field("estado", "payment.status").byDefault().register();
//	}
//
//	public Object getMapper(Object dtoEnt, Class<?> dtoSal) {
//
//		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
//
//		dtoSal = mapperFactory.getMapperFacade().map(dtoEnt, dtoSal.getClass());
//		return dtoSal;
//	}

	/**
	 * Metodo temporal para el mapeo del formato de salida a el DtoInterno
	 * @author Sebastian Gamba - Entelgy Col.
	 * @since 9/01/2015
	 * @param formatoSalida
	 * @return
	 */
	public static DTOIntLoan dtoIntLoanMapper(FormatoOZNCSNJ0 formatoSalida) throws BusinessServiceException{
		DTOIntLoan dTOIntLoan = new DTOIntLoan();
		try {
			dTOIntLoan.setId(formatoSalida.getNumero());
			dTOIntLoan.setType(EnumProductType.RQ);
			dTOIntLoan.setName(formatoSalida.getNomprod());
			dTOIntLoan.setBalance(setBalance(formatoSalida.getSaldoto(), formatoSalida.getSaldodi(), null));
			dTOIntLoan.setDebt(setBalance(formatoSalida.getMontoso(), formatoSalida.getSaldope(), null));
			
			Calendar fechaPa = Calendar.getInstance();
			fechaPa.setTime(formatoSalida.getFechapa());
			
			Calendar fechaVe = Calendar.getInstance();
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			fechaVe.setTime(formatter.parse(formatoSalida.getFechave()));
			
			
			dTOIntLoan.setPayment(setPayment(
					fechaPa, fechaVe, 
					formatoSalida.getFechaco(), formatoSalida.getHonorar(), 
					null, Integer.parseInt(formatoSalida.getNumcout())));
			
			dTOIntLoan.setStatus(EnumLoanStatus.valueOf(formatoSalida.getEstado()));
			
		} catch (Exception e) {
			log.error("An error happened while mapping");
			throw new BusinessServiceException(EnumError.TECHNICAL_ERROR.getAlias(), e);
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
	private static Money setMoneyValue(BigDecimal value){
		Money money = new Money();
		money.setCurrency("COP");
		money.setAmount(value);
		
		return money;
	}
	
	/**
	 * Metodo que retorna un balance segun unos valores: total, disponible y canje
	 * @author Sebastian Gamba - Entelgy Col.
	 * @since 8/01/2015
	 * @param total
	 * @param available
	 * @param trade
	 * @return
	 */
	private static Balance setBalance(BigDecimal total, BigDecimal available, BigDecimal trade){
		Balance auxBalance = new Balance();
		if(total != null){
			auxBalance.setAvailableBalance(setMoneyValue(available));
		}
		if(available != null){
			auxBalance.setTotal(setMoneyValue(total));
		}
		if(trade != null){
			auxBalance.setTradeBalance(setMoneyValue(trade));
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
	private static Payment setPayment(Calendar dueDate, Calendar paymentDate, 
			Date shortDate, BigDecimal fees, BigDecimal minimumPayment, Integer numbersOfQuota){
		Payment payment = new Payment();
		
		payment.setDueDate(dueDate);
		payment.setFees(setMoneyValue(fees));
		payment.setMinimumPayment(setMoneyValue(minimumPayment));
		payment.setNumbersOfQuota(numbersOfQuota);
		payment.setPaymentDate(paymentDate);
		payment.setShortDate(shortDate);
		
		return payment;
	}
}
