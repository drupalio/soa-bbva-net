package com.bbva.czic.products.dao.model.ozn2;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import com.bbva.jee.arq.spring.core.host.Atributo;
import com.bbva.jee.arq.spring.core.host.Cuerpo;
import com.bbva.jee.arq.spring.core.host.CuerpoMultiparte;
import com.bbva.jee.arq.spring.core.host.MensajeMultiparte;
import com.bbva.jee.arq.spring.core.host.Multiformato;
import com.bbva.jee.arq.spring.core.host.Transaccion;

/**
 * <p>Transacci&oacute;n <code>OZN2</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionOzn2</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionOzn2</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: QGDTFDX.OZOZN2.TXT
 * OZN2OZECN2S0OZECN2S0OZ1COZ551S3000S400                     CE33823 2015-01-29-12.28.32.040340CE33823 2015-01-29-12.28.32.040387
 * 
 * FICHERO: QGDTFDF.OZECNLS0.TXT
 * OZECN2S0�FORM SALIDA EXTRACTOS OZN2    �X�18�01800�01�00001�SALTR01�SUBTRAMA SAL UNO    �A�100�0�S�        �
 * OZECN2S0�FORM SALIDA EXTRACTOS OZN2    �X�18�01800�02�00101�SALTR02�SUBTRAMA SAL DOS    �A�100�0�S�        �
 * OZECN2S0�FORM SALIDA EXTRACTOS OZN2    �X�18�01800�03�00201�SALTR03�SUBTRAMA SAL TRES   �A�100�0�S�        �
 * OZECN2S0�FORM SALIDA EXTRACTOS OZN2    �X�18�01800�04�00301�SALTR04�SUBTRAMA SAL CUATRO �A�100�0�S�        �
 * OZECN2S0�FORM SALIDA EXTRACTOS OZN2    �X�18�01800�05�00401�SALTR05�SUBTRAMA SAL CINCO  �A�100�0�S�        �
 * OZECN2S0�FORM SALIDA EXTRACTOS OZN2    �X�18�01800�06�00501�SALTR06�SUBTRAMA SAL SEIS   �A�100�0�S�        �
 * OZECN2S0�FORM SALIDA EXTRACTOS OZN2    �X�18�01800�07�00601�SALTR07�SUBTRAMA SAL SIETE  �A�100�0�S�        �
 * OZECN2S0�FORM SALIDA EXTRACTOS OZN2    �X�18�01800�08�00701�SALTR08�SUBTRAMA SAL OCHO   �A�100�0�S�        �
 * OZECN2S0�FORM SALIDA EXTRACTOS OZN2    �X�18�01800�09�00801�SALTR09�SUBTRAMA SAL NUEVE  �A�100�0�S�        �
 * OZECN2S0�FORM SALIDA EXTRACTOS OZN2    �X�18�01800�10�00901�SALTR10�SUBTRAMA SAL DIEZ   �A�100�0�S�        �
 * OZECN2S0�FORM SALIDA EXTRACTOS OZN2    �X�18�01800�11�01001�SALTR11�SUBTRAMA SAL ONCE   �A�100�0�S�        �
 * OZECN2S0�FORM SALIDA EXTRACTOS OZN2    �X�18�01800�12�01101�SALTR12�SUBTRAMA SAL DOCE   �A�100�0�S�        �
 * OZECN2S0�FORM SALIDA EXTRACTOS OZN2    �X�18�01800�13�01201�SALTR13�SUBTRAMA SAL TRECE  �A�100�0�S�        �
 * OZECN2S0�FORM SALIDA EXTRACTOS OZN2    �X�18�01800�14�01301�SALTR14�SUBTRAMA SAL CATORCE�A�100�0�S�        �
 * OZECN2S0�FORM SALIDA EXTRACTOS OZN2    �X�18�01800�15�01401�SALTR15�SUBTRAMA SAL QUINCE �A�100�0�S�        �
 * OZECN2S0�FORM SALIDA EXTRACTOS OZN2    �X�18�01800�16�01501�SALTR16�SUBTRAMA SAL DIESEI �A�100�0�S�        �
 * OZECN2S0�FORM SALIDA EXTRACTOS OZN2    �X�18�01800�17�01601�SALTR17�SUBTRAMA SAL DIESIE �A�100�0�S�        �
 * OZECN2S0�FORM SALIDA EXTRACTOS OZN2    �X�18�01800�18�01701�SALTR18�SUBTRAMA SAL DIEOCH �A�100�0�S�        �
 * 
 * FICHERO: QGDTFDF.OZECNLE0.TXT
 * OZECN2E0�FORM ENTRADA EXTRACTOS OZN2   �F�11�01004�01�00001�LONGTRA�LONGITUD DE TRAMA   �N�004�0�O�        �
 * OZECN2E0�FORM ENTRADA EXTRACTOS OZN2   �F�11�01004�02�00005�SUBTRM1�SUBTRAMA UNO        �A�100�0�O�        �
 * OZECN2E0�FORM ENTRADA EXTRACTOS OZN2   �F�11�01004�03�00105�SUBTRM2�SUBTRAMA DOS        �A�100�0�O�        �
 * OZECN2E0�FORM ENTRADA EXTRACTOS OZN2   �F�11�01004�04�00205�SUBTRM3�SUBTRAMA TRES       �A�100�0�O�        �
 * OZECN2E0�FORM ENTRADA EXTRACTOS OZN2   �F�11�01004�05�00305�SUBTRM4�SUBTRAMA CUATRO     �A�100�0�O�        �
 * OZECN2E0�FORM ENTRADA EXTRACTOS OZN2   �F�11�01004�06�00405�SUBTRM5�SUBTRAMA CINCO      �A�100�0�O�        �
 * OZECN2E0�FORM ENTRADA EXTRACTOS OZN2   �F�11�01004�07�00505�SUBTRM6�SUBTRAMA SEIS       �A�100�0�O�        �
 * OZECN2E0�FORM ENTRADA EXTRACTOS OZN2   �F�11�01004�08�00605�SUBTRM7�SUBTRAMA SIETE      �A�100�0�O�        �
 * OZECN2E0�FORM ENTRADA EXTRACTOS OZN2   �F�11�01004�09�00705�SUBTRM8�SUBTRAMA OCHO       �A�100�0�O�        �
 * OZECN2E0�FORM ENTRADA EXTRACTOS OZN2   �F�11�01004�10�00805�SUBTRM9�SUBTRAMA NUEVE      �A�100�0�O�        �
 * OZECN2E0�FORM ENTRADA EXTRACTOS OZN2   �F�11�01004�11�00905�SUBTRM0�SUBTRAMA DIEZ       �A�100�0�O�        �
 * 
 * FICHERO: QGDTCCT.OZOZN2.TXT
 * OZN2EXTRACTOS                          OZ        OZ1COZN2BVDKNPO OZECN2E0            OZNM  NS3000NNNNNN    SSTN    C   SNNSSNNN  NN                2015-01-29CE33823 2015-01-2917.33.18CE33824 2015-01-29-12.22.59.337324CE33823 0001-01-010001-01-01
 * 
</pre></code>
 * 
 * @see RespuestaTransaccionOzn2
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "OZN2",
	tipo = 1, 
	subtipo = 1,	
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionOzn2.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoOZECN2E0.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionOzn2 implements MensajeMultiparte {
	
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