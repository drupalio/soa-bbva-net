package com.bbva.czic.accounts.dao.model.oznv;

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
 * <p>Transacci&oacute;n <code>OZNV</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionOznv</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionOznv</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: COBD.CN.TMP.QGDTCCT.OZOZNV.TXT
 * OZNVCONSULTA MOVIMIENTOS DEPOSITOS     OZ        OZ1COZNVBVDKNPO OZECNVE0            OZNU  NS3000NNNNNN    SSTN    C   SNNSSNNN  NN                2015-01-05CICSDC112015-01-0518.28.52CICSDC112015-01-05-17.25.00.406896CICSDC110001-01-010001-01-01
 * 
 * FICHERO: COBD.CN.TMP.QGDTFDF.OZECNVE0.TXT
 * OZECNVE0�E - CONSUL MOVIMIENTOS DEPOSIT�F�03�00024�01�00001�NUMCTA �NUMERO DE PRODUCTO  �A�020�0�R�        �
 * OZECNVE0�E - CONSUL MOVIMIENTOS DEPOSIT�F�03�00024�02�00021�MESINI �MES INICIAL         �A�002�0�R�        �
 * OZECNVE0�E - CONSUL MOVIMIENTOS DEPOSIT�F�03�00024�03�00023�MESFIN �MES FINAL           �A�002�0�R�        �
 * 
 * FICHERO: COBD.CN.TMP.QGDTFDF.OZECNVS0.TXT
 * OZECNVS0�S - CONSULTAR MVTOS DEPOSITOS �X�02�00017�01�00001�SALDDIS�SALDO DISPONIBLE    �N�015�2�S�        �
 * OZECNVS0�S - CONSULTAR MVTOS DEPOSITOS �X�02�00017�02�00016�MES    �MES DEL EVALUO      �A�002�0�S�        �
 * 
 * FICHERO: COBD.CN.TMP.QGDTFDX.OZOZNV.TXT
 * OZNVOZECNVS0OZCENVS0OZ1COZNV1S                             CICSDC112015-01-05-17.32.01.397683CICSDC112015-01-05-18.27.32.436814
 * 
</pre></code>
 * 
 * @see RespuestaTransaccionOznv
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "OZNV",
	tipo = 1, 
	subtipo = 1,	
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionOznv.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoOZECNVE0.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionOznv implements MensajeMultiparte {
	
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