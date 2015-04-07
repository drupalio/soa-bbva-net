package com.bbva.zic.cards.dao;

import java.util.List;

import javax.annotation.Resource;

import com.bbva.zic.cards.business.dto.DTOIntFilterCards;
import com.bbva.zic.cards.dao.tx.TxGetCreditCardCharges;
import org.springframework.stereotype.Component;

import com.bbva.zic.cards.business.dto.DTOIntCardCharge;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;

@Component(value = "cards-dao")
public class CardsDAOImpl implements CardsDAO {

	private static I18nLog log = I18nLogFactory.getLogI18n(CardsDAOImpl.class, "META-INF/spring/i18n/log/mensajesLog");

	/**
	 * OZNO
	 */
	@Resource(name = "tx-get-creditcard-charges")
	private TxGetCreditCardCharges txtGetCreditCardCharges;

	@Override
	public List<DTOIntCardCharge> getCreditCardCharges(final DTOIntFilterCards filter){
		return txtGetCreditCardCharges.invoke(filter);
	}
}
