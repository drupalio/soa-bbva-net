package com.bbva.czic.products.facade.v01;

import java.util.List;

import com.bbva.czic.dto.net.Conditions;
import com.bbva.czic.dto.net.Extract;


public interface ISrvProductsV01 {

    public Conditions getConditions(String productId);
    
    public List<Extract> listExtracts(String productId, String filter, Integer paginationKey, Integer pageSize);
}