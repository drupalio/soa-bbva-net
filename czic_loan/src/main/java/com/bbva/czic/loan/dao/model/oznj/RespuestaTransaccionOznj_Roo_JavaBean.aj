// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bbva.czic.loan.dao.model.oznj;

import com.bbva.jee.arq.spring.core.host.CuerpoMultiparte;
import java.lang.String;

privileged aspect RespuestaTransaccionOznj_Roo_JavaBean {
    
    public String RespuestaTransaccionOznj.getCodigoRetorno() {
        return this.codigoRetorno;
    }
    
    public void RespuestaTransaccionOznj.setCodigoRetorno(String codigoRetorno) {
        this.codigoRetorno = codigoRetorno;
    }
    
    public String RespuestaTransaccionOznj.getCodigoControl() {
        return this.codigoControl;
    }
    
    public void RespuestaTransaccionOznj.setCodigoControl(String codigoControl) {
        this.codigoControl = codigoControl;
    }
    
    public void RespuestaTransaccionOznj.setCuerpo(CuerpoMultiparte cuerpo) {
        this.cuerpo = cuerpo;
    }
    
}
