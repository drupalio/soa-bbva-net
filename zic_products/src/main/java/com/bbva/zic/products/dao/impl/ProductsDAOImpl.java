package com.bbva.zic.products.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import com.bbva.zic.products.dao.IProductsDAO;
import com.bbva.zic.products.dao.tx.TxGetConditions;
import com.bbva.zic.products.dao.tx.TxGetMovement;
import com.bbva.zic.products.dao.tx.TxListExtracts;
import com.bbva.zic.products.dao.tx.TxListMovements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bbva.zic.products.business.dto.DTOIntConditions;
import com.bbva.zic.products.business.dto.DTOIntExtractOutput;
import com.bbva.zic.products.business.dto.DTOIntFilterExtract;
import com.bbva.zic.products.business.dto.DTOIntFilterMovements;
import com.bbva.zic.products.business.dto.DTOIntMovement;
import com.bbva.zic.products.business.dto.DTOIntProduct;
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

