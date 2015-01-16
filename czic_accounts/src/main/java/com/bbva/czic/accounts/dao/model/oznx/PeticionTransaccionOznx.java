package com.bbva.czic.accounts.dao.model.oznx;

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
 * <p>Transacci&oacute;n <code>OZNX</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionOznx</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionOznx</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: COBD.CN.TMP.QGDTCCT.OZOZNX.txt
 * OZNXCONSULTA DETALLE DE CHEQUES        OZ        OZ1COZNXBVDKNPO OZECNXE0            OZNX  NS3000NNNNNN    SSTN    C   SNNSSNNN  NN                2015-01-09CICSDC112015-01-1412.06.29CICSDC112015-01-09-18.13.37.923655CICSDC110001-01-010001-01-01
 * 
 * FICHERO: COBD.CN.TMP.QGDTFDF.OZECNXE0.txt
 * OZECNXE0�E - DETALLE CHEQUES CHEQUERA  �F�06�00047�01�00001�INDPAGI�INDICE DE PAGINACION�S�003�0�R�        �
 * OZECNXE0�E - DETALLE CHEQUES CHEQUERA  �F�06�00047�02�00004�TAMPAGI�TAMANO DE LA PAGINA �S�003�0�R�        �
 * OZECNXE0�E - DETALLE CHEQUES CHEQUERA  �F�06�00047�03�00007�NUMPROD�NUMERO DE PRODUCTO  �A�020�0�R�        �
 * OZECNXE0�E - DETALLE CHEQUES CHEQUERA  �F�06�00047�04�00027�FECHINI�FECHA INICIAL       �A�010�0�O�        �
 * OZECNXE0�E - DETALLE CHEQUES CHEQUERA  �F�06�00047�05�00037�FECHFIN�FECHA FINAL         �A�010�0�O�        �
 * OZECNXE0�E - DETALLE CHEQUES CHEQUERA  �F�06�00047�06�00047�ESTCHEQ�ESTADO CHEQUE       �A�001�0�O�        �
 * 
 * FICHERO: COBD.CN.TMP.QGDTFDF.OZECNXS0.txt
 * OZECNXS0�S - DETALLE CHEQUES CHEQUERA  �X�07�00070�01�00016�INDPAGI�INDICE DE PAGINACION�S�003�0�S�        �
 * OZECNXS0�S - DETALLE CHEQUES CHEQUERA  �X�07�00070�02�00022�NUMPROD�NUMERO DE PRODUCTO  �A�020�0�S�        �
 * OZECNXS0�S - DETALLE CHEQUES CHEQUERA  �X�07�00070�03�00045�NUMCHEQ�NUMERO DE CHEQUE    �A�009�0�S�        �
 * OZECNXS0�S - DETALLE CHEQUES CHEQUERA  �X�07�00070�04�00057�FECHEMI�FECHA EMISION CHEQUE�A�010�0�S�        �
 * OZECNXS0�S - DETALLE CHEQUES CHEQUERA  �X�07�00070�05�00070�VALCHEQ�VALOR DEL CHEQUE    �S�017�2�S�        �
 * OZECNXS0�S - DETALLE CHEQUES CHEQUERA  �X�07�00070�06�00090�ESTCHEQ�ESTADO DEL CHEQUE   �A�001�0�S�        �
 * OZECNXS0�S - DETALLE CHEQUES CHEQUERA  �X�07�00070�07�00094�FECHMOD�FECHA MODIFICACION  �A�010�0�S�        �
 * 
 * FICHERO: COBD.CN.TMP.QGDTFDX.OZOZNX.txt
 * OZNXOZECNXS0COPY    OZECNSX01S                             CICSDC112015-01-14-12.08.06.147080CICSDC112015-01-14-12.08.06.147094
 * 
</pre></code>
 * 
 * @see RespuestaTransaccionOznx
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "OZNX",
	tipo = 1, 
	subtipo = 1,	
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionOznx.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoOZECNXE0.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionOznx implements MensajeMultiparte {
	
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