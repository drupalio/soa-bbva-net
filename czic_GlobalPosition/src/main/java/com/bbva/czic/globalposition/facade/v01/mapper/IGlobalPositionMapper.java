package com.bbva.czic.globalposition.facade.v01.mapper;

import java.util.List;

import com.bbva.czic.dto.net.Product;
import com.bbva.czic.globalposition.business.dto.DTOIntProduct;

public interface IGlobalPositionMapper {

	List<Product> map(List<DTOIntProduct> products);

}