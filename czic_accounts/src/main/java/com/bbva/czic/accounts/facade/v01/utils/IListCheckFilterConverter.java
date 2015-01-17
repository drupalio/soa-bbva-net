package com.bbva.czic.accounts.facade.v01.utils;

import com.bbva.czic.accounts.business.dto.DTOIntFilterChecks;

/**
 * Created by user on 15/01/2015.
 */
public interface IListCheckFilterConverter {
    public DTOIntFilterChecks getDTOIntFilter(String accountId, String filter, String status, String paginationKey, String pageSize);
}
