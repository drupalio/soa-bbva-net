package com.bbva.czic.accounts.facade.v01.utils;

import com.bbva.czic.accounts.business.dto.DTOIntFilterAccount;

/**
 * Created by user on 15/01/2015.
 */
public interface IListCheckFilterConverter {
    public DTOIntFilterAccount getDTOIntFilter(String accountId, String filter);
}
