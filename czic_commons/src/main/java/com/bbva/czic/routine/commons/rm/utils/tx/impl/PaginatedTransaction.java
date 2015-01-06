package com.bbva.czic.routine.commons.rm.utils.tx.impl;

import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.czic.routine.commons.rm.utils.tx.IFormatNotApply;
import com.bbva.czic.routine.commons.rm.utils.tx.IPaginatedTransaction;
import com.bbva.czic.routine.commons.rm.utils.tx.IPaginatedTransactionMapper;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.MensajeMultiparte;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.ErrorMappingHelper;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase abstracta de la que deben heredar todas aquellas transacciones paginadas, es decir, aquellas que reciben un formato de entrada con
 * datos de paginación generado a partir de un dto de entrada y tienen como salida un dto de salida.
 *
 * @author Adesis
 *
 * @param <P>
 *            Tipo de la petición de la transacción.
 * @param <R>
 *            Tipo de la respuesta de la transacción.
 */
public abstract class PaginatedTransaction<P extends MensajeMultiparte, R extends MensajeMultiparte> implements IPaginatedTransaction {

    @Autowired
    private ErrorMappingHelper errorMappingHelper;

    /**
     * Obtiene el invocador de la transacción, esto es, la clase automáticamente generada por la arquitectura Spring que representa a la
     * transacción.
     *
     * @return Invocador de la transacción.
     */
    protected abstract InvocadorTransaccion<P, R> getInvoker();

    /**
     * Obtiene el mapper que realizará el mapeo entre el dto de entrada al formato de entrada de la transacción, y el mapeo entre los
     * distintos formatos de salida de la transacción a los dtos correspondientes.
     *
     * @return Mapper de la transacción.
     */
    protected abstract <I, IF, O, OF, E, EOF, POF> IPaginatedTransactionMapper<I, IF, O, OF, E, EOF, POF> getMapper();

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public <I, IF, O, OF, E, EOF, POF> O invoke(final I dtoIn) {
        try {
            O o = null;
            final List<E> eList = new ArrayList<E>();

            // Obtenemos el invocador con el que llamaremos a la transacción...
            final InvocadorTransaccion<P, R> invocadorTransaccion = getInvoker();
            // ... y el mapper que realizará los mapeos entre los formatos y los
            // dtos
            final IPaginatedTransactionMapper<I, IF, O, OF, E, EOF, POF> mapperTransaccion = getMapper();

            // Obtenemos la clase de la petición de entrada con la información
            // dada en el invocador...
            final ParameterizedType tipoInterfaceInvocador = (ParameterizedType) invocadorTransaccion.getClass().getGenericInterfaces()[0];
            final Type[] tiposArgumentosPeticionYRespuesta = tipoInterfaceInvocador.getActualTypeArguments();
            final Class<P> clasePeticion = (Class<P>) tiposArgumentosPeticionYRespuesta[0];

            // A través del mapper vamos a recuperar el tipo de los distintos
            // formatos de salida de transacción...
            final ParameterizedType tipoInterfaceMapper = (ParameterizedType) mapperTransaccion.getClass().getGenericInterfaces()[0];
            final Type[] tiposArgumentosMapper = tipoInterfaceMapper.getActualTypeArguments();
            // ...el tipo del formato de salida...
            final Class<OF> claseFormatoSalida = (Class<OF>) tiposArgumentosMapper[3];
            // ...el tipo del formato de salida de la entidad...
            final Class<EOF> claseFormatoSalidaEntidad = (Class<EOF>) tiposArgumentosMapper[5];
            // ...y el tipo del formato de salida de la paginación
            final Class<POF> claseFormatoSalidaPaginacion = (Class<POF>) tiposArgumentosMapper[6];

            do {

                // Creamos una instancia de la petición para mandarla en la
                // transacción
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

                // Obtenemos la lista de copys de salida
                final List<CopySalida> copysSalida = response.getCuerpo().getPartes(CopySalida.class);

                //
                for (final CopySalida copySalida : copysSalida) {

                    // Obtenemos el formato de salida común
                    if (!claseFormatoSalida.isAssignableFrom(IFormatNotApply.class)) {
                        final OF formatoSalida = copySalida.getCopy(claseFormatoSalida);
                        if (formatoSalida != null) {
                            // Invocamos al mapper para mapear los datos comunes
                            // al dto de salida
                            o = mapperTransaccion.mapToOuter(formatoSalida, dtoIn);
                        }
                    }

                    // Obtenemos el formato de salida particular de la entidad
                    final EOF formatoSalidaEntidad = copySalida.getCopy(claseFormatoSalidaEntidad);
                    if (formatoSalidaEntidad != null) {
                        // Invocamos al mapper para mapear los datos
                        // particulares de la entidad
                        eList.add(mapperTransaccion.mapToInnerEntity(formatoSalidaEntidad, dtoIn));
                    }

                    // Obtenemos el formato de salida de paginación
                    final POF formatoSalidaPaginacion = copySalida.getCopy(claseFormatoSalidaPaginacion);
                    if (formatoSalidaPaginacion != null) {
                        // Invocamos al mapper para mapear los datos de
                        // paginación en el dto de entrada
                        mapperTransaccion.addPaginationInfo(formatoSalidaPaginacion, dtoIn);
                    }

                }

            } while (mapperTransaccion.doIHaveToPaginate(dtoIn));

            //
            final Class<O> claseDtoSalida = (Class<O>) tiposArgumentosMapper[2];
            if (o == null) {
                o = claseDtoSalida.newInstance();
            }

            // set eList in o.
            final Class<E> claseEntidad = (Class<E>) tiposArgumentosMapper[4];
            Class<?>[] parameterTypes;
            Type[] types;
            for (final Method m : claseDtoSalida.getMethods()) {
                parameterTypes = m.getParameterTypes();
                if (parameterTypes.length == 1) {
                    types = m.getGenericParameterTypes();
                    if (types.length == 1 && types[0] instanceof ParameterizedType) {
                        final ParameterizedType pType = (ParameterizedType) types[0];
                        final Class<?> clazz = (Class<?>) pType.getActualTypeArguments()[0];
                        if (parameterTypes[0].isInstance(eList) && clazz.equals(claseEntidad)) {
                            m.invoke(o, eList);
                        }
                    }
                }
            }

            return o;
        } catch (final IllegalAccessException iae) {
            throw new BusinessServiceException(EnumError.TECHNICAL_ERROR.getAlias(), iae);
        } catch (final InstantiationException ie) {
            throw new BusinessServiceException(EnumError.TECHNICAL_ERROR.getAlias(), ie);
        } catch (final InvocationTargetException ite) {
            throw new BusinessServiceException(EnumError.TECHNICAL_ERROR.getAlias(), ite);
        }
    }

}

