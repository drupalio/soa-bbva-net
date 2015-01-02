package com.bbva.czic.loan.dao.model.oznj;

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
 * <p>Transacci&oacute;n <code>OZNJ</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionOznj</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionOznj</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: DOF.CN.YLQ.QGDTCCT.KNOZNJ.txt
 * OZNJENCABEZADO RESUMEN CUPO ROTATIVO   OZ        OZ1COZNJBVDKNPO OZNCENJ0            OZNJ  NS3000NNNNNN    SSTN    C   SNNSSNNN  NN                2014-12-22CE33823 2014-12-2209.37.46CE33823 2014-12-22-09.32.31.242359CE33823 0001-01-010001-01-01
 * 
 * FICHERO: DOF.CN.YLQ.QGDTFDF.OZNCENMJ.txt
 * OZNCENJ0�ENTRADA RESUMEN CUPO ROTATIVO �F�01�00020�01�00001�NUMPROD�NUMERO DE PRODUCTO  �A�020�0�O�        �
 * 
 * FICHERO: DOF.CN.YLQ.QGDTFDF.OZNCSNMJ.txt
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�13�00131�01�00001�TIPPROD�TIPO DE PRODUCTO    �N�002�0�S�        �
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�13�00131�02�00003�NOMPROD�NOMBRE DE PRODUCTO  �N�010�0�S�        �
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�13�00131�03�00013�SALDOTO�SALDO TOTAL         �S�015�2�S�        �
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�13�00131�04�00028�SALDODI�SALDO DISPONIBLE    �S�015�2�S�        �
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�13�00131�05�00043�MONTOSO�MONTO SOLICITADO    �S�015�2�S�        �
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�13�00131�06�00058�SALDOPE�SALDO PENDIENTE     �S�015�2�S�        �
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�13�00131�07�00073�FECHAVE�FECHA VENCIMIENTO   �A�010�0�S�        �
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�13�00131�08�00083�FECHAPA�FECHA PAGO          �A�010�0�S�        �
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�13�00131�09�00093�FECHACO�FECHA CORTE         �A�010�0�S�        �
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�13�00131�10�00103�HONORAR�HONORARIOS          �S�015�2�S�        �
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�13�00131�11�00118�NUMCOUT�NUMERO DE CUOTAS    �A�002�0�S�        �
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�13�00131�12�00120�ESTADO �ESTADO DE LA TARJETA�A�002�0�S�        �
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�13�00131�13�00122�NUMERO �NUMERO DE OPERACION �A�010�0�S�        �
 * 
 * FICHERO: DOF.CN.YLQ.QGDTFDX.KNOZNJ.txt
 * OZNJOZNCSNJ0OZNCSNJ0OZ1COZNJ1S3000S400                     CE33823 2014-12-22-09.46.29.405335CE33823 2014-12-22-09.46.29.405409
 * 
</pre></code>
 * 
 * @see RespuestaTransaccionOznj
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "OZNJ",
	tipo = 1, 
	subtipo = 1,	
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionOznj.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoOZNCENJ0.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionOznj implements MensajeMultiparte {
	
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