package com.bbva.czic.accounts.facade.v01.utils;

import com.bbva.czic.accounts.business.dto.DTOIntFilterAccount;
import com.bbva.czic.accounts.business.dto.DTOIntFilterMovResumes;

/**
 * Created by Entelgy on 12/01/2015.
 */
public interface IFilterConverter {

    /**
     * Metodo encargado de hacer el manejo del filter para retornar un DTO de tipo filtro el cual sera enviado
     * a los servicios de negocio
     * @author David Tafur
     * @param accountId
     * @param filter
     * @return
     */
    public DTOIntFilterAccount getDTOIntFilter(String accountId, String filter);

    public DTOIntFilterMovResumes getDTOIntFilterMovRes(String accountId, String filter);
}
