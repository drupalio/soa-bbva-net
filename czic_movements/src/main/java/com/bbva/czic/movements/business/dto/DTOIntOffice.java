
package com.bbva.czic.movements.business.dto;


import com.bbva.czic.dto.net.Location;
import com.wordnik.swagger.annotations.ApiModelProperty;

public class DTOIntOffice {


    private String code;
    private String name;
    private DTOIntLocation dtoIntLocation;

    public DTOIntOffice() {
        //default constructor
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DTOIntLocation getDtoIntLocation() {
        return dtoIntLocation;
    }

    public void setDtoIntLocation(DTOIntLocation dtoIntLocation) {
        this.dtoIntLocation = dtoIntLocation;
    }
}
