package com.bbva.czic.products.dao.model.oznl;

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
 * <code><pre> * FICHERO: OZOZNLCCT.TXT
 * OZNLLISTADO DE MOVIMIENTOS             OZ        OZ2COZNLBVDKNPO OZECNLE0            OZNM  NS3000NNNNNN    SSTN    C   SNNSSNNN  NN                2014-12-29CE33822 2015-01-2918.28.01CE33822 2014-12-29-09.32.44.138666CE33822 0001-01-010001-01-01
 * 
 * FICHERO: OZECNLE0FDF.TXT
 * OZECNLE0�E - LISTADO MOVS CTA CORRIENTE�F�08�00094�01�00001�NUMPROD�NUMERO DE CUENTA    �A�020�0�R�        �
 * OZECNLE0�E - LISTADO MOVS CTA CORRIENTE�F�08�00094�02�00021�USUARIO�NUMERO DE CLIENTE   �A�008�0�R�        �
 * OZECNLE0�E - LISTADO MOVS CTA CORRIENTE�F�08�00094�03�00029�INDPAGI�INDICADOR DE PAGINA �N�009�0�O�        �
 * OZECNLE0�E - LISTADO MOVS CTA CORRIENTE�F�08�00094�04�00038�TAMPAGI�TAMANO DE PAGINA    �N�003�0�O�        �
 * OZECNLE0�E - LISTADO MOVS CTA CORRIENTE�F�08�00094�05�00041�FECINI �FECHA DE INICIO     �A�010�0�O�        �
 * OZECNLE0�E - LISTADO MOVS CTA CORRIENTE�F�08�00094�06�00051�FECFIN �FECHA FINAL         �A�010�0�O�        �
 * OZECNLE0�E - LISTADO MOVS CTA CORRIENTE�F�08�00094�07�00061�SALINC �SALDO INICIAL       �S�017�2�O�        �
 * OZECNLE0�E - LISTADO MOVS CTA CORRIENTE�F�08�00094�08�00078�SALFIN �SALDO FINAL         �S�017�2�O�        �
 * 
 * FICHERO: OZECNLS0FDF.TXT
 * OZECNLS0�S - LISTADO MOVS CTA CORRIENTE�X�07�00108�01�00001�NUMOPER�NUMERO DE MOVIMIENTO�N�009�0�S�        �
 * OZECNLS0�S - LISTADO MOVS CTA CORRIENTE�X�07�00108�02�00010�FECHOPE�FECHA DE OPERACION  �A�010�0�S�        �
 * OZECNLS0�S - LISTADO MOVS CTA CORRIENTE�X�07�00108�03�00020�DESCOPR�DESC DE CODIGO OPERA�A�030�0�S�        �
 * OZECNLS0�S - LISTADO MOVS CTA CORRIENTE�X�07�00108�04�00050�VALOROP�IMPORTE DE OPERACION�A�018�0�S�        �
 * OZECNLS0�S - LISTADO MOVS CTA CORRIENTE�X�07�00108�05�00068�BALANCE�BALANCE DE OPERACION�A�018�0�S�        �
 * OZECNLS0�S - LISTADO MOVS CTA CORRIENTE�X�07�00108�06�00086�CONCEPT�CONCEPTO            �A�020�0�S�        �
 * OZECNLS0�S - LISTADO MOVS CTA CORRIENTE�X�07�00108�07�00106�TIPOOPR�CODIGO DE OPERACION �A�003�0�S�        �
 * 
 * FICHERO: OZOZNLFDX.TXT
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