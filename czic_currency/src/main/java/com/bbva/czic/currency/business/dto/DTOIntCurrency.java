
package com.bbva.czic.currency.business.dto;


import javax.validation.constraints.NotNull;

/**
 * Clase DTO interna que tiene solo los atributos que seran manejados durante la ejecución del servicio listCurrencies
 */
public class DTOIntCurrency {

    public final static long serialVersionUID = 1L;
    @NotNull
    private String id;
    @NotNull
    private String name;

    public DTOIntCurrency() {
        //default constructor
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
