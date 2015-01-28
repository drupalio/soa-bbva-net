package com.bbva.czic.products.dao.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.czic.products.business.dto.DTOIntConditions;
import com.bbva.czic.products.business.dto.DTOIntProduct;
import com.bbva.czic.products.dao.IProductsDAO;
import com.bbva.czic.products.dao.tx.TxGetConditions;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.ErrorMappingHelper;

@Component(value = "products-dao")
public class ProductsDAOImpl  implements IProductsDAO {

    @Autowired
    private ErrorMappingHelper errorMappingHelper;

    @Resource(name = "tx-get-conditions")
    private TxGetConditions txGetConditions;

    @Override
    public DTOIntConditions getConditions(DTOIntProduct productId){
        return txGetConditions.invoke(productId);
    }
}

