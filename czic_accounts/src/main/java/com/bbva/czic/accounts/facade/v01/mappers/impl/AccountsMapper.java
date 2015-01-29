package com.bbva.czic.accounts.facade.v01.mappers.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.bbva.czic.accounts.business.dto.*;
import com.bbva.czic.accounts.facade.v01.mappers.IAccountsMapper;
import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.Account;
import com.bbva.czic.dto.net.Balance;
import com.bbva.czic.dto.net.Check;
import com.bbva.czic.dto.net.Checkbook;
import com.bbva.czic.dto.net.EnumCheckbookStatus;
import com.bbva.czic.dto.net.MonthlyBalances;
import com.bbva.czic.routine.commons.rm.utils.EDateFormat;
import com.bbva.czic.routine.commons.rm.utils.converter.BigDecimalMoneyConverter;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.czic.routine.commons.rm.utils.fiql.FiqlType;
import com.bbva.czic.routine.commons.rm.utils.mappers.AbstractBbvaConfigurableMapper;
import com.bbva.czic.routine.commons.rm.utils.mappers.Mapper;
import com.bbva.czic.routine.mapper.MapperFactory;
import com.bbva.czic.routine.mapper.converter.builtin.DateToStringConverter;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

@Mapper(value = "accounts-mapper")
public class AccountsMapper extends AbstractBbvaConfigurableMapper implements
		IAccountsMapper {

	private static I18nLog log = I18nLogFactory.getLogI18n(
			AccountsMapper.class, "META-INF/spring/i18n/log/mensajesLog");

	final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	protected void configure(MapperFactory factory) {

		super.configure(factory);
		/**
		 * Convert HOST Date to String
		 */
		factory.getConverterFactory().registerConverter(
				new DateToStringConverter(EDateFormat.DIA_MES_ANIO.getPattern()));

		// Map DTOIntCheckbook <-> CheckBook
		factory.classMap(DTOIntCheckbook.class, Checkbook.class)
				.field("id", "id").field("firstCheck", "firstCheck")
				.field("lastCheck", "lastCheck")
				.field("totalCheck", "totalCheck")
				.field("actualState", "actualState")
				.field("deliveryDate", "deliveryDate")
				.field("requestDate", "requestDate").byDefault().register();

		factory.classMap(DTOIntBalance.class, Balance.class)
				.field("total", "total")
				.field("availableBalance", "availableBalance").byDefault()
				.register();

		// Map DTOIntAccount <-> FormatoOZECNVE0
		factory.classMap(DTOIntAccount.class, Account.class)
				.field("name", "name").field("idAccount", "id")
				.field("balance", "balance")
				.field("listaCheckBook", "checkbooks").byDefault().register();

		// // Map DTOIntCheck <-> FormatoOZECNVE0
		factory.classMap(DTOIntCheck.class, Check.class).field("id", "id")
				.field("status", "status").field("issueDate", "issueDate")
				.field("value", "value").byDefault().register();
		//
		// // Map DTOIntMonthlyBalances <-> MonthlyBalances
		factory.classMap(DTOIntMonthlyBalances.class, MonthlyBalances.class)
				.field("balance", "balance").field("month", "month")
				.byDefault().register();

		// // Map DTOIntAccMovementsResume <-> AccMovementsResume

		factory.classMap(DTOIntAccMovementsResume.class, AccMovementsResume.class).field("month", "month")
				.field("balance", "balance").field("income", "income").field("outcome", "outcome").byDefault()
				.register();

		// Map DTOIntCheckbook <-> CheckBook
		factory.classMap(DTOIntCheck.class, Check.class).field("id", "id").field("issueDate", "issueDate")
				.field("value", "value").field("status", "status").field("modifiedDate", "modifiedDate").byDefault().register();


	}

	@Override
	public DTOIntFilterAccount getDTOIntFilter(String idAccount, String filter) {

		final String ge = this.getGeValue(filter, FiqlType.month.name());
		final String le = this.getLeValue(filter, FiqlType.month.name());

		final DTOIntFilterAccount dtoIntFilterAccount = new DTOIntFilterAccount();
		dtoIntFilterAccount.setStartMonth(ge);
		dtoIntFilterAccount.setEndMonth(le);
		dtoIntFilterAccount.setAccountId(idAccount);

		return dtoIntFilterAccount;

	}

	@Override
	public DTOIntFilterChecks getDtoIntFilterChecks(String idAccount,
			String filter, Integer paginationKey, Integer paginationSize) {

		final DTOIntFilterChecks dtoFilter = new DTOIntFilterChecks();
		dtoFilter.setAccountId(idAccount);
		dtoFilter.setPaginationKey(paginationKey);
		dtoFilter.setPageSize(paginationSize);

		try {
			dtoFilter.setStartDate(formatter.parse(this.getGeValue(filter,
					"issueDate")));
			dtoFilter.setEndDate(formatter.parse(this.getLeValue(filter,
					"issueDate")));
		} catch (ParseException e) {
			throw new BusinessServiceException(
					EnumError.WRONG_PARAMETERS.getAlias());
		}
		dtoFilter.setStatus(this.getEqValue(filter, "status"));

		return dtoFilter;
	}

	@Override
	public DTOIntFilterMovResumes getDtoIntFilterMovResumes(String idAccount,
			String filter) {
		final DTOIntFilterMovResumes dtoFilter = new DTOIntFilterMovResumes();
		dtoFilter.setAccountId(idAccount);
		dtoFilter.setMonth(this.getGeValue(filter, FiqlType.month.name()));
		return dtoFilter;
	}

	@Override
	public DTOIntCheckbook getDtoIntCheckbook(String idAccount,
			String idCheckbook) {
		final DTOIntCheckbook dtoIntCheckbook = new DTOIntCheckbook();
		dtoIntCheckbook.setId(idCheckbook);
		dtoIntCheckbook.setIdAccount(idAccount);
		return dtoIntCheckbook;
	}

	/**
	 * Metodo encargado de mapear un DTO interno de tipo DTOIntAccount a un DTO
	 * externo de tipo Account
	 *
	 * @author David Tafur
	 * @param dtoIntAccount
	 * @return
	 */
	@Override
	public Account map(DTOIntAccount dtoIntAccount) {
		log.info("map- return:Account-parameter:dtoIntAccount");
		return map(dtoIntAccount, Account.class);
	}

	/**
	 * Metodo que mapea una lista de DTOIntChecks a Checks
	 * 
	 * @param listaDtoIntChecks
	 * @return
	 */
	@Override
	public List<Check> mapChecks(List<DTOIntCheck> listaDtoIntChecks) {
		return mapAsList(listaDtoIntChecks, Check.class);
	}

	/**
	 * Metodo encargado de mapear una lista de tipo DTOIntMonthlyBalances a una
	 * lista MonthlyBalances
	 *
	 * @author David Tafur
	 * @param listaDtoIntMonthlyBalances
	 * @return
	 */
	@Override
	public List<MonthlyBalances> mapL(
			List<DTOIntMonthlyBalances> listaDtoIntMonthlyBalances) {
		log.info("map- return: List<MonthlyBalances>-parameter:listaDtoIntMonthlyBalances");
		return mapAsList(listaDtoIntMonthlyBalances, MonthlyBalances.class);
	}

	/**
	 * Metodo encargado de mapear una lista de DTO internos de tipo
	 * DTOIntAccMovementsResume, a una lista de DTO de tipo AccMovementsResume
	 *
	 * @author David Tafur
	 * @param listaDTOIntAccMovementsResume
	 * @return
	 */
	@Override
	public List<AccMovementsResume> map(
			List<DTOIntAccMovementsResume> listaDTOIntAccMovementsResume) {
		log.info("map- return:List<AccMovementsResume>-parameter:listaDTOIntAccMovementsResume");
		return mapAsList(listaDTOIntAccMovementsResume,
				AccMovementsResume.class);
	}

	@Override
	public Check map(DTOIntCheck intCheck) {
		log.info("map- return:Check-parameter:dtoIntExecutive");
		return map(intCheck, Check.class);
	}

	@Override
	public Checkbook mapCheckbooks(DTOIntCheckbook intCheckbook) {

		final Checkbook checkbook = new Checkbook();
		checkbook.setId(intCheckbook.getId());
		checkbook.setFirstCheck(intCheckbook.getFirstCheck() + "");
		checkbook.setLastCheck(intCheckbook.getLastCheck());
		checkbook.setTotalCheck(intCheckbook.getTotalCheck());

		final Calendar requestDate = Calendar.getInstance();
		requestDate.setTime(intCheckbook.getRequestDate());
		checkbook.setRequestDate(requestDate);

		final Calendar deliveryDate = Calendar.getInstance();
		deliveryDate.setTime(intCheckbook.getDeliveryDate());
		checkbook.setDeliveryDate(deliveryDate);
		if (intCheckbook.getActualState().equals("H")) {
			checkbook.setActualState(EnumCheckbookStatus.HABILITADO);
		} else if (intCheckbook.getActualState().equals("S")) {
			checkbook.setActualState(EnumCheckbookStatus.SOLICITADO);
		}
		return checkbook;
	}


	@Override
	public DTOIntCheckFilter getDTOIntFilterChecks(String checkId,String accountId) {

		final DTOIntCheckFilter dtoIntCheckFilter = new DTOIntCheckFilter();
		dtoIntCheckFilter.setCheckId(checkId);
		dtoIntCheckFilter.setAccountId(accountId);

		return dtoIntCheckFilter;

	}
}