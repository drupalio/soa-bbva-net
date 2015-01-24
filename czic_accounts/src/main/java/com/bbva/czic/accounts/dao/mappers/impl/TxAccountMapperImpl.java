package com.bbva.czic.accounts.dao.mappers.impl;

import java.util.ArrayList;

import com.bbva.czic.accounts.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.accounts.business.dto.DTOIntAccount;
import com.bbva.czic.accounts.business.dto.DTOIntCheckbook;
import com.bbva.czic.accounts.business.dto.DTOIntFilterAccount;
import com.bbva.czic.accounts.business.dto.DTOIntMonthlyBalances;
import com.bbva.czic.accounts.dao.mappers.TxAccountMapper;
import com.bbva.czic.accounts.dao.model.ozna.FormatoOZNCENA0;
import com.bbva.czic.accounts.dao.model.ozna.FormatoOZNCSNA0;
import com.bbva.czic.accounts.dao.model.oznu.FormatoOZECNUE0;
import com.bbva.czic.accounts.dao.model.oznu.FormatoOZECNUS0;
import com.bbva.czic.accounts.dao.model.oznv.FormatoOZECNVE0;
import com.bbva.czic.accounts.dao.model.oznv.FormatoOZECNVS0;
import com.bbva.czic.routine.commons.rm.utils.converter.StringMoneyConverter;
import com.bbva.czic.routine.commons.rm.utils.mappers.Mapper;
import com.bbva.czic.routine.mapper.CustomMapper;
import com.bbva.czic.routine.mapper.MapperFactory;
import com.bbva.czic.routine.mapper.MappingContext;
import com.bbva.czic.routine.mapper.impl.ConfigurableMapper;

@Mapper(value = "txAccountMapper")
public class TxAccountMapperImpl extends ConfigurableMapper implements TxAccountMapper {

	/**
	 * 
	 */
	@Override
	protected void configure(MapperFactory factory) {

		/**
		 * Convert HOST FORMAT (+EEEEEEEEDD) to COP Money
		 */
		factory.getConverterFactory().registerConverter(new StringMoneyConverter());

		/**
		 * MAPEO DE ENTRADAS
		 */
		// Map DTOIntFilter <-> FormatoOZNCENA0 (OZNA)
		factory.classMap(DTOIntFilterAccount.class, FormatoOZNCENA0.class).field("accountId", "numprod").byDefault()
				.register();

		// Map DTOIntFilter <-> FormatoOZECNVE0 (OZNV)
		factory.classMap(DTOIntFilterAccount.class, FormatoOZECNVE0.class).field("startMonth", "mesini")
				.field("endMonth", "mesfin").field("accountId", "numcta").byDefault().register();

		// Map DTOIntFilter <-> FormatoOZECNUE0 (OZNU)
		factory.classMap(DTOIntFilterAccount.class, FormatoOZECNUE0.class).field("startMonth", "intervm")
				.field("accountId", "numprod").byDefault().register();

		/**
		 * MAPEO DE SALIDAS
		 */
		// Map FormatoOZECNVS0 <-> DTOIntMonthlyBalances (OZNA)
		factory.classMap(DTOIntAccount.class, FormatoOZNCSNA0.class).field("name", "nomprod").field("type", "tipprod")
				.field("idAccount", "numprod").field("balance.total", "saltota")
				.field("balance.availableBalance", "sddispo").field("balance.tradeBalance", "sdcanje").byDefault()
				.customize(new CheckBookListMapper()).register();

		// Map FormatoOZECNVS0 <-> DTOIntMonthlyBalances (OZNV)
		factory.classMap(DTOIntMonthlyBalances.class, FormatoOZECNVS0.class).field("balance", "salddis")
				.field("month", "mes").byDefault().register();

		// Map FormatoOZECNUS0 <-> DTOIntAccMovementsResume (OZNU)
		factory.classMap(DTOIntAccMovementsResume.class, FormatoOZECNUS0.class).field("balance", "saldtot")
				.field("income", "valdepo").field("outcome", "valcarg").field("month.mes", "mes").byDefault()
				.register();

	}

	@Override
	public FormatoOZNCENA0 mapInOzna(DTOIntFilterAccount dtoIn) {
		return map(dtoIn, FormatoOZNCENA0.class);
	}

	@Override
	public DTOIntAccount mapOutOzna(FormatoOZNCSNA0 formatOutput) {
		return map(formatOutput, DTOIntAccount.class);
	}

	@Override
	public FormatoOZECNVE0 mapInOznv(DTOIntFilterAccount dtoIn) {
		return map(dtoIn, FormatoOZECNVE0.class);
	}

	@Override
	public DTOIntMonthlyBalances mapOutOznv(FormatoOZECNVS0 formatOutput) {
		return map(formatOutput, DTOIntMonthlyBalances.class);
	}

	@Override
	public FormatoOZECNUE0 mapInOznu(DTOIntFilterAccount dtoIn) {
		return map(dtoIn, FormatoOZECNUE0.class);
	}

	@Override
	public DTOIntAccMovementsResume mapOutOznu(FormatoOZECNUS0 formatOutput) {
		return map(formatOutput, DTOIntAccMovementsResume.class);
	}

	/**
	 * @author Entelgy
	 */
	private static class CheckBookListMapper extends CustomMapper<DTOIntAccount, FormatoOZNCSNA0> {

		@Override
		public void mapBtoA(FormatoOZNCSNA0 outputFormat, DTOIntAccount dtoIntAccout, MappingContext context) {

			dtoIntAccout.setListaCheckBook(new ArrayList<DTOIntCheckbook>());
			dtoIntAccout.getListaCheckBook().add(new DTOIntCheckbook(outputFormat.getIdcheq0()));
			dtoIntAccout.getListaCheckBook().add(new DTOIntCheckbook(outputFormat.getIdcheq1()));
			dtoIntAccout.getListaCheckBook().add(new DTOIntCheckbook(outputFormat.getIdcheq2()));
			dtoIntAccout.getListaCheckBook().add(new DTOIntCheckbook(outputFormat.getIdcheq3()));
			dtoIntAccout.getListaCheckBook().add(new DTOIntCheckbook(outputFormat.getIdcheq4()));
			dtoIntAccout.getListaCheckBook().add(new DTOIntCheckbook(outputFormat.getIdcheq5()));
			dtoIntAccout.getListaCheckBook().add(new DTOIntCheckbook(outputFormat.getIdcheq6()));
			dtoIntAccout.getListaCheckBook().add(new DTOIntCheckbook(outputFormat.getIdcheq7()));
			dtoIntAccout.getListaCheckBook().add(new DTOIntCheckbook(outputFormat.getIdcheq8()));
			dtoIntAccout.getListaCheckBook().add(new DTOIntCheckbook(outputFormat.getIdcheq9()));
		}
	}

}
