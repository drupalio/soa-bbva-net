// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.bbva.czic.products.dao.model.oznl;

import com.bbva.jee.arq.spring.core.host.CuerpoMultiparte;

privileged aspect RespuestaTransaccionOznl_Roo_JavaBean {
    
    public String RespuestaTransaccionOznl.getCodigoRetorno() {
        return this.codigoRetorno;
    }
    
    public void RespuestaTransaccionOznl.setCodigoRetorno(String codigoRetorno) {
        this.codigoRetorno = codigoRetorno;
    }
    
    public String RespuestaTransaccionOznl.getCodigoControl() {
        return this.codigoControl;
    }
    
    public void RespuestaTransaccionOznl.setCodigoControl(String codigoControl) {
        this.codigoControl = codigoControl;
    }
    
    public void RespuestaTransaccionOznl.setCuerpo(CuerpoMultiparte cuerpo) {
        this.cuerpo = cuerpo;
    }
    
}
