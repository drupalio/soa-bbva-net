package com.bbva.czic.globalposition.facade.v01.mappers;

import com.bbva.czic.dto.net.*;
import com.bbva.czic.globalposition.business.dto.*;

import java.util.List;

public interface IGlobalPositionMapper {

    List<Product> map(List<DTOIntProduct> products);

    DTOIntProductFilter getDTOIntFilter(String customerId, String filter);
}