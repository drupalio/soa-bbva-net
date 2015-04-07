
package com.bbva.zic.executives.business.dto;


import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class DTOIntOffice {

    public final static long serialVersionUID = 1L;
    private String officeId;
    private String code;
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    private String postalAddress;

    public DTOIntOffice() {
        //default constructor
    }

    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
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

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }
}
