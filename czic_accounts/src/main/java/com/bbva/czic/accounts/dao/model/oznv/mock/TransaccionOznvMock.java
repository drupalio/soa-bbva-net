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

        for(int i=0;i<31;i++){
            FormatoOZECNVS0 formatoSalida1 = new FormatoOZECNVS0();
            formatoSalida1.setSalddis(new BigDecimal("1000"));
            if(i<10){
                formatoSalida1.setMes("0"+i);
            }else{
                formatoSalida1.setMes(""+i);
            }


            CopySalida copySalida1 = new CopySalida();
            copySalida1.setCopy(formatoSalida1);
            resultado.getCuerpo().getPartes().add(copySalida1);

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
