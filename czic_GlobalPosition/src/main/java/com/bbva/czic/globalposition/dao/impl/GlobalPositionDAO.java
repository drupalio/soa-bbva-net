package com.bbva.czic.globalposition.dao.impl;

import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.czic.globalposition.business.dto.DTOIntProductFilter;
import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.dao.IGlobalPositionDAO;
import com.bbva.czic.globalposition.dao.tx.TxGetExtractGlobalBalance;
import com.bbva.czic.globalposition.dao.tx.TxGetExtractGlobalBalanceNoTC;
import com.bbva.czic.routine.commons.rm.utils.tx.ISimpleTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository(value = "global-position-dao")
public class GlobalPositionDAO implements IGlobalPositionDAO {

	@Resource(name = "tx-get-extract-global-balance")
	private TxGetExtractGlobalBalance txGetExtractGlobalBalance;

	@Resource(name = "tx-get-extract-global-balance-no-tc")
	private TxGetExtractGlobalBalanceNoTC txGetExtractGlobalBalanceNoTC;

	@Autowired
	@Qualifier("tx-update-product-visibility")
	private ISimpleTransaction txUpdateProductVisibility;

	@Autowired
	@Qualifier("tx-update-product-operability")
	private ISimpleTransaction txUpdateProductOperability;

	@Override
	public List<DTOIntProduct> getExtractGlobalBalance(final DTOIntProductFilter filterProduct) {

		final List<DTOIntProduct> products;

		if (filterProduct.getProductType() == null || filterProduct.getProductType().equals(EnumProductType.TC.name())) {
			products = txGetExtractGlobalBalance.invoke(filterProduct);
		} else {
			products = txGetExtractGlobalBalanceNoTC.invoke(filterProduct);
		}
		return products;
	}

	@Override
	public void updateProductVisibility(final DTOIntProduct product) {
		txUpdateProductVisibility.invoke(product);
	}

	@Override
	public void updateProductOperability(final DTOIntProduct product) {
		txUpdateProductOperability.invoke(product);
	}

}
