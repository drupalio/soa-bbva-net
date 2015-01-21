package com.bbva.czic.movements.facade.v01;

import com.bbva.czic.dto.net.AccMoveDetail;
import com.bbva.czic.dto.net.Movement;

import java.util.List;


public interface ISrvMovementsV01 {

	public Movement getMovement(String idMovement, String filter);

	public List<Movement> listMovements(String idMovement, String filter, Integer paginationKey, Integer pageSize);
}
