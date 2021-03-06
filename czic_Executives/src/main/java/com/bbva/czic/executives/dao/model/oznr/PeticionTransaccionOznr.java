package com.bbva.czic.executives.dao.model.oznr;

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
 * <p>Transacci&oacute;n <code>OZNR</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionOznr</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionOznr</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: COBD.CN.TMP.QGDTCCT.OZOZNR.TXT
 * OZNRCONSULTAR EJECUTIVO - NET CORPORATIOZ        OZ1COZNRBVDKNPO OZECNRE0            OZNR  NS3000NNNNNN    SSTN    C   SNNSSNNN  NN                2014-12-21CE15505 2014-12-2122.44.30CE15505 2014-12-21-21.30.54.003024CE15505 0001-01-010001-01-01
 * 
 * FICHERO: COBD.CN.TMP.QGDTFDF.OZECNRE0.TXT
 * OZECNRE0�E - CONSULTAR EJECUTIVO       �F�01�00008�01�00001�IDUSUAR�ID DE USUARIO       �A�008�0�R�        �
 * 
 * FICHERO: COBD.CN.TMP.QGDTFDF.OZECNRS0.TXT
 * OZECNRS0�S - CONSULTA EJECUTIVO        �X�05�00119�01�00001�IDEJECU�ID DEL EJECUTIVO    �A�015�0�S�        �
 * OZECNRS0�S - CONSULTA EJECUTIVO        �X�05�00119�02�00016�NOMEJEC�NOMBRE DEL EJECUTIVO�A�040�0�S�        �
 * OZECNRS0�S - CONSULTA EJECUTIVO        �X�05�00119�03�00056�TELEJEC�TELEFONO DE EJECUTIV�A�010�0�S�        �
 * OZECNRS0�S - CONSULTA EJECUTIVO        �X�05�00119�04�00066�OFIEJEC�OFICINA DE EJECUTIVO�A�004�0�S�        �
 * OZECNRS0�S - CONSULTA EJECUTIVO        �X�05�00119�05�00070�EMAILEJ�EMAIL DEL EJECUTIVO �A�050�0�S�        �
 * 
 * FICHERO: COBD.CN.TMP.QGDTFDX.OZOZNR.TXT
 * OZNROZECNRS0OZECNRS0OZ1COZNR1S                             CE15505 2014-12-21-22.54.58.276700CE15505 2014-12-21-22.54.58.276744
 * 
</pre></code>
 * 
 * @see RespuestaTransaccionOznr
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "OZNR",
	tipo = 1, 
	subtipo = 1,	
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionOznr.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoOZECNRE0.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionOznr implements MensajeMultiparte {
	
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