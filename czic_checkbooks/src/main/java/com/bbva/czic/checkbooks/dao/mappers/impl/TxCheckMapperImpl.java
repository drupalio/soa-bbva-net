package com.bbva.czic.checkbooks.dao.mappers.impl;

import com.bbva.czic.checkbooks.business.dto.DTOIntCheck;
import com.bbva.czic.checkbooks.business.dto.DTOIntCheckFilter;
import com.bbva.czic.checkbooks.dao.mappers.TxCheckMapper;
import com.bbva.czic.checkbooks.dao.model.ozny.FormatoOZECNYE0;
import com.bbva.czic.checkbooks.dao.model.ozny.FormatoOZECNYS0;
import com.bbva.czic.dto.net.EnumCheckStatus;
import com.bbva.czic.routine.commons.rm.utils.converter.StringMoneyConverter;
import com.bbva.czic.routine.commons.rm.utils.converter.UtilsConverter;
import com.bbva.czic.routine.commons.rm.utils.mappers.AbstractBbvaTxConfigurableMapper;
import com.bbva.czic.routine.commons.rm.utils.tx.ISimpleTransactionMapper;
import com.bbva.czic.routine.mapper.MapperFactory;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component(value = "tx-get-checks-mapper")
public class TxCheckMapperImpl extends AbstractBbvaTxConfigurableMapper implements TxCheckMapper{

    /**
     *
     */
    @Override
    protected void configure(MapperFactory factory) {

        super.configure(factory);
        /**
         * Convert HOST FORMAT (+EEEEEEEEDD) to COP Money
         */
        factory.getConverterFactory().registerConverter(new StringMoneyConverter());

        /**
         * MAPEO DE ENTRADAS
         */
        // Map DTOIntFilter <-> FormatoOZNCENA0 (OZNy)
        factory.classMap(FormatoOZECNYE0.class, DTOIntCheckFilter.class).field("numcheq", "checkId").field("numprod", "accountId").byDefault()
                .register();

        /**
         * MAPEO DE SALIDAS
         */
        // Map FormatoOZECNVS0 <-> DTOIntMonthlyBalances (OZNy)
        factory.classMap(FormatoOZECNYS0.class, DTOIntCheck.class).field("numcheq", "id").field("fechemi", "issueDate")
                .field("valcheq", "value.amount").field("estcheq", "status")
                .field("fechmod", "modifiedDate").byDefault().register();

    }

    @Override
    public FormatoOZECNYE0 mapInOzny(DTOIntCheckFilter dtoIn) {
        return map(dtoIn, FormatoOZECNYE0.class);
    }

    @Override
    public DTOIntCheck mapOutOzny(FormatoOZECNYS0 formatOutput) {
        return map(formatOutput, DTOIntCheck.class);
    }


}
