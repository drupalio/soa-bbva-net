package com.bbva.czic.dto.net;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "EnumCheckbookStatus", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "EnumCheckbookStatus", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public enum EnumCheckbookStatus {
    DISPONIBLE("0"),
    ANULADO("1"),
    PERDIDO("2"),
    PAGADOCPD("3"),
    PAGADOOFF("4"),
    EXTRAVIADO("5"),
    REEXPEDIDO("6"),
    ORDENOPAGO("8"),
    CPENDIENTEE("9"),
    REGISTPTE("A"),
    CEMPAREJADO("B"),
    REGISTEMP("C"),
    REEMPLAZADO("R"),
    REEMPLAZADO1("E");

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
