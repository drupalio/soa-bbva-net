package com.bbva.czic.movements.facade.v01;

import com.bbva.czic.dto.net.AccMoveDetail;
import com.bbva.czic.dto.net.Movement;


public interface ISrvMovementsV01 {

	Movement getMovement(String idMovement, String filter);

	Movement listMovements(String idMovement, String filter, Integer paginationKey, Integer pageSize);
}