package com.bbva.czic.globalposition.business;

import java.util.List;

import com.bbva.czic.globalposition.business.dto.DTOIntProduct;

public interface ISrvIntGlobalPosition {

	public List<DTOIntProduct> getExtractGlobalBalance(String customerId);

	public void update(String idProduct, DTOIntProduct infoProduct);

}