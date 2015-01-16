package com.bbva.czic.globalposition.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.czic.globalposition.business.dto.DTOIntFilterProduct;
import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.business.dto.DTOIntProducts;
import com.bbva.czic.globalposition.dao.IGlobalPositionDAO;
import com.bbva.czic.routine.commons.rm.utils.tx.IPaginatedTransaction;
import com.bbva.czic.routine.commons.rm.utils.tx.ISimpleTransaction;

@Repository(value = "global-position-dao")
@Profile(value = "prod")
public class GlobalPositionDAO implements IGlobalPositionDAO {

	@Autowired
	@Qualifier("tx-get-extract-global-balance")
	private IPaginatedTransaction txGetExtractGlobalBalance;

	@Autowired
	@Qualifier("tx-get-extract-global-balance-no-tc")
	private IPaginatedTransaction txGetExtractGlobalBalanceNoTC;

	@Autowired
	@Qualifier("tx-update-product-visibility")
	private ISimpleTransaction txUpdateProductVisibility;

	@Autowired
	@Qualifier("tx-update-product-operability")
	private ISimpleTransaction txUpdateProductOperability;

	@Override
	public DTOIntProducts getExtractGlobalBalance(final DTOIntFilterProduct filterProduct) {

		final DTOIntProducts products = (DTOIntProducts)(filterProduct.getProductType() == null
				|| (filterProduct.getProductType().equals(EnumProductType.TC)) ? txGetExtractGlobalBalance
				.invoke(filterProduct) : txGetExtractGlobalBalanceNoTC.invoke(filterProduct));
		return products;
	}

	@Override
	public void updateProductVisibility(DTOIntProduct product) {
		txUpdateProductVisibility.invoke(product);
	}

	@Override
	public void updateProductOperability(DTOIntProduct product) {
		txUpdateProductOperability.invoke(product);
	}

}
