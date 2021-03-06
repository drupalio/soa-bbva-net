package com.bbva.czic.accounts.dao.model.ozny;

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
 * <p>Transacci&oacute;n <code>OZNY</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionOzny</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionOzny</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: COBD.CN.TMP.QGDTCCT.OZOZNY.TXT
 * OZNYLISTA DETALLE DE UN CHEQUE         OZ        OZ1COZNYBVDKNPO OZECNYE0            OZNY  NS3000NNNNNN    SSTN    C   SNNSSNNN  NN                2015-01-05CICSDC112015-01-2811.38.42CE15505 2015-01-05-17.44.43.866591CICSDC110001-01-010001-01-01
 * 
 * FICHERO: COBD.CN.TMP.QGDTFDF.OZECNYE0.TXT
 * OZECNYE0�E - DETALLE DE UN CHEQUE      �F�03�00030�01�00016�NUMPROD�NUMERO DE CUENTA    �A�020�0�R�        �
 * OZECNYE0�E - DETALLE DE UN CHEQUE      �F�03�00030�02�00039�NUMCHEQ�NUMERO DE CHEQUE    �A�009�0�R�        �
 * OZECNYE0�E - DETALLE DE UN CHEQUE      �F�03�00030�03�00051�ESTCHEQ�ESTADO DEL CHEQUE   �A�001�0�O�        �
 * 
 * FICHERO: COBD.CN.TMP.QGDTFDF.OZECNYS0.txt
 * OZECNYS0�S - CONSULTA CHEQUERA         �X�05�00049�01�00001�NUMCHEQ�NUMERO DE CHEQUE    �A�009�0�S�        �
 * OZECNYS0�S - CONSULTA CHEQUERA         �X�05�00049�02�00010�FECHEMI�FECHA EMISION CHEQUE�A�010�0�S�        �
 * OZECNYS0�S - CONSULTA CHEQUERA         �X�05�00049�03�00020�VALCHEQ�VALOR DEL CHEQUE    �A�018�0�S�        �
 * OZECNYS0�S - CONSULTA CHEQUERA         �X�05�00049�04�00039�ESTCHEQ�ESTADO CHEQUE       �A�001�0�S�        �
 * OZECNYS0�S - CONSULTA CHEQUERA         �X�05�00049�05�00040�FECMODI�FECHA MODIFICACION  �A�010�0�S�        �
 * 
 * FICHERO: COBD.CN.TMP.QGDTFDX.OZOZNY.TXT
 * OZNYOZECNYS0OZECNYS0OZ1COZNY1S                             CICSDC112015-01-05-18.03.56.142566CICSDC112015-01-11-14.16.54.600287
 * 
</pre></code>
 * 
 * @see RespuestaTransaccionOzny
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "OZNY",
	tipo = 1, 
	subtipo = 1,	
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionOzny.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoOZECNYE0.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionOzny implements MensajeMultiparte {
	
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