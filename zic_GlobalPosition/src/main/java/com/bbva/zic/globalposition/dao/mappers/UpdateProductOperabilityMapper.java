package com.bbva.zic.globalposition.dao.mappers;

import com.bbva.zic.globalposition.business.dto.DTOIntProduct;
import com.bbva.zic.globalposition.business.dto.DTOIntProductOperability;
import com.bbva.zic.globalposition.dao.enums.EnumOperability;
import com.bbva.zic.globalposition.dao.model.oznh.FormatoOZNCEOMH;
import com.bbva.zic.routine.commons.rm.utils.tx.IFormatNotApply;
import com.bbva.zic.routine.commons.rm.utils.tx.ISimpleTransactionMapper;
import org.springframework.stereotype.Component;

/**
 * Created by Julio Cesar on 07-01-2015.
 */
@Component("tx-update-product-operability-mapper")
public class UpdateProductOperabilityMapper implements ISimpleTransactionMapper<DTOIntProductOperability, FormatoOZNCEOMH, DTOIntProduct, IFormatNotApply> {

    @Override
    public FormatoOZNCEOMH mapToInner(DTOIntProductOperability dtoIn) {
        final FormatoOZNCEOMH formatoEntrada = new FormatoOZNCEOMH();

        formatoEntrada.setNumcta(dtoIn.getId());

        formatoEntrada.setCodblq(dtoIn.isOperable() ? EnumOperability.B.name() : EnumOperability.U.name());

        return formatoEntrada;
    }

    @Override
    public DTOIntProduct mapToOuter(IFormatNotApply outFormat, DTOIntProductOperability dtoIn) {
        return null;
    }
}