// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bbva.czic.loan.dao.model.ozni;

import java.lang.String;

privileged aspect PeticionTransaccionOzni_Roo_ToString {
    
    public String PeticionTransaccionOzni.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cuerpo: ").append(getCuerpo());
        return sb.toString();
    }
    
}
