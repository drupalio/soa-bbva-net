package com.bbva.zic.products.dao.model.oznt;


import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * Formato de datos <code>OZECNTE0</code> de la transacci&oacute;n <code>OZNT</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZECNTE0")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZECNTE0 {

	/**
	 * <p>Campo <code>NUMPROD</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "NUMPROD", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String numprod;
	
}