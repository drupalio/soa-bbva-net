package com.bbva.czic.globalposition.dao.model.oznh;

import com.bbva.jee.arq.spring.core.host.Atributo;
import com.bbva.jee.arq.spring.core.host.Cuerpo;
import com.bbva.jee.arq.spring.core.host.CuerpoMultiparte;
import com.bbva.jee.arq.spring.core.host.MensajeMultiparte;
import com.bbva.jee.arq.spring.core.host.Multiformato;
import com.bbva.jee.arq.spring.core.host.Transaccion;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

/**
 * <p>Transacci&oacute;n <code>OZNH</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionOznh</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionOznh</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: DBG.CN.YLQ.QGDTCCT.KNOZNH.txt
 * OZNHBLOQUEO DE OPERACIONES             OZ        OZ1COZNHBVDKNPO OZNCEOMH            OZNH  NS3000NNNNNN    SSTN    C   SNNSSNNN  NN                2014-12-30CICSDC112015-01-1118.46.48CE33823 2014-12-30-09.03.53.738759CICSDC110001-01-010001-01-01
 * 
 * FICHERO: DBG.CN.YLQ.QGDTFDF.OZNCEOMH.txt
 * OZNCEOMH�NUMERO DE CUENTA              �F�02�00021�01�00001�NUMCTA �NUMERO DE CUENTA    �A�020�0�R�        �
 * OZNCEOMH�NUMERO DE CUENTA              �F�02�00021�02�00021�CODBLQ �CODIGO DE BLOQUEO   �A�001�0�R�        �
 * 
</pre></code>
 * 
 * @see RespuestaTransaccionOznh
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "OZNH",
	tipo = 1, 
	subtipo = 1,	
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionOznh.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoOZNCEOMH.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionOznh implements MensajeMultiparte {
	
	/**
	 * <p>Cuerpo del mensaje de petici&oacute;n multiparte</p>
	 */
	@Cuerpo
	private CuerpoMultiparte cuerpo = new CuerpoMultiparte();
	
	/**
	 * <p>Permite obtener el cuerpo del mensaje de petici&oacute;n multiparte</p>
	 */
	@Override
	public CuerpoMultiparte getCuerpo() {
		return cuerpo;
	}
	
}