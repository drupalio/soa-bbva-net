package com.bbva.czic.products.facade.v01.mapper.impl;

import com.bbva.czic.dto.net.*;
import com.bbva.czic.products.business.dto.DTOIntConditions;
import com.bbva.czic.products.facade.v01.IProductsMapper;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Component(value = "products-mapper")
public class ProductsMapper implements IProductsMapper{

	@Override
	public Conditions map(DTOIntConditions intConditions) {
		final Conditions conditions = new Conditions();

		conditions.setCategory(intConditions.getCategory());
		conditions.setDescription(intConditions.getDescription());

		Calendar calendarOpeningDate = Calendar.getInstance();
		calendarOpeningDate.setTime(intConditions.getOpeningDate());

		conditions.setOpeningDate(calendarOpeningDate);
		conditions.setCommission(intConditions.getCommission());
		Office office = new Office();
		office.setName(intConditions.getOffice().getName());
		office.setPostalAddress(intConditions.getOffice().getPostalAddress());

		Location location = new Location();

		City city = new City();
		city.setName(intConditions.getOffice().getLocation().getCity().getName());
		location.setCity(city);

		Country country = new Country();
		country.setName(intConditions.getOffice().getLocation().getCountry().getName());
		location.setCountry(country);

		office.setLocation(location);

		conditions.setOffice(office);
		conditions.setMobilizationConditions(intConditions.getMobilizationConditions());

		Activity activity = new Activity();

		Calendar operationDate = Calendar.getInstance();
		operationDate.setTime(Date.valueOf(intConditions.getActivities().getOperationDate()));
		activity.setOperationDate(operationDate);

		Calendar executionDate = Calendar.getInstance();
		executionDate.setTime(Date.valueOf(intConditions.getActivities().getExecutionDate()));
		activity.setExecutionDate(executionDate);

		Function function = new Function();
		function.setId(intConditions.getActivities().getFunction().getId());
		function.setType(EnumFunctionType.valueOf(intConditions.getActivities().getFunction().getType().getEnumValue()));
		activity.setFunction(function);

		Money money = new Money();
		money.setAmount(new BigDecimal(intConditions.getActivities().getAmount()));
		activity.setAmount(money);

		activity.setReference(intConditions.getActivities().getReference());

		List<Activity> activities = new ArrayList<Activity>();
		activities.add(activity);
		conditions.setActivities(activities);

		return conditions;
	}

}