package com.bbva.zic.customers.dao.mappers.impl;

import com.bbva.zic.customers.business.dto.DTOIntCustomerOperation;
import com.bbva.zic.customers.dao.model.oznz.FormatoOZECNZE0;
import com.bbva.zic.routine.commons.rm.utils.tx.IFormatNotApply;
import com.bbva.zic.routine.commons.rm.utils.tx.ISimpleTransactionMapper;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Created by Julio Cesar on 07-01-2015.
 */
@Component("tx-verify-customer-mapper")
public class VerifyCustomerMapper implements ISimpleTransactionMapper<DTOIntCustomerOperation, FormatoOZECNZE0, Object, IFormatNotApply> {

    @Override
    public FormatoOZECNZE0 mapToInner(DTOIntCustomerOperation dtoIn) {
        final FormatoOZECNZE0 formato = new FormatoOZECNZE0();
        formato.setCanal(dtoIn.getChannelId());
        formato.setTipoope(dtoIn.getCode());
        formato.setNumtarj(dtoIn.getCardNumber());
        formato.setClatarj(dtoIn.getCardNip());
        formato.setIdclien(dtoIn.getCustomerId());
        formato.setNumdocu(dtoIn.getDocumentNumber());
        formato.setTipdocu(dtoIn.getDocumentType());
        formato.setEmail(dtoIn.getEmails() != null && !dtoIn.getEmails().isEmpty()? dtoIn.getEmails().get(0) : StringUtils.EMPTY);
        // TODO : Daniel.Cortes :: validar que valor deberia llegar aca
        formato.setUsuario(dtoIn.getCustomerId());



        return formato;
    }

    @Override
    public Object mapToOuter(IFormatNotApply outFormat, DTOIntCustomerOperation dtoIn) {
        return null;
    }
}