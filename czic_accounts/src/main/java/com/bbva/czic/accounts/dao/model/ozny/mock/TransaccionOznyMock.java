package com.bbva.czic.accounts.dao.model.ozny.mock;

import com.bbva.czic.accounts.dao.model.ozny.FormatoOZECNYS0;
import com.bbva.czic.accounts.dao.model.ozny.PeticionTransaccionOzny;
import com.bbva.czic.accounts.dao.model.ozny.RespuestaTransaccionOzny;
import com.bbva.czic.dto.net.EnumCheckStatus;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Entelgy on 28/01/2015.
 */
@Component(value = "transaccionOzny")
@Profile(value = "dev")
public class TransaccionOznyMock implements InvocadorTransaccion<PeticionTransaccionOzny, RespuestaTransaccionOzny> {
    @Override
    public RespuestaTransaccionOzny invocar(PeticionTransaccionOzny peticion) throws ExcepcionTransaccion {

        RespuestaTransaccionOzny resultado = new RespuestaTransaccionOzny();
        FormatoOZECNYS0 formato = new FormatoOZECNYS0();
      formato.setValcheq("1000000");
        formato.setNumcheq("002233");
        formato.setFechemi(new Date());
        formato.setFechemi(new Date());
        formato.setEstcheq(EnumCheckStatus.EN_IMPRESOR.getCodigo());

        CopySalida copy = new CopySalida();
        copy.setCopy(formato);
        resultado.getCuerpo().getPartes().add(copy);
        // TODO Auto-generated method stub
        return resultado;
    }

    @Override
    public RespuestaTransaccionOzny invocarCache(PeticionTransaccionOzny peticion) throws ExcepcionTransaccion {
        return null;
    }

    @Override
    public void vaciarCache() {

    }
}
