package com.bbva.czic.customers.facade.v01;

import java.util.List;
import javax.ws.rs.core.Response;

import com.bbva.czic.dto.net.CreditCard;
import com.bbva.czic.dto.net.Product;
import com.bbva.czic.dto.net.CardCharge;
import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.User;
import com.bbva.czic.dto.net.EnumCardChargeCategory;
import com.bbva.czic.dto.net.EnumMonth;


public interface ISrvCustomersV01 {
 	public List<CardCharge> listCreditCardsCharges(String idUser);

	public List<AccMovementsResume> listAccountsMovementsResume(String idUser);

}