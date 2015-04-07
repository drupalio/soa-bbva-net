package com.bbva.zic.routine.commons.rm.utils.tx.impl;

/**
 * Created by Administrador on 06/01/2015.
 */

import com.bbva.zic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.zic.routine.commons.rm.utils.tx.ISimpleTransaction;
import com.bbva.zic.routine.commons.rm.utils.tx.ISimpleTransactionMapper;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.MensajeMultiparte;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.ErrorMappingHelper;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import com.bbva.zic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.zic.routine.commons.rm.utils.tx.ISimpleTransaction;
import com.bbva.zic.routine.commons.rm.utils.tx.ISimpleTransactionMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Clase abstracta de la que deben heredar todas aquellas transacciones
 * consideradas simples, es decir, aquellas que reciben un formato de entrada
 * generado a partir de un dto de entrada o entidad de entrada, y tienen como
 * salida una entidad, que puede coincidir con el dto de entrada.
 *
 * @author Adesis
 *
 * @param <P>
 *            Tipo de la petición de la transacción.
 * @param <R>
 *            Tipo de la respuesta de la transacción.
 */
public abstract class SimpleTransaction<P extends MensajeMultiparte, R extends MensajeMultiparte> implements ISimpleTransaction {

    @Autowired
    private ErrorMappingHelper errorMappingHelper;

    /**
     * Obtiene el invocador de la transacción, esto es, la clase automáticamente
     * generada por la arquitectura Spring que representa a la transacción.
     *
     * @return Invocador de la transacción.
     */
    protected abstract InvocadorTransaccion<P, R> getInvoker();

    /**
     * Obtiene el mapper que realizará el mapeo entre el dto o entidad de
     * entrada al formato de entrada de la transacción, y el mapeo entre el
     * formato de salida de la transacción a la entidad.
     *
     * @return Mapper de la transacción.
     */
    protected abstract <I, IF, O, OF> ISimpleTransactionMapper<I, IF, O, OF> getMapper();

    /**
     * Realiza la invocación de la transacción a partir del dto o entidad de
     * entrada.
     *
     * @param dtoIn
     *            Dto o entidad de entrada a la transacción.
     * @return Entidad de respuesta de la transacción, que será el parámetro de
     *         entrada en caso de tratarse éste de una entidad.
     */
    @Override
    @SuppressWarnings("unchecked")
    public <I, IF, O, OF> O invoke(final I dtoIn) {
        try {

            // Obtenemos el invocador con el que llamaremos a la transacción...
            final InvocadorTransaccion<P, R> invocadorTransaccion = getInvoker();
            // ... y el mapper que realizará los mapeos entre los formatos y los
            // dtos
            final ISimpleTransactionMapper<I, IF, O, OF> mapperTransaccion = getMapper();

            // Obtenemos la clase de la petición de entrada con la información
            // dada en el invocador...
            final ParameterizedType tipoInterfaceInvocador = (ParameterizedType) invocadorTransaccion.getClass().getGenericInterfaces()[0];
            final Type[] tiposArgumentosPeticionYRespuesta = tipoInterfaceInvocador.getActualTypeArguments();
            final Class<P> clasePeticion = (Class<P>) tiposArgumentosPeticionYRespuesta[0];
            // ... y creamos una instancia para mandarla en la transacción
            final P peticion = clasePeticion.newInstance();

            // Con el mapper obtenemos el formato de entrada...
            final Object formatoEntrada = mapperTransaccion.mapToInner(dtoIn);
            // ... y lo añadimos al a petición
            peticion.getCuerpo().getPartes().add(formatoEntrada);

            // Invocamos a la transacción...
            final R response = invocadorTransaccion.invocar(peticion);

            // ... y comprobamos posibles errores
            final BusinessServiceException businessServiceException = errorMappingHelper.toBusinessServiceException(response);

            if (businessServiceException != null) {
                throw businessServiceException;
            }

            // ... y obtener la copy de salida
            final CopySalida copySalida = response.getCuerpo().getParte(CopySalida.class);

            // A través del mapper vamos a recuperar el tipo del formato de
            // salida
            final ParameterizedType tipoInterfaceMapper = (ParameterizedType) mapperTransaccion.getClass().getGenericInterfaces()[0];
            final Type[] tiposArgumentosMapper = tipoInterfaceMapper.getActualTypeArguments();
            final Class<OF> claseFormatoSalida = (Class<OF>) tiposArgumentosMapper[3];

            // Obtenemos el formato de salida
            OF formatoSalida = null;
            if (copySalida != null) {
                formatoSalida = copySalida.getCopy(claseFormatoSalida);
            }
            // E invocamos al mapper que lo mapeará a la entidad esperada
            return mapperTransaccion.mapToOuter(formatoSalida, dtoIn);

        } catch (final IllegalAccessException iae) {
            throw new BusinessServiceException(EnumError.TECHNICAL_ERROR.getAlias(), iae);
        } catch (final InstantiationException ie) {
            throw new BusinessServiceException(EnumError.TECHNICAL_ERROR.getAlias(), ie);
        }
    }

}
