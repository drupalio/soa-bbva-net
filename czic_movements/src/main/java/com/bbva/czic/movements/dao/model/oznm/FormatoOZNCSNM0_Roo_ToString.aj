// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bbva.czic.movements.dao.model.oznm;

import java.lang.String;

privileged aspect FormatoOZNCSNM0_Roo_ToString {
    
    public String FormatoOZNCSNM0.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Baloper: ").append(getBaloper()).append(", ");
        sb.append("Ctroorg: ").append(getCtroorg()).append(", ");
        sb.append("Descodi: ").append(getDescodi()).append(", ");
        sb.append("Fchoper: ").append(getFchoper()).append(", ");
        sb.append("Fchvalr: ").append(getFchvalr()).append(", ");
        sb.append("Nomovim: ").append(getNomovim()).append(", ");
        sb.append("Numecta: ").append(getNumecta()).append(", ");
        sb.append("Plaza: ").append(getPlaza()).append(", ");
        sb.append("Resto: ").append(getResto()).append(", ");
        sb.append("Saldo: ").append(getSaldo()).append(", ");
        sb.append("Tipo: ").append(getTipo()).append(", ");
        sb.append("Valor: ").append(getValor());
        return sb.toString();
    }
    
}
