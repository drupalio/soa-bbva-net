package com.bbva.czic.accounts.business.dto;

import java.util.List;

/**
 * Created by Entelgy on 12/01/2015.
 */
public class DTOIntResponseAccMovementsResumes {

    private List<DTOIntAccMovementsResume> listDTOIntAccMovementsResume;

    public List<DTOIntAccMovementsResume> getListDTOIntAccMovementsResume() {
        return listDTOIntAccMovementsResume;
    }

    public void setListDTOIntAccMovementsResume(List<DTOIntAccMovementsResume> listDTOIntAccMovementsResume) {
        this.listDTOIntAccMovementsResume = listDTOIntAccMovementsResume;
    }
}
