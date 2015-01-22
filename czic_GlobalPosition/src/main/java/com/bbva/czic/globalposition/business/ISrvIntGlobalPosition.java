package com.bbva.czic.globalposition.business;

import java.util.List;

import com.bbva.czic.globalposition.business.dto.DTOIntProductFilter;
import com.bbva.czic.globalposition.business.dto.DTOIntProduct;

public interface ISrvIntGlobalPosition {
 	public List<DTOIntProduct> getExtractGlobalBalance(DTOIntProductFilter filterProduct);

	public void updateProductVisibility(DTOIntProduct productInt);

	public void updateProductOperability(DTOIntProduct productInt);

}