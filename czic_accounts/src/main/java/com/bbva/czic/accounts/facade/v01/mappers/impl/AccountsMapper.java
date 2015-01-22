package com.bbva.czic.accounts.facade.v01.mappers.impl;

import java.util.Calendar;
import java.util.List;

import com.bbva.czic.accounts.business.dto.*;
import com.bbva.czic.accounts.facade.v01.mappers.IAccountsMapper;
import com.bbva.czic.dto.net.*;
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
				.field("lastCheck", "lastCheck").field("totalCheck", "totalCheck").field("actualState", "actualState")
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

	@Override
	public Check mapCheck(DTOIntCheck intCheck) {
		final Check check = new Check();

		check.setId(intCheck.getId());

		final Calendar issueDate = Calendar.getInstance();
		issueDate.setTime(intCheck.getIssueDate());
		check.setIssueDate(issueDate);
		check.setValue(intCheck.getValue());
		check.setStatus(intCheck.getStatus());

		final Calendar modifiedDate = Calendar.getInstance();
		modifiedDate.setTime(intCheck.getModifiedDate());
		check.setModifiedDate(modifiedDate);

		return check;
	}

	@Override
	public Checkbook mapCheckbook(DTOIntCheckbook intCheckbook) {
		final Checkbook checkbook = new Checkbook();

		checkbook.setId(intCheckbook.getId());
		checkbook.setFirstCheck(intCheckbook.getFirstCheck());
		checkbook.setLastCheck(intCheckbook.getLastCheck());
		checkbook.setTotalCheck(intCheckbook.getTotalCheck());

		final Calendar requestDate = Calendar.getInstance();
		requestDate.setTime(intCheckbook.getRequestDate());
		checkbook.setRequestDate(requestDate);

		final Calendar deliveryDate = Calendar.getInstance();
		deliveryDate.setTime(intCheckbook.getDeliveryDate());
		checkbook.setDeliveryDate(deliveryDate);

		checkbook.setActualState(EnumCheckbookStatus.valueOf(intCheckbook.getActualState().toString()));

		return checkbook;
	}

}