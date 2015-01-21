package com.bbva.czic.movements.dao.model.oznm;


import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * Formato de datos <code>OZNCENM0</code> de la transacci&oacute;n <code>OZNM</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZNCENM0")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZNCENM0 {

	/**
	 * <p>Campo <code>NOCUENT</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "NOCUENT", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String nocuent;
	
	/**
	 * <p>Campo <code>NUMMOV</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "NUMMOV", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 9, longitudMaxima = 9)
	private String nummov;
	
}