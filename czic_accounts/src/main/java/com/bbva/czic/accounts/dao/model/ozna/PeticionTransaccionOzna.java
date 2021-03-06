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
 * OZNADETALLE DE CUENTAS                 OZ        OZ1COZNABVDKNPO OZNCENA0            OZNA  NS3000CNNNNN    SSTN    C   SNNNSNNN  NN                2015-01-13CE33514 2015-01-1318.30.18CE33514 2015-01-13-18.13.18.909055CE33514 0001-01-010001-01-01
 * 
 * FICHERO: DOF.CN.DCG.QGDTFDF.OZNCENA0.TXT
 * OZNCENA0�FORMATO DE SALIDA TRX OZNA    �F�01�00020�01�00001�NUMPROD�NUMERO DE CUENTA    �A�020�0�R�        �
 * 
 * FICHERO: DOF.CN.DCG.QGDTFDF.OZNCSNA0.TXT
 * OZNCSNA0�FORMATO DE SALIDA TRX OZNA    �X�16�00226�01�00001�NUMPROD�NUMERO DE CUENTA    �A�020�0�S�        �
 * OZNCSNA0�FORMATO DE SALIDA TRX OZNA    �X�16�00226�02�00021�TIPPROD�TIPO DE PRODUCTO    �A�002�0�S�        �
 * OZNCSNA0�FORMATO DE SALIDA TRX OZNA    �X�16�00226�03�00023�NOMPROD�NOMBRE DE PRODUCTO  �A�050�0�S�        �
 * OZNCSNA0�FORMATO DE SALIDA TRX OZNA    �X�16�00226�04�00073�SALTOTA�SALDO TOTAL         �A�018�0�S�        �
 * OZNCSNA0�FORMATO DE SALIDA TRX OZNA    �X�16�00226�05�00091�SDDISPO�SALDO DISPONIBLE    �A�018�0�S�        �
 * OZNCSNA0�FORMATO DE SALIDA TRX OZNA    �X�16�00226�06�00109�SDCANJE�SALDO EN CANJE      �A�018�0�S�        �
 * OZNCSNA0�FORMATO DE SALIDA TRX OZNA    �X�16�00226�07�00127�IDCHEQ0�ID_CHEQUERAS0       �A�010�0�S�        �
 * OZNCSNA0�FORMATO DE SALIDA TRX OZNA    �X�16�00226�08�00137�IDCHEQ1�ID_CHEQUERAS1       �A�010�0�S�        �
 * OZNCSNA0�FORMATO DE SALIDA TRX OZNA    �X�16�00226�09�00147�IDCHEQ2�ID_CHEQUERAS2       �A�010�0�S�        �
 * OZNCSNA0�FORMATO DE SALIDA TRX OZNA    �X�16�00226�10�00157�IDCHEQ3�ID_CHEQUERAS3       �A�010�0�S�        �
 * OZNCSNA0�FORMATO DE SALIDA TRX OZNA    �X�16�00226�11�00167�IDCHEQ4�ID_CHEQUERAS4       �A�010�0�S�        �
 * OZNCSNA0�FORMATO DE SALIDA TRX OZNA    �X�16�00226�12�00177�IDCHEQ5�ID_CHEQUERAS5       �A�010�0�S�        �
 * OZNCSNA0�FORMATO DE SALIDA TRX OZNA    �X�16�00226�13�00187�IDCHEQ6�ID_CHEQUERAS6       �A�010�0�S�        �
 * OZNCSNA0�FORMATO DE SALIDA TRX OZNA    �X�16�00226�14�00197�IDCHEQ7�ID_CHEQUERAS7       �A�010�0�S�        �
 * OZNCSNA0�FORMATO DE SALIDA TRX OZNA    �X�16�00226�15�00207�IDCHEQ8�ID_CHEQUERAS8       �A�010�0�S�        �
 * OZNCSNA0�FORMATO DE SALIDA TRX OZNA    �X�16�00226�16�00217�IDCHEQ9�ID_CHEQUERAS9       �A�010�0�S�        �
 * 
 * FICHERO: DOF.CN.DCG.QGDTFDX.KNOZNA.TXT
 * OZNAOZNCSNA0COPY    OZ1COZNA1S                             CE33514 2015-01-13-18.29.21.779270CE33514 2015-01-13-18.29.21.779301
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