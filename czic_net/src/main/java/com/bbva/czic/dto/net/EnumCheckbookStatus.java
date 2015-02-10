package com.bbva.czic.dto.net;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "EnumCheckbookStatus", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "EnumCheckbookStatus", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public enum EnumCheckbookStatus {
    HABILITADO ("H"), SOLICITADO("S");

    private String code;

    private EnumCheckbookStatus(String code){
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public static EnumCheckbookStatus getByCode(String code){
        if(code != null) {
            for (EnumCheckbookStatus val : EnumCheckbookStatus.values()){
                if (val.getCode().equals(code)){
                    return val;
                }
            }
        }
        return null;
    }
}
