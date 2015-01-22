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
 * <code><pre> * FICHERO: DOF.CN.DCG.QGDTFDX.KNOZNB.txt
 * OZNBOZNCSNB0COPY    OZ1COZNB1S                             CE33514 2015-01-08-14.40.42.760078CE33514 2015-01-08-14.40.42.760092
 * 
 * FICHERO: DOF.CN.DCG.QGDTFDF.OZNCSNB0.OZNCSNB0.txt
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�16�00235�01�00016�NUMCLIE�NUMERO DEL CLIENTE  �A�008�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�16�00235�02�00027�NOMCLIE�NOMBRE DEL CLIENTE  �A�050�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�16�00235�03�00080�SEGMENT�SEGMENTO            �A�001�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�16�00235�04�00084�CORREO �CORREO ELECT USUARIO�A�050�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�16�00235�05�00137�DESCVIA�UBICA DE LA VIVIENDA�A�050�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�16�00235�06�00190�CIUDVIA�CIUD DE LA VIVIENDA �A�003�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�16�00235�07�00196�DEPAVIA�DEPTO DE LA VIVIENDA�A�002�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�16�00235�08�00201�PAISVIA�PAIS DE LA VIVIENDA �A�004�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�16�00235�09�00208�ESTRATO�ESTRATO SOCIOECONOMI�A�002�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�16�00235�10�00213�ANOSVDA�A�OS DE RESIDENCIA  �A�002�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�16�00235�11�00218�NROPNAS�CTDAD MIEMBROS HOGAR�A�003�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�16�00235�12�00224�TPOVVDA�TIPO DE RESIDENCIA  �A�001�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�16�00235�13�00228�DESCOFI�UBICAC DE LA OFICINA�A�050�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�16�00235�14�00281�CIUDOFI�CIUD DE LA OFICINA  �A�003�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�16�00235�15�00287�DEPAOFI�DPTO DE LA OFICINA  �A�002�0�S�        �
 * OZNCSNB0�FORMATO SALIDA OZNB           �X�16�00235�16�00292�PAISOFI�PAIS DE LA OFICINA  �A�004�0�S�        �
 * 
 * FICHERO: DOF.CN.DCG.QGDTFDF.OZNCENB0.OZNCENB0.txt
 * OZNCENB0�FORMATO DE ENTRADA OZNB       �F�01�00008�01�00001�NUMCLIE�IDENTIFICADOR CLIENT�A�008�0�R�        �
 * 
 * FICHERO: DOF.CN.DCG.QGDTCCT.KNOZNB.txt
 * OZNBCONSULTA DATOS BASICOS DEL CLIENTE OZ        OZ1COZNBBVDKNPO OZNCENB0            OZNB  NS3000CNNNNN    SSTN    C   SNNNSNNN  NN                2015-01-07CE33822 2015-01-2015.39.24CE33514 2015-01-07-17.55.44.663987CE33822 0001-01-010001-01-01
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