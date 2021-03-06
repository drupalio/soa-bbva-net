package com.bbva.czic.customers.dao.model.oznq;

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
 * <p>Transacci&oacute;n <code>OZNQ</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionOznq</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionOznq</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: DOF.CN.YLQ.QGDTCCT.KNOZNQ.txt
 * OZNQLISTA RESUMEN MOVIMIENTOS DE CUENTAOZ        OZ1COZNQBVDKNPO OZECNQE0            OZNQ  NS3000NNNNNN    SSTN    C   SNNSSNNN  NN                2014-12-21CE15505 2015-01-2016.11.58CE15505 2014-12-21-23.18.35.935521CE15505 0001-01-010001-01-01
 * 
 * FICHERO: DOF.CN.YLQ.QGDTFDF.OZECNQE0.txt
 * OZECNQE0�E - LISTA RESUMEN MOVIMENTOS C�F�03�00028�01�00001�IDUSUAR�ID DE USUARIO       �A�008�0�O�        �
 * OZECNQE0�E - LISTA RESUMEN MOVIMENTOS C�F�03�00028�02�00009�FECHAIN�FECHA INICIAL CALCUL�A�010�0�R�        �
 * OZECNQE0�E - LISTA RESUMEN MOVIMENTOS C�F�03�00028�03�00019�FECHAFI�FECHA FINAL CALCULO �A�010�0�R�        �
 * 
 * FICHERO: DOF.CN.YLQ.QGDTFDF.OZECNQS0.txt
 * OZECNQS0�S - LISTA RESUMEN MOVIMIENTOS �X�04�00056�01�00001�VALDEPO�VALOR DEPOSITO      �A�018�0�S�        �
 * OZECNQS0�S - LISTA RESUMEN MOVIMIENTOS �X�04�00056�02�00019�VALCARG�VALOR CARGO CTA CLIE�A�018�0�S�        �
 * OZECNQS0�S - LISTA RESUMEN MOVIMIENTOS �X�04�00056�03�00037�SALTOTA�SALDO TOTAL CTA CLIE�A�018�0�S�        �
 * OZECNQS0�S - LISTA RESUMEN MOVIMIENTOS �X�04�00056�04�00055�MES    �MES SOBRE HACE EVALU�A�002�0�S�        �
 * 
 * FICHERO: DOF.CN.YLQ.QGDTFDX.KNOZNQ.txt
 * OZNQOZECNQS0OZECNQS0OZ1COZNQ1S                             CE15505 2014-12-21-23.26.19.082943CE15505 2014-12-21-23.26.19.082955
 * 
</pre></code>
 * 
 * @see RespuestaTransaccionOznq
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "OZNQ",
	tipo = 1, 
	subtipo = 1,	
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionOznq.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoOZECNQE0.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionOznq implements MensajeMultiparte {
	
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