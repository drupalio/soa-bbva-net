// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bbva.czic.loan.dao.model.ozni;

import java.lang.String;

privileged aspect FormatoOZNCSNI0_Roo_ToString {
    
    public String FormatoOZNCSNI0.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Balance: ").append(getBalance()).append(", ");
        sb.append("Fechaop: ").append(getFechaop()).append(", ");
        sb.append("Numeext: ").append(getNumeext()).append(", ");
        sb.append("Numeope: ").append(getNumeope()).append(", ");
        sb.append("Resto: ").append(getResto()).append(", ");
        sb.append("Tipope: ").append(getTipope()).append(", ");
        sb.append("Valorop: ").append(getValorop());
        return sb.toString();
    }
    
}
