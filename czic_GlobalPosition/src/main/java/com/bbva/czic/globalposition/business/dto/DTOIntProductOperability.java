package com.bbva.czic.globalposition.business.dto;

import com.bbva.czic.routine.commons.rm.utils.validator.IsProductId;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author Entelgy Colombia.
 */
public class DTOIntProductOperability {

    @NotEmpty
    //@IsProductId
    @Pattern(regexp = "^(\\d{20}|\\d{16})$")
    private String id;

    @NotNull
    private Boolean operable;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean isOperable() {
        return operable;
    }

    public void setOperable(Boolean operable) {
        this.operable = operable;
    }
}
