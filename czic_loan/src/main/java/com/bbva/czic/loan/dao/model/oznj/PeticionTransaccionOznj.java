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
 * <code><pre> * FICHERO: DBG.CN.YLQ.QGDTCCT.KNOZNJ.txt
 * OZNJENCABEZADO RESUMEN CUPO ROTATIVO   OZ        OZ1COZNJBVDKNPO OZNCENJ0            OZNM  NS3000NNNNNN    SSTN    C   SNNSSNNN  NN                2014-12-22CE33823 2015-01-2911.58.40CICSDC112014-12-22-09.32.31.242359CE33823 0001-01-010001-01-01
 * 
 * FICHERO: DBG.CN.YLQ.QGDTFDF.OZNCENJ0.txt
 * OZNCENJ0�ENTRADA RESUMEN CUPO ROTATIVO �F�01�00020�01�00001�NOMTARJ�NUMERO DE TARJETAO  �A�020�0�O�        �
 * 
 * FICHERO: DBG.CN.YLQ.QGDTFDF.OZNCSNJ0.txt
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�14�00227�01�00001�NUMCONT�NUMERO DE CONTRATO  �A�020�0�S�        �
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�14�00227�02�00021�TIPPROD�TIPO DE PRODUCTO    �A�002�0�S�        �
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�14�00227�03�00023�DESCTAR�DESCRIPCION TARJETA �A�020�0�S�        �
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�14�00227�04�00043�SALDOTO�SALDO TOTAL         �A�012�0�S�        �
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�14�00227�05�00055�SALDODI�SALDO DISPONIBLE    �A�012�0�S�        �
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�14�00227�06�00067�PAGOMIN�PAGO MINIMO         �A�012�0�S�        �
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�14�00227�07�00079�MNTOSOL�MONTO SOLICITADO    �A�012�0�S�        �
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�14�00227�08�00091�SALDOPE�SALDO PENDIENTE     �A�012�0�S�        �
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�14�00227�09�00103�FECHACA�FECHA CADUCACION    �A�010�0�S�        �
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�14�00227�10�00113�FECHALI�FECHA LIMITE        �A�010�0�S�        �
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�14�00227�11�00123�FECHACO�FECHA CORTE         �A�010�0�S�        �
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�14�00227�12�00133�HONORAR�HONORARIOS          �A�012�0�S�        �
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�14�00227�13�00145�CUOTATO�CUOTA TOTAL         �A�003�0�S�        �
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�14�00227�14�00148�ESTADOT�ESTADO TARJETA      �A�080�0�S�        �
 * 
 * FICHERO: DBG.CN.YLQ.QGDTFDX.KNOZNJ.txt
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