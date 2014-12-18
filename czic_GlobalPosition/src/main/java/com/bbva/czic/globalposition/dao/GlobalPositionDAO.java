package com.bbva.czic.globalposition.dao;

import java.util.List;

import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.jee.arq.spring.core.host.transporte.ExcepcionTransporte;

public interface GlobalPositionDAO {

	public List<DTOIntProduct> getExtractGlobalBalance(String customerId) throws ExcepcionTransporte;

	public void updateProductVisibility(String idProduct, DTOIntProduct infoProduct);

	public void updateProductOperability(String idProduct, DTOIntProduct infoProduct);
}
