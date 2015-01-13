package com.bbva.czic.globalposition.dao.mapper;

import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.dao.enums.EnumVisibility;
import com.bbva.czic.globalposition.dao.model.ozn0.FormatoOZNCEOM0;
import com.bbva.czic.routine.commons.rm.utils.tx.IFormatNotApply;
import com.bbva.czic.routine.commons.rm.utils.tx.ISimpleTransactionMapper;
import org.springframework.stereotype.Component;

/**
 * Created by Julio Cesar on 06-01-2015.
 */
@Component("tx-update-product-visibility-mapper")
public class UpdateProductVisibilityMapper implements ISimpleTransactionMapper<DTOIntProduct, FormatoOZNCEOM0, DTOIntProduct, IFormatNotApply> {

    @Override
    public FormatoOZNCEOM0 mapToInner(DTOIntProduct dtoIn) {
        final FormatoOZNCEOM0 formatoEntrada = new FormatoOZNCEOM0();

        formatoEntrada.setNumcta(dtoIn.getId());

        formatoEntrada.setIndcta(dtoIn.isVisible() ? EnumVisibility.SHOW.name() : EnumVisibility.HIDE.name());

        return formatoEntrada;
    }

    @Override
    public DTOIntProduct mapToOuter(IFormatNotApply outFormat, DTOIntProduct dtoIn) {
        return null;
    }
}
