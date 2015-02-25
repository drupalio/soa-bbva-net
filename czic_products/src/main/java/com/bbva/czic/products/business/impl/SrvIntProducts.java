package com.bbva.czic.products.business.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbva.czic.products.business.ISrvIntProducts;
import com.bbva.czic.products.business.dto.DTOIntConditions;
import com.bbva.czic.products.business.dto.DTOIntExtract;
import com.bbva.czic.products.business.dto.DTOIntExtractOutput;
import com.bbva.czic.products.business.dto.DTOIntFilterExtract;
import com.bbva.czic.products.business.dto.DTOIntFilterMovements;
import com.bbva.czic.products.business.dto.DTOIntMovement;
import com.bbva.czic.products.business.dto.DTOIntProduct;
import com.bbva.czic.products.dao.IProductsDAO;
import com.bbva.czic.routine.commons.rm.utils.EDateFormat;
import com.bbva.czic.routine.commons.rm.utils.validator.DtoValidator;
import com.bbva.czic.routine.commons.rm.utils.validator.impl.DateValidator;
import com.bbva.czic.routine.commons.rm.utils.validator.impl.StringValidator;
import com.bbva.jee.arq.spring.core.log.I18nLog;
import com.bbva.jee.arq.spring.core.log.I18nLogFactory;
import com.bbva.jee.arq.spring.core.servicing.utils.BusinessServicesToolKit;

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

	/**Aquí se realiza el llamado al dao. De primera mano se realiza la validación del productId del filtro, y en caso
	 * de ser en modo de obtención de extracto, realiza las validaciones del extractId, del mes y del año. Así mismo que el dto
	 * de salida tenga la lista no nula, así sea vacía.
	 * 
	 */
	@Override
	public List<DTOIntExtract> listExtracts(DTOIntFilterExtract dtoIntFilterExtract) {
		// 1. Validate DtoIntFilterAccount
		DtoValidator.validate(dtoIntFilterExtract);
		
		if (dtoIntFilterExtract.getExtractId() != null) {
			new StringValidator()
					.isNumericText(dtoIntFilterExtract.getExtractId())
					.isNumericMonth(dtoIntFilterExtract.getMonth())
					.isNumericText(dtoIntFilterExtract.getYear())
					.validate();
			new DateValidator().noFuture(dtoIntFilterExtract.getMonth()+dtoIntFilterExtract.getYear(),EDateFormat.MES_ANIO);
		} 

		// 2. Get response
		final DTOIntExtractOutput result = productsDAO
				.listExtracts(dtoIntFilterExtract);

		// 3. Validate output
		DtoValidator.validate(result);

		log.info(" listExtracts Extract ");
		return result.getExtracts();
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
