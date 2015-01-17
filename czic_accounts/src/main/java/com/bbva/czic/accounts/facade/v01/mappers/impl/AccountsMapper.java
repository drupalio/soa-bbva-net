package com.bbva.czic.accounts.facade.v01.mappers.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.bbva.czic.accounts.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.accounts.business.dto.DTOIntAccount;
import com.bbva.czic.accounts.business.dto.DTOIntBalance;
import com.bbva.czic.accounts.business.dto.DTOIntCheck;
import com.bbva.czic.accounts.business.dto.DTOIntCheckbook;
import com.bbva.czic.accounts.business.dto.DTOIntMonthlyBalances;
import com.bbva.czic.accounts.facade.v01.mappers.IAccountsMapper;
import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.Account;
import com.bbva.czic.dto.net.Balance;
import com.bbva.czic.dto.net.Check;
import com.bbva.czic.dto.net.Checkbook;
import com.bbva.czic.dto.net.EnumCheckStatus;
import com.bbva.czic.dto.net.EnumCheckbookStatus;
import com.bbva.czic.dto.net.EnumMonth;
import com.bbva.czic.dto.net.MonthlyBalances;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;

@Component(value = "accounts-mapper")
public class AccountsMapper implements IAccountsMapper {

	private static I18nLog log = I18nLogFactory
			.getLogI18n(AccountsMapper.class, "META-INF/spring/i18n/log/mensajesLog");

	/**
	 * Metodo encargado de mapear un DTO interno de tipo DTOIntAccount a un DTO externo de tipo Account
	 * 
	 * @author David Tafur
	 * @param dtoIntAccount
	 * @return
	 */
	@Override
	public Account map(DTOIntAccount dtoIntAccount) {
		log.info("map- return:Account-parameter:dtoIntAccount");
		Account account = new Account();
		account.setName(dtoIntAccount.getName());
		account.setId(dtoIntAccount.getIdAccount());
		account.setBalance(map(dtoIntAccount.getBalance()));
		account.setCheckbooks(mapLCheckbook(dtoIntAccount.getListaCheckBook()));
		return account;
	}

	/**
	 * Metodo encargado de mapear una lista de tipo DTOIntCheckbook a una lista Checkbook
	 * 
	 * @author David Tafur
	 * @param listaDTOIntCheckbook
	 * @return
	 */
	@Override
	public List<Checkbook> mapLCheckbook(List<DTOIntCheckbook> listaDTOIntCheckbook) {
		log.info("map- return:List<Checkbook>-parameter:listaDTOIntCheckbook");
		List<Checkbook> listaCheckbook = new ArrayList<Checkbook>();

		if (!CollectionUtils.isEmpty(listaDTOIntCheckbook)) {

			for (DTOIntCheckbook dtoIntCheckbook : listaDTOIntCheckbook) {
				Checkbook checkbook = new Checkbook();
				checkbook.setId(dtoIntCheckbook.getId());
				checkbook.setActualState(EnumCheckbookStatus.valueOf(dtoIntCheckbook.getActualState().toString()));
				Calendar delivCalendar = Calendar.getInstance();
				delivCalendar.setTime(dtoIntCheckbook.getDeliveryDate());
				checkbook.setDeliveryDate(delivCalendar);
				checkbook.setFirstCheck(dtoIntCheckbook.getFirstCheck());
				checkbook.setLastCheck(dtoIntCheckbook.getLastCheckl());
				Calendar requestDateCalendar = Calendar.getInstance();
				requestDateCalendar.setTime(dtoIntCheckbook.getRequestDate());
				checkbook.setRequestDate(requestDateCalendar);
				checkbook.setTotalCheck(dtoIntCheckbook.getTotalCheck());
				listaCheckbook.add(checkbook);
			}
		}

		return listaCheckbook;
	}

	@Override
	public Check mapChecks(List<DTOIntCheck> listaDtoIntChecks) {
		return null;
	}

