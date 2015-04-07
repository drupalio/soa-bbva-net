package com.bbva.zic.accounts.dao.model.oznx.mock;

import com.bbva.zic.accounts.dao.model.oznx.FormatoOZECNXE0;
import com.bbva.zic.accounts.dao.model.oznx.FormatoOZECNXS0;
import com.bbva.zic.accounts.dao.model.oznx.PeticionTransaccionOznx;
import com.bbva.zic.accounts.dao.model.oznx.RespuestaTransaccionOznx;
import com.bbva.zic.dto.net.EnumCheckStatus;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Entelgy on 26/01/2015.
 */
@Profile(value = "dev")
@Component(value = "transaccionOznx")
public class TransaccionOznxMock implements InvocadorTransaccion<PeticionTransaccionOznx,RespuestaTransaccionOznx> {

    @Override
    public RespuestaTransaccionOznx invocar(PeticionTransaccionOznx peticion) throws ExcepcionTransaccion {

        final RespuestaTransaccionOznx respuesta = new RespuestaTransaccionOznx();
        final List<FormatoOZECNXS0> salidas = new ArrayList<FormatoOZECNXS0>();
        final DataFactory dataFactory = new DataFactory();

        for(int i = 0; i < 10; i++) {
            FormatoOZECNXS0 salida = new FormatoOZECNXS0();
            salida.setEstcheq(EnumCheckStatus.ANULADO.getCodigo());
            salida.setFechemi(dataFactory.getDateBetween(dataFactory.getDate(2014, 12, 01), new Date()));
            salida.setFechmod(dataFactory.getDateBetween(dataFactory.getDate(2014, 12, 01), new Date()));
            salida.setIndpagi(dataFactory.getNumberBetween(1, 10));
            salida.setNumcheq(dataFactory.getNumberText(9));
            salida.setValcheq(String.valueOf(dataFactory.getNumberBetween(100000, 200000)));
            salida.setNumprod((peticion.getCuerpo().getParte(FormatoOZECNXE0.class)).getNumprod());

            CopySalida copySalida = new CopySalida();
            copySalida.setCopy(salida);
            respuesta.getCuerpo().getPartes().add(copySalida);
        }

        return respuesta;
    }

    @Override
    public RespuestaTransaccionOznx invocarCache(PeticionTransaccionOznx peticion) throws ExcepcionTransaccion {
        return null;
    }

    @Override
    public void vaciarCache() {

    }
}
