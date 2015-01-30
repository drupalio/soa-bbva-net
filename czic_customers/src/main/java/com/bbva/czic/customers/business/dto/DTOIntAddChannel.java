package com.bbva.czic.customers.business.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * Created by Entelgy on 30/01/2015.
 */
public class DTOIntAddChannel {

    @NotNull

    @Length(min = 8, max = 8)
    private String customerId;

    @NotNull

    @Length(min = 4, max = 4)
    private String channelId;

    public DTOIntAddChannel(){    }

    public DTOIntAddChannel(String customerId, String channelId){
        this.customerId = customerId;
        this.channelId = channelId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }
}
