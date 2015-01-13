package com.bbva.czic.globalposition.dao;

import com.bbva.czic.globalposition.business.dto.DTOIntFilterProduct;
import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.business.dto.DTOIntProducts;
import com.bbva.jee.arq.spring.core.host.transporte.ExcepcionTransporte;

import java.util.List;

public interface IGlobalPositionDAO {
    
    DTOIntProducts getExtractGlobalBalance(DTOIntFilterProduct filterProduct);

    void updateProductVisibility(DTOIntProduct product);

    void updateProductOperability(DTOIntProduct product);
}
