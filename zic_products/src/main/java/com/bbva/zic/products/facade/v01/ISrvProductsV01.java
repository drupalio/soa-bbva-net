package com.bbva.zic.products.facade.v01;

import java.util.List;

import com.bbva.zic.dto.net.AccMoveDetail;
import com.bbva.zic.dto.net.Conditions;
import com.bbva.zic.dto.net.Extract;
import com.bbva.zic.dto.net.Movement;


public interface ISrvProductsV01 {

    public Conditions getConditions(String productId);
    
    public List<Extract> listExtracts(String productId, String filter);

    public AccMoveDetail getMovement(String productId,String idMovement, String filter);

    public List<Movement> listMovements(String productId, String filter, Integer paginationKey, Integer pageSize);

}