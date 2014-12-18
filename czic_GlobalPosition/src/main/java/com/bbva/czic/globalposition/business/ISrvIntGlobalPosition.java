package com.bbva.czic.globalposition.business;

import java.util.List;


import com.bbva.czic.globalposition.business.dto.DTOIntProduct;


public interface ISrvIntGlobalPosition {
 	public List<DTOIntProduct> getExtractGlobalBalance(String customerId, String filter);

	public void updateProductVisibility(String idProduct, DTOIntProduct infoProduct);

	public void updateProductOperability(String idProduct, DTOIntProduct infoProduct);

}