package com.bbva.czic.customers.facade.v01.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResumesFilter;
import com.bbva.czic.customers.facade.v01.mappers.ICustomerMapper;
import org.apache.cxf.jaxrs.model.wadl.ElementClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbva.czic.customers.business.ISrvIntCustomers;
import com.bbva.czic.customers.facade.v01.ISrvCustomersV01;
import com.bbva.czic.customers.facade.v01.utils.converters.IFilterConverter;
import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.CardCharge;
import com.bbva.czic.dto.net.Customer;
import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.czic.routine.commons.rm.utils.validator.impl.FiqlValidator;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.annotations.SMC;
import com.bbva.jee.arq.spring.core.servicing.annotations.SN;
import com.bbva.jee.arq.spring.core.servicing.annotations.VN;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

@Path("/V01")
@SN(registryID = "SNCO1400003", logicalID = "customers")
@VN(vnn = "V01")
@Api(value = "/customers/V01", description = "SN Customer")
@Produces({ MediaType.APPLICATION_JSON })
@Service
public class SrvCustomersV01 implements ISrvCustomersV01, com.bbva.jee.arq.spring.core.servicing.utils.ContextAware {

	private static I18nLog log = I18nLogFactory.getLogI18n(SrvCustomersV01.class,
			"META-INF/spring/i18n/log/mensajesLog");

	public HttpHeaders httpHeaders;

	@Autowired
	BusinessServicesToolKit businessServicesToolKit;

	@Resource(name = "customer-resumes-filter-converter")
	IFilterConverter filterConverter;

	@Resource(name = "customerMapper")
	private ICustomerMapper customerMapper;

	@Autowired
	ISrvIntCustomers srvIntCustomers;

	public UriInfo uriInfo;

	@Override
	public void setUriInfo(UriInfo ui) {
		this.uriInfo = ui;
	}

	@Override
	public void setHttpHeaders(HttpHeaders httpHeaders) {
		this.httpHeaders = httpHeaders;
	}

	public void setFilterConverter(IFilterConverter filterConverter) {
		this.filterConverter = filterConverter;
	}

	@Override
	@ApiOperation(value = "Returns the relationship between consumption and / or expenses of the customer in different business scopes", notes = "these are ordered items for all credit cards a client.", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Found Sucessfully", response = List.class),
			@ApiResponse(code = 400, message = "Wrong parameters"),
			@ApiResponse(code = 409, message = "Data not found"), @ApiResponse(code = 500, message = "Technical Error") })
	@GET
	@ElementClass(response = List.class)
	@Path("/{customerId}/creditCard/cardCharges")
	@SMC(registryID = "SMCCO1400006", logicalID = "getlistCreditCardsCharges")
	public List<CardCharge> listCreditCardsCharges(
			@ApiParam(value = "Claim identifier param") @PathParam("customerId") String customerId,
			@ApiParam(value = "filter param") @DefaultValue("null") @QueryParam("$filter") String filter) {

		log.info("Into listCreditCardsCharges...");

		// 1. Validate parameter
		if (customerId == null || customerId.trim().isEmpty()) {
			throw new BusinessServiceException(EnumError.WRONG_PARAMETERS.getAlias());
		}
		// 2. Validate filter FIQL
		new FiqlValidator(filter).exist().hasGeAndLe("chargeDate").validate();
		// 3. Invoke SrvIntCustomers and Mapping to canonical DTO
		return srvIntCustomers.getlistCreditCharges(customerId, filterConverter.toCardChargeFilter(filter));
	}

	@Override
	@ApiOperation(value = "Returns the list of summaries of balance all customer accounts per month", notes = "(income, expenses and balance)", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Found Sucessfully", response = List.class),
			@ApiResponse(code = 400, message = "Wrong parameters"),
			@ApiResponse(code = 409, message = "Data not found"), @ApiResponse(code = 500, message = "Technical Error") })
	@GET
	@ElementClass(response = List.class)
	@Path("/{customerId}/accounts/movementsResume")
	@SMC(registryID = "SMCCO1400007", logicalID = "getListAccountsMovementsResume")
	public List<AccMovementsResume> listAccountsMovementsResume(
			@ApiParam(value = "Claim identifier param") @PathParam("customerId") String customerId,
			@ApiParam(value = "filter param") @QueryParam("$filter") String filter) {

		log.info("Into listAccountsMovementsResume...");

		// 1. Validate filter FIQL
		new FiqlValidator(filter).exist().hasGeAndLe("month").validate();

		// 2. Mapping to DTOIntFilter
		final DTOIntAccMovementsResumesFilter filterCustomerResumes = customerMapper.getDTOIntMovementResumesFilter(customerId, filter);

		// 3. Invoke SrvIntCustomers and Mapping to canonical DTO
		List<DTOIntAccMovementsResume> accMovementsResumes = srvIntCustomers.getListAccountsMovementsResume(filterCustomerResumes);

		return customerMapper.map(accMovementsResumes);
	}

	@Override
	@ApiOperation(value = "Returns the customer information for showing in global position", notes = "Customer Information", response = List.class)
	@ApiResponses(value = { @ApiResponse(code = -1, message = "aliasGCE1"),
			@ApiResponse(code = -1, message = "aliasGCE2"),
			@ApiResponse(code = 200, message = "Found Sucessfully", response = Customer.class),
			@ApiResponse(code = 400, message = "Wrong parameters"),
			@ApiResponse(code = 409, message = "Data not found"), @ApiResponse(code = 500, message = "Technical Error") })
	@GET
	@ElementClass(response = Customer.class)
	@Path("/{customerId}")
	@SMC(registryID = "SMCCO1400023", logicalID = "getCustomer")
	public Customer getCustomer(@ApiParam(value = "Claim identifier param") @PathParam("customerId") String customerId) {

		log.info("Into getCustomer...");

		// 1. Invoke SrvIntCustomers and Mapping to canonical DTO
		return srvIntCustomers.getCustomer(customerId);
	}
}