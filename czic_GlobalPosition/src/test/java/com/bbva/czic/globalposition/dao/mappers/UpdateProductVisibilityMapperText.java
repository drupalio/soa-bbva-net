package com.bbva.czic.globalposition.dao.mappers;

import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.business.dto.DTOIntProductVisibility;
import com.bbva.czic.globalposition.dao.enums.EnumVisibility;
import com.bbva.czic.globalposition.dao.model.ozn0.FormatoOZNCEOM0;
import com.bbva.czic.routine.commons.rm.utils.tx.IFormatNotApply;
import com.bbva.czic.routine.commons.rm.utils.tx.ISimpleTransactionMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.stereotype.Component;

import static org.mockito.Matchers.any;

/**
 * Created by Julio Cesar on 06-01-2015.
 */

public class UpdateProductVisibilityMapperText {

    @Mock
    private UpdateProductVisibilityMapper updateProductVisibilityMapper;

    @Before
    public void init(){
        updateProductVisibilityMapper = new UpdateProductVisibilityMapper();
    }

    @Test
    public void callMapToInnerTest(){
        DTOIntProductVisibility dtoIntProductVisibility = new DTOIntProductVisibility();
        dtoIntProductVisibility.setId("34567865");
        dtoIntProductVisibility.setVisible(false);

        updateProductVisibilityMapper.mapToInner(dtoIntProductVisibility);
    }

    @Test
    public void callMapToOuterTest(){
        updateProductVisibilityMapper.mapToOuter(any(IFormatNotApply.class), any(DTOIntProductVisibility.class));
    }
}
