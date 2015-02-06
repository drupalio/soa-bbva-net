package com.bbva.czic.products.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.czic.products.business.dto.DTOIntConditions;
import com.bbva.czic.products.business.dto.DTOIntExtractOutput;
import com.bbva.czic.products.business.dto.DTOIntFilterExtract;
import com.bbva.czic.products.business.dto.DTOIntFilterMovements;
import com.bbva.czic.products.business.dto.DTOIntMovement;
import com.bbva.czic.products.business.dto.DTOIntProduct;
import com.bbva.czic.products.dao.IProductsDAO;
import com.bbva.czic.products.dao.tx.TxGetConditions;
import com.bbva.czic.products.dao.tx.TxGetMovement;
import com.bbva.czic.products.dao.tx.TxListExtracts;
import com.bbva.czic.products.dao.tx.TxListMovements;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.ErrorMappingHelper;

@Component(value = "products-dao")
public class ProductsDAOImpl  implements IProductsDAO {

    @Autowired
    private ErrorMappingHelper errorMappingHelper;

    @Resource(name = "tx-get-conditions")
    private TxGetConditions txGetConditions;
    
    @Resource(name = "tx-list-extracts")
    private TxListExtracts txListExtracts;

    @Resource(name = "tx-get-movement")
    private TxGetMovement txGetMovement;

    @Resource(name = "tx-list-movements")
    private TxListMovements txListMovements;

    @Override
    public DTOIntConditions getConditions(DTOIntProduct productId){
        return txGetConditions.invoke(productId);
    }

	@Override
	public DTOIntExtractOutput listExtracts(DTOIntFilterExtract dtoIntFilterExtract) {
		return txListExtracts.invoke(dtoIntFilterExtract);
	}

    @Override
    public DTOIntMovement getMovement(DTOIntFilterMovements dtoIntFilterMovements){
        return txGetMovement.invoke(dtoIntFilterMovements);
    }

    @Override
    public List<DTOIntMovement> listMovements(DTOIntFilterMovements dtoIntFilterMovements) {
        return txListMovements.invoke(dtoIntFilterMovements);
    }
}

