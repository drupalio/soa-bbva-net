package com.bbva.czic.globalposition.dao;

import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.business.dto.DTOIntProductFilter;

import java.util.List;

public interface IGlobalPositionDAO {
    
    List<DTOIntProduct> getExtractGlobalBalance(final DTOIntProductFilter filterProduct);

    void updateProductVisibility(final DTOIntProduct product);

    void updateProductOperability(final DTOIntProduct product);
}

