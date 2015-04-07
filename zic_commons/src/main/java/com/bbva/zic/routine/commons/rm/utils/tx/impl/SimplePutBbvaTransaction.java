package com.bbva.zic.routine.commons.rm.utils.tx.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.springframework.beans.factory.annotation.Autowired;

import com.bbva.zic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.zic.routine.commons.rm.utils.tx.ISimplePutBbvaTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.MensajeMultiparte;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.ErrorMappingHelper;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

public abstract class SimplePutBbvaTransaction<E, FE, S> implements ISimplePutBbvaTransaction<E> {

	@Autowired
	private ErrorMappingHelper errorMappingHelper;

	/**
	 * @param dtoIn
	 * @return
	 */
	protected abstract FE mapDtoInToRequestFormat(E dtoIn);

	/**
	 * @return
	 */
	protected abstract InvocadorTransaccion<?, ?> getTransaction();

	@Override
	public void invoke(E entrada) {

		try {

			InvocadorTransaccion<?, ?> transaction = getTransaction();

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

		} catch (final Exception iae) {
			throw new BusinessServiceException(EnumError.TECHNICAL_ERROR.getAlias(), iae);
		}

	}

}
