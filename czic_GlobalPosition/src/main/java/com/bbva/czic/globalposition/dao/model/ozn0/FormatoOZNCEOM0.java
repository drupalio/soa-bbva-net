package com.bbva.czic.globalposition.dao.model.ozn0;


import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * Formato de datos <code>OZNCEOM0</code> de la transacci&oacute;n <code>OZN0</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZNCEOM0")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZNCEOM0 {

	/**
	 * <p>Campo <code>NUMCTA</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "NUMCTA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String numcta;
	
	/**
	 * <p>Campo <code>INDCTA</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "INDCTA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 4, longitudMaxima = 7)
	private String indcta;
	
}