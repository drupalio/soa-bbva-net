// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bbva.czic.customers.dao.model.ozno;

import java.lang.String;

privileged aspect PeticionTransaccionOzno_Roo_ToString {
    
    public String PeticionTransaccionOzno.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cuerpo: ").append(getCuerpo());
        return sb.toString();
    }
    
}
