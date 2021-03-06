package com.bbva.czic.cards.dao.model.ozno;

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
 * <p>Transacci&oacute;n <code>OZNO</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionOzno</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionOzno</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: COBD.CN.TMP.QGDTCCT.OZOZNO.txt
 * OZNOCONSULTA CARGOS TARJETA DE CREDITO OZ        OZ1COZNOBVDKNPO OZECNOE0            OZNO  NS3000CNNNNN    SSTN    C   SNNSSNNN  NN                2014-12-22CE15505 2015-10-0618.44.01CE37479 2014-12-22-00.28.48.527183CE15505 0001-01-010001-01-01
 * 
 * FICHERO: COBD.CN.TMP.QGDTFDF.OZECNOE0.txt
 * OZECNOE0�E - LISTA CARGOS TARJETA CREDI�F�03�00036�01�00001�NUMPROD�NUMERO DE PRODUCTO  �A�016�0�O�        �
 * OZECNOE0�E - LISTA CARGOS TARJETA CREDI�F�03�00036�02�00017�FECHAIN�FECHA INICIAL EVALUO�A�010�0�O�        �
 * OZECNOE0�E - LISTA CARGOS TARJETA CREDI�F�03�00036�03�00027�FECHAFI�FECHA FINAL EVALUO  �A�010�0�O�        �
 * 
 * FICHERO: COBD.CN.TMP.QGDTFDF.OZECNOS0.txt
 * OZECNOS0�S - LISTA CARGOS TARJETA CREDI�X�02�00052�01�00001�CATEGOR�CATEGORIA GENERAL TC�A�035�0�S�        �
 * OZECNOS0�S - LISTA CARGOS TARJETA CREDI�X�02�00052�02�00036�VALCATE�VALOR CATEGORIA TC  �A�017�0�S�        �
 * 
 * FICHERO: COBD.CN.TMP.QGDTFDX.OZOZNO.txt
 * OZNOOZECNOS0OZECNOS0OZ1COZNO1S                             CE15505 2014-12-22-00.33.54.412429CE15505 2014-12-22-00.33.54.412440
 * 
</pre></code>
 * 
 * @see RespuestaTransaccionOzno
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "OZNO",
	tipo = 1, 
	subtipo = 1,	
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionOzno.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoOZECNOE0.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionOzno implements MensajeMultiparte {
	
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