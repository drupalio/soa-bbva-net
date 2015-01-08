package com.bbva.czic.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import com.bbva.czic.core.stereotype.AbstractConfigurableMapper;
import com.bbva.czic.core.stereotype.Mapper;
import com.bbva.czic.accounts.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.accounts.business.dto.DTOIntAccount;
import com.bbva.czic.accounts.business.dto.DTOIntMonthlyBalances;
import com.bbva.czic.accounts.dao.model.oznu.FormatoOZECNUE0;
import com.bbva.czic.accounts.dao.model.oznv.FormatoOZECNVE0;

@Mapper(value = "accountsMapper")
public class AccountsMapper extends AbstractConfigurableMapper {

	@Override
	protected void configure(MapperFactory factory) {
		// Mapeo getAccount
		factory.classMap(DTOIntAccount.class, FormatoOZECNVE0.class)
				.field("tipprod", "productType").field("nomprod", "name")
				.field("alias", "alias").field("saldoto", "balance.balance")
				.field("saldodi", "balance.availableBalance")
				.field("saldcnj", "tradeBalance").byDefault().register();

		// Mapeo getAccountMonthlyBalance
		factory.classMap(DTOIntMonthlyBalances.class, FormatoOZECNVE0.class)
				.field("balance", "salddis").field("month", "mes").byDefault()
				.register();

		// Mapeo DTOIntAccMovementsResume
		factory.classMap(DTOIntAccMovementsResume.class,FormatoOZECNUE0.class)
				.field("income", "valdepo").field("outcome", "valcarg")
				.field("balance", "saldtot").field("month", "mes").byDefault()
				.register();

	}

	public Object getMapper(Object dtoEnt, Class<?> dtoSal) {

		MapperFactory mapperFactory = new DefaultMapperFactory.Builder()
				.build();

		dtoSal = mapperFactory.getMapperFacade().map(dtoEnt, dtoSal.getClass());
		return dtoSal;
	}

	public DTOIntAccount map(FormatoOZECNVE0 formatoSalida,
			Class<DTOIntAccount> class1) {
		// TODO Auto-generated method stub
		return null;
	}

}