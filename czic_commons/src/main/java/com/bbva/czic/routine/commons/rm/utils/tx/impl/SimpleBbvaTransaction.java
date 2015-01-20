package com.bbva.czic.routine.commons.rm.utils.tx.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.springframework.beans.factory.annotation.Autowired;

import com.bbva.czic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.czic.routine.commons.rm.utils.tx.ISimpleBbvaTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.MensajeMultiparte;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.ErrorMappingHelper;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;

public abstract class SimpleBbvaTransaction<E, FE, S, FS> implements ISimpleBbvaTransaction<E, S> {

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
	protected abstract S mapResponseFormatToDtoOut(FS formatOutput, E dtoIn);

	/**
	 * @return
	 */
	protected abstract InvocadorTransaccion<?, ?> getTransaction();

	/**
	 * @param entrada
	 * @return
	 */
	@Override
	@SuppressWarnings({ "unchecked", "null" })
	public S invoke(E entrada) {

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
			// ... y obtener la copy de salida
			final CopySalida copySalida = respuesta.getCuerpo().getParte(CopySalida.class);

			// Obtenemos el formato de salida
			FS formatoSalida = null;
			if (copySalida != null) {
				formatoSalida = (FS)copySalida.getCopy(formatoSalida.getClass());
			}

			// Get output class
			final ParameterizedType typeInterfaceOutput = (ParameterizedType)this.getClass().getGenericSuperclass();
			final Type[] typesSimpleTransaction = typeInterfaceOutput.getActualTypeArguments();
			final Class<?> claseSalida = (Class<?>)typesSimpleTransaction[2];

			// E invocamos al mapper que lo mapeará a la entidad esperada
			final S outputReturn = mapResponseFormatToDtoOut(formatoSalida, entrada);
			// return outputReturn;
			return ((outputReturn == null) ? (S)claseSalida.newInstance() : outputReturn);

		} catch (final Exception iae) {
			throw new BusinessServiceException(EnumError.TECHNICAL_ERROR.getAlias(), iae);
		}

	}
}
