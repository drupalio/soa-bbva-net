// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bbva.czic.customers.dao.model.oznp;

import java.lang.String;

privileged aspect RespuestaTransaccionOznp_Roo_ToString {
    
    public String RespuestaTransaccionOznp.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CodigoControl: ").append(getCodigoControl()).append(", ");
        sb.append("CodigoRetorno: ").append(getCodigoRetorno()).append(", ");
        sb.append("Cuerpo: ").append(getCuerpo());
        return sb.toString();
    }
    
}
