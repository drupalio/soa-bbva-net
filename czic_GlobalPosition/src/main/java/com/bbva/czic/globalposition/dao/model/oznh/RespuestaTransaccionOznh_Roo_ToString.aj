// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bbva.czic.globalposition.dao.model.oznh;

import java.lang.String;

privileged aspect RespuestaTransaccionOznh_Roo_ToString {
    
    public String RespuestaTransaccionOznh.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CodigoControl: ").append(getCodigoControl()).append(", ");
        sb.append("CodigoRetorno: ").append(getCodigoRetorno()).append(", ");
        sb.append("Cuerpo: ").append(getCuerpo());
        return sb.toString();
    }
    
}
