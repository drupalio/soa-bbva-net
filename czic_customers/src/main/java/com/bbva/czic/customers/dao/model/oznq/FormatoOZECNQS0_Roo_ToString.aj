// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bbva.czic.customers.dao.model.oznq;

import java.lang.String;

privileged aspect FormatoOZECNQS0_Roo_ToString {
    
    public String FormatoOZECNQS0.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Mes: ").append(getMes()).append(", ");
        sb.append("Saltota: ").append(getSaltota()).append(", ");
        sb.append("Valcarg: ").append(getValcarg()).append(", ");
        sb.append("Valdepo: ").append(getValdepo());
        return sb.toString();
    }
    
}
