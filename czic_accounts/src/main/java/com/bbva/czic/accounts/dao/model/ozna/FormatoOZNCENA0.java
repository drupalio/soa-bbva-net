package com.bbva.czic.accounts.dao.model.ozna;


import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * Formato de datos <code>OZNCENA0</code> de la transacci&oacute;n <code>OZNA</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZNCENA0")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZNCENA0 {

	/**
	 * <p>Campo <code>NUMPROD</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "NUMPROD", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String numprod;
	
}