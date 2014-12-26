package com.bbva.czic.executives.dao.model.oznr;


import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * Formato de datos <code>OZECNRE0</code> de la transacci&oacute;n <code>OZNR</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZECNRE0")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZECNRE0 {

	/**
	 * <p>Campo <code>IDUSUAR</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "IDUSUAR", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 8, longitudMaxima = 8)
	private String idusuar;
	
}