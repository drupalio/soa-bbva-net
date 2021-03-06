package com.bbva.czic.accounts.dao.model.oznu;

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
 * <p>Transacci&oacute;n <code>OZNU</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionOznu</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionOznu</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: OZNUcct.txt
 * OZNUCONSULTA MOVIMIENTOS CTAS PERSONAL OZ        OZ1COZNUBVDKNPO OZECNUE0            OZNU  NS3000NNNNNN    SSTN    C   SNNSSNNN  NN                2015-01-05CICSDC112015-01-0611.48.47CICSDC112015-01-05-16.18.58.263593CICSDC110001-01-010001-01-01
 * 
 * FICHERO: OZECNUE0fdf.txt
 * OZECNUE0�E - CONSULTAR CTAS PERSONALES �F�02�00022�01�00001�NUMPROD�NUMERO DE PRODUCTO  �A�020�0�R�        �
 * OZECNUE0�E - CONSULTAR CTAS PERSONALES �F�02�00022�02�00021�INTERVM�INTERVALO MES       �A�002�0�R�        �
 * 
 * FICHERO: COBD.CN.TMP.QGDTFDF.OZECNUS0_V2.txt
 * OZECNUS0�S - CONSULTAR CTAS PERSONALES �X�04�00063�01�00001�VALDEPO�VALOR DEPOSITO      �A�018�0�S�        �
 * OZECNUS0�S - CONSULTAR CTAS PERSONALES �X�04�00063�02�00020�VALCARG�VALOR CARGO         �A�018�0�S�        �
 * OZECNUS0�S - CONSULTAR CTAS PERSONALES �X�04�00063�03�00039�SALDTOT�SALDO TOTAL         �A�018�0�S�        �
 * OZECNUS0�S - CONSULTAR CTAS PERSONALES �X�04�00063�04�00058�MES    �MES ANO EVALUO      �A�006�0�S�        �
 * 
 * FICHERO: OZNUfdx.txt
 * OZNUOZECNUS0OZCENUS0OZ1COZNU1S                             CICSDC112015-01-05-16.36.49.992036CICSDC112015-01-05-18.27.17.175152
 * 
</pre></code>
 * 
 * @see RespuestaTransaccionOznu
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "OZNU",
	tipo = 1, 
	subtipo = 1,	
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionOznu.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoOZECNUE0.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionOznu implements MensajeMultiparte {
	
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