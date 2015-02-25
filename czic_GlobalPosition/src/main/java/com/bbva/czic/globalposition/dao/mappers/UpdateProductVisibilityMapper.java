package com.bbva.czic.globalposition.dao.mappers;

import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.business.dto.DTOIntProductVisibility;
import com.bbva.czic.globalposition.dao.enums.EnumVisibility;
import com.bbva.czic.globalposition.dao.model.ozn0.FormatoOZNCEOM0;
import com.bbva.czic.routine.commons.rm.utils.tx.IFormatNotApply;
import com.bbva.czic.routine.commons.rm.utils.tx.ISimpleTransactionMapper;
import org.springframework.stereotype.Component;

/**
 * Created by Julio Cesar on 06-01-2015.
 */
@Component("tx-update-product-visibility-mapper")
public class UpdateProductVisibilityMapper implements ISimpleTransactionMapper<DTOIntProductVisibility, FormatoOZNCEOM0, DTOIntProduct, IFormatNotApply> {

    @Override
    public FormatoOZNCEOM0 mapToInner(DTOIntProductVisibility dtoIn) {
        final FormatoOZNCEOM0 formatoEntrada = new FormatoOZNCEOM0();

        formatoEntrada.setNumcta(dtoIn.getId());

        formatoEntrada.setIndcta(dtoIn.isVisible() ? EnumVisibility.SHOW.getAlias() : EnumVisibility.HIDE.getAlias());

        return formatoEntrada;
    }

    @Override
    public DTOIntProduct mapToOuter(IFormatNotApply outFormat, DTOIntProductVisibility dtoIn) {
        return null;
    }
}
