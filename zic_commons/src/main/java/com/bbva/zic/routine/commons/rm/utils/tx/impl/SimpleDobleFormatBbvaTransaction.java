package com.bbva.zic.routine.commons.rm.utils.tx.impl;

import com.bbva.zic.routine.commons.rm.utils.errors.EnumError;
import com.bbva.zic.routine.commons.rm.utils.tx.ISimpleBbvaTransaction;
import com.bbva.jee.arq.spring.core.host.InvocadorTransaccion;
import com.bbva.jee.arq.spring.core.host.MensajeMultiparte;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.ErrorMappingHelper;
import com.bbva.jee.arq.spring.core.host.protocolo.ps9.aplicacion.CopySalida;
import com.bbva.jee.arq.spring.core.servicing.gce.BusinessServiceException;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author Entelgy
 * @param <E> Objeto de entrada.
 * @param <FE> Formato de Entrada
 * @param <S> Objeto de salida.
 * @param <FS> Formato de salida original
 * @param <FSI> Formato de salida interno al formato de salida original (FS).
 */
public abstract class SimpleDobleFormatBbvaTransaction<E, FE, S, FS, FSI> implements ISimpleBbvaTransaction<E, S> {

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
	protected abstract S mapResponseFormatToDtoOut(FS formatOutput, E dtoIn, S dtoOut);

	/**
	 * @param formatInnerOutput
	 * @param dtoOut
	 * @return
	 */
	protected abstract S mapResponseFormatToInnerDtoOfOutDto(FSI formatInnerOutput, S dtoOut);

	/**
	 * @return
	 */
	protected abstract InvocadorTransaccion<?, ?> getTransaction();

	/**
	 * @param entrada
	 * @return
	 */
	@Override
	@SuppressWarnings({ "unchecked" })
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
			final List<CopySalida> copiesSalida = respuesta.getCuerpo().getPartes(CopySalida.class);


			final ParameterizedType typeInterfaceOutput = (ParameterizedType)this.getClass().getGenericSuperclass();
			final Type[] typesOutput = typeInterfaceOutput.getActualTypeArguments();

			// Get output class
			final Class<?> claseSalida = (Class<?>)typesOutput[2];
			S salida = (S)claseSalida.newInstance();

			// Obtenemos el formato de salida
			FS formatoSalida = null;
			FSI formatoSalidaInterno = null;

			for (CopySalida copySalida : copiesSalida) {

				if (copySalida != null) {

					final Class<FS> claseFormatoSalida = (Class<FS>)typesOutput[3];
					formatoSalida = copySalida.getCopy(claseFormatoSalida);
					if (formatoSalida != null) {
						salida = mapResponseFormatToDtoOut(formatoSalida, entrada, salida);
					} else {
						final Class<FSI> claseFormatoSalidaInterno = (Class<FSI>)typesOutput[4];
						formatoSalidaInterno = copySalida.getCopy(claseFormatoSalidaInterno);
						if (formatoSalidaInterno != null) {
							salida = mapResponseFormatToInnerDtoOfOutDto(formatoSalidaInterno, salida);
						}
					}
				}
			}

			// return outputReturn;
			return salida;

		} catch (final Exception iae) {
			throw new BusinessServiceException(EnumError.TECHNICAL_ERROR.getAlias(), iae);
		}

	}
}
