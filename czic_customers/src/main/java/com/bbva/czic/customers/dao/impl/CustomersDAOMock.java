package com.bbva.czic.customers.dao.impl;

import java.math.BigDecimal;

import com.bbva.czic.customers.dao.model.oznb.FormatoOZNCSNB0;
import com.bbva.czic.customers.dao.model.oznp.FormatoOZECNPS0;
import com.bbva.czic.customers.dao.model.oznq.FormatoOZECNQS0;

public class CustomersDAOMock {

	public static FormatoOZECNPS0 getListCreditCardCharges() {
		FormatoOZECNPS0 formato = new FormatoOZECNPS0();
		formato.setCategor("COMERCIOBASICO                     ");
		formato.setValcate(BigDecimal.valueOf(00000000001000000));
		return formato;
	}

	public static FormatoOZECNQS0 getListAccountMovementsResume() {
		FormatoOZECNQS0 formato = new FormatoOZECNQS0();
		formato.setMes("ABRIL");
		formato.setSaltota(BigDecimal.valueOf(00000000001000000));
		formato.setValcarg(BigDecimal.valueOf(00000000000200000));
		formato.setValdepo(BigDecimal.valueOf(00000000001200000));
		return formato;
	}

	public static FormatoOZNCSNB0 getCustomer() {
		FormatoOZNCSNB0 formato = new FormatoOZNCSNB0();
		return formato;
	}

}
