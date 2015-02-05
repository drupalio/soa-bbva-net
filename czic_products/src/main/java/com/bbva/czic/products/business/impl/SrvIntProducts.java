package com.bbva.czic.products.business.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.bbva.czic.products.business.dto.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbva.czic.products.business.ISrvIntProducts;
import com.bbva.czic.products.business.dto.DTOIntConditions;
import com.bbva.czic.products.business.dto.DTOIntExtract;
import com.bbva.czic.products.business.dto.DTOIntFilterExtract;
import com.bbva.czic.products.business.dto.DTOIntProduct;
import com.bbva.czic.products.dao.IProductsDAO;
import com.bbva.czic.routine.commons.rm.utils.validator.DtoValidator;
import com.bbva.czic.routine.commons.rm.utils.validator.impl.DateValidator;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;

import java.util.List;

@Service
public class SrvIntProducts implements ISrvIntProducts {

	private static I18nLog log = I18nLogFactory.getLogI18n(
			SrvIntProducts.class, "META-INF/spring/i18n/log/mensajesLog");

	@Autowired
	BusinessServicesToolKit bussinesToolKit;

	@Resource(name = "products-dao")
	IProductsDAO productsDAO;

	@Override
	public DTOIntConditions getConditions(DTOIntProduct dtoIntConditions) {
		// 1. Validate DtoIntFilterAccount
		DtoValidator.validate(dtoIntConditions);

		// 2. Get response
		final DTOIntConditions result = productsDAO
				.getConditions(dtoIntConditions);

		// 3. Validate output
		DtoValidator.validate(result);

		log.info(" getConditions Conditions ");
		return result;
	}

	@Override
	public List<DTOIntExtract> listExtracts(DTOIntFilterExtract dtoIntFilterExtract) {
		// 1. Validate DtoIntFilterAccount
		DtoValidator.validate(dtoIntFilterExtract);
		
		if (dtoIntFilterExtract.getExtractId() != null) {
			@SuppressWarnings("deprecation")
			DateValidator validator = (DateValidator) new DateValidator()
					.noFuture(
							new Date(dtoIntFilterExtract.getEndYear() + "-"
									+ dtoIntFilterExtract.getEndMonth() + "-01"))
					.equals(new Date(dtoIntFilterExtract.getStartYear() + "-"
							+ dtoIntFilterExtract.getStartMonth() + "-01"),
							new Date(dtoIntFilterExtract.getEndYear() + "-"
									+ dtoIntFilterExtract.getEndMonth() + "-01"))
					.validate();
		} else {
			@SuppressWarnings("deprecation")
			DateValidator validator = (DateValidator) new DateValidator()
					.noFuture(
							new Date(dtoIntFilterExtract.getStartYear() + "-"
									+ dtoIntFilterExtract.getStartMonth()
									+ "-01"))
					.validDateRange(
							new Date(dtoIntFilterExtract.getStartYear() + "-"
									+ dtoIntFilterExtract.getStartMonth()
									+ "-01"),
							new Date(dtoIntFilterExtract.getEndYear() + "-"
									+ dtoIntFilterExtract.getEndMonth() + "-01"))
					.validate();
		}

		// 2. Get response
		final List<DTOIntExtract> result = productsDAO
				.listExtracts(dtoIntFilterExtract);

		// 3. Validate output
		DtoValidator.validate(result);

		log.info(" getConditions Conditions ");
		return result;
	}

	@Override
	public DTOIntMovement getMovement(DTOIntFilterMovements dtoIntMovementsFilter) {
		// 1. Validate DtoIntFilterAccount
		DtoValidator.validate(dtoIntMovementsFilter);

		// 2. Get response
		final DTOIntMovement result = productsDAO.getMovement(dtoIntMovementsFilter);

		// 3. Validate output
		DtoValidator.validate(result);

		log.info(" getConditions Conditions ");
		return result;
	}

	@Override
	public List<DTOIntMovement> listMovements(DTOIntFilterMovements filter) {
		// 1. Validate DtoIntFilterAccount
		DtoValidator.validate(filter);

		// 2. Get response
		final List<DTOIntMovement> result = productsDAO.listMovements(filter);

		// 3. Validate output
		DtoValidator.validate(result);

		log.info(" getConditions Conditions ");
		return result;
	}

}
