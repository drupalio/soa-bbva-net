package com.bbva.czic.movements.business;

import java.util.List;
import javax.ws.rs.core.Response;


import com.bbva.czic.movements.business.dto.DTOIntEnumProductType;
import com.bbva.czic.movements.business.dto.DTOIntOffice;
import com.bbva.czic.movements.business.dto.DTOIntOperation;
import com.bbva.czic.movements.business.dto.DTOIntAccMoveDetail;
import com.bbva.czic.movements.business.dto.DTOIntMovement;
import com.bbva.czic.movements.business.dto.DTOIntEnumAccountMoveStatus;
import com.bbva.czic.movements.business.dto.DTOIntEnumAccountState;



public interface ISrvIntMovements {
 	public DTOIntMovement getMovement( String idMovement);

		public DTOIntMovement listMovements( String idMovement);

	
}