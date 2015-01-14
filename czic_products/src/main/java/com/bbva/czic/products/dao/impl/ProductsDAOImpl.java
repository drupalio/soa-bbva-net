package com.bbva.czic.products.dao.impl;

import com.bbva.czic.products.business.dto.DTOIntConditions;
import com.bbva.czic.products.dao.IProductsDAO;
import com.bbva.czic.routine.commons.rm.utils.tx.ISimpleTransaction;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.ErrorMappingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository(value = "products-dao")
public class ProductsDAOImpl  implements IProductsDAO {

    @Autowired
    private ErrorMappingHelper errorMappingHelper;

    @Autowired
    @Qualifier("tx-get-conditions")
    private ISimpleTransaction txGetConditions;

    @Override
    public DTOIntConditions getConditions(String productId){
        return txGetConditions.invoke(productId);
    }
}

