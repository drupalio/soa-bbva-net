package com.bbva.czic.routine.commons.rm.utils.tx.impl;

import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.MensajeMultiparte;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.ErrorMappingHelper;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Entelgy Colombia.
 */
public abstract class DoubleFormatBbvaTransaction <E, FE, S, FS1, FS2> {


    @Autowired
    private ErrorMappingHelper errorMappingHelper;

    /**
     * @param dtoIn
     * @return
     */
    protected abstract FE mapDtoInToRequestFormat(E dtoIn);

    /**
     * @param formatOutput
     * @param dtoIn
     * @return
     */
    protected abstract S mapResponseFormatToDtoOut1(FS1 formatOutput, E dtoIn);

    /**
     *
     * @param formatOutput
     * @param dtoIn
     * @return
     */
    protected abstract S mapResponseFormatToDtoOut2(FS2 formatOutput, E dtoIn);

    /**
     * @return
     */
    protected abstract InvocadorTransaccion<?, ?> getTransaction();

    /**
     * @param entrada
     * @return
     */
    public List<S> invoke(final E entrada) {

        try {

            final InvocadorTransaccion<?, ?> transaction = getTransaction();

            // Obtenemos la clase de la petición de entrada con la información
            // dada en el invocador...
            final ParameterizedType tipoInterfaceInvocador = (ParameterizedType)transaction.getClass()
                    .getGenericInterfaces()[0];
            final Type[] tiposArgumentosPeticionYRespuesta = tipoInterfaceInvocador.getActualTypeArguments();
            final Class<?> clasePeticion = (Class<?>)tiposArgumentosPeticionYRespuesta[0];
            // ... y creamos una instancia para mandarla en la transacción
            MensajeMultiparte peticion = (MensajeMultiparte)clasePeticion.newInstance();

            final Object formatoEntrada = mapDtoInToRequestFormat(entrada);
            // ... y lo añadimos al a petición
            peticion.getCuerpo().getPartes().add(formatoEntrada);

            // Invocamos a la transacción...
            final MensajeMultiparte respuesta = (MensajeMultiparte)transaction.getClass()
                    .getMethod("invocar", peticion.getClass()).invoke(transaction, peticion);

            // ... y comprobamos posibles errores
            final BusinessServiceException businessServiceException = errorMappingHelper
                    .toBusinessServiceException(respuesta);

            if (businessServiceException != null) {
                throw businessServiceException;
            }
            // ... y obtener la copy de salida
            final List<CopySalida> copysSalida = respuesta.getCuerpo().getPartes(CopySalida.class);

            final List<S> salidaList = new ArrayList<S>();

            S salida = null;

            final ParameterizedType typeInterfaceOutput = (ParameterizedType)this.getClass().getGenericSuperclass();
            final Type[] typesListTransaction = typeInterfaceOutput.getActualTypeArguments();
            FS1 formatoSalida1 = null;
            FS2 formatoSalida2 = null;
            for (final CopySalida copySalida : copysSalida) {
                // Obtenemos el formato de salida

                if (copySalida != null) {
                    @SuppressWarnings("unchecked")
                    final Class<FS1> claseFormatoSalida1 = (Class<FS1>)typesListTransaction[3];
                    formatoSalida1 = copySalida.getCopy(claseFormatoSalida1);
                    if (formatoSalida1 != null) {
                        salida = mapResponseFormatToDtoOut1(formatoSalida1, entrada);
                    } else {
                        final Class<FS2> claseFormatoSalida2 = (Class<FS2>)typesListTransaction[4];
                        formatoSalida2 = copySalida.getCopy(claseFormatoSalida2);
                        salida = mapResponseFormatToDtoOut2(formatoSalida2, entrada);
                    }
                }
                salidaList.add(salida);
            }

            return salidaList;

        } catch (final Exception iae) {
            throw new BusinessServiceException(EnumError.TECHNICAL_ERROR.getAlias(), iae);
        }

    }
}

