// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bbva.czic.loan.dao.model.oznk;

import com.bbva.jee.arq.spring.core.host.CuerpoMultiparte;
import java.lang.String;

privileged aspect RespuestaTransaccionOznk_Roo_JavaBean {
    
    public String RespuestaTransaccionOznk.getCodigoRetorno() {
        return this.codigoRetorno;
    }
    
    public void RespuestaTransaccionOznk.setCodigoRetorno(String codigoRetorno) {
        this.codigoRetorno = codigoRetorno;
    }
    
    public String RespuestaTransaccionOznk.getCodigoControl() {
        return this.codigoControl;
    }
    
    public void RespuestaTransaccionOznk.setCodigoControl(String codigoControl) {
        this.codigoControl = codigoControl;
    }
    
    public void RespuestaTransaccionOznk.setCuerpo(CuerpoMultiparte cuerpo) {
        this.cuerpo = cuerpo;
    }
    
}
