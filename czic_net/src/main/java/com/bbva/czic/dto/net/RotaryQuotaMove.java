
package com.bbva.czic.dto.net;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "RotaryQuotaMove", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "RotaryQuotaMove", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class RotaryQuotaMove
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty(value = "Cuotas restantes del movimiento de la cuenta", required = true)
    private Integer remainingQuotas;
    @ApiModelProperty(value = "Total cuotas pendientes de la cuenta", required = true)
    private Integer totalQuotal;
    @ApiModelProperty(value = "Estado de los movimientos de la cuenta", required = true)
    private EnumRotaryMoveStatus status;

    public RotaryQuotaMove() {
        //default constructor
    }

    public Integer getRemainingQuotas() {
        return remainingQuotas;
    }

    public void setRemainingQuotas(Integer remainingQuotas) {
        this.remainingQuotas = remainingQuotas;
    }

    public Integer getTotalQuotal() {
        return totalQuotal;
    }

    public void setTotalQuotal(Integer totalQuotal) {
        this.totalQuotal = totalQuotal;
    }

    public EnumRotaryMoveStatus getStatus() {
        return status;
    }

    public void setStatus(EnumRotaryMoveStatus status) {
        this.status = status;
    }

}
