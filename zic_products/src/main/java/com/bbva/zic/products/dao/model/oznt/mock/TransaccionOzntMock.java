package com.bbva.zic.products.dao.model.oznt.mock;

import com.bbva.zic.products.dao.model.oznt.FormatoOZECNTS1;
import com.bbva.zic.products.dao.model.oznt.RespuestaTransaccionOznt;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.context.annotation.Profile;

import com.bbva.zic.products.dao.model.oznt.FormatoOZECNTS0;
import com.bbva.zic.products.dao.model.oznt.PeticionTransaccionOznt;
import com.bbva.zic.routine.commons.rm.utils.tx.Transaction;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;

/**
 * Invocador de la transacci&oacute;n <code>OZNT</code>
 *
 * @see PeticionTransaccionOznt
 * @see com.bbva.zic.products.dao.model.oznt.RespuestaTransaccionOznt
 */
@Profile("dev")
@Transaction(value = "transaccionOznt")
public class TransaccionOzntMock implements InvocadorTransaccion<PeticionTransaccionOznt,RespuestaTransaccionOznt> {

    final String MOCK_PRODUCT_TYPE = "AQ";


    @Override
    public RespuestaTransaccionOznt invocar(PeticionTransaccionOznt transaccion) throws ExcepcionTransaccion {
        final RespuestaTransaccionOznt respuesta = new RespuestaTransaccionOznt();
        final FormatoOZECNTS0 salida = new FormatoOZECNTS0();
        final FormatoOZECNTS1 salida1 = new FormatoOZECNTS1();
        final DataFactory dataFactory = new DataFactory();
        CopySalida copySalida = new CopySalida();
        CopySalida copySalida1 = new CopySalida();

        salida.setTipprod(MOCK_PRODUCT_TYPE);
        salida.setDesprod("Cuenta Ahorros");
        salida.setTialias("Titular de la cuenta");
        salida.setCategor("Plan clásico");
        salida.setFechape(dataFactory.getBirthDate());
        salida.setDirofic(dataFactory.getRandomText(40));
        salida.setCiudofi(dataFactory.getRandomText(20));
        salida.setNomofic(dataFactory.getRandomText(20));
        salida.setPaisofi(dataFactory.getRandomText(20));
        salida.setConprod("9000");
        salida.setTipfunc(dataFactory.getNumberText(10));

        copySalida.setCopy(salida);

        salida1.setTitular(dataFactory.getFirstName());

        copySalida1.setCopy(salida1);

        respuesta.getCuerpo().getPartes().add(copySalida);
        respuesta.getCuerpo().getPartes().add(copySalida1);
        return respuesta;
    }

    @Override
    public RespuestaTransaccionOznt invocarCache(PeticionTransaccionOznt transaccion) throws ExcepcionTransaccion {
        return null;
    }

    @Override
    public void vaciarCache() {}
}