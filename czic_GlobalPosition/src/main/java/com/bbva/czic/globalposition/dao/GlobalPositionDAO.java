package com.bbva.czic.globalposition.dao;

import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.jee.arq.spring.core.host.transporte.ExcepcionTransporte;

import java.util.List;

public interface GlobalPositionDAO {
    
    List<DTOIntProduct> getExtractGlobalBalance(String customerId) throws ExcepcionTransporte;

    void updateProductVisibility(String idProduct, Boolean visible);

    void updateProductOperability(String idProduct, Boolean operable);
}

