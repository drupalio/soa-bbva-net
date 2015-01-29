package com.bbva.czic.cards.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.bbva.czic.cards.business.dto.DTOIntFilterCards;
import com.bbva.czic.cards.dao.tx.TxGetCreditCardCharges;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.bbva.czic.cards.business.dto.DTOIntCardCharge;
import com.bbva.czic.cards.dao.model.ozno.FormatoOZECNOE0;
import com.bbva.czic.cards.dao.model.ozno.FormatoOZECNOS0;
import com.bbva.czic.cards.dao.model.ozno.PeticionTransaccionOzno;
import com.bbva.czic.cards.dao.model.ozno.RespuestaTransaccionOzno;
import com.bbva.czic.cards.facade.v01.CardsChargesMapper;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.ErrorMappingHelper;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.host.transporte.ExcepcionTransporte;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

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
