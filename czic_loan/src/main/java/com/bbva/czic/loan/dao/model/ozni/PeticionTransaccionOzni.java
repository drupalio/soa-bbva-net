package com.bbva.czic.loan.dao.model.ozni;

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
 * <p>Transacci&oacute;n <code>OZNI</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionOzni</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionOzni</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: DBG.CN.JEF.QGDTCCT.KNOZNI.txt
 * OZNIMOVIMIENTOS CUPO ROTATIVO          OZ        OZ1COZNIBVDKNPO OZNCENI0            OZNM  NS3000NNNNNN    SSTN    C   SNNSSNNN  NN                2014-12-22CE33823 2015-01-2619.00.52CE33823 2014-12-22-09.47.47.099739CE33823 0001-01-010001-01-01
 * 
 * FICHERO: DBG.CN.JEF.QGDTFDF.OZNCENI0.txt
 * OZNCENI0�AREA DE PAGINACION            �F�05�00061�01�00001�NOTARJE�NUMERO DE TARJETA   �A�020�0�O�        �
 * OZNCENI0�AREA DE PAGINACION            �F�05�00061�02�00021�FECHINI�FECHA DESDE         �A�010�0�O�        �
 * OZNCENI0�AREA DE PAGINACION            �F�05�00061�03�00031�FECHAFI�FECHA HASTA         �A�010�0�O�        �
 * OZNCENI0�AREA DE PAGINACION            �F�05�00061�04�00041�INDPAG �INDICADOR PAGINACION�A�001�0�O�        �
 * OZNCENI0�AREA DE PAGINACION            �F�05�00061�05�00042�POSPAG �AREA DE PAGINACION  �A�020�0�O�        �
 * 
 * FICHERO: DBG.CN.JEF.QGDTFDF.OZNCSNI0.txt
 * OZNCSNI0�SALIDA RESUMEN DE MOVIEMIENTO �X�08�00091�01�00001�NUMEOPE�NUMERO DE OPERACION �A�009�0�S�        �
 * OZNCSNI0�SALIDA RESUMEN DE MOVIEMIENTO �X�08�00091�02�00010�FECHAOP�FECHA DE OPERACION  �A�010�0�S�        �
 * OZNCSNI0�SALIDA RESUMEN DE MOVIEMIENTO �X�08�00091�03�00020�RESTO  �RESTO               �A�025�0�S�        �
 * OZNCSNI0�SALIDA RESUMEN DE MOVIEMIENTO �X�08�00091�04�00045�VALOROP�VALOR OPERACION     �A�012�0�S�        �
 * OZNCSNI0�SALIDA RESUMEN DE MOVIEMIENTO �X�08�00091�05�00057�BALANCE�BALANCE OPERACION   �A�012�0�S�        �
 * OZNCSNI0�SALIDA RESUMEN DE MOVIEMIENTO �X�08�00091�06�00069�TIPOPE �TIPO DE OPERACION   �A�002�0�S�        �
 * OZNCSNI0�SALIDA RESUMEN DE MOVIEMIENTO �X�08�00091�07�00071�INDPAG �INDICADOR PAGINACION�A�001�0�S�        �
 * OZNCSNI0�SALIDA RESUMEN DE MOVIEMIENTO �X�08�00091�08�00072�POSPAG �AREA DE PAGINACION  �A�020�0�S�        �
 * 
 * FICHERO: DBG.CN.JEF.QGDTFDX.KNOZNI.txt
 * OZNIOZNCSNI0OZNCSNI0OZ1COZNI1S3000S400                     CE33823 2014-12-22-09.50.29.250782CE33823 2014-12-22-09.50.29.250798
 * 
</pre></code>
 * 
 * @see RespuestaTransaccionOzni
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "OZNI",
	tipo = 1, 
	subtipo = 1,	
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionOzni.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoOZNCENI0.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionOzni implements MensajeMultiparte {
	
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