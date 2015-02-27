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
 * OZNKDETALLE Y SALDO DE CUPO ROTATIVO   OZ        OZ1COZNKBVDKNPO OZNCENK0            OZNK  NS3000CNNNNN    SSTN    C   SNNNSNNN  NN                2014-12-22CE33823 2015-01-1316.14.26CE33822 2014-12-22-09.53.34.739073CE33823 0001-01-010001-01-01
 * 
 * FICHERO: DBG.CN.JEF.QGDTFDF.OZNCENK0.txt
 * OZNCENK0�AREA DE PAGINACION            �F�02�00026�01�00001�NOMMOVI�NUMERO DE MOVIMIENTO�S�006�0�O�        �
 * OZNCENK0�AREA DE PAGINACION            �F�02�00026�02�00007�NOMTARJ�NUMERO DE TARJETA   �A�020�0�O�        �
 * 
 * FICHERO: DBG.CN.JEF.QGDTFDF.OZNCSNK0.txt
 * OZNCSNK0�SALIDA DETALLE DE MOV CUPO ROT�X�09�00162�01�00001�NUMEMOV�NUMERO DE MOVIMIENTO�A�008�0�S�        �
 * OZNCSNK0�SALIDA DETALLE DE MOV CUPO ROT�X�09�00162�02�00009�FECHAOP�FECHA OPERACION     �A�010�0�S�        �
 * OZNCSNK0�SALIDA DETALLE DE MOV CUPO ROT�X�09�00162�03�00019�RESTO  �RESTO / TIPO DE OPER�A�002�0�S�        �
 * OZNCSNK0�SALIDA DETALLE DE MOV CUPO ROT�X�09�00162�04�00021�IMPORTE�IMPORTE DE OPERACION�A�012�0�S�        �
 * OZNCSNK0�SALIDA DETALLE DE MOV CUPO ROT�X�09�00162�05�00033�BALANCE�BALANCE OPERACION   �A�012�0�S�        �
 * OZNCSNK0�SALIDA DETALLE DE MOV CUPO ROT�X�09�00162�06�00045�DESCOP �DESC DE OPERACION   �A�030�0�S�        �
 * OZNCSNK0�SALIDA DETALLE DE MOV CUPO ROT�X�09�00162�07�00075�COUTAF �CUOTAS FACTURADAS   �A�004�0�S�        �
 * OZNCSNK0�SALIDA DETALLE DE MOV CUPO ROT�X�09�00162�08�00079�COUTAT �CUOTAS TOTALES      �A�004�0�S�        �
 * OZNCSNK0�SALIDA DETALLE DE MOV CUPO ROT�X�09�00162�09�00083�ESTADO �ESTADO DE TARJETA   �A�080�0�S�        �
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