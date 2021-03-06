package com.bbva.czic.accounts.dao.model.ozns;

import com.bbva.czic.accounts.dao.model.ozns.RespuestaTransaccionOzns;
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
 * <p>Transacci&oacute;n <code>OZNS</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionOzns</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionOzns</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: COBD.CN.TMP.QGDTCCT.OZOZNS.txt
 * OZNSCONSULTAR CHEQUERAS - NET CORPORATIOZ        OZ1COZNSBVDKNPO OZECNSE0            OZNS  NS3000NNNNNN    SSTN    C   SNNSSNNN  NN                2014-12-21CE15505 2014-12-2200.15.34CE15505 2014-12-21-23.59.01.342540CE15505 0001-01-010001-01-01
 * 
 * FICHERO: COBD.CN.TMP.QGDTFDF.OZECNSE0.txt
 * OZECNSE0�E - CONSULTA CHEQUERAS - NET C�F�02�00040�01�00001�NUMCUEN�NUMERO CTA ASOCIADA �A�020�0�R�        �
 * OZECNSE0�E - CONSULTA CHEQUERAS - NET C�F�02�00040�02�00021�NUMCHEQ�NUMERO CHEQUERA     �A�020�0�R�        �
 * 
 * FICHERO: COBD.CN.TMP.QGDTFDF.OZECNSS0.txt
 * OZECNSS0�S - CONSULTA CHEQUERA         �X�06�00044�01�00001�PRIMCHQ�PRIMER CHEQUE       �A�010�0�S�        �
 * OZECNSS0�S - CONSULTA CHEQUERA         �X�06�00044�02�00011�ULTICHQ�ULTIMO NUMERO CHEQUE�A�010�0�S�        �
 * OZECNSS0�S - CONSULTA CHEQUERA         �X�06�00044�03�00021�TOTACHQ�TOTAL DE CHEQUES    �A�003�0�S�        �
 * OZECNSS0�S - CONSULTA CHEQUERA         �X�06�00044�04�00024�FECEMIS�FECHA DE EMISION    �A�010�0�S�        �
 * OZECNSS0�S - CONSULTA CHEQUERA         �X�06�00044�05�00034�FECENTR�FECHA DE ENTREGA    �A�010�0�S�        �
 * OZECNSS0�S - CONSULTA CHEQUERA         �X�06�00044�06�00044�ESTACHQ�ESTADO DE CHEQUERA  �A�001�0�S�        �
 * 
 * FICHERO: COBD.CN.TMP.QGDTFDX.OZOZNS.txt
 * OZNSOZECNSS0OZECNSS0OZ1COZNS1S                             CE15505 2014-12-22-00.21.22.557483CE15505 2014-12-22-00.21.22.557495
 * 
</pre></code>
 * 
 * @see RespuestaTransaccionOzns
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "OZNS",
	tipo = 1, 
	subtipo = 1,	
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionOzns.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoOZECNSE0.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionOzns implements MensajeMultiparte {
	
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