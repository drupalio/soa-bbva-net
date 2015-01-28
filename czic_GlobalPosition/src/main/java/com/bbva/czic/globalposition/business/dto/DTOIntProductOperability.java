package com.bbva.czic.globalposition.business.dto;

/**
 * @author Entelgy Colombia.
 */
public class DTOIntProductOperability {

    private String productId;

    private Boolean operable;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Boolean getOperable() {
        return operable;
    }

    public void setOperable(Boolean operable) {
        this.operable = operable;
    }
}
