package com.bbva.czic.products.facade.v01.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import com.bbva.czic.dto.net.*;
import com.bbva.czic.products.business.dto.*;
import org.hibernate.id.enhanced.AccessCallback;
import org.springframework.stereotype.Component;

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
		factory.classMap(DTOIntHolder.class, Holder.class)
				.field("name", "name")
				.field("alias", "alias")
				.byDefault().register();

		// Map DTOIntConditions <-> Conditions
		factory.classMap(DTOIntConditions.class, Conditions.class)
				.field("type", "type")
				.field("alias", "alias")
				.field("category", "category")
				.field("description", "description")
				.field("openingDate", "openingDate")
				.field("commission", "commission")
				.field("mobilizationConditions", "mobilizationConditions")
				.field("office.name", "office.name")
				.field("office.postalAddress", "office.postalAddress")
				.field("office.location.city.name", "office.location.city.name")
				.field("office.location.country.name", "office.location.country.name")
				.field("activity", "activity")
				.field("holders", "holders")
				.register();

		// Add ProductDTO Factory
		factory.registerObjectFactory(new MoneyFactory(),
				TypeFactory.<Money> valueOf(Money.class));

		// Movement
		factory.classMap(AccMoveDetail.class, DTOIntMovement.class)
				.field("id", "id")
				.field("concept", "concept")
				.field("value", "value")
				.field("balance", "balance")
				.field("operation.code", "operation.code")
				.field("operation.description", "operation.description")
				.field("transactionDate", "transactionDate")
				.field("operationDate", "operationDate")
				.field("office.postalAddress", "office.postalAddress")
				.field("office.name", "office.name")
				.field("office.location.city.name", "office.location.city.name")
				.field("office.location.state.name", "office.location.dtoIntState.name")
				.field("originValue", "originValue")
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
		return map(intConditions, Conditions.class);
	}

	@Override
	public DTOIntProduct getDtoIntConditions(String productId) {
		DTOIntProduct dtoIntProduct = new DTOIntProduct();
		dtoIntProduct.setId(productId);
		return dtoIntProduct;
	}

	@Override
	public DTOIntFilterMovements getDTOIntFilterGetMovement(String productId,String movementId, String filter) {

		final String productType = this.getEqValue(filter, FiqlType.productType.name());

		final DTOIntFilterMovements dtoIntFilterMovements = new DTOIntFilterMovements();
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
		final String productType = this.getEqValue(filter, FiqlType.productType.name());

		final DTOIntFilterMovements dtoIntFilterMovements = new DTOIntFilterMovements();
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

	/**Mapeo del Filtro al DTO del filtro para la entrada de la transacción,
	 * si es para el modo listado de extractos, el filtro debe ir nulo, de lo contrario
	 * este debe incluir el extractId o código externo, mes y año obligatoriamente
	 * 
	 * @param productId identificador del producto
	 * @param filter filtro de la URL
	 * 
	 */
	@Override
	public DTOIntFilterExtract getDtoIntFilterExtract(String productId,
			String filter) {
		DTOIntFilterExtract dtoIntFilter = new DTOIntFilterExtract();
		if (filter != null) {
			final String month = this.getEqValue(filter, "month");
			final String year = this.getEqValue(filter, "year");
			final String extractId = this.getEqValue(filter, "extractId");
			dtoIntFilter.setExtractId(extractId);
			dtoIntFilter.setMonth(month);
			dtoIntFilter.setYear(year);
		}

		dtoIntFilter.setProductId(productId);

		return dtoIntFilter;
	}

	/**Mapeo de salida del dto extractos a la entidad canónica, la única diferencia entre estas entidades
	 * es el código de control que no se sabe en realidad para que se usa pero que sin embargo, para efectos
	 * futuros, se captura.
	 * 
	 * @param list Listado de extractos en el dto interno
	 * 
	 */
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
	public AccMoveDetail mapMovement(DTOIntMovement dtoIntMovement) {
		log.info("map- return:Account-parameter:dtoIntAccount");
		return map(dtoIntMovement,AccMoveDetail.class);
	}

	@Override
	public List<Movement> mapMovements(List<DTOIntMovement> listaDTOIntMovements) {
		return mapAsList(listaDTOIntMovements, Movement.class);
	}


}