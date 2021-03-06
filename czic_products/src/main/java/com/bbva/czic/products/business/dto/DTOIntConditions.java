
package com.bbva.czic.products.business.dto;

import com.bbva.czic.dto.net.Activity;
import com.bbva.czic.dto.net.Holder;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class DTOIntConditions {

    public final static long serialVersionUID = 1L;
    private String type;
    private String alias;
    private String category;
    private String description;
    private Date openingDate;
    private String commission;
    private DTOIntOffice office;
    private String mobilizationConditions;
    private Activity activity;
    private List<DTOIntHolder> holders;

    public DTOIntConditions() {
        //default constructor
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public String getCommission() {
        return commission;
    }

    public void setCommission(String commission) {
        this.commission = commission;
    }

    public DTOIntOffice getOffice() {
        return office;
    }

    public void setOffice(DTOIntOffice office) {
        this.office = office;
    }

    public String getMobilizationConditions() {
        return mobilizationConditions;
    }

    public void setMobilizationConditions(String mobilizationConditions) {
        this.mobilizationConditions = mobilizationConditions;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public List<DTOIntHolder> getHolders() {
        return holders;
    }

    public void setHolders(List<DTOIntHolder> holders) {
        this.holders = holders;
    }
}
