package com.bbva.zic.customers.business.dto;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Entelgy on 30/01/2015.
 */
public class DTOIntCustomerOperation {

    @NotNull
    private String code;
    private String cardNumber;
    private String cardNip;
    private String customerId;
    private String channelId;
    @NotNull
    private String documentNumber;
    @NotNull
    private String documentType;
    private List<String> emails;

    public DTOIntCustomerOperation() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardNip() {
        return cardNip;
    }

    public void setCardNip(String cardNip) {
        this.cardNip = cardNip;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    @Override
    public String toString() {
        return "DTOIntCustomerOperation{" +
                "code='" + code + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardNip='" + cardNip + '\'' +
                ", customerId='" + customerId + '\'' +
                ", channelId='" + channelId + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                ", documentType='" + documentType + '\'' +
                ", emails=" + emails +
                '}';
    }
}
