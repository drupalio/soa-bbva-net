package com.bbva.czic.routine.commons.rm.utils.tx.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.MensajeMultiparte;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.ErrorMappingHelper;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

public abstract class ListBbvaTransaction<E, FE, S, FS> {

	@Autowired
	private ErrorMappingHelper errorMappingHelper;

	protected abstract FE mapDtoInToRequestFormat(E dtoIn);

	protected abstract S mapResponseFormatToDtoOut(FS formatOutput, E dtoIn);

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
			FS formatoSalida = null;
			S salida = null;

			for (final CopySalida copySalida : copysSalida) {
				// Obtenemos el formato de salida
				if (copySalida != null) {
					formatoSalida = (FS)copySalida.getCopy(formatoSalida.getClass());
				}
				salida = mapResponseFormatToDtoOut(formatoSalida, entrada);
				salidaList.add(salida);
			}

			return salidaList;

		} catch (final Exception iae) {
			throw new BusinessServiceException(EnumError.TECHNICAL_ERROR.getAlias(), iae);
		}

	}
}
