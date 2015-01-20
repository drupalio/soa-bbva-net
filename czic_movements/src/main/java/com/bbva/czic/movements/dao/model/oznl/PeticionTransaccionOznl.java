package com.bbva.czic.movements.dao.model.oznl;

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
 * <p>Transacci&oacute;n <code>OZNL</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionOznl</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionOznl</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: DOF.CN.DCG.QGDTCCT.KNOZNL.TXT
 * OZNLLISTADO MOVIMIENTOS CTA CORRIENTE  OZ        OZ1COZNLBVDKNPO OZECNLE0            OZNL  NS3000CNNNNN    SSTN    C   SNNNSNNN  NN                2014-12-29CE33822 2014-12-3014.41.00CE33514 2014-12-29-09.32.44.138666CE33822 0001-01-010001-01-01
 * 
 * FICHERO: DOF.CN.DCG.QGDTFDF.OZECNLE0.TXT
 * OZECNLE0�E - LISTADO MOVS CTA CORRIENTE�F�07�00085�01�00001�NUMCUEN�NUMERO DE CUENTA    �A�018�0�R�        �
 * OZECNLE0�E - LISTADO MOVS CTA CORRIENTE�F�07�00085�02�00019�NUMCLIE�NUMERO DE CLIENTE   �A�008�0�R�        �
 * OZECNLE0�E - LISTADO MOVS CTA CORRIENTE�F�07�00085�03�00027�FECINI �FECHA DE INICIO     �A�010�0�O�        �
 * OZECNLE0�E - LISTADO MOVS CTA CORRIENTE�F�07�00085�04�00037�FECFIN �FECHA DE FIN        �A�010�0�O�        �
 * OZECNLE0�E - LISTADO MOVS CTA CORRIENTE�F�07�00085�05�00047�SALINI �SALDO DE INICIO     �S�015�0�O�        �
 * OZECNLE0�E - LISTADO MOVS CTA CORRIENTE�F�07�00085�06�00062�SALFIN �SALDO DE FIN        �S�015�0�O�        �
 * OZECNLE0�E - LISTADO MOVS CTA CORRIENTE�F�07�00085�07�00077�INDPAGI�INDICADOR DE PAGINA �N�009�0�O�        �
 * 
 * FICHERO: DOF.CN.DCG.QGDTFDF.OZECNLS0.TXT
 * OZECNLS0�S - LISTADO MOVS CTA CORRIENTE�X�07�00102�01�00001�NUMOPER�NUMERO DE MOVIMIENTO�N�009�0�S�        �
 * OZECNLS0�S - LISTADO MOVS CTA CORRIENTE�X�07�00102�02�00010�FECHOPE�FECHA DE OPERACION  �A�010�0�S�        �
 * OZECNLS0�S - LISTADO MOVS CTA CORRIENTE�X�07�00102�03�00020�TIPOOPR�CODIGO DE OPERACION �A�003�0�S�        �
 * OZECNLS0�S - LISTADO MOVS CTA CORRIENTE�X�07�00102�04�00023�VALOROP�IMPORTE DE OPERACION�S�015�0�S�        �
 * OZECNLS0�S - LISTADO MOVS CTA CORRIENTE�X�07�00102�05�00038�BALANCE�BALANCE DE OPERACION�S�015�0�S�        �
 * OZECNLS0�S - LISTADO MOVS CTA CORRIENTE�X�07�00102�06�00053�DESCOPR�DESC DE CODIGO OPERA�A�030�0�S�        �
 * OZECNLS0�S - LISTADO MOVS CTA CORRIENTE�X�07�00102�07�00083�RESTO  �INFO COMPLEMENTARIA �A�020�0�S�        �
 * 
 * FICHERO: DOF.CN.DCG.QGDTFDX.KNOZNL.TXT
 * OZNLOZECNLS0OZECNLS0OZ2COZNL1S3000S400                     CE33514 2014-12-30-11.19.59.244059CE33514 2014-12-30-11.19.59.244059
 * 
</pre></code>
 * 
 * @see RespuestaTransaccionOznl
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "OZNL",
	tipo = 1, 
	subtipo = 1,	
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionOznl.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoOZECNLE0.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionOznl implements MensajeMultiparte {
	
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