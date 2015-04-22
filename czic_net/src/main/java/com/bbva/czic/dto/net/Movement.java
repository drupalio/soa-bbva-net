
package com.bbva.czic.dto.net;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.bbva.jee.arq.spring.core.servicing.utils.DateAdapter;
import org.hibernate.validator.constraints.NotBlank;

import com.bbva.jee.arq.spring.core.servicing.utils.CalendarAdapter;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import com.bbva.jee.arq.spring.core.servicing.utils.MoneyAdapter;
import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Movement", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "Movement", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Movement  implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty(value = "Identificador de la operacion", required = true)
    private String id;
    @ApiModelProperty(value = "concepto de la operacion", required = true)
    private String concept;
    @XmlJavaTypeAdapter(CalendarAdapter.class)
    @ApiModelProperty(value = " fecha de la transaccion", required = true)
    @Past
    private Calendar transactionDate;
    @XmlJavaTypeAdapter(CalendarAdapter.class)
    @ApiModelProperty(value = " fecha y hora de la operacion", required = true)
    @Past
    private Calendar operationDate;
    @ApiModelProperty("Cuenta origen del movimiento")
    private String sourceReference;
    @ApiModelProperty("Cuenta destino del movimiento")
    private String destinationReference;
    @ApiModelProperty(value = "Informacion de la operacion (codigo y descripcion)", required = true)
    private Operation operation;
    @ApiModelProperty(value = "Informacion de la operacion (codigo y descripcion)", required = true)
    private Office office;
    @ApiModelProperty(value = "Campo alfanum\u00e9rico que permite identificar la red utilizada para la operaci\u00f3n", required = true)
    private String status;
    @XmlElement(type = Money.class)
    @ApiModelProperty("valor de la operacion")
    private Money value;
    @XmlElement(type = Money.class)
    @ApiModelProperty("")
    private Money balance;
    @ApiModelProperty("Numero de cuotas del pago o movimiento")
    private String numberOfQuotas;
    @ApiModelProperty("")
    private Integer remainingQuotas;
    @ApiModelProperty("")
    private Balance deb;
    @ApiModelProperty("")
    private String numExt;


    public Movement() {
        //default constructor
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public Calendar getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Calendar transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Calendar getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(Calendar operationDate) {
        this.operationDate = operationDate;
    }

    public String getSourceReference() {
        return sourceReference;
    }

    public void setSourceReference(String sourceReference) {
        this.sourceReference = sourceReference;
    }

    public String getDestinationReference() {
        return destinationReference;
    }

    public void setDestinationReference(String destinationReference) {
        this.destinationReference = destinationReference;
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }

    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Money getValue() {
        return value;
    }

    public void setValue(Money value) {
        this.value = value;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

	public String getNumberOfQuotas() {
		return numberOfQuotas;
	}

	public void setNumberOfQuotas(String numberOfQuotas) {
		this.numberOfQuotas = numberOfQuotas;
	}

    public Integer getRemainingQuotas() {
        return remainingQuotas;
    }

    public void setRemainingQuotas(Integer remainingQuotas) {
        this.remainingQuotas = remainingQuotas;
    }

    public Balance getDeb() {
        return deb;
    }

    public void setDeb(Balance deb) {
        this.deb = deb;
    }

    public String getNumExt() {
        return numExt;
    }

    public void setNumExt(String numExt) {
        this.numExt = numExt;
    }
}
