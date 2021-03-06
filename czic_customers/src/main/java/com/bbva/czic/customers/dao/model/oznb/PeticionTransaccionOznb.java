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
 * OZNBCONSULTA DATOS BASICOS DEL CLIENTE OZ        OZ1COZNBBVDKNPO OZNCENB0            OZNB  NN3000CNNNNN    SSTN    C   SNNNSNNN  NN                2015-01-07CE33822 2015-02-1609.26.41CE33514 2015-01-07-17.55.44.663987CE33822 0001-01-010001-01-01
 * 
 * FICHERO: DOF.CN.DCG.QGDTFDF.OZNCENB0.txt
 * OZNCENB0�FORMATO DE ENTRADA OZNB       �F�01�00035�01�00001�CLVEACC�CLAVE DE ACCESO     �A�035�0�O�        �
 * 
 * FICHERO: DOF.CN.DCG.QGDTFDF.OZNCSNB0.txt
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�17�00278�01�00001�NUMCLIE�NUMERO DE CLIENTE   �A�008�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�17�00278�02�00009�NOMCLIE�NOMBRE DEL CLIENTE  �A�050�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�17�00278�03�00059�SEGMENT�SEGMENTO            �A�001�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�17�00278�04�00060�CORREO �CORREO ELECT USUARIO�A�050�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�17�00278�05�00110�DESCVIA�UBICA DE LA VIVIENDA�A�050�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�17�00278�06�00160�CIUDVIA�CIUD DE LA VIVIENDA �A�003�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�17�00278�07�00163�DEPAVIA�DEPTO DE LA VIVIENDA�A�002�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�17�00278�08�00165�PAISVIA�PAIS DE LA VIVIENDA �A�004�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�17�00278�09�00169�ESTRATO�ESTRATO SOCIOECONOMI�A�002�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�17�00278�10�00171�ANOSVDA�A�OS DE RESIDENCIA  �A�002�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�17�00278�11�00173�NROPNAS�CTDAD MIEMBROS HOGAR�A�003�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�17�00278�12�00176�TPOVVDA�TIPO DE RESIDENCIA  �A�001�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�17�00278�13�00177�DESCOFI�UBICAC DE LA OFICINA�A�050�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�17�00278�14�00227�CIUDOFI�CIUD DE LA OFICINA  �A�003�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�17�00278�15�00230�DEPAOFI�DPTO DE LA OFICINA  �A�002�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�17�00278�16�00232�PAISOFI�PAIS DE LA OFICINA  �A�004�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�17�00278�17�00236�ULTCONX�ULTIMA CONEXION     �A�043�0�S�        �
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