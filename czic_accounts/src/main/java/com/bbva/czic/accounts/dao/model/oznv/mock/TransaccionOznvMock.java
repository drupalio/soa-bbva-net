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

        FormatoOZECNVS0 formatoSalida1 = new FormatoOZECNVS0();
        formatoSalida1.setSalddis(new BigDecimal("1000"));
        formatoSalida1.setMes("JANUARY");

        CopySalida copySalida1 = new CopySalida();
        copySalida1.setCopy(formatoSalida1);
        resultado.getCuerpo().getPartes().add(copySalida1);

        FormatoOZECNVS0 formatoSalida2 = new FormatoOZECNVS0();
        formatoSalida2.setSalddis(new BigDecimal("2000"));
        formatoSalida2.setMes("FEBRUARY");

        CopySalida copySalida2 = new CopySalida();
        copySalida2.setCopy(formatoSalida2);
        resultado.getCuerpo().getPartes().add(copySalida2);

        FormatoOZECNVS0 formatoSalida3 = new FormatoOZECNVS0();
        formatoSalida3.setSalddis(new BigDecimal("3000"));
        formatoSalida3.setMes("MARCH");

        CopySalida copySalida3 = new CopySalida();
        copySalida3.setCopy(formatoSalida3);
        resultado.getCuerpo().getPartes().add(copySalida3);

        FormatoOZECNVS0 formatoSalida4 = new FormatoOZECNVS0();
        formatoSalida4.setSalddis(new BigDecimal("4000"));
        formatoSalida4.setMes("APRIL");

        CopySalida copySalida4 = new CopySalida();
        copySalida4.setCopy(formatoSalida4);
        resultado.getCuerpo().getPartes().add(copySalida4);

        FormatoOZECNVS0 formatoSalida5 = new FormatoOZECNVS0();
        formatoSalida5.setSalddis(new BigDecimal("5000"));
        formatoSalida5.setMes("MAY");

        CopySalida copySalida5 = new CopySalida();
        copySalida5.setCopy(formatoSalida5);
        resultado.getCuerpo().getPartes().add(copySalida5);


            FormatoOZECNVS0 formatoSalida6 = new FormatoOZECNVS0();
        formatoSalida6.setSalddis(new BigDecimal("6000"));
        formatoSalida6.setMes("JUNE");

            CopySalida copySalida6 = new CopySalida();
        copySalida6.setCopy(formatoSalida6);
            resultado.getCuerpo().getPartes().add(copySalida6);



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
