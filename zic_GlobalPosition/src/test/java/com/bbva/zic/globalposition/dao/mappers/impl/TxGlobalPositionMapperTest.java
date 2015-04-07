package com.bbva.zic.globalposition.dao.mappers.impl;

import com.bbva.zic.globalposition.business.dto.DTOIntProductFilter;
import com.bbva.zic.globalposition.dao.model.ozn1.FormatoOZECN1S0;
import com.bbva.zic.globalposition.dao.model.ozn1.FormatoOZECN1S1;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Matchers.any;

public class TxGlobalPositionMapperTest {

    @Mock
    private TxGlobalPositionMapper txGlobalPositionMapper;

    @Before
    public void init(){
        txGlobalPositionMapper = new TxGlobalPositionMapper();
    }

    @Test
    public void callMapInOzn1Mapper(){
        txGlobalPositionMapper.mapInOzn1(any(DTOIntProductFilter.class));
    }

    @Test
    public void callMapOutOzn1S0Mapper(){
        txGlobalPositionMapper.mapOutOzn1S0(any(FormatoOZECN1S0.class));
    }

    @Test
    public void callMapOutOzn1S1WhitParamsNullMapper(){
        FormatoOZECN1S1 formatoOZECN1S1 = new FormatoOZECN1S1();
        txGlobalPositionMapper.mapOutOzn1S1(formatoOZECN1S1);
    }

    @Test
    public void callMapOutOzn1S1WhitParamsNotNullMapper(){

        FormatoOZECN1S1 formatoOZECN1S1 = new FormatoOZECN1S1();
        formatoOZECN1S1.setNumtarj("74028595726849725910");

        txGlobalPositionMapper.mapOutOzn1S1(formatoOZECN1S1);
    }

}
