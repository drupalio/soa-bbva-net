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
 * <code><pre> * FICHERO: COBD.CN.TMP.QGDTCCT.OZOZNZ.txt
 * OZNZVERIFYCUSTOMER - NET CORPORATIVA   OZ        OZ1COZNZBVDKNPO OZECNZE0            OZNZ  NS3000NNNNNN    SSTN    C   SNNSSNNN  NN                2015-01-29CICSDC112015-01-2923.17.55CICSDC112015-01-29-22.59.17.851243CICSDC110001-01-010001-01-01
 * 
 * FICHERO: COBD.CN.TMP.QGDTFDF.OZECNZE0.txt
 * OZECNZE0�E - VERIFYCUSTOMER - NET CORPO�E�09�00156�01�00016�TIPOOPE�TIPO DE OPERACION   �A�001�0�R�        �
 * OZECNZE0�E - VERIFYCUSTOMER - NET CORPO�E�09�00156�02�00020�CANAL  �CANAL OPERACION     �A�004�0�O�        �
 * OZECNZE0�E - VERIFYCUSTOMER - NET CORPO�E�09�00156�03�00027�IDCLIEN�ID CLIENTE          �A�008�0�R�        �
 * OZECNZE0�E - VERIFYCUSTOMER - NET CORPO�E�09�00156�04�00038�USUARIO�USUARIO CLIENTE OPER�A�008�0�R�        �
 * OZECNZE0�E - VERIFYCUSTOMER - NET CORPO�E�09�00156�05�00049�NUMTARJ�NUMERO DE LA TARJETA�A�016�0�R�        �
 * OZECNZE0�E - VERIFYCUSTOMER - NET CORPO�E�09�00156�06�00068�CLATARJ�CLAVE DE LA TARJETA �A�004�0�R�        �
 * OZECNZE0�E - VERIFYCUSTOMER - NET CORPO�E�09�00156�07�00075�NUMDOCU�NUMERO DE DOCUMENTO �A�015�0�R�        �
 * OZECNZE0�E - VERIFYCUSTOMER - NET CORPO�E�09�00156�08�00093�TIPDOCU�TIPO DE DOCUMENTO   �A�001�0�R�        �
 * OZECNZE0�E - VERIFYCUSTOMER - NET CORPO�E�09�00156�09�00097�EMAIL  �CORREO ELECTRONICO  �A�060�0�O�        �
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
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "BMS")}
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