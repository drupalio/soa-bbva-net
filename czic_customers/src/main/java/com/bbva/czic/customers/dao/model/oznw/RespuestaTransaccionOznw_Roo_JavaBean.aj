// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bbva.czic.customers.dao.model.oznw;

import com.bbva.jee.arq.spring.core.host.CuerpoMultiparte;
import java.lang.String;

privileged aspect RespuestaTransaccionOznw_Roo_JavaBean {
    
    public String RespuestaTransaccionOznw.getCodigoRetorno() {
        return this.codigoRetorno;
    }
    
    public void RespuestaTransaccionOznw.setCodigoRetorno(String codigoRetorno) {
        this.codigoRetorno = codigoRetorno;
    }
    
    public String RespuestaTransaccionOznw.getCodigoControl() {
        return this.codigoControl;
    }
    
    public void RespuestaTransaccionOznw.setCodigoControl(String codigoControl) {
        this.codigoControl = codigoControl;
    }
    
    public void RespuestaTransaccionOznw.setCuerpo(CuerpoMultiparte cuerpo) {
        this.cuerpo = cuerpo;
    }
    
}
