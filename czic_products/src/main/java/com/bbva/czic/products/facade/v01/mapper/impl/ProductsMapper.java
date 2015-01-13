package com.bbva.czic.globalposition.facade.v01.mapper.impl;

import com.bbva.czic.dto.net.*;
import com.bbva.czic.products.business.dto.*;
import com.bbva.czic.products.facade.v01.mapper.IGlobalPositionMapper;
import com.bbva.czic.routine.commons.rm.utils.mappers.Mapper;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component(value = "products-mapper")
public class ProductsMapper implements IProductsMapper{

	@Override
	public Conditions map(DTOIntConditions intConditions) {
		final Conditions conditions = new Conditions();

		conditions.setCategory(intConditions.getCategory());
		conditions.setDescription(intConditions.getDescription());
		conditions.setOpeningDate(intConditions.getOpeningDate());
		conditions.setCommission(intConditions.getCommission());
		conditions.setOffice(intConditions.getOffice());
		conditions.setMobilizationConditions(intConditions.getMobilizationConditions());
		conditions.setActivities(intConditions.getActivities());
		return conditions;
	}

}