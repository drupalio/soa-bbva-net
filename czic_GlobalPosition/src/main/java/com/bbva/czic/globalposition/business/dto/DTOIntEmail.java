
package com.bbva.czic.globalposition.business.dto;


import com.bbva.czic.dto.net.EnumContactSourceType;

public class DTOIntEmail {

    public final static long serialVersionUID = 1L;
    private String address;
    private Boolean primary;
    private Boolean active;
    private EnumContactSourceType source;

    public DTOIntEmail() {
        //default constructor
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getPrimary() {
        return primary;
    }

    public void setPrimary(Boolean primary) {
        this.primary = primary;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public EnumContactSourceType getSource() {
        return source;
    }

    public void setSource(EnumContactSourceType source) {
        this.source = source;
    }
}
