package com.bbva.czic.accounts.dao.model.oznx.mock;

import com.bbva.czic.accounts.dao.model.oznx.PeticionTransaccionOznx;
import com.bbva.czic.accounts.dao.model.oznx.RespuestaTransaccionOznx;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Created by Entelgy on 26/01/2015.
 */
@Profile(value = "dev")
@Component(value = "transaccionOznx")
public class TransaccionOznxMock implements InvocadorTransaccion<PeticionTransaccionOznx,RespuestaTransaccionOznx> {

    @Override
    public RespuestaTransaccionOznx invocar(PeticionTransaccionOznx peticion) throws ExcepcionTransaccion {
        return null;
    }

    @Override
    public RespuestaTransaccionOznx invocarCache(PeticionTransaccionOznx peticion) throws ExcepcionTransaccion {
        return null;
    }

    @Override
    public void vaciarCache() {

    }
}
