package com.bbva.czic.accounts.dao.model.ozna;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import com.bbva.jee.arq.spring.core.host.Cabecera;
import com.bbva.jee.arq.spring.core.host.Cuerpo;
import com.bbva.jee.arq.spring.core.host.CuerpoMultiparte;
import com.bbva.jee.arq.spring.core.host.NombreCabecera;
import com.bbva.jee.arq.spring.core.host.RespuestaTransaccion;
import com.bbva.jee.arq.spring.core.host.Multiformato;
import com.bbva.jee.arq.spring.core.host.MensajeMultiparte;

/**
 * Bean de respuesta para la transacci&oacute;n <code>OZNA</code>
 * 
 * @see PeticionTransaccionOzna
 * 
 * @author Arquitectura Spring BBVA
 */
@RespuestaTransaccion
@Multiformato(formatos = {FormatoOZNCSNA0.class })
@RooJavaBean
@RooToString
@RooSerializable
public class RespuestaTransaccionOzna implements MensajeMultiparte {
	
	/**
	 * <p>Cabecera <code>serviceResponse</code></p>
	 */
	@Cabecera(nombre=NombreCabecera.CODIGO_RETORNO)
	private String codigoRetorno;
	
	/**
	 * <p>Cabecera <code>processControl</code></p>
	 */
	@Cabecera(nombre=NombreCabecera.CODIGO_CONTROL)
	private String codigoControl;
	
	/**
	 * <p>Cuerpo del mensaje de respuesta multiparte</p>
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
