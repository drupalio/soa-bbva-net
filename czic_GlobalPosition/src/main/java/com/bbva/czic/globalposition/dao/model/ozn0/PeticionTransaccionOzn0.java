package com.bbva.czic.globalposition.dao.model.ozn0;

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
 * <p>Transacci&oacute;n <code>OZN0</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionOzn0</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionOzn0</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: DOF.CN.YLQ.QGDTCCT.KNOZN0.txt
 * OZN0OCU/MUESTRA POSICION GLOBAL        OZ        OZ1COZN0BVDKNPO OZNCEOM0            OZN0  NS3000CNNNNN    SSTN    C   SNNSSNNN  NN                2014-12-22CE33821 2015-01-1118.44.45CE33823 2014-12-22-09.30.34.026864CE33821 0001-01-010001-01-01
 * 
 * FICHERO: DOF.CN.YLQ.QGDTFDF.OZNCEOM0.txt
 * OZNCEOM0�NUMERO DE CUENTA              �F�02�00024�01�00001�NUMCTA �NUMERO DE CUENTA    �A�020�0�R�        �
 * OZNCEOM0�NUMERO DE CUENTA              �F�02�00024�02�00021�INDCTA �INDICADOR CUENTA    �A�004�0�R�        �
 * 
</pre></code>
 * 
 * @see RespuestaTransaccionOzn0
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "OZN0",
	tipo = 1, 
	subtipo = 1,	
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionOzn0.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoOZNCEOM0.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionOzn0 implements MensajeMultiparte {
	
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