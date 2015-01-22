package com.bbva.czic.globalposition.dao.mappers;

import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.dao.enums.EnumOperability;
import com.bbva.czic.globalposition.dao.model.oznh.FormatoOZNCEOMH;
import com.bbva.czic.routine.commons.rm.utils.tx.IFormatNotApply;
import com.bbva.czic.routine.commons.rm.utils.tx.ISimpleTransactionMapper;
import org.springframework.stereotype.Component;

/**
 * Created by Julio Cesar on 07-01-2015.
 */
@Component("tx-update-product-operability-mapper")
public class UpdateProductOperabilityMapper implements ISimpleTransactionMapper<DTOIntProduct, FormatoOZNCEOMH, DTOIntProduct, IFormatNotApply> {

    @Override
    public FormatoOZNCEOMH mapToInner(DTOIntProduct dtoIn) {
        final FormatoOZNCEOMH formatoEntrada = new FormatoOZNCEOMH();

        formatoEntrada.setNumcta(dtoIn.getId());

        formatoEntrada.setCodblq(dtoIn.isOperable() ? EnumOperability.B.name() : EnumOperability.U.name());

        return formatoEntrada;
    }

    @Override
    public DTOIntProduct mapToOuter(IFormatNotApply outFormat, DTOIntProduct dtoIn) {
        return null;
    }
}