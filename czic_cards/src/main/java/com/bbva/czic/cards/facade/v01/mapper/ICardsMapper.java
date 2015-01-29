package com.bbva.czic.cards.facade.v01.mapper;

import com.bbva.czic.cards.business.dto.DTOIntCardCharge;
import com.bbva.czic.cards.business.dto.DTOIntFilterCards;
import com.bbva.czic.dto.net.*;

import java.util.List;

/**
 * Created by Entelgy on 12/01/2015.
 */
public interface ICardsMapper {

	DTOIntFilterCards map(String id, String filter);

	List<CardCharge> map(List<DTOIntCardCharge> charges);
}
