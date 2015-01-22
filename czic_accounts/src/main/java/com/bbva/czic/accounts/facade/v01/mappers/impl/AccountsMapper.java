package com.bbva.czic.accounts.facade.v01.mappers.impl;

import java.util.List;

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
import com.bbva.czic.dto.net.MonthlyBalances;
import com.bbva.czic.routine.commons.rm.utils.converter.CalendarConverter;
import com.bbva.czic.routine.commons.rm.utils.mappers.Mapper;
import com.bbva.czic.routine.mapper.MapperFactory;
import com.bbva.czic.routine.mapper.factory.MoneyFactory;
import com.bbva.czic.routine.mapper.impl.ConfigurableMapper;
import com.bbva.czic.routine.mapper.metadata.TypeFactory;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;

@Mapper(value = "accounts-mapper")
public class AccountsMapper extends ConfigurableMapper implements IAccountsMapper {

	private static I18nLog log = I18nLogFactory
			.getLogI18n(AccountsMapper.class, "META-INF/spring/i18n/log/mensajesLog");

	@Override
	protected void configure(MapperFactory factory) {

		// Add Converter
		factory.getConverterFactory().registerConverter(new CalendarConverter());

		factory.registerObjectFactory(new MoneyFactory(), TypeFactory.<Money> valueOf(Money.class));

		// Map DTOIntCheckbook <-> CheckBook
		factory.classMap(DTOIntCheckbook.class, Checkbook.class).field("id", "id").field("firstCheck", "firstCheck")
				.field("lastCheckl", "lastCheck").field("totalCheck", "totalCheck").field("actualState", "actualState")
				.field("deliveryDate", "deliveryDate").field("requestDate", "requestDate").byDefault().register();

		factory.classMap(DTOIntBalance.class, Balance.class).field("total", "total")
				.field("availableBalance", "availableBalance").byDefault().register();

		// Map DTOIntAccount <-> FormatoOZECNVE0
		factory.classMap(DTOIntAccount.class, Account.class).field("name", "name").field("idAccount", "id")
				.field("balance", "balance").field("listaCheckBook", "checkbooks").byDefault().register();

		// // Map DTOIntCheck <-> FormatoOZECNVE0
		factory.classMap(DTOIntCheck.class, Check.class).field("id", "id").field("status", "status")
				.field("issueDate", "issueDate").field("value", "value").byDefault().register();
		//
		// // Map DTOIntMonthlyBalances <-> MonthlyBalances
		factory.classMap(DTOIntMonthlyBalances.class, MonthlyBalances.class).field("balance", "balance")
				.field("month.mes", "month").byDefault().register();

		// // Map DTOIntAccMovementsResume <-> AccMovementsResume
		factory.classMap(DTOIntAccMovementsResume.class, AccMovementsResume.class).field("month.mes", "month")
				.field("balance", "balance").field("income", "income").field("outcome", "outcome").byDefault()
				.register();

	}

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
	 * Metodo encargado de mapear una lista de tipo DTOIntMonthlyBalances a una lista MonthlyBalances
	 *
	 * @author David Tafur
	 * @param listaDtoIntMonthlyBalances
	 * @return
	 */
	@Override
	public List<MonthlyBalances> mapL(List<DTOIntMonthlyBalances> listaDtoIntMonthlyBalances) {
		log.info("map- return: List<MonthlyBalances>-parameter:listaDtoIntMonthlyBalances");
		return mapAsList(listaDtoIntMonthlyBalances, MonthlyBalances.class);
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
		return mapAsList(listaDTOIntAccMovementsResume, AccMovementsResume.class);
	}

}