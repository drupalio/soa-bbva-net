package com.bbva.zic.globalposition.dao.mappers;

import com.bbva.zic.globalposition.business.dto.DTOIntProductVisibility;
import com.bbva.zic.routine.commons.rm.utils.tx.IFormatNotApply;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

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
