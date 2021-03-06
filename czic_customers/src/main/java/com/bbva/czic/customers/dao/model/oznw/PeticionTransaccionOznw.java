package com.bbva.czic.customers.dao.model.oznw;

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
 * <p>Transacci&oacute;n <code>OZNW</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionOznw</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionOznw</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: DOF.CN.DCG.QGDTCCT.KNOZNW.txt
 * OZNWADDCHANNEL - NET CORPORATIVA       OZ        OZ1COZNWBVDKNPO OZECNWE0            OZNW  NS3000NNNNNN    SSTN    C   SNNSSNNN  NN                2015-01-29CICSDC112015-01-2923.17.44CICSDC112015-01-29-22.58.51.274149CICSDC110001-01-010001-01-01
 * 
 * FICHERO: DOF.CN.DCG.QGDTFDF.OZECNWE0.txt
 * OZECNWE0�E - ADDCHANNEL - NET CORPORATI�F�02�00012�01�00001�USUARIO�USUARIO OPERACION   �A�008�0�O�        �
 * OZECNWE0�E - ADDCHANNEL - NET CORPORATI�F�02�00012�02�00009�CANAL  �CANAL OPERACION     �A�004�0�O�        �
 * 
</pre></code>
 * 
 * @see RespuestaTransaccionOznw
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "OZNW",
	tipo = 1, 
	subtipo = 1,	
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionOznw.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoOZECNWE0.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionOznw implements MensajeMultiparte {
	
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