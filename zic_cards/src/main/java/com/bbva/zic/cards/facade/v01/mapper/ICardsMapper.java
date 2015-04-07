package com.bbva.zic.cards.facade.v01.mapper;

import com.bbva.zic.cards.business.dto.DTOIntCardCharge;
import com.bbva.zic.cards.business.dto.DTOIntFilterCards;
import com.bbva.zic.dto.net.*;

import java.util.List;

/**
 * Created by Entelgy on 12/01/2015.
 */
public interface ICardsMapper {

	DTOIntFilterCards map(String id, String filter);

	List<CardCharge> map(List<DTOIntCardCharge> charges);
}
