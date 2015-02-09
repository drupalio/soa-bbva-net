package com.bbva.czic.products.dao.model.oznl.mock;

import java.util.Date;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.bbva.czic.products.dao.model.oznl.FormatoOZECNLS0;
import com.bbva.czic.products.dao.model.oznl.PeticionTransaccionOznl;
import com.bbva.czic.products.dao.model.oznl.RespuestaTransaccionOznl;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;

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
      formato1.setBalance("1000");
        formato1.setConcept("ABC");
        formato1.setDescopr("Descripcion");
        formato1.setFechope(new Date());
        formato1.setNumoper(100);
        formato1.setTipoopr("1");
        formato1.setValorop("2000");

        CopySalida copy1 = new CopySalida();
        copy1.setCopy(formato1);
        resultado.getCuerpo().getPartes().add(copy1);

        FormatoOZECNLS0 formato2 = new FormatoOZECNLS0();
        formato2.setBalance("2000");
        formato2.setConcept("CDE");
        formato2.setDescopr("Descripcion");
        formato2.setFechope(new Date());
        formato2.setNumoper(100);
        formato2.setTipoopr("2");
        formato2.setValorop("3000");

        CopySalida copy2 = new CopySalida();
        copy2.setCopy(formato2);
        resultado.getCuerpo().getPartes().add(copy2);

        FormatoOZECNLS0 formato3 = new FormatoOZECNLS0();
        formato3.setBalance("3000");
        formato3.setConcept("UUU");
        formato3.setDescopr("Descripcion");
        formato3.setFechope(new Date());
        formato3.setNumoper(100);
        formato3.setTipoopr("4");
        formato3.setValorop("4000");

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
