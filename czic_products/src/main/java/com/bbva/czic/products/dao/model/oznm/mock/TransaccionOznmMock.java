package com.bbva.czic.products.dao.model.oznm.mock;

import com.bbva.czic.products.dao.model.oznl.RespuestaTransaccionOznl;
import com.bbva.czic.products.dao.model.oznm.FormatoOZNCSNM0;
import com.bbva.czic.products.dao.model.oznm.PeticionTransaccionOznm;
import com.bbva.czic.products.dao.model.oznm.RespuestaTransaccionOznm;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

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
        formato.setBaloper("");
        formato.setCtroorg("");
        formato.setDescodi("");
        formato.setFchoper("");
        formato.setFchvalr("");
        formato.setNumecta("");
        formato.setPlaza("");
        formato.setResto("");
        formato.setSaldo("");
        formato.setTipo("");

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
