// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bbva.czic.accounts.dao.model.ozns;

import java.lang.String;

privileged aspect FormatoOZECNSE0_Roo_ToString {
    
    public String FormatoOZECNSE0.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Numcheq: ").append(getNumcheq()).append(", ");
        sb.append("Numcuen: ").append(getNumcuen());
        return sb.toString();
    }
    
}
