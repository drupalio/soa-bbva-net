package com.bbva.czic.products.dao.model.oznm;

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
 * <p>Transacci&oacute;n <code>OZNM</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionOznm</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionOznm</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: DBG.CN.JEF.QGDTCCT.KNOZNM.txt
 * OZNMDETALLE DE MOVIMIENTOS             OZ        OZ1COZNMBVDKNPO OZNCENM0            OZNM  NS3000CNNNNN    SSTN    C   SNNSSNNN  NN                2014-12-22CE33514 2015-08-2008.19.27CE39010 2014-12-22-10.06.02.965828CE33514 0001-01-010001-01-01
 * 
 * FICHERO: DBG.CN.JEF.QGDTFDF.OZNCENM0.txt
 * OZNCENM0�FORMATO ENTRADA OZNM          �F�03�00031�01�00001�NOCUENT�NUMERO DE CUENTA    �A�020�0�R�        �
 * OZNCENM0�FORMATO ENTRADA OZNM          �F�03�00031�02�00021�TIPROD �TIPO DE PRODUCTO    �A�002�0�R�        �
 * OZNCENM0�FORMATO ENTRADA OZNM          �F�03�00031�03�00023�NUMMOV �NUMERO DE MOVIMIENTO�A�009�0�R�        �
 * 
 * FICHERO: DBG.CN.JEF.QGDTFDF.OZNCSNM0.txt
 * OZNCSNM0�FORMATO SALIDA OZNM           �X�14�00234�01�00001�NUMECTA�NUMERO DE CUENTA    �A�020�0�S�        �
 * OZNCSNM0�FORMATO SALIDA OZNM           �X�14�00234�02�00021�TIPO   �TIPO PRODUCTO       �A�002�0�S�        �
 * OZNCSNM0�FORMATO SALIDA OZNM           �X�14�00234�03�00023�NUMMOV �NUMERO DE OPERACION �A�009�0�S�        �
 * OZNCSNM0�FORMATO SALIDA OZNM           �X�14�00234�04�00032�FCHOPER�FECHA DE OPERACION  �A�015�0�S�        �
 * OZNCSNM0�FORMATO SALIDA OZNM           �X�14�00234�05�00047�RESTO  �RESTO               �A�030�0�S�        �
 * OZNCSNM0�FORMATO SALIDA OZNM           �X�14�00234�06�00077�VALOR  �VALOR               �A�016�0�S�        �
 * OZNCSNM0�FORMATO SALIDA OZNM           �X�14�00234�07�00093�BALOPER�BALANCE DE LA OPERAC�A�016�0�S�        �
 * OZNCSNM0�FORMATO SALIDA OZNM           �X�14�00234�08�00109�CODOPER�CODIGO TIPO OPER    �A�002�0�S�        �
 * OZNCSNM0�FORMATO SALIDA OZNM           �X�14�00234�09�00111�DESCODI�DESCRIPCION DEL CODI�A�030�0�S�        �
 * OZNCSNM0�FORMATO SALIDA OZNM           �X�14�00234�10�00141�FCHVALR�FECHA VALOR         �A�010�0�S�        �
 * OZNCSNM0�FORMATO SALIDA OZNM           �X�14�00234�11�00151�PLAZA  �PLAZA               �A�030�0�S�        �
 * OZNCSNM0�FORMATO SALIDA OZNM           �X�14�00234�12�00181�SALDO  �SALDO               �A�016�0�S�        �
 * OZNCSNM0�FORMATO SALIDA OZNM           �X�14�00234�13�00197�CTROORG�CENTRO ORIGEN       �A�030�0�S�        �
 * OZNCSNM0�FORMATO SALIDA OZNM           �X�14�00234�14�00227�NUMCLIE�NUMERO DE ID        �A�008�0�S�        �
 * 
 * FICHERO: DBG.CN.JEF.QGDTFDX.KNOZNM.txt
 * OZNMOZNCSNM0OZNCSNM0OZ1COZNM1S3000S400                     CE33514 2014-12-22-10.25.33.005014CE33514 2014-12-22-10.25.33.005082
 * 
</pre></code>
 * 
 * @see RespuestaTransaccionOznm
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "OZNM",
	tipo = 1, 
	subtipo = 1,	
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionOznm.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoOZNCENM0.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionOznm implements MensajeMultiparte {
	
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