package com.bbva.czic.globalposition.business;

import java.util.List;

import com.bbva.czic.dto.net.Product;
import com.bbva.czic.globalposition.business.dto.DTOIntProduct;

public interface ISrvIntGlobalPosition {
 	public List<DTOIntProduct> getExtractGlobalBalance(String customerId, String filter);

	public void updateProductVisibility(DTOIntProduct productInt);

	public void updateProductOperability(DTOIntProduct productInt);

}