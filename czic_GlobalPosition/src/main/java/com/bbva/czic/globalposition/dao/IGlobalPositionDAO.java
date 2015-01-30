package com.bbva.czic.globalposition.dao;

import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.business.dto.DTOIntProductFilter;
import com.bbva.czic.globalposition.business.dto.DTOIntProductOperability;
import com.bbva.czic.globalposition.business.dto.DTOIntProductVisibility;

import java.util.List;

public interface IGlobalPositionDAO {
    
    List<DTOIntProduct> getExtractGlobalBalance(final DTOIntProductFilter filterProduct);

    void updateProductVisibility(final DTOIntProductVisibility productVisibility);

    void updateProductOperability(final DTOIntProductOperability productOperability);
}

