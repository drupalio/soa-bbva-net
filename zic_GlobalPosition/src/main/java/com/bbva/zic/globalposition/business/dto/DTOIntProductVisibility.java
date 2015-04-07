package com.bbva.zic.globalposition.business.dto;

import com.bbva.zic.routine.commons.rm.utils.validator.IsProductId;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author Entelgy Colombia.
 */
public class DTOIntProductVisibility {

    @NotEmpty
    @Pattern(regexp = "^([0-9]{20}|[0-9]{16})$")
    private String id;

    @NotNull
    private Boolean visible;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean isVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }
}
