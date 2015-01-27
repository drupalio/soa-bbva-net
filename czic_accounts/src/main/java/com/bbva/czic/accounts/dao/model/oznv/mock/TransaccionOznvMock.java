package com.bbva.czic.accounts.dao.model.oznv.mock;

import com.bbva.czic.accounts.dao.model.oznv.FormatoOZECNVS0;
import com.bbva.czic.accounts.dao.model.oznv.PeticionTransaccionOznv;
import com.bbva.czic.accounts.dao.model.oznv.RespuestaTransaccionOznv;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by Entelgy on 27/01/2015.
 */
@Component(value = "transaccionOznv")
@Profile(value = "dev")
public class TransaccionOznvMock implements InvocadorTransaccion<PeticionTransaccionOznv, RespuestaTransaccionOznv> {
    @Override
    public RespuestaTransaccionOznv invocar(PeticionTransaccionOznv peticion) throws ExcepcionTransaccion {

        RespuestaTransaccionOznv resultado = new RespuestaTransaccionOznv();

        for (int i = 0; i < 5; i++) {

            FormatoOZECNVS0 formatoSalida = new FormatoOZECNVS0();
            formatoSalida.setSalddis(new BigDecimal("1000"));
            formatoSalida.setMes("ENERO");

            CopySalida copySalida = new CopySalida();
            copySalida.setCopy(formatoSalida);
            resultado.getCuerpo().getPartes().add(copySalida);

        }

        return resultado;
    }

    @Override
    public RespuestaTransaccionOznv invocarCache(PeticionTransaccionOznv peticion) throws ExcepcionTransaccion {
        return null;
    }

    @Override
    public void vaciarCache() {

    }

}
