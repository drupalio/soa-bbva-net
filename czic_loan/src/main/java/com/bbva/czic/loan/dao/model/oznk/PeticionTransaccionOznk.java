package com.bbva.czic.loan.dao.model.oznk;

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
 * <p>Transacci&oacute;n <code>OZNK</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionOznk</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionOznk</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: DOF.CN.YLQ.QGDTCCT.KNOZNK.txt
 * OZNKDETALLE Y SALDO DE CUPO ROTATIVO   OZ        OZ1COZNKBVDKNPO OZNCENK0            OZNI  NS3000NNNNNN    SSTN    C   SNNSSNNN  NN                2014-12-22CE33823 2014-12-2209.56.03CE33823 2014-12-22-09.53.34.739073CE33823 0001-01-010001-01-01
 * 
 * FICHERO: DOF.CN.YLQ.QGDTFDF.OZNCENK0.txt
 * OZNCENK0�AREA DE PAGINACION            �F�01�00010�01�00001�NOMOPER�NUMERO DE OPERACION �A�010�0�O�        �
 * 
 * FICHERO: DOF.CN.YLQ.QGDTFDF.OZNCSNK0.txt
 * OZNCSNK0�SALIDA DETALLE DE MOV CUPO ROT�X�08�00122�01�00001�FECHAO �FECHA DE OPERACION  �A�010�0�S�        �
 * OZNCSNK0�SALIDA DETALLE DE MOV CUPO ROT�X�08�00122�02�00011�RESTO  �RESTO               �S�015�2�S�        �
 * OZNCSNK0�SALIDA DETALLE DE MOV CUPO ROT�X�08�00122�03�00026�IMPORTE�IMPORTE             �A�010�0�S�        �
 * OZNCSNK0�SALIDA DETALLE DE MOV CUPO ROT�X�08�00122�04�00036�BALANCE�BALANCE DE OPERACIO �S�015�2�S�        �
 * OZNCSNK0�SALIDA DETALLE DE MOV CUPO ROT�X�08�00122�05�00051�DESCOP �DESC DE OPERACION   �A�050�0�S�        �
 * OZNCSNK0�SALIDA DETALLE DE MOV CUPO ROT�X�08�00122�06�00101�COUTAS �CUOTAS FACTURADAS   �A�010�0�S�        �
 * OZNCSNK0�SALIDA DETALLE DE MOV CUPO ROT�X�08�00122�07�00111�COUTAT �CUOTAS TOTALES      �A�010�0�S�        �
 * OZNCSNK0�SALIDA DETALLE DE MOV CUPO ROT�X�08�00122�08�00121�ESTADO �ESTADO              �A�002�0�S�        �
 * 
 * FICHERO: DOF.CN.YLQ.QGDTFDX.KNOZNK.txt
 * OZNKOZNCSNK0OZNCSNK0OZ1COZNK1S3000S400                     CE33823 2014-12-22-09.54.36.059386CE33823 2014-12-22-09.54.36.059435
 * 
</pre></code>
 * 
 * @see RespuestaTransaccionOznk
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "OZNK",
	tipo = 1, 
	subtipo = 1,	
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionOznk.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoOZNCENK0.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionOznk implements MensajeMultiparte {
	
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