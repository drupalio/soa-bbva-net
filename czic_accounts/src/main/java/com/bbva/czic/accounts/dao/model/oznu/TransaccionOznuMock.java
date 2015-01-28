package com.bbva.czic.accounts.dao.model.oznu;

import com.bbva.czic.accounts.dao.model.oznx.FormatoOZECNXE0;
import com.bbva.czic.accounts.dao.model.oznx.FormatoOZECNXS0;
import com.bbva.czic.accounts.dao.model.oznx.RespuestaTransaccionOznx;
import com.bbva.czic.dto.net.EnumMonth;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Entelgy on 28/01/2015.
 */
@Profile(value = "dev")
@Component(value = "transaccionOznu")
public class TransaccionOznuMock  implements InvocadorTransaccion<PeticionTransaccionOznu,RespuestaTransaccionOznu>{

    @Override
    public RespuestaTransaccionOznu invocar(PeticionTransaccionOznu peticion) throws ExcepcionTransaccion {
        final RespuestaTransaccionOznu respuesta = new RespuestaTransaccionOznu();
        final List<FormatoOZECNUS0> salidas = new ArrayList<FormatoOZECNUS0>();
        final DataFactory dataFactory = new DataFactory();

        for(EnumMonth month : EnumMonth.values()) {
            FormatoOZECNUS0 salida = new FormatoOZECNUS0();
            salida.setMes(month.name());
            salida.setValcarg(new BigDecimal(dataFactory.getNumberBetween(50000, 100000)));
            salida.setValdepo(new BigDecimal(dataFactory.getNumberBetween(100000, 200000)));
            salida.setSaldtot(salida.getValdepo().subtract(salida.getValcarg()));

            CopySalida copySalida = new CopySalida();
            copySalida.setCopy(salida);
            respuesta.getCuerpo().getPartes().add(copySalida);
        }

        return respuesta;
    }

    @Override
    public RespuestaTransaccionOznu invocarCache(PeticionTransaccionOznu peticion) throws ExcepcionTransaccion {
        return null;
    }

    @Override
    public void vaciarCache() {

    }
}
