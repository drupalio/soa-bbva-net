package com.bbva.zic.accounts.business.dto;

import java.util.List;

/**
 * Created by Entelgy on 14/01/2015.
 */
public class DTOIntResponseListCheck extends DTOIntCheck {

    private List<DTOIntCheck> listDTDtoIntChecks;

    public List<DTOIntCheck> getListDTDtoIntChecks() {
        return listDTDtoIntChecks;
    }

    public void setListDTDtoIntChecks(List<DTOIntCheck> listDTOIntChecks) {
        this.listDTDtoIntChecks = listDTOIntChecks;
    }
}
