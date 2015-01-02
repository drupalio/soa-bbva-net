package com.bbva.czic.customers.facade.v01;

import java.util.List;

import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.CardCharge;


public interface ISrvCustomersV01 {
 	public List<CardCharge> getlistCreditCardsCharges(String idUser,String fechaini , String fechafi);

		public List<AccMovementsResume> getlistAccountsMovementsResume(String idUser, String fechaini , String fechafi);

	
}