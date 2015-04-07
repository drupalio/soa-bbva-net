package com.bbva.zic.globalposition.dao.mappers;


import com.bbva.zic.globalposition.business.dto.DTOIntProductOperability;
import com.bbva.zic.routine.commons.rm.utils.tx.IFormatNotApply;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Matchers.any;

/**
 * Created by Julio Cesar on 07-01-2015.
 */

public class UpdateProductOperabilityMapperTest {
    @Mock
    private UpdateProductOperabilityMapper updateProductOperabilityMapper;

    @Before
    public void init(){
        updateProductOperabilityMapper = new UpdateProductOperabilityMapper();
    }

    @Test
    public void callMapToInnerTest(){
        DTOIntProductOperability dtoIntProductOperability = new DTOIntProductOperability();
        dtoIntProductOperability.setId("2345678");
        dtoIntProductOperability.setOperable(true);

        updateProductOperabilityMapper.mapToInner(dtoIntProductOperability);
    }

    @Test
    public void callMapToOuterTest(){
        updateProductOperabilityMapper.mapToOuter(any(IFormatNotApply.class), any(DTOIntProductOperability .class));
    }
}