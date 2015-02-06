package com.bbva.czic.products.dao.model.oznm.mock;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.bbva.czic.products.dao.model.oznm.FormatoOZNCSNM0;
import com.bbva.czic.products.dao.model.oznm.PeticionTransaccionOznm;
import com.bbva.czic.products.dao.model.oznm.RespuestaTransaccionOznm;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;

/**
 * Created by Entelgy on 30/01/2015.
 */
@Component(value = "transaccionOznm")
@Profile(value = "dev")
public class TransaccionOznmMock implements InvocadorTransaccion<PeticionTransaccionOznm, RespuestaTransaccionOznm> {
    @Override
    public RespuestaTransaccionOznm invocar(PeticionTransaccionOznm peticion) throws ExcepcionTransaccion {


        RespuestaTransaccionOznm resultado = new RespuestaTransaccionOznm();
        FormatoOZNCSNM0 formato = new FormatoOZNCSNM0();
        formato.setBaloper("1000");
        formato.setCtroorg("CHILE CENTRO");
        formato.setDescodi("ABC");
        formato.setFchoper("2014-03-11");
        formato.setFchvalr("2014-05-12");
        formato.setNumecta("000100987333");
        formato.setPlaza("NORTE");
        formato.setResto("1000");
        formato.setSaldo("2000");
        formato.setTipo("A");
        formato.setValor("3000");

        CopySalida copy = new CopySalida();
        copy.setCopy(formato);
        resultado.getCuerpo().getPartes().add(copy);

        return resultado;
    }

    @Override
    public RespuestaTransaccionOznm invocarCache(PeticionTransaccionOznm peticion) throws ExcepcionTransaccion {
        return null;
    }

    @Override
    public void vaciarCache() {

    }
}
