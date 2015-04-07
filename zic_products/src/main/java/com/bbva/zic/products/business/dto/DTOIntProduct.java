
package com.bbva.zic.products.business.dto;




public class DTOIntProduct {

    public final static long serialVersionUID = 1L;
    private String id;
    private String type;
    private String name;
    private String alias;
    private Boolean visible;
    private Boolean operable;
    private DTOIntConditions conditions;

    public DTOIntProduct() {
        //default constructor
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public Boolean getOperable() {
        return operable;
    }

    public void setOperable(Boolean operable) {
        this.operable = operable;
    }

    public DTOIntConditions getConditions() {
        return conditions;
    }

    public void setConditions(DTOIntConditions conditions) {
        this.conditions = conditions;
    }

}
