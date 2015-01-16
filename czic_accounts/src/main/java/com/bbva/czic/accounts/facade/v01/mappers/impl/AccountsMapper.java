package com.bbva.czic.accounts.facade.v01.mappers.impl;

import com.bbva.czic.accounts.business.dto.*;
import com.bbva.czic.accounts.dao.model.oznv.FormatoOZECNVE0;
import com.bbva.czic.accounts.facade.v01.mappers.IAccountsMapper;
import com.bbva.czic.dto.net.*;
import com.bbva.czic.routine.commons.rm.utils.mappers.Mapper;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Component(value = "accounts-mapper")
public class AccountsMapper implements IAccountsMapper {

	private static I18nLog log = I18nLogFactory
			.getLogI18n(AccountsMapper.class, "META-INF/spring/i18n/log/mensajesLog");
	/**
	 * Metodo encargado de mapear un DTO interno de tipo DTOIntAccount a un DTO externo de tipo Account
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
	 * @author David Tafur
	 * @param listaDTOIntCheckbook
	 * @return
	 */
	@Override
	public List<Checkbook> mapLCheckbook(List<DTOIntCheckbook> listaDTOIntCheckbook){
		log.info("map- return:List<Checkbook>-parameter:listaDTOIntCheckbook");
		List<Checkbook> listaCheckbook = new ArrayList<Checkbook>();

		for(DTOIntCheckbook dtoIntCheckbook:listaDTOIntCheckbook){
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

		return listaCheckbook;
	}

	/**
	 * Metodo encargado de mapear una lista de tipo DTOIntMonthlyBalances a una lista MonthlyBalances
	 * @author David Tafur
	 * @param listaDtoIntMonthlyBalances
	 * @return
	 */
	@Override
	public List<MonthlyBalances> mapL(List<DTOIntMonthlyBalances> listaDtoIntMonthlyBalances){
		log.info("map- return: List<MonthlyBalances>-parameter:listaDtoIntMonthlyBalances");
		List<MonthlyBalances> listaMonthlyBalance = new ArrayList<MonthlyBalances>();

		for(DTOIntMonthlyBalances dtoIntMonthlyBalances:listaDtoIntMonthlyBalances){
			MonthlyBalances monthlyBalances = new MonthlyBalances();
			monthlyBalances.setBalance(dtoIntMonthlyBalances.getBalance());
			monthlyBalances.setMonth(EnumMonth.valueOf(dtoIntMonthlyBalances.getMonth().getMes().toString()));
			listaMonthlyBalance.add(monthlyBalances);
		}

		return listaMonthlyBalance;
	}

	/**
	 * Metodo encargado de mapear una lista de DTO internos de tipo DTOIntAccMovementsResume, a una lista de DTO de tipo AccMovementsResume
	 *@author David Tafur
	 * @param listaDTOIntAccMovementsResume
	 * @return
	 */
	@Override
	public List<AccMovementsResume> map(List<DTOIntAccMovementsResume> listaDTOIntAccMovementsResume){
		log.info("map- return:List<AccMovementsResume>-parameter:listaDTOIntAccMovementsResume");
		List<AccMovementsResume> listaAccMovementResume = new ArrayList<AccMovementsResume>();

		for(DTOIntAccMovementsResume dtoIntAccMovementsResume:listaDTOIntAccMovementsResume){
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
	 * @author David Tafur
	 * @param intBalance
	 * @return
	 */
	@Override
	public Balance map(DTOIntBalance intBalance) {
		log.info("map- return:Balance-parameter:intBalance");
		final Balance balance = new Balance();

		balance.setTotal(intBalance.getTotal());
		balance.setAvailableBalance(intBalance.getAvailableBalance());

		return balance;
	}
}