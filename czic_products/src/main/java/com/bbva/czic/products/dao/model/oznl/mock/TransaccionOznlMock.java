package com.bbva.czic.products.dao.model.oznl.mock;

import com.bbva.czic.products.dao.model.oznl.FormatoOZECNLS0;
import com.bbva.czic.products.dao.model.oznl.PeticionTransaccionOznl;
import com.bbva.czic.products.dao.model.oznl.RespuestaTransaccionOznl;
import com.bbva.czic.products.dao.model.oznm.FormatoOZNCSNM0;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Entelgy on 30/01/2015.
 */
@Component(value = "transaccionOznl")
@Profile(value = "dev")
public class TransaccionOznlMock implements InvocadorTransaccion<PeticionTransaccionOznl, RespuestaTransaccionOznl> {
    @Override
    public RespuestaTransaccionOznl invocar(PeticionTransaccionOznl peticion) throws ExcepcionTransaccion {


        RespuestaTransaccionOznl resultado = new RespuestaTransaccionOznl();
        FormatoOZECNLS0 formato1 = new FormatoOZECNLS0();
      formato1.setBalance("");
        formato1.setConcept("");
        formato1.setDescopr("");
        formato1.setFechope(new Date());
        formato1.setNumoper(100);
        formato1.setTipoopr("");
        formato1.setValorop("");

        CopySalida copy1 = new CopySalida();
        copy1.setCopy(formato1);
        resultado.getCuerpo().getPartes().add(copy1);

        FormatoOZECNLS0 formato2 = new FormatoOZECNLS0();
        formato2.setBalance("");
        formato2.setConcept("");
        formato2.setDescopr("");
        formato2.setFechope(new Date());
        formato2.setNumoper(100);
        formato2.setTipoopr("");
        formato2.setValorop("");

        CopySalida copy2 = new CopySalida();
        copy2.setCopy(formato2);
        resultado.getCuerpo().getPartes().add(copy2);

        FormatoOZECNLS0 formato3 = new FormatoOZECNLS0();
        formato3.setBalance("");
        formato3.setConcept("");
        formato3.setDescopr("");
        formato3.setFechope(new Date());
        formato3.setNumoper(100);
        formato3.setTipoopr("");
        formato3.setValorop("");

        CopySalida copy3 = new CopySalida();
        copy3.setCopy(formato3);
        resultado.getCuerpo().getPartes().add(copy3);

        return resultado;
    }

    @Override
    public RespuestaTransaccionOznl invocarCache(PeticionTransaccionOznl peticion) throws ExcepcionTransaccion {
        return null;
    }

    @Override
    public void vaciarCache() {

    }
}
