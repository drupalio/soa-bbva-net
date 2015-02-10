package com.bbva.czic.products.facade.v01;

import java.util.List;

import com.bbva.czic.dto.net.Conditions;
import com.bbva.czic.dto.net.Extract;
import com.bbva.czic.dto.net.Movement;


public interface ISrvProductsV01 {

    public Conditions getConditions(String productId);
    
    public List<Extract> listExtracts(String productId, String extractId, String filter);

    public Movement getMovement(String productId,String idMovement, String filter);

    public List<Movement> listMovements(String productId, String filter, Integer paginationKey, Integer pageSize);

}