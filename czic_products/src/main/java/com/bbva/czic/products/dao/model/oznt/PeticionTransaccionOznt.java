package com.bbva.czic.products.dao.model.oznt;

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
 * <p>Transacci&oacute;n <code>OZNT</code></p>
 * <p>Informaci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Tipo:</b> 1</li>
 *    <li><b>Subtipo:</b> 1</li>
 *    <li><b>Versi&oacute;n:</b> 1</li>
 *    <li><b>Clase de petici&oacute;n:</b> PeticionTransaccionOznt</li>
 *    <li><b>Clase de respuesta:</b> RespuestaTransaccionOznt</li>
 * </ul>
 * </p>
 * <p>Configuraci&oacute;n de la transacci&oacute;n:
 * <ul>
 *    <li><b>Nombre configuraci&oacute;n:</b> default_ps9_mx</li>
 * </ul>
 * </p>
 * <p>Copy de la transacci&oacute;n:</p>
 * <code><pre> * FICHERO: OZNTcct.txt
 * OZNTLISTA CONDICIONES PROD DE UN CLIENTOZ        OZ1COZNTBVDKNPO OZECNTE0            OZNT  NS3000NNNNNN    SSTN    C   SNNSSNNN  NN                2015-01-08CICSDC112015-01-0814.36.31CICSDC112015-01-08-13.57.06.998944CICSDC110001-01-010001-01-01
 * 
 * FICHERO: OZECNTE0fdf.txt
 * OZECNTE0�E - LISTA CONDICIONES PRODUCTO�F�01�00020�01�00001�NUMPROD�NUMERO DE PRODUCTO  �A�020�0�O�        �
 * 
 * FICHERO: OZECNTS0fdf.txt
 * OZECNTS0�S - LISTA CONDICIONES PRODUCTO�X�17�00380�01�00001�TIPPROD�TIPO DE PRODUCTO    �A�002�0�S�        �
 * OZECNTS0�S - LISTA CONDICIONES PRODUCTO�X�17�00380�02�00003�TIALIAS�ALIAS PARA TITULAR  �A�030�0�S�        �
 * OZECNTS0�S - LISTA CONDICIONES PRODUCTO�X�17�00380�03�00033�CATEGOR�CATEGORIA PRODUCTO  �A�010�0�S�        �
 * OZECNTS0�S - LISTA CONDICIONES PRODUCTO�X�17�00380�04�00043�DESPROD�DESCRIPCION PRODUCTO�A�040�0�S�        �
 * OZECNTS0�S - LISTA CONDICIONES PRODUCTO�X�17�00380�05�00083�FECHAPE�FECHA APERTURA PRODU�A�010�0�S�        �
 * OZECNTS0�S - LISTA CONDICIONES PRODUCTO�X�17�00380�06�00093�COMPROD�COMISION MANEJO PROD�A�009�0�S�        �
 * OZECNTS0�S - LISTA CONDICIONES PRODUCTO�X�17�00380�07�00102�CONPROD�CONDICION MOVIL PROD�A�030�0�S�        �
 * OZECNTS0�S - LISTA CONDICIONES PRODUCTO�X�17�00380�08�00132�NOMOFIC�NOMBRE OFICINA PRODU�A�020�0�S�        �
 * OZECNTS0�S - LISTA CONDICIONES PRODUCTO�X�17�00380�09�00152�DIROFIC�DIRECION OFINA PRODU�A�040�0�S�        �
 * OZECNTS0�S - LISTA CONDICIONES PRODUCTO�X�17�00380�10�00192�CIUDOFI�CIUDAD OFICINA PRODU�A�020�0�S�        �
 * OZECNTS0�S - LISTA CONDICIONES PRODUCTO�X�17�00380�11�00212�PAISOFI�PAIS OFICINA PROD   �A�020�0�S�        �
 * OZECNTS0�S - LISTA CONDICIONES PRODUCTO�X�17�00380�12�00232�FECOPER�FECHA OPERACION COND�A�010�0�S�        �
 * OZECNTS0�S - LISTA CONDICIONES PRODUCTO�X�17�00380�13�00242�FECEJEC�FECHA DE EJECUCION  �A�010�0�S�        �
 * OZECNTS0�S - LISTA CONDICIONES PRODUCTO�X�17�00380�14�00252�TIPFUNC�TIPO DE FUNCIONALIDA�A�002�0�S�        �
 * OZECNTS0�S - LISTA CONDICIONES PRODUCTO�X�17�00380�15�00254�DESFUNC�DESCRIP FUNCIONALIDA�A�050�0�S�        �
 * OZECNTS0�S - LISTA CONDICIONES PRODUCTO�X�17�00380�16�00304�CANTDAD�CANTIDAD            �A�017�0�S�        �
 * OZECNTS0�S - LISTA CONDICIONES PRODUCTO�X�17�00380�17�00321�REFFUNC�REF PARA FUNCIONALID�A�060�0�S�        �
 * 
 * FICHERO: OZECNTS1fdf.txt
 * OZECNTS1�S - LISTA CONDICIONES PRODUCTO�X�01�00040�01�00001�TITULAR�TITULAR DE LA CUENTA�A�040�0�S�        �
 * 
 * FICHERO: OZNTfdx.txt
 * OZNTOZECNTS0COPY    OZECNTS01S                             CICSDC112015-01-08-14.37.09.086465CICSDC112015-01-26-16.00.08.465910
 * OZNTOZECNTS1COPY    OZECNTS11S                             CICSDC112015-01-26-16.03.05.804260CICSDC112015-01-26-16.03.05.804352
 * 
</pre></code>
 * 
 * @see RespuestaTransaccionOznt
 *
 * @author Arquitectura Spring BBVA
 */
@Transaccion(
	nombre = "OZNT",
	tipo = 1, 
	subtipo = 1,	
	version = 1,
	configuracion = "default_ps9_mx",
	respuesta = RespuestaTransaccionOznt.class,
	atributos = {@Atributo(nombre = "altamiraExtendido", valor = "true"), @Atributo(nombre = "tipoCopy", valor = "FIJA")}
)
@Multiformato(formatos = {FormatoOZECNTE0.class})
@RooJavaBean
@RooToString
@RooSerializable
public class PeticionTransaccionOznt implements MensajeMultiparte {
	
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