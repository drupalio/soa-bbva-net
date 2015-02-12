package com.bbva.czic.products.facade.v01.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bbva.czic.dto.net.City;
import com.bbva.czic.dto.net.Conditions;
import com.bbva.czic.dto.net.Extract;
import com.bbva.czic.dto.net.Location;
import com.bbva.czic.dto.net.Movement;
import com.bbva.czic.dto.net.Office;
import com.bbva.czic.dto.net.State;
import com.bbva.czic.products.business.dto.DTOIntCity;
import com.bbva.czic.products.business.dto.DTOIntConditions;
import com.bbva.czic.products.business.dto.DTOIntExtract;
import com.bbva.czic.products.business.dto.DTOIntFilterExtract;
import com.bbva.czic.products.business.dto.DTOIntFilterMovements;
import com.bbva.czic.products.business.dto.DTOIntLocation;
import com.bbva.czic.products.business.dto.DTOIntMovement;
import com.bbva.czic.products.business.dto.DTOIntOffice;
import com.bbva.czic.products.business.dto.DTOIntProduct;
import com.bbva.czic.products.business.dto.DTOIntState;
import com.bbva.czic.products.facade.v01.mapper.IProductsMapper;
import com.bbva.czic.routine.commons.rm.utils.fiql.FiqlType;
import com.bbva.czic.routine.commons.rm.utils.mappers.AbstractBbvaConfigurableMapper;
import com.bbva.czic.routine.mapper.MapperFactory;
import com.bbva.czic.routine.mapper.factory.MoneyFactory;
import com.bbva.czic.routine.mapper.metadata.TypeFactory;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;

@Component(value = "products-mapper")
public class ProductsMapper extends AbstractBbvaConfigurableMapper implements
		IProductsMapper {

	@Override
	protected void configure(MapperFactory factory) {

		super.configure(factory);

		// Map DTOIntConditions <-> Conditions
		factory.classMap(Conditions.class, DTOIntConditions.class)
				.field("alias", "alias")
				.field("category", "category")
				.field("description", "description")
				.field("openingDate", "openingDate")
				.field("commission", "commission")
				.field("office.name", "office.name")
				.field("office.postalAddress", "office.postalAddress")
				.field("office.location.city.name", "office.location.city.name")
				.field("office.location.country.name", "office.location.country.name")
				.field("mobilizationConditions", "mobilizationConditions")
				.byDefault()
				.register();

		// Add ProductDTO Factory
		factory.registerObjectFactory(new MoneyFactory(),
				TypeFactory.<Money> valueOf(Money.class));

		// Movement
		factory.classMap(Movement.class, DTOIntMovement.class)
				.field("id", "id").field("concept", "concept")
				.field("transactionDate", "transactionDate")
				.field("operationDate", "operationDate")
				.field("office", "office").field("status", "status")
				.field("value", "value").field("balance", "balance")
				.byDefault().register();
		// Office
		factory.classMap(Office.class, DTOIntOffice.class)
				.field("name", "name").field("location", "location")
				.byDefault().register();

		// Location
		factory.classMap(Location.class, DTOIntLocation.class)
				.field("city", "city").field("state", "dtoIntState")
				.byDefault().register();

		// City
		factory.classMap(City.class, DTOIntCity.class).field("name", "name")
				.byDefault().register();

		// State
		factory.classMap(State.class, DTOIntState.class).field("name", "name")
				.byDefault().register();

		// Money
		factory.classMap(Money.class, Money.class).field("amount", "amount")
				.field("currency", "currency").byDefault().register();

	}

	@Override
	public Conditions map(DTOIntConditions intConditions) {
		log.info("map- return:Conditions-parameter:DTOIntConditions");
		return map(intConditions,Conditions.class);
	}

	@Override
	public DTOIntProduct getDtoIntConditions(String productId) {
		DTOIntProduct dtoIntProduct = new DTOIntProduct();
		dtoIntProduct.setId(productId);
		return dtoIntProduct;
	}

	@Override
	public DTOIntFilterMovements getDTOIntFilterGetMovement(String productId,String movementId, String filter) {

		final String customerId = this.getEqValue(filter, FiqlType.customerId.name());
		final String productType = this.getEqValue(filter, FiqlType.productType.name());

		final DTOIntFilterMovements dtoIntFilterMovements = new DTOIntFilterMovements();
		dtoIntFilterMovements.setCustomerId(customerId);
		dtoIntFilterMovements.setProductType(productType);
		dtoIntFilterMovements.setProductId(productId);
		dtoIntFilterMovements.setMovementId(movementId);

		return dtoIntFilterMovements;

	}

	@Override
	public DTOIntFilterMovements getDTOIntFilterGetListMovements(String productId,String filter,Integer paginationKey,  Integer pageSize) {

		final String transactionDateStart = this.getGeValue(filter, FiqlType.transactionDate.name());
		final String transactionDateEnd = this.getLeValue(filter, FiqlType.transactionDate.name());
		final String valueStart = this.getGeValue(filter, FiqlType.value.name());
		final String valueEnd = this.getLeValue(filter, FiqlType.value.name());
		final String customerId = this.getEqValue(filter, FiqlType.customerId.name());
		final String productType = this.getEqValue(filter, FiqlType.productType.name());

		final DTOIntFilterMovements dtoIntFilterMovements = new DTOIntFilterMovements();
		dtoIntFilterMovements.setCustomerId(customerId);
		dtoIntFilterMovements.setProductType(productType);
		dtoIntFilterMovements.setProductId(productId);
		dtoIntFilterMovements.setPageSize(pageSize);
		dtoIntFilterMovements.setPaginationKey(paginationKey);
		dtoIntFilterMovements.setTransactionDateStart(transactionDateStart);
		dtoIntFilterMovements.setTransactionDateEnd(transactionDateEnd);
		dtoIntFilterMovements.setValueStart(valueStart);
		dtoIntFilterMovements.setValueEnd(valueEnd);

		return dtoIntFilterMovements;


	}

	public DTOIntFilterExtract getDtoIntFilterExtract(String productId, String filter) {
		final String month = this.getEqValue(filter,"month");
		final String year = this.getEqValue(filter,"year");
		final String extractId = this.getEqValue(filter,"extractId");

		DTOIntFilterExtract dtoIntFilter = new DTOIntFilterExtract();
		dtoIntFilter.setExtractId(extractId);
		dtoIntFilter.setProductId(productId);
		dtoIntFilter.setMonth(month);
		dtoIntFilter.setYear(year);
		
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
			extract.setExternalCode(dtoExtract.getExtCode());
			extracts.add(extract);
		}
		return extracts;
	}

	@Override
	public Movement mapMovement(DTOIntMovement dtoIntMovement) {
		log.info("map- return:Account-parameter:dtoIntAccount");
		return map(dtoIntMovement,Movement.class);
	}

	@Override
	public List<Movement> mapMovements(List<DTOIntMovement> listaDTOIntMovements) {
		return mapAsList(listaDTOIntMovements, Movement.class);
	}


}