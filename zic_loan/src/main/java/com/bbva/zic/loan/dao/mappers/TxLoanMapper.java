package com.bbva.zic.loan.dao.mappers;

import com.bbva.zic.loan.business.dto.*;
import com.bbva.zic.loan.dao.mappers.impl.ITxLoanMapper;

import com.bbva.zic.loan.dao.model.ozni.FormatoOZNCENI0;
import com.bbva.zic.loan.dao.model.ozni.FormatoOZNCSNI0;
import com.bbva.zic.loan.dao.model.oznj.FormatoOZNCENJ0;

import com.bbva.zic.loan.dao.model.oznj.FormatoOZNCSNJ0;
import com.bbva.zic.loan.dao.model.oznk.FormatoOZNCENK0;
import com.bbva.zic.loan.dao.model.oznk.FormatoOZNCSNK0;
import com.bbva.zic.routine.commons.rm.utils.mappers.AbstractBbvaTxConfigurableMapper;
import com.bbva.zic.routine.mapper.MapperFactory;
import org.springframework.stereotype.Component;

@Component(value = "tx-loan-mapper")
public class TxLoanMapper extends AbstractBbvaTxConfigurableMapper implements ITxLoanMapper {

	@Override
	protected void configure(MapperFactory factory) {

		super.configure(factory);

		// Map  FormatoOZNCENJ0 DTOIntLoan
		factory.classMap(FormatoOZNCENJ0.class, DTOIntLoan.class)
				.field("nomtarj", "id").byDefault().register();

		// Map  FormatoOZNCENJ0 DTOIntLoan
		factory.classMap(FormatoOZNCENK0.class, DTOIntFilterRotaryMovement.class)
				.field("nomtarj", "idLoan")
				.field("nomextr", "movementNumber")
				.field("nommovi", "idMovement")
				.byDefault().register();


		// Map  FormatoOZNCSNJ0 DTOIntLoan
		factory.classMap(FormatoOZNCSNJ0.class, DTOIntLoan.class)
				.field("numcont", "id")    
				.field("tipprod", "type")
				.field("desctar", "name")
				.field("saldoto", "balance.total")
				.field("saldodi", "balance.availableBalance")
				.field("pagomin", "payment.minimumPayment")
				.field("mntosol", "debt.total")
				.field("saldope", "debt.availableBalance")
				.field("fechaca", "payment.dueDate")
				.field("fechali", "payment.shortDate")
				.field("fechaco", "payment.paymentDate")
				.field("honorar", "payment.fees")
				.field("cuotato", "payment.numbersOfQuota")
				.field("estadot", "status")
				.byDefault().register();

		// Map  FormatoOZNCSNK0 DTOIntRotaryQuotaMove
		factory.classMap(FormatoOZNCSNK0.class, DTOIntRotaryQuotaMove.class)
				.field("numemov","id")
				.field("fechaop", "transactionDate")
				.field("resto","concept")
				.field("importe", "value")
				.field("balance","balance.availableBalance")
				.field("descop", "operation")
				.field("coutaf","remainingQuotas")
				.field("coutat", "numbersOfQuota")
				.byDefault().register();

		// Map  FormatoOZNCSNI0 DTOIntMovement
		factory.classMap(FormatoOZNCSNI0.class, DTOIntMovement.class)
				.field("numeope","id")
				.field("fechaop", "transactionDate")
				.field("resto","concept")
				.field("valorop", "value")
				.field("balance","balance")
				.field("tipope", "operation")
				.field("numeext", "extractNumber")
				.byDefault().register();

		// Map  FormatoOZNCENI0 DTOIntFilterLoan
		factory.classMap(FormatoOZNCENI0.class, DTOIntFilterLoan.class)
				.field("notarje", "idLoan")
				.field("fechini", "fechaInicial")
				.field("fechafi", "fechaFinal")
				.field("indpane", "extractInd")
				.field("indpano", "movementInd")
				.field("pospag", "pageSize")
				.byDefault().register();
	}

	/**
	 *
	 * @param dtoIn
	 * @return
	 */
	@Override
	public FormatoOZNCENJ0 mapInOznj(DTOIntFilterLoan dtoIn) {
		return map(dtoIn, FormatoOZNCENJ0.class);
	}

	/**
	 *
	 * @param formatOutput
	 * @return
	 */
	@Override
	public DTOIntLoan mapOutOznj(FormatoOZNCSNJ0 formatOutput) {

		return map(formatOutput, DTOIntLoan.class);
	}

	/**
	 *
	 * @param dtoIn
	 * @return
	 */
	@Override
	public FormatoOZNCENK0 mapInOznk(DTOIntFilterRotaryMovement dtoIn) {
		return map(dtoIn, FormatoOZNCENK0.class);
	}

	/**
	 *
	 * @param formatOutput
	 * @return
	 */
	@Override
	public DTOIntRotaryQuotaMove mapOutOznk(FormatoOZNCSNK0 formatOutput) {
		return map(formatOutput, DTOIntRotaryQuotaMove.class);
	}

	/**
	 *
	 * @param dtoIn
	 * @return
	 */
	@Override
	public FormatoOZNCENI0 mapInOzni(DTOIntFilterLoan dtoIn) {
		return map(dtoIn, FormatoOZNCENI0.class);
	}

	/**
	 *
	 * @param formatOutput
	 * @return
	 */
	@Override
	public DTOIntMovement mapOutOzni(FormatoOZNCSNI0 formatOutput) {
		return map(formatOutput, DTOIntMovement.class);
	}
}
