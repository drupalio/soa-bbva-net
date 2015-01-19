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
 * <code><pre> * FICHERO: DBG.CN.JEF.QGDTCCT.KNOZNJ.txt
 * OZNJENCABEZADO RESUMEN CUPO ROTATIVO   OZ        OZ1COZNJBVDKNPO OZNCENJ0            OZNJ  NS3000CNNNNN    SSTN    C   SNNNSNNN  NN                2014-12-22CE33823 2015-01-1316.11.58CE33823 2014-12-22-09.32.31.242359CE33823 0001-01-010001-01-01
 * 
 * FICHERO: DBG.CN.JEF.QGDTFDF.OZNCENJ0.txt
 * OZNCENJ0�ENTRADA RESUMEN CUPO ROTATIVO �F�01�00020�01�00001�NOMTARJ�NUMERO DE TARJETAO  �A�020�0�O�        �
 * 
 * FICHERO: DBG.CN.JEF.QGDTFDF.OZNCSNJ0.txt
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�13�00215�01�00001�NUMCONT�NUMERO DE CONTRATO  �A�020�0�S�        �
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�13�00215�02�00021�TIPPROD�TIPO DE PRODUCTO    �A�002�0�S�        �
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�13�00215�03�00023�DESCTAR�DESCRIPCION TARJETA �A�020�0�S�        �
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�13�00215�04�00043�SALDOTO�SALDO TOTAL         �A�012�0�S�        �
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�13�00215�05�00055�PAGOMIN�PAGO MINIMO         �A�012�0�S�        �
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�13�00215�06�00067�MNTOSOL�MONTO SOLICITADO    �A�012�0�S�        �
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�13�00215�07�00079�SALDOPE�SALDO PENDIENTE     �A�012�0�S�        �
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�13�00215�08�00091�FECHACA�FECHA CADUCACION    �A�010�0�S�        �
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�13�00215�09�00101�FECHALI�FECHA LIMITE        �A�010�0�S�        �
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�13�00215�10�00111�FECHACO�FECHA CORTE         �A�010�0�S�        �
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�13�00215�11�00121�HONORAR�HONORARIOS          �A�012�0�S�        �
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�13�00215�12�00133�CUOTATO�CUOTA TOTAL         �A�003�0�S�        �
 * OZNCSNJ0�SALIDA RESUMEN CUPO ROTATIVO  �X�13�00215�13�00136�ESTADOT�ESTADO TARJETA      �A�080�0�S�        �
 * 
 * FICHERO: DBG.CN.JEF.QGDTFDX.KNOZNJ.txt
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