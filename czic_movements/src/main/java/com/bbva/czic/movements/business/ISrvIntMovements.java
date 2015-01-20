package com.bbva.czic.movements.business;

import java.util.List;
import javax.ws.rs.core.Response;


import com.bbva.czic.movements.business.dto.*;


public interface ISrvIntMovements {
	public DTOIntMovement getMovement(DTOIntMovementsFilter dtoIntMovementsFilter);

	public  List<DTOIntMovement> listMovements( DTOIntMovementsFilter filter);
}