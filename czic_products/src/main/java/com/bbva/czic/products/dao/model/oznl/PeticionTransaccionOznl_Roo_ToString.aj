// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bbva.czic.products.dao.model.oznl;

import java.lang.String;

privileged aspect PeticionTransaccionOznl_Roo_ToString {
    
    public String PeticionTransaccionOznl.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cuerpo: ").append(getCuerpo());
        return sb.toString();
    }
    
}
