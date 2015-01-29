package com.bbva.czic.customers.facade.v01.utils.converters;

import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResumesFilter;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

/**
 *  Interfaz para convertir el filtro de una consulta del servicio customers a DTO
 * @author Sebastian Gamba - Entelgy Col. 
 * @since 11/01/2015
 */
public interface IFilterConverter {
	/**
	 * Metodo que  convierte un filtro de consulta de resumenes a DTO
	 * @author Sebastian Gamba - Entelgy Col.
	 * @since 11/01/2015
	 * @param filter
	 * @return
	 * @throws Exception
	 */
	DTOIntAccMovementsResumesFilter toCardChargeFilter(String filter) throws BusinessServiceException;

	DTOIntAccMovementsResumesFilter toAccountMovementFilter(String filter) throws BusinessServiceException;
}
