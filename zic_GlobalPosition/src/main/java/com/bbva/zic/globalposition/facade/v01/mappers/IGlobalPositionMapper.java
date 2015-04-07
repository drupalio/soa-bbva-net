package com.bbva.zic.globalposition.facade.v01.mappers;

import com.bbva.zic.dto.net.*;
import com.bbva.zic.globalposition.business.dto.DTOIntProduct;
import com.bbva.zic.globalposition.business.dto.DTOIntProductFilter;

import java.util.List;

public interface IGlobalPositionMapper {

    List<Product> map(List<DTOIntProduct> products);

    DTOIntProductFilter getDTOIntFilter(String filter);

    Product map(DTOIntProduct intProduct);

    DTOIntProduct map(Product product);

    DTOIntProduct getDTOInt(String productId, Product product);
}