package com.bbva.czic.movements.facade.v01.mapper;

import com.bbva.czic.dto.net.*;
import com.bbva.czic.movements.business.dto.*;

import java.util.List;

/**
 * Created by Entelgy on 19/01/2015.
 */
public interface IMovementsMapper {

    public Movement movementMap(DTOIntMovement dtoIntMovement) ;

    List<Movement> listMovementMap(List<DTOIntMovement> listDTOIntMovements);
}
