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
 * <code><pre> * FICHERO: DBG.CN.JEF.QGDTCCT.KNOZNK.txt
 * OZNKDETALLE Y SALDO DE CUPO ROTATIVO   OZ        OZ1COZNKBVDKNPO OZNCENK0            OZNM  NS3000CNNNNN    SSTN    C   SNNSSNNN  NN                2014-12-22CE33823 2015-03-0310.26.53CE33514 2014-12-22-09.53.34.739073CE33823 0001-01-010001-01-01
 * 
 * FICHERO: DBG.CN.JEF.QGDTFDF.OZNCENK0.txt
 * OZNCENK0�FORMARTO DE ENTRADA DETALLE CR�F�03�00030�01�00001�NOMTARJ�NUMERO DE TARJETA   �A�020�0�O�        �
 * OZNCENK0�FORMARTO DE ENTRADA DETALLE CR�F�03�00030�02�00021�NOMMOVI�NUMERO DE MOVIMIENTO�A�006�0�O�        �
 * OZNCENK0�FORMARTO DE ENTRADA DETALLE CR�F�03�00030�03�00027�NOMEXTR�NUMERO DE EXTRACTO  �A�004�0�O�        �
 * 
 * FICHERO: DBG.CN.JEF.QGDTFDF.OZNCSNK0.txt
 * OZNCSNK0�FORMATO DE SALIDA DETALLE CR  �X�08�00080�01�00001�NUMEMOV�NUMERO DE MOVIMIENTO�A�006�0�S�        �
 * OZNCSNK0�FORMATO DE SALIDA DETALLE CR  �X�08�00080�02�00007�FECHAOP�FECHA OPERACION     �A�010�0�S�        �
 * OZNCSNK0�FORMATO DE SALIDA DETALLE CR  �X�08�00080�03�00017�RESTO  �RESTO / TIPO DE OPER�A�002�0�S�        �
 * OZNCSNK0�FORMATO DE SALIDA DETALLE CR  �X�08�00080�04�00019�IMPORTE�IMPORTE DE OPERACION�A�012�0�S�        �
 * OZNCSNK0�FORMATO DE SALIDA DETALLE CR  �X�08�00080�05�00031�BALANCE�BALANCE OPERACION   �A�012�0�S�        �
 * OZNCSNK0�FORMATO DE SALIDA DETALLE CR  �X�08�00080�06�00043�DESCOP �DESC DE OPERACION   �A�030�0�S�        �
 * OZNCSNK0�FORMATO DE SALIDA DETALLE CR  �X�08�00080�07�00073�COUTAF �CUOTAS FACTURADAS   �A�004�0�S�        �
 * OZNCSNK0�FORMATO DE SALIDA DETALLE CR  �X�08�00080�08�00077�COUTAT �CUOTAS TOTALES      �A�004�0�S�        �
 * 
 * FICHERO: DBG.CN.JEF.QGDTFDX.KNOZNK.txt
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