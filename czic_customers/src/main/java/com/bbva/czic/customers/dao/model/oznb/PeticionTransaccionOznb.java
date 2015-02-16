package com.bbva.czic.customers.dao.model.oznb;

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
 * <p>Transacci&oacute;n <code>OZNB</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionOznb</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionOznb</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: DOF.CN.DCG.QGDTCCT.KNOZNB.txt
 * OZNBCONSULTA DATOS BASICOS DEL CLIENTE OZ        OZ1COZNBBVDKNPO OZNCENB0            OZNB  NS3000NNNNNN    SSTN    C   SNNSSNNN  NN                2015-01-07CE33822 2015-02-1316.47.57CE33514 2015-01-07-17.55.44.663987CE33822 0001-01-010001-01-01
 * 
 * FICHERO: DOF.CN.DCG.QGDTFDF.OZNCENB0.txt
 * OZNCENB0�FORMATO DE ENTRADA OZNB       �F�01�00035�01�00001�CLVEACC�CLAVE DE ACCESO     �A�035�0�R�        �
 * 
 * FICHERO: DOF.CN.DCG.QGDTFDF.OZNCSNB0.txt
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�16�00270�01�00001�NOMCLIE�NOMBRE DEL CLIENTE  �A�050�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�16�00270�02�00051�SEGMENT�SEGMENTO            �A�001�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�16�00270�03�00052�CORREO �CORREO ELECT USUARIO�A�050�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�16�00270�04�00102�DESCVIA�UBICA DE LA VIVIENDA�A�050�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�16�00270�05�00152�CIUDVIA�CIUD DE LA VIVIENDA �A�003�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�16�00270�06�00155�DEPAVIA�DEPTO DE LA VIVIENDA�A�002�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�16�00270�07�00157�PAISVIA�PAIS DE LA VIVIENDA �A�004�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�16�00270�08�00161�ESTRATO�ESTRATO SOCIOECONOMI�A�002�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�16�00270�09�00163�ANOSVDA�A�OS DE RESIDENCIA  �A�002�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�16�00270�10�00165�NROPNAS�CTDAD MIEMBROS HOGAR�A�003�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�16�00270�11�00168�TPOVVDA�TIPO DE RESIDENCIA  �A�001�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�16�00270�12�00169�DESCOFI�UBICAC DE LA OFICINA�A�050�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�16�00270�13�00219�CIUDOFI�CIUD DE LA OFICINA  �A�003�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�16�00270�14�00222�DEPAOFI�DPTO DE LA OFICINA  �A�002�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�16�00270�15�00224�PAISOFI�PAIS DE LA OFICINA  �A�004�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�16�00270�16�00228�ULTCONX�ULTIMA CONEXION     �A�043�0�S�        �
 * 
 * FICHERO: DOF.CN.DCG.QGDTFDX.KNOZNB.txt
 * OZNBOZNCSNB0COPY    OZ1COZNB1S                             CE33514 2015-01-08-14.40.42.760078CE33514 2015-01-08-14.40.42.760092
 * 
</pre></code>
 * 
 * @see RespuestaTransaccionOznb
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "OZNB",
	tipo = 1, 
	subtipo = 1,	
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionOznb.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoOZNCENB0.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionOznb implements MensajeMultiparte {
	
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