package com.bbva.zic.globalposition.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import com.bbva.zic.globalposition.business.dto.DTOIntProductOperability;
import com.bbva.zic.globalposition.business.dto.DTOIntProductVisibility;
import com.bbva.zic.globalposition.dao.tx.TxGetExtractGlobalBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.bbva.zic.globalposition.business.dto.DTOIntProduct;
import com.bbva.zic.globalposition.business.dto.DTOIntProductFilter;
import com.bbva.zic.globalposition.dao.IGlobalPositionDAO;
import com.bbva.zic.globalposition.dao.tx.TxGetExtractGlobalBalanceNoTC;
import com.bbva.zic.routine.commons.rm.utils.tx.ISimpleTransaction;

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

	// private final String CREDIT_CARD_TYPE = "TC";

	@Override
	public List<DTOIntProduct> getExtractGlobalBalance(final DTOIntProductFilter filterProduct) {

		final List<DTOIntProduct> products;

		/*
		if (filterProduct.getProductType() == null || CREDIT_CARD_TYPE.equals(filterProduct.getProductType())) {
			products = txGetExtractGlobalBalanceNoTC.invoke(filterProduct);
		} else {
		*/
		products = txGetExtractGlobalBalance.invoke(filterProduct);
		//}
		return products;
	}

	@Override
	public void updateProductVisibility(final DTOIntProductVisibility productVisibility) {
		txUpdateProductVisibility.invoke(productVisibility);
	}

	@Override
	public void updateProductOperability(final DTOIntProductOperability productOperability) {
		txUpdateProductOperability.invoke(productOperability);
	}

}
