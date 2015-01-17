package com.bbva.czic.accounts.dao.mappers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bbva.czic.accounts.business.dto.DTOIntAccount;
import com.bbva.czic.accounts.business.dto.DTOIntBalance;
import com.bbva.czic.accounts.business.dto.DTOIntCheckbook;
import com.bbva.czic.accounts.business.dto.DTOIntFilterAccount;
import com.bbva.czic.accounts.dao.model.ozna.FormatoOZNCENA0;
import com.bbva.czic.accounts.dao.model.ozna.FormatoOZNCSNA0;
import com.bbva.czic.routine.commons.rm.utils.tx.ISimpleTransactionMapper;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;

@Component("tx-get-account-mapper")
public class GetAccountMapper implements
		ISimpleTransactionMapper<DTOIntFilterAccount, FormatoOZNCENA0, DTOIntAccount, FormatoOZNCSNA0> {

	private static I18nLog log = I18nLogFactory.getLogI18n(GetAccountMapper.class,
			"META-INF/spring/i18n/log/mensajesLog");

	@Override
	public FormatoOZNCENA0 mapToInner(DTOIntFilterAccount dtoIn) {
		log.info("mapToInner-return:FormatoOZNCENA0-parameter:DTOIntAccount");
		FormatoOZNCENA0 formatoEntrada = new FormatoOZNCENA0();
		formatoEntrada.setNumprod(dtoIn.getAccountId());
		return formatoEntrada;
	}

	@Override
	public DTOIntAccount mapToOuter(FormatoOZNCSNA0 outFormat, DTOIntFilterAccount dtoIn) {
		log.info("mapToOuter-return:DTOIntAccount-parameter:FormatoOZNCSNA0");
		List<DTOIntCheckbook> listaCheckBooks = new ArrayList<DTOIntCheckbook>();
		DTOIntAccount dtoIntAccount = new DTOIntAccount();

		if (outFormat != null) {
			dtoIntAccount.setName(outFormat.getNomprod());
			dtoIntAccount.setType(outFormat.getTipprod());
			dtoIntAccount.setIdAccount(outFormat.getNumprod());

			// Balance
			DTOIntBalance dtoIntBalance = new DTOIntBalance();
			Money total = new Money();
			Money disponible = new Money();
			Money canje = new Money();

			total.setAmount(new BigDecimal(outFormat.getSaltota()));
			disponible.setAmount(new BigDecimal(outFormat.getSddispo()));
			canje.setAmount(new BigDecimal(outFormat.getSdcanje()));

			dtoIntBalance.setAvailableBalance(disponible);
			dtoIntBalance.setTotal(total);
			dtoIntBalance.setTradeBalance(canje);
			dtoIntAccount.setBalance(dtoIntBalance);

			DTOIntCheckbook dtoIntCheckbook0 = new DTOIntCheckbook();
			dtoIntCheckbook0.setId(outFormat.getIdcheq0());
			listaCheckBooks.add(dtoIntCheckbook0);

			DTOIntCheckbook dtoIntCheckbook1 = new DTOIntCheckbook();
			dtoIntCheckbook1.setId(outFormat.getIdcheq1());
			listaCheckBooks.add(dtoIntCheckbook1);

			DTOIntCheckbook dtoIntCheckbook2 = new DTOIntCheckbook();
			dtoIntCheckbook2.setId(outFormat.getIdcheq2());
			listaCheckBooks.add(dtoIntCheckbook2);

			DTOIntCheckbook dtoIntCheckbook3 = new DTOIntCheckbook();
			dtoIntCheckbook3.setId(outFormat.getIdcheq3());
			listaCheckBooks.add(dtoIntCheckbook3);

			DTOIntCheckbook dtoIntCheckbook4 = new DTOIntCheckbook();
			dtoIntCheckbook4.setId(outFormat.getIdcheq4());
			listaCheckBooks.add(dtoIntCheckbook4);

			DTOIntCheckbook dtoIntCheckbook5 = new DTOIntCheckbook();
			dtoIntCheckbook5.setId(outFormat.getIdcheq5());
			listaCheckBooks.add(dtoIntCheckbook5);

			DTOIntCheckbook dtoIntCheckbook6 = new DTOIntCheckbook();
			dtoIntCheckbook6.setId(outFormat.getIdcheq6());
			listaCheckBooks.add(dtoIntCheckbook6);

			DTOIntCheckbook dtoIntCheckbook7 = new DTOIntCheckbook();
			dtoIntCheckbook7.setId(outFormat.getIdcheq7());
			listaCheckBooks.add(dtoIntCheckbook7);

			DTOIntCheckbook dtoIntCheckbook8 = new DTOIntCheckbook();
			dtoIntCheckbook8.setId(outFormat.getIdcheq8());
			listaCheckBooks.add(dtoIntCheckbook8);

			DTOIntCheckbook dtoIntCheckbook9 = new DTOIntCheckbook();
			dtoIntCheckbook9.setId(outFormat.getIdcheq9());
			listaCheckBooks.add(dtoIntCheckbook9);

			dtoIntAccount.setListaCheckBook(listaCheckBooks);
		}

		return dtoIntAccount;
	}
}
