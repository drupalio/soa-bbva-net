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
 * <code><pre> * FICHERO: OZN1cct.txt
 * OZN1POSICION GLOBAL - NET CORPORATIVA  OZ        OZ1COZN1BVDKNPO OZECN1E0            OZN1  NS3000NNNNNN    SSTN    C   SNNSSNNN  NN                2014-12-10CE15005 2014-12-1811.00.12CICSDC112014-12-10-16.03.17.503005CE15005 0001-01-010001-01-01
 * 
 * FICHERO: OZECN1E0fdf.txt
 * OZECN1E0�E - POS GLOBAL NET CORPORATIVA�F�02�00010�01�00001�NUMCLIE�NUMERO DE CLIENTE   �A�008�0�O�        �
 * OZECN1E0�E - POS GLOBAL NET CORPORATIVA�F�02�00010�02�00009�TIPPROD�TIPO DE PRODUCTO    �A�002�0�O�        �
 * 
 * FICHERO: COBD.CN.TMP.QGDTFDF.OZECN1S0.txt
 * OZECN1S0�S - POS GLOBAL NET CORPORATIVA�X�10�00119�01�00001�TIPPROD�TIPO DE PRODUCTO    �A�002�0�S�        �
 * OZECN1S0�S - POS GLOBAL NET CORPORATIVA�X�10�00119�02�00003�NUMPROD�NUMERO DE PRODUCTO  �A�020�0�S�        �
 * OZECN1S0�S - POS GLOBAL NET CORPORATIVA�X�10�00119�03�00023�SALCANJ�SALDO EN CANJE      �A�018�0�S�        �
 * OZECN1S0�S - POS GLOBAL NET CORPORATIVA�X�10�00119�04�00041�SALTOTA�SALDO TOTAL         �A�018�0�S�        �
 * OZECN1S0�S - POS GLOBAL NET CORPORATIVA�X�10�00119�05�00059�SALDISP�SALDO DISPONIBLE    �A�018�0�S�        �
 * OZECN1S0�S - POS GLOBAL NET CORPORATIVA�X�10�00119�06�00077�INDVISI�INDICADOR VISIBILIDA�A�001�0�S�        �
 * OZECN1S0�S - POS GLOBAL NET CORPORATIVA�X�10�00119�07�00078�INDOPER�INDICADOR OPERABILID�A�001�0�S�        �
 * OZECN1S0�S - POS GLOBAL NET CORPORATIVA�X�10�00119�08�00079�ALIAS  �ALIAS DEL PRODUCTO  �A�020�0�S�        �
 * OZECN1S0�S - POS GLOBAL NET CORPORATIVA�X�10�00119�09�00099�NOMPROD�NOMBRE DEL PRODUCTO �A�020�0�S�        �
 * OZECN1S0�S - POS GLOBAL NET CORPORATIVA�X�10�00119�10�00119�FINSTAT�ACTIVO O PASIVO     �A�001�0�S�        �
 * 
 * FICHERO: COBD.CN.TMP.QGDTFDF.OZECN1S1.txt
 * OZECN1S1�S - POS GLOBAL NET CORPORATIVA�X�12�00147�01�00001�TIPPROD�TIPO DE PRODUCTO    �A�002�0�S�        �
 * OZECN1S1�S - POS GLOBAL NET CORPORATIVA�X�12�00147�02�00003�NUMPROD�NUMERO DE PRODUCTO  �A�020�0�S�        �
 * OZECN1S1�S - POS GLOBAL NET CORPORATIVA�X�12�00147�03�00023�SALTOTA�SALDO TOTAL         �A�018�0�S�        �
 * OZECN1S1�S - POS GLOBAL NET CORPORATIVA�X�12�00147�04�00041�SALDISP�SALDO DISPONIBLE    �A�018�0�S�        �
 * OZECN1S1�S - POS GLOBAL NET CORPORATIVA�X�12�00147�05�00059�INDVISI�INDICADOR VISIBILIDA�A�001�0�S�        �
 * OZECN1S1�S - POS GLOBAL NET CORPORATIVA�X�12�00147�06�00060�INDOPER�INDICADOR OPERABILID�A�001�0�S�        �
 * OZECN1S1�S - POS GLOBAL NET CORPORATIVA�X�12�00147�07�00061�ALIAS  �ALIAS DEL PRODUCTO  �A�020�0�S�        �
 * OZECN1S1�S - POS GLOBAL NET CORPORATIVA�X�12�00147�08�00081�NOMPROD�NOMBRE DEL PRODUCTO �A�020�0�S�        �
 * OZECN1S1�S - POS GLOBAL NET CORPORATIVA�X�12�00147�09�00101�FINSTAT�ACTIVO O PASIVO     �A�001�0�S�        �
 * OZECN1S1�S - POS GLOBAL NET CORPORATIVA�X�12�00147�10�00102�NUMTARJ�NUMERO DE TARJETA   �A�016�0�S�        �
 * OZECN1S1�S - POS GLOBAL NET CORPORATIVA�X�12�00147�11�00118�NUMCONT�NUMERO CONTRATO TARJ�A�020�0�S�        �
 * OZECN1S1�S - POS GLOBAL NET CORPORATIVA�X�12�00147�12�00138�NUMCELU�NUMERO CELULAR - DDE�A�010�0�S�        �
 * 
 * FICHERO: OZN1fdx.txt
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