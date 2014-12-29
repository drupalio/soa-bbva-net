package com.bbva.czic.globalposition.dao.model.ozn1;

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
 * <p>Transacci&oacute;n <code>OZN1</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionOzn1</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionOzn1</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: OZECN1E0_FDF.txt
 * OZECN1E0�E - POS GLOBAL NET CORPORATIVA�F�02�00010�01�00001�NUMCLIE�NUMERO DE CLIENTE   �A�008�0�R�        �
 * OZECN1E0�E - POS GLOBAL NET CORPORATIVA�F�02�00010�02�00009�TIPPROD�TIPO DE PRODUCTO    �A�002�0�O�        �
 * 
 * FICHERO: OZECN1S0_FDF.txt
 * OZECN1S0�S - POS GLOBAL NET CORPORATIVA�X�10�00122�01�00001�TIPPROD�TIPO DE PRODUCTO    �A�002�0�S�        �
 * OZECN1S0�S - POS GLOBAL NET CORPORATIVA�X�10�00122�02�00003�NUMPROD�NUMERO DE PRODUCTO  �A�020�0�S�        �
 * OZECN1S0�S - POS GLOBAL NET CORPORATIVA�X�10�00122�03�00023�SALCANJ�SALDO EN CANJE      �A�019�0�S�        �
 * OZECN1S0�S - POS GLOBAL NET CORPORATIVA�X�10�00122�04�00042�SALTOTA�SALDO TOTAL         �A�019�0�S�        �
 * OZECN1S0�S - POS GLOBAL NET CORPORATIVA�X�10�00122�05�00061�SALDISP�SALDO DISPONIBLE    �A�019�0�S�        �
 * OZECN1S0�S - POS GLOBAL NET CORPORATIVA�X�10�00122�06�00080�INDVISI�INDICADOR VISIBILIDA�A�001�0�S�        �
 * OZECN1S0�S - POS GLOBAL NET CORPORATIVA�X�10�00122�07�00081�INDOPER�INDICADOR OPERABILID�A�001�0�S�        �
 * OZECN1S0�S - POS GLOBAL NET CORPORATIVA�X�10�00122�08�00082�ALIAS  �ALIAS DEL PRODUCTO  �A�020�0�S�        �
 * OZECN1S0�S - POS GLOBAL NET CORPORATIVA�X�10�00122�09�00102�NOMPROD�NOMBRE DEL PRODUCTO �A�020�0�S�        �
 * OZECN1S0�S - POS GLOBAL NET CORPORATIVA�X�10�00122�10�00122�FINSTAT�ACTIVO O PASIVO     �A�001�0�S�        �
 * 
 * FICHERO: OZECN1S1_FDF.txt
 * OZECN1S1�S - POS GLOBAL NET CORP. NOCOM�X�12�00149�01�00001�TIPPROD�TIPO DE PRODUCTO    �A�002�0�S�        �
 * OZECN1S1�S - POS GLOBAL NET CORP. NOCOM�X�12�00149�02�00003�NUMPROD�NUMERO DE PRODUCTO  �A�020�0�S�        �
 * OZECN1S1�S - POS GLOBAL NET CORP. NOCOM�X�12�00149�03�00023�SALTOTA�SALDO TOTAL         �A�019�0�S�        �
 * OZECN1S1�S - POS GLOBAL NET CORP. NOCOM�X�12�00149�04�00042�SALDISP�SALDO DISPONIBLE    �A�019�0�S�        �
 * OZECN1S1�S - POS GLOBAL NET CORP. NOCOM�X�12�00149�05�00061�INDVISI�INDICADOR VISIBILIDA�A�001�0�S�        �
 * OZECN1S1�S - POS GLOBAL NET CORP. NOCOM�X�12�00149�06�00062�INDOPER�INDICADOR OPERABILID�A�001�0�S�        �
 * OZECN1S1�S - POS GLOBAL NET CORP. NOCOM�X�12�00149�07�00063�ALIAS  �ALIAS DEL PRODUCTO  �A�020�0�S�        �
 * OZECN1S1�S - POS GLOBAL NET CORP. NOCOM�X�12�00149�08�00083�NOMPROD�NOMBRE DEL PRODUCTO �A�020�0�S�        �
 * OZECN1S1�S - POS GLOBAL NET CORP. NOCOM�X�12�00149�09�00103�FINSTAT�ACTIVO O PASIVO     �A�001�0�S�        �
 * OZECN1S1�S - POS GLOBAL NET CORP. NOCOM�X�12�00149�10�00104�NUMTARJ�NUMERO DE TARJETA   �A�016�0�S�        �
 * OZECN1S1�S - POS GLOBAL NET CORP. NOCOM�X�12�00149�11�00120�NUMCONT�NUMERO CONTRATO TARJ�A�020�0�S�        �
 * OZECN1S1�S - POS GLOBAL NET CORP. NOCOM�X�12�00149�12�00140�NUMCELU�NUMERO CELULAR - DDE�A�010�0�S�        �
 * 
 * FICHERO: OZN1_CCT.txt
 * OZN1POSICION GLOBAL - NET CORPORATIVA  OZ        OZ1COZN1BVDKNPO OZECN1E0            OZN1  NS3000CNNNNN    SSTN    C   NNNSSNNN  NN                2014-12-10CE15005 2014-12-1109.59.17CE15505 2014-12-10-16.03.17.503005CE15005 0001-01-010001-01-01
 * 
 * FICHERO: OZN1_FDX.txt
 * OZN1OZECN1S0OZECN1S0OZ1COZN11S                             CE15505 2014-12-11-09.57.30.203103CE15505 2014-12-11-09.57.30.203149
 * OZN1OZECN1S1OZECN1S1OZ1COZN11S                             CE15505 2014-12-11-09.57.39.695057CE15505 2014-12-11-09.57.39.695070
 * 
</pre></code>
 * 
 * @see RespuestaTransaccionOzn1
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "OZN1",
	tipo = 1, 
	subtipo = 1,	
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionOzn1.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoOZECN1E0.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionOzn1 implements MensajeMultiparte {
	
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