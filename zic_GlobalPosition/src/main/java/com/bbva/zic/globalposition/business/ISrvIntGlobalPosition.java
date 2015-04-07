package com.bbva.zic.globalposition.business;

import java.util.List;

import com.bbva.zic.globalposition.business.dto.DTOIntProductFilter;
import com.bbva.zic.globalposition.business.dto.DTOIntProduct;
import com.bbva.zic.globalposition.business.dto.DTOIntProductOperability;
import com.bbva.zic.globalposition.business.dto.DTOIntProductVisibility;

public interface ISrvIntGlobalPosition {
 	public List<DTOIntProduct> getExtractGlobalBalance(DTOIntProductFilter filterProduct);

	public void updateProductVisibility(DTOIntProductVisibility productVisibility);

	public void updateProductOperability(DTOIntProductOperability productOperability);

}