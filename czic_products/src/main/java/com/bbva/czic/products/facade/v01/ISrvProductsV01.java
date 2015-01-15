package com.bbva.czic.products.facade.v01;

import com.bbva.czic.dto.net.Conditions;


public interface ISrvProductsV01 {

    public Conditions getConditions(String productId);
}