package com.bbva.czic.movements.dao.model.oznm;

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
 * <code><pre> * FICHERO: DOF.CN.YLQ.QGDTCCT.KNOZNM.TXT
 * OZNMDETALLE DE MOVIMIENTOS             OZ        OZ1COZNMBVDKNPO OZNCENM0            OZNM  NS3000NNNNNN    SSTN    C   SNNSSNNN  NN                2014-12-22CE33514 2014-12-2210.21.58CE33514 2014-12-22-10.06.02.965828CE33514 0001-01-010001-01-01
 * 
 * FICHERO: DOF.CN.YLQ.QGDTFDF.OZNCENM0.TXT
 * OZNCENM0�FORMATO ENTRADA OZNM          �F�02�00029�01�00001�NUMMOV �NUMERO DE MOVIMIENTO�A�009�0�R�        �
 * OZNCENM0�FORMATO ENTRADA OZNM          �F�02�00029�02�00010�NOCUENT�NUMERO DE CUENTA    �A�020�0�R�        �
 * 
 * FICHERO: DOF.CN.YLQ.QGDTFDF.OZNCSNM0.TXT
 * OZNCSNM0�FORMATO SALIDA OZNM           �X�15�00251�01�00001�NUMECTA�NUMERO DE CUENTA    �A�023�0�S�        �
 * OZNCSNM0�FORMATO SALIDA OZNM           �X�15�00251�02�00024�NOMOVIM�NUMERO DE MOVIMEINTO�S�009�0�S�        �
 * OZNCSNM0�FORMATO SALIDA OZNM           �X�15�00251�03�00033�FCHOPER�FECHA DE OPERACION  �A�010�0�S�        �
 * OZNCSNM0�FORMATO SALIDA OZNM           �X�15�00251�04�00043�FCHVALR�FECHA VALOR         �A�010�0�S�        �
 * OZNCSNM0�FORMATO SALIDA OZNM           �X�15�00251�05�00053�HRAOPER�HORA DE LA OPERACION�A�008�0�S�        �
 * OZNCSNM0�FORMATO SALIDA OZNM           �X�15�00251�06�00061�VALOR  �VALOR               �S�017�2�S�        �
 * OZNCSNM0�FORMATO SALIDA OZNM           �X�15�00251�07�00078�SALDO  �SALDO               �S�017�2�S�        �
 * OZNCSNM0�FORMATO SALIDA OZNM           �X�15�00251�08�00095�CHEQUE �CHEQUE              �S�009�0�S�        �
 * OZNCSNM0�FORMATO SALIDA OZNM           �X�15�00251�09�00104�CODIGO �CODIGO              �A�003�0�S�        �
 * OZNCSNM0�FORMATO SALIDA OZNM           �X�15�00251�10�00107�DESCODI�DESCRIPCION DEL CODI�A�030�0�S�        �
 * OZNCSNM0�FORMATO SALIDA OZNM           �X�15�00251�11�00137�OBSERVA�OBSERVACIONES       �A�030�0�S�        �
 * OZNCSNM0�FORMATO SALIDA OZNM           �X�15�00251�12�00167�CTROORG�CENTRO ORIGEN       �A�030�0�S�        �
 * OZNCSNM0�FORMATO SALIDA OZNM           �X�15�00251�13�00197�PLAZA  �PLAZA               �A�030�0�S�        �
 * OZNCSNM0�FORMATO SALIDA OZNM           �X�15�00251�14�00227�CTATRAS�CTA DE TRASPASO     �A�023�0�S�        �
 * OZNCSNM0�FORMATO SALIDA OZNM           �X�15�00251�15�00250�TIPO   �TIPO                �A�002�0�S�        �
 * 
 * FICHERO: DOF.CN.YLQ.QGDTFDX.KNOZNM.TXT
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