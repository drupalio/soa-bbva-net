package com.bbva.czic.products.dao;

import com.bbva.czic.products.business.dto.DTOIntProducts;
import com.bbva.czic.products.business.dto.DTOIntConditions;
import com.bbva.czic.products.dao.IProductsDAO;
import com.bbva.czic.routine.commons.rm.utils.tx.IPaginatedTransaction;
import com.bbva.czic.routine.commons.rm.utils.tx.ISimpleTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.lang.Override;

@Repository(value = "products-dao")
public class ProductsDAOImpl  implements IProductsDAO {

    @Autowired
    @Qualifier("tx-get-extract-global-balance")
    private ISimpleTransaction txGetConditions;

    @Override
    public DTOIntConditions getConditions(final DTOIntConditions dtoIntConditions){

        final
    }
}

