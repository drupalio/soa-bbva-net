// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bbva.czic.loan.dao.model.ozni;

import com.bbva.jee.arq.spring.core.host.CuerpoMultiparte;
import java.lang.String;

privileged aspect RespuestaTransaccionOzni_Roo_JavaBean {
    
    public String RespuestaTransaccionOzni.getCodigoRetorno() {
        return this.codigoRetorno;
    }
    
    public void RespuestaTransaccionOzni.setCodigoRetorno(String codigoRetorno) {
        this.codigoRetorno = codigoRetorno;
    }
    
    public String RespuestaTransaccionOzni.getCodigoControl() {
        return this.codigoControl;
    }
    
    public void RespuestaTransaccionOzni.setCodigoControl(String codigoControl) {
        this.codigoControl = codigoControl;
    }
    
    public void RespuestaTransaccionOzni.setCuerpo(CuerpoMultiparte cuerpo) {
        this.cuerpo = cuerpo;
    }
    
}
