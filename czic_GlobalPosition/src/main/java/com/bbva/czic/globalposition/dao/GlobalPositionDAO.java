package com.bbva.czic.globalposition.dao;

import com.bbva.czic.globalposition.business.dto.DTOIntProduct;

import java.util.List;

public interface GlobalPositionDAO {

    List<DTOIntProduct> getExtractGlobalBalance(String customerId);

    void updateVisibility(String idProduct, Boolean visible);

    void updateOperability(String idProduct, Boolean operable);
}

