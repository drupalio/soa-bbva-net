package com.bbva.czic.movements.facade.v01.mapper;

import com.bbva.czic.dto.net.*;
import com.bbva.czic.movements.business.dto.*;

/**
 * Created by Entelgy on 19/01/2015.
 */
public interface IMovementsMapper {
    DTOIntEnumProductType dtoIntEnumProductTypeMap(EnumProductType enumProductType);

    Office officeMap(DTOIntOffice dtoIntOffice);

    DTOIntOffice dtoIntOfficeMap(Office office);

    Operation operationMap(DTOIntOperation dtoIntOperation);

    DTOIntOperation dtoIntOperationMap(Operation operation);

    AccMoveDetail accMoveDetailMap(DTOIntAccMoveDetail dtoIntAccMoveDetail);

    DTOIntAccMoveDetail dtoIntAccMoveDetailMap(AccMoveDetail accMoveDetail);

    Movement movementMap(DTOIntMovement dtoIntMovement);

    DTOIntMovement dtoIntMovementMap(Movement movement);

    DTOIntEnumAccountMoveStatus dtoIntEnumAccountMoveStatusMap(EnumAccountMoveStatus enumAccountMoveStatus);

    DTOIntEnumAccountState dtoIntEnumAccountStateMap(EnumAccountState enumAccountState);
}
