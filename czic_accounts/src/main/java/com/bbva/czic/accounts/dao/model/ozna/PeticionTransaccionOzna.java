package com.bbva.czic.accounts.dao.model.ozna;

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
 * <p>Transacci&oacute;n <code>OZNA</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionOzna</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionOzna</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: DOF.CN.DCG.QGDTCCT.KNOZNA.TXT
 * OZNACONSULTA DE SALDOS                 OZ        OZ1CONN0BVDKNPO OZNCENA0            OZNA  NS3000NNNNNN    SSTN    C   SNNSSNNN  NN                2015-01-08CE33514 2015-01-0809.56.43CE33514 2015-01-08-08.04.31.951465CE33514 0001-01-010001-01-01
 * 
 * FICHERO: DOF.CN.DCG.QGDTFDF.OZNCENA0.TXT
 * OZNCENA0�FORMATO DE ENTRADA OZNA       �F�01�00020�01�00001�NUMPROD�NUMERO DE PRODUCTO  �A�020�0�R�        �
 * 
 * FICHERO: DOF.CN.DCG.QGDTFDF.OZNCSNA0.TXT
 * OZNCSNA0�FORMATO DE SALIDA OZNA        �X�16�00223�01�00001�NUMPROD�NUMERO DE PRODUCTO  �A�020�0�S�        �
 * OZNCSNA0�FORMATO DE SALIDA OZNA        �X�16�00223�02�00021�TIPPROD�TIPO DE PRODUCTO    �A�002�0�S�        �
 * OZNCSNA0�FORMATO DE SALIDA OZNA        �X�16�00223�03�00023�NOMPROD�NOMBRE DE PRODUCTO  �A�050�0�S�        �
 * OZNCSNA0�FORMATO DE SALIDA OZNA        �X�16�00223�04�00073�SALTOTA�SALDO TOTAL         �S�017�2�S�        �
 * OZNCSNA0�FORMATO DE SALIDA OZNA        �X�16�00223�05�00090�SDDISPO�SALDO DISPONIBLE    �S�017�2�S�        �
 * OZNCSNA0�FORMATO DE SALIDA OZNA        �X�16�00223�06�00107�SDCANJE�SALDO EN CANJE      �S�017�2�S�        �
 * OZNCSNA0�FORMATO DE SALIDA OZNA        �X�16�00223�07�00124�IDCHEQ0�ID_CHEQUERAS0       �A�010�0�S�        �
 * OZNCSNA0�FORMATO DE SALIDA OZNA        �X�16�00223�08�00134�IDCHEQ1�ID_CHEQUERAS1       �A�010�0�S�        �
 * OZNCSNA0�FORMATO DE SALIDA OZNA        �X�16�00223�09�00144�IDCHEQ2�ID_CHEQUERAS2       �A�010�0�S�        �
 * OZNCSNA0�FORMATO DE SALIDA OZNA        �X�16�00223�10�00154�IDCHEQ3�ID_CHEQUERAS3       �A�010�0�S�        �
 * OZNCSNA0�FORMATO DE SALIDA OZNA        �X�16�00223�11�00164�IDCHEQ4�ID_CHEQUERAS4       �A�010�0�S�        �
 * OZNCSNA0�FORMATO DE SALIDA OZNA        �X�16�00223�12�00174�IDCHEQ5�ID_CHEQUERAS5       �A�010�0�S�        �
 * OZNCSNA0�FORMATO DE SALIDA OZNA        �X�16�00223�13�00184�IDCHEQ6�ID_CHEQUERAS6       �A�010�0�S�        �
 * OZNCSNA0�FORMATO DE SALIDA OZNA        �X�16�00223�14�00194�IDCHEQ7�ID_CHEQUERAS7       �A�010�0�S�        �
 * OZNCSNA0�FORMATO DE SALIDA OZNA        �X�16�00223�15�00204�IDCHEQ8�ID_CHEQUERAS8       �A�010�0�S�        �
 * OZNCSNA0�FORMATO DE SALIDA OZNA        �X�16�00223�16�00214�IDCHEQ9�ID_CHEQUERAS9       �A�010�0�S�        �
 * 
 * FICHERO: DOF.CN.DCG.QGDTFDX.KNOZNA.TXT
 * OZNAOZNCSNA0COPY    OZ1COZNN1S                             CE33514 2015-01-08-08.28.53.792932CE33514 2015-01-08-08.28.53.792971
 * 
</pre></code>
 * 
 * @see RespuestaTransaccionOzna
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "OZNA",
	tipo = 1, 
	subtipo = 1,	
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionOzna.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoOZNCENA0.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionOzna implements MensajeMultiparte {
	
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