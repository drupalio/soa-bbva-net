package com.bbva.czic.globalposition.dao;

import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GlobalPositionDAOImpl  implements GlobalPositionDAO {
    @Override
    public List<DTOIntProduct> getExtractGlobalBalance(String customerId) {
        return null;
    }
	
}