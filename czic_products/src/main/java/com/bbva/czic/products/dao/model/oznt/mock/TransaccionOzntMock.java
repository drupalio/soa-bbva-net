package com.bbva.czic.products.dao.model.oznt.mock;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.context.annotation.Profile;

import com.bbva.czic.products.dao.model.oznt.FormatoOZECNTS0;
import com.bbva.czic.products.dao.model.oznt.PeticionTransaccionOznt;
import com.bbva.czic.products.dao.model.oznt.RespuestaTransaccionOznt;
import com.bbva.czic.routine.commons.rm.utils.tx.Transaction;
import com.bbva.jee.arq.spring.core.host.ExcepcionTransaccion;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;

/**
 * Invocador de la transacci&oacute;n <code>OZNT</code>
 *
 * @see PeticionTransaccionOznt
 * @see RespuestaTransaccionOznt
 */
@Profile("dev")
@Transaction(value = "transaccionOznt")
public class TransaccionOzntMock implements InvocadorTransaccion<PeticionTransaccionOznt,RespuestaTransaccionOznt> {

    final String MOCK_PRODUCT_TYPE = "AQ";


    @Override
    public RespuestaTransaccionOznt invocar(PeticionTransaccionOznt transaccion) throws ExcepcionTransaccion {
        final RespuestaTransaccionOznt respuesta = new RespuestaTransaccionOznt();
        final FormatoOZECNTS0 salida = new FormatoOZECNTS0();
        final DataFactory dataFactory = new DataFactory();
        CopySalida copySalida = new CopySalida();

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

        copySalida.setCopy(salida);
        respuesta.getCuerpo().getPartes().add(copySalida);
        return respuesta;
    }

    @Override
    public RespuestaTransaccionOznt invocarCache(PeticionTransaccionOznt transaccion) throws ExcepcionTransaccion {
        return null;
    }

    @Override
    public void vaciarCache() {}
}