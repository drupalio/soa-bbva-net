package com.bbva.czic.customers.dao.model.oznz;

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
 * <p>Transacci&oacute;n <code>OZNZ</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionOznz</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionOznz</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: DOF.CN.DCG.QGDTCCT.KNOZNZ.txt
 * OZNZVERIFYCUSTOMER - NET CORPORATIVA   OZ        OZ1COZNZBVDKNPO OZECNZE0            OZNZ  NS3000NNNNNN    SSTN    C   SNNSSNNN  NN                2015-01-29CICSDC112015-02-1914.59.34CE33514 2015-01-29-22.59.17.851243CICSDC110001-01-010001-01-01
 * 
 * FICHERO: DOF.CN.DCG.QGDTFDF.OZECNZE0.txt
 * OZECNZE0�E - VERIFYCUSTOMER - NET CORPO�F�09�00117�01�00001�TIPOOPE�TIPO DE OPERACION   �A�001�0�R�        �
 * OZECNZE0�E - VERIFYCUSTOMER - NET CORPO�F�09�00117�02�00002�CANAL  �CANAL OPERACION     �A�004�0�O�        �
 * OZECNZE0�E - VERIFYCUSTOMER - NET CORPO�F�09�00117�03�00006�IDCLIEN�ID CLIENTE          �A�008�0�R�        �
 * OZECNZE0�E - VERIFYCUSTOMER - NET CORPO�F�09�00117�04�00014�USUARIO�USUARIO CLIENTE OPER�A�008�0�R�        �
 * OZECNZE0�E - VERIFYCUSTOMER - NET CORPO�F�09�00117�05�00022�NUMTARJ�NUMERO DE LA TARJETA�A�016�0�R�        �
 * OZECNZE0�E - VERIFYCUSTOMER - NET CORPO�F�09�00117�06�00038�CLATARJ�CLAVE DE LA TARJETA �A�004�0�R�        �
 * OZECNZE0�E - VERIFYCUSTOMER - NET CORPO�F�09�00117�07�00042�NUMDOCU�NUMERO DE DOCUMENTO �A�015�0�R�        �
 * OZECNZE0�E - VERIFYCUSTOMER - NET CORPO�F�09�00117�08�00057�TIPDOCU�TIPO DE DOCUMENTO   �A�001�0�R�        �
 * OZECNZE0�E - VERIFYCUSTOMER - NET CORPO�F�09�00117�09�00058�EMAIL  �CORREO ELECTRONICO  �A�060�0�O�        �
 * 
</pre></code>
 * 
 * @see RespuestaTransaccionOznz
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "OZNZ",
	tipo = 1, 
	subtipo = 1,	
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionOznz.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoOZECNZE0.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionOznz implements MensajeMultiparte {
	
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