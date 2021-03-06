package com.bbva.czic.customers.dao.model.oznp;

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
 * <p>Transacci&oacute;n <code>OZNP</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionOznp</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionOznp</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: DOF.CN.NOV.QGDTCCT.KNOZNP.txt
 * OZNPLISTA CARGOS DE TARJETA DE CREDITO OZ        OZ1COZNPBVDKNPO OZECNPE0            OZNP  NS3000NNNNNN    SSTN    C   SNNSSNNN  NN                2014-12-21CE15505 2014-12-2123.23.40CE15505 2014-12-21-23.06.07.491432CE15505 0001-01-010001-01-01
 * 
 * FICHERO: COBD.CN.TMP.QGDTFDF.OZECNPE0.txt
 * OZECNPE0�E - LISTA CARGOS TARJETA CREDI�F�03�00028�01�00001�IDUSUAR�ID DE USUARIO       �A�008�0�O�        �
 * OZECNPE0�E - LISTA CARGOS TARJETA CREDI�F�03�00028�02�00009�FECHAIN�FECHA INICIAL CALCUL�A�010�0�R�        �
 * OZECNPE0�E - LISTA CARGOS TARJETA CREDI�F�03�00028�03�00019�FECHAFI�FECHA FINAL CALCULO �A�010�0�R�        �
 * 
 * FICHERO: COBD.CN.TMP.QGDTFDF.OZECNPS0.txt
 * OZECNPS0�S - LISTA CARGOS TARJETA CREDI�X�02�00052�01�00001�CATEGOR�CATEGORIA GENERAL TC�A�035�0�S�        �
 * OZECNPS0�S - LISTA CARGOS TARJETA CREDI�X�02�00052�02�00036�VALCATE�VALOR CATEGORIA TC  �N�017�2�S�        �
 * 
 * FICHERO: COBD.CN.TMP.QGDTFDX.OZOZNP.txt
 * OZNPOZECNPS0OZECNPS0OZ1COZNP1S                             CE15505 2014-12-21-23.15.27.104933CE15505 2014-12-21-23.15.27.104947
 * 
</pre></code>
 * 
 * @see RespuestaTransaccionOznp
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "OZNP",
	tipo = 1, 
	subtipo = 1,	
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionOznp.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoOZECNPE0.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionOznp implements MensajeMultiparte {
	
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