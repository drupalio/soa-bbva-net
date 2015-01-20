package com.bbva.czic.movements.business.dto;

import com.bbva.czic.dto.net.City;
import com.bbva.czic.dto.net.Country;
import com.bbva.czic.dto.net.State;
import com.wordnik.swagger.annotations.ApiModelProperty;

/**
 * Created by Entelgy on 19/01/2015.
 */
public class DTOIntLocation {

    private DTOIntCity dtoIntCity;
    private DTOIntState dtoIntState;

    public DTOIntCity getDtoIntCity() {
        return dtoIntCity;
    }

    public void setDtoIntCity(DTOIntCity dtoIntCity) {
        this.dtoIntCity = dtoIntCity;
    }

    public DTOIntState getDtoIntState() {
        return dtoIntState;
    }

    public void setDtoIntState(DTOIntState dtoIntState) {
        this.dtoIntState = dtoIntState;
    }
}
