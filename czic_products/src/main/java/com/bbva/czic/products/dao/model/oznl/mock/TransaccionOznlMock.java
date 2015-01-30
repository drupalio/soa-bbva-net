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
        FormatoOZECNLS0 formato = new FormatoOZECNLS0();
      formato.setBalance("");
        formato.setConcept("");
        formato.setDescopr("");
        formato.setFechope(new Date());
        formato.setNumoper(100);
        formato.setTipoopr("");
        formato.setValorop("");

        CopySalida copy = new CopySalida();
        copy.setCopy(formato);
        resultado.getCuerpo().getPartes().add(copy);

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
