// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bbva.czic.customers.dao.model.oznp;

import java.lang.String;

privileged aspect FormatoOZECNPS0_Roo_ToString {
    
    public String FormatoOZECNPS0.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Categor: ").append(getCategor()).append(", ");
        sb.append("Valcate: ").append(getValcate());
        return sb.toString();
    }
    
}