	/**
	 * Metodo encargado de mapear una lista de tipo DTOIntMonthlyBalances a una lista MonthlyBalances
	 * 
	 * @author David Tafur
	 * @param listaDtoIntMonthlyBalances
	 * @return
	 */
	@Override
	public List<MonthlyBalances> mapL(List<DTOIntMonthlyBalances> listaDtoIntMonthlyBalances) {
		log.info("map- return: List<MonthlyBalances>-parameter:listaDtoIntMonthlyBalances");
		List<MonthlyBalances> listaMonthlyBalance = new ArrayList<MonthlyBalances>();

		for (DTOIntMonthlyBalances dtoIntMonthlyBalances : listaDtoIntMonthlyBalances) {
			MonthlyBalances monthlyBalances = new MonthlyBalances();
			monthlyBalances.setBalance(dtoIntMonthlyBalances.getBalance());
			monthlyBalances.setMonth(EnumMonth.valueOf(dtoIntMonthlyBalances.getMonth().getMes().toString()));
			listaMonthlyBalance.add(monthlyBalances);
		}

		return listaMonthlyBalance;
	}

	/**
	 * Metodo encargado de mapear una lista de DTO internos de tipo DTOIntAccMovementsResume, a una lista de DTO de tipo
	 * AccMovementsResume
	 *
	 * @author David Tafur
	 * @param listaDTOIntAccMovementsResume
	 * @return
	 */
	@Override
	public List<AccMovementsResume> map(List<DTOIntAccMovementsResume> listaDTOIntAccMovementsResume) {
		log.info("map- return:List<AccMovementsResume>-parameter:listaDTOIntAccMovementsResume");
		List<AccMovementsResume> listaAccMovementResume = new ArrayList<AccMovementsResume>();

		for (DTOIntAccMovementsResume dtoIntAccMovementsResume : listaDTOIntAccMovementsResume) {
			AccMovementsResume accMovementsResume = new AccMovementsResume();
			accMovementsResume.setMonth(EnumMonth.valueOf(dtoIntAccMovementsResume.getMonth().getMes().toString()));
			accMovementsResume.setBalance(dtoIntAccMovementsResume.getBalance());
			accMovementsResume.setIncome(dtoIntAccMovementsResume.getIncome());
			accMovementsResume.setOutcome(dtoIntAccMovementsResume.getOutcome());
			listaAccMovementResume.add(accMovementsResume);
		}

		return listaAccMovementResume;
	}

	/**
	 * Metodo encargado de mapear un DTOIntBalance a un Balance
	 * 
	 * @author David Tafur
	 * @param intBalance
	 * @return
	 */
	@Override
	public Balance map(DTOIntBalance intBalance) {
		log.info("map- return:Balance-parameter:intBalance");
		final Balance balance = new Balance();

		if (intBalance != null) {

			balance.setTotal(intBalance.getTotal());
			balance.setAvailableBalance(intBalance.getAvailableBalance());
		}
		return balance;
	}

	/**
	 * Metodo encargado de mapear una lista de tipo DTOIntCheck a una lista Check
	 * 
	 * @author Cristian Rojas
	 * @param listaDTOIntCheck
	 * @return
	 */
	public List<Check> mapLCheck(List<DTOIntCheck> listaDTOIntCheck) {
		List<Check> listaCheck = new ArrayList<Check>();

		for (DTOIntCheck dtoIntCheck : listaDTOIntCheck) {
			Check check = new Check();
			check.setId(String.valueOf(dtoIntCheck.getId()));
			check.setStatus(EnumCheckStatus.valueOf(dtoIntCheck.getStatus().toString()));
			final Calendar issueDate = Calendar.getInstance();
			issueDate.setTime(dtoIntCheck.getIssueDate());
			check.setIssueDate(issueDate);
			check.setValue(dtoIntCheck.getValue());
			listaCheck.add(check);
		}
		return listaCheck;
	}

}