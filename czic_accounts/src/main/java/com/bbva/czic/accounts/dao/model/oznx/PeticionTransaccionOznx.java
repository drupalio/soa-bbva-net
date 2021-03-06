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
 * <code><pre> * FICHERO: OZNXcct.TXT
 * OZNXCONSULTA DETALLE DE CHEQUES        OZ        OZ1COZNXBVDKNPO OZECNXE0            OZNX  NS3000NNNNNN    SSTN    C   SNNSSNNN  NN                2015-01-09CICSDC112015-01-1412.06.29CICSDC112015-01-09-18.13.37.923655CICSDC110001-01-010001-01-01
 * 
 * FICHERO: OZECNXE0fdf.TXT
 * OZECNXE0�E - DETALLE CHEQUES CHEQUERA  �F�06�00047�01�00001�INDPAGI�INDICE DE PAGINACION�S�003�0�R�        �
 * OZECNXE0�E - DETALLE CHEQUES CHEQUERA  �F�06�00047�02�00004�TAMPAGI�TAMANO DE LA PAGINA �S�003�0�R�        �
 * OZECNXE0�E - DETALLE CHEQUES CHEQUERA  �F�06�00047�03�00007�NUMPROD�NUMERO DE PRODUCTO  �A�020�0�R�        �
 * OZECNXE0�E - DETALLE CHEQUES CHEQUERA  �F�06�00047�04�00027�FECHINI�FECHA INICIAL       �A�010�0�O�        �
 * OZECNXE0�E - DETALLE CHEQUES CHEQUERA  �F�06�00047�05�00037�FECHFIN�FECHA FINAL         �A�010�0�O�        �
 * OZECNXE0�E - DETALLE CHEQUES CHEQUERA  �F�06�00047�06�00047�ESTCHEQ�ESTADO CHEQUE       �A�001�0�O�        �
 * 
 * FICHERO: OZECNXS0fdf.TXT
 * OZECNXS0�S - DETALLE CHEQUES CHEQUERA  �X�07�00072�01�00001�INDPAGI�INDICE DE PAGINACION�S�003�0�S�        �
 * OZECNXS0�S - DETALLE CHEQUES CHEQUERA  �X�07�00072�02�00004�NUMPROD�NUMERO DE PRODUCTO  �A�020�0�S�        �
 * OZECNXS0�S - DETALLE CHEQUES CHEQUERA  �X�07�00072�03�00024�NUMCHEQ�NUMERO DE CHEQUE    �A�009�0�S�        �
 * OZECNXS0�S - DETALLE CHEQUES CHEQUERA  �X�07�00072�04�00033�FECHEMI�FECHA EMISION CHEQUE�A�010�0�S�        �
 * OZECNXS0�S - DETALLE CHEQUES CHEQUERA  �X�07�00072�05�00043�VALCHEQ�VALOR DEL CHEQUE    �A�018�0�S�        �
 * OZECNXS0�S - DETALLE CHEQUES CHEQUERA  �X�07�00072�06�00062�ESTCHEQ�ESTADO DEL CHEQUE   �A�001�0�S�        �
 * OZECNXS0�S - DETALLE CHEQUES CHEQUERA  �X�07�00072�07�00063�FECHMOD�FECHA MODIFICACION  �A�010�0�S�        �
 * 
 * FICHERO: OZNXfdx.TXT
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