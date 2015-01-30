package com.bbva.czic.products.facade.v01.mapper.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bbva.czic.dto.net.City;
import com.bbva.czic.dto.net.Conditions;
import com.bbva.czic.dto.net.Country;
import com.bbva.czic.dto.net.Extract;
import com.bbva.czic.dto.net.Location;
import com.bbva.czic.dto.net.Office;
import com.bbva.czic.products.business.dto.DTOIntConditions;
import com.bbva.czic.products.business.dto.DTOIntExtract;
import com.bbva.czic.products.business.dto.DTOIntFilterExtract;
import com.bbva.czic.products.business.dto.DTOIntProduct;
import com.bbva.czic.products.facade.v01.mapper.IProductsMapper;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.czic.routine.commons.rm.utils.fiql.FiqlType;
import com.bbva.czic.routine.commons.rm.utils.mappers.AbstractBbvaConfigurableMapper;
import com.bbva.czic.routine.mapper.MapperFactory;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

@Component(value = "products-mapper")
public class ProductsMapper extends AbstractBbvaConfigurableMapper implements
		IProductsMapper {

	@Override
	protected void configure(MapperFactory factory) {

		super.configure(factory);

		// Map DTOIntConditions <-> Conditions
		// factory.classMap(DTOIntConditions.class, Conditions.class)
		// .field("alias", "alias").field("category", "category")
		// .field("description", "description")
		// .field("openingDate", "openingDate")
		// .field("commission", "commission").byDefault().register();

	}

	@Override
	public Conditions map(DTOIntConditions intConditions) {
		final Conditions conditions = new Conditions();

		try {
			conditions.setCategory(intConditions.getCategory());
			conditions.setDescription(intConditions.getDescription());

			Calendar calendarOpeningDate = Calendar.getInstance();
			calendarOpeningDate.setTime(intConditions.getOpeningDate());

			conditions.setOpeningDate(calendarOpeningDate);
			conditions.setCommission(intConditions.getCommission());
			Office office = new Office();
			office.setName(intConditions.getOffice().getName());
			office.setPostalAddress(intConditions.getOffice()
					.getPostalAddress());

			Location location = new Location();

			City city = new City();
			city.setName(intConditions.getOffice().getLocation().getCity()
					.getName());
			location.setCity(city);

			Country country = new Country();
			country.setName(intConditions.getOffice().getLocation()
					.getCountry().getName());
			location.setCountry(country);

			office.setLocation(location);

			conditions.setOffice(office);
			// conditions.setMobilizationConditions(intConditions.getMobilizationConditions());

			// Activity activity = new Activity();

			// Calendar operationDate = Calendar.getInstance();
			// DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

			// operationDate.setTime(dateFormat.parse(intConditions.getActivities().getOperationDate()));
			// activity.setOperationDate(operationDate);

			// Calendar executionDate = Calendar.getInstance();
			// executionDate.setTime(Date.valueOf(intConditions.getActivities().getExecutionDate()));
			// activity.setExecutionDate(executionDate);

			// Function function = new Function();
			// function.setId(intConditions.getActivities().getFunction().getId());
			// function.setType(intConditions.getActivities().getFunction().getType().getEnumValue().toString());
			// activity.setFunction(function);
			// activity.setAmount(UtilsConverter.getMoneyDTO(new
			// BigDecimal(intConditions.getActivities().getAmount())));

			// activity.setReference(intConditions.getActivities().getReference());

			// List<Activity> activities = new ArrayList<Activity>();
			// activities.add(activity);
			// conditions.setActivities(activities);
		} catch (Exception e) {
			throw new BusinessServiceException(
					EnumError.TECHNICAL_ERROR.getAlias());
		}

		return conditions;
	}

	@Override
	public DTOIntProduct getDtoIntConditions(String productId) {
		DTOIntProduct dtoIntProduct = new DTOIntProduct();
		dtoIntProduct.setId(productId);
		return dtoIntProduct;
	}

	@Override
	public DTOIntFilterExtract getDtoIntFilterExtract(String productId,
			String filter, Integer paginationKey, Integer pageSize) {
		final String monthGe = this.getGeValue(filter,"month");
		final String monthLe = this.getLeValue(filter,"month");
		final String yearGe = this.getGeValue(filter,"year");
		final String yearLe = this.getLeValue(filter,"year");

		DTOIntFilterExtract dtoIntFilter = new DTOIntFilterExtract();
		dtoIntFilter.setProductId(productId);
		dtoIntFilter.setPaginationKey(paginationKey);
		dtoIntFilter.setPageSize(pageSize);
		dtoIntFilter.setStartMonth(monthGe);
		dtoIntFilter.setEndMonth(monthLe);
		dtoIntFilter.setStartYear(yearGe);
		dtoIntFilter.setEndYear(yearLe);
		
		return dtoIntFilter;
	}

	@Override
	public List<Extract> mapExtracts(List<DTOIntExtract> list) {
		List<Extract> extracts = new ArrayList<Extract>();
		for (DTOIntExtract dtoExtract : list) {			
			Extract extract = new Extract();
			extract.setMonth(dtoExtract.getMonth());
			extract.setYear(dtoExtract.getYear());
			extract.setUrl(dtoExtract.getUrl());
			extract.setGenerationDate(dtoExtract.getGenerationDate());
			extracts.add(extract);
		}
		return extracts;
	}

}