// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bbva.czic.products.dao.model.oznt;

import java.lang.String;

privileged aspect FormatoOZECNTE0_Roo_ToString {
    
    public String FormatoOZECNTE0.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Numprod: ").append(getNumprod());
        return sb.toString();
    }
    
}
