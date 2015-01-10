package com.bbva.czic.globalposition.dao;

import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.czic.globalposition.business.dto.DTOIntFilterProduct;
import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.business.dto.DTOIntProducts;
import com.bbva.czic.routine.commons.rm.utils.tx.IPaginatedTransaction;
import com.bbva.czic.routine.commons.rm.utils.tx.ISimpleTransaction;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.ErrorMappingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository(value = "global-position-dao")
public class GlobalPositionDAOImpl implements GlobalPositionDAO {

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

	@Autowired
	private ErrorMappingHelper errorMappingHelper;

	@Override
	public DTOIntProducts getExtractGlobalBalance(final DTOIntFilterProduct filterProduct) {

		final DTOIntProducts products = (DTOIntProducts) ((filterProduct.getProductType().equals(EnumProductType.TC) || filterProduct.getProductType().equals(null)) ?
				txGetExtractGlobalBalance.invoke(filterProduct) : txGetExtractGlobalBalanceNoTC.invoke(filterProduct));
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
