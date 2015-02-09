package com.bbva.czic.products.dao.model.oznt;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;


/**
 * Formato de datos <code>OZECNTS1</code> de la transacci&oacute;n <code>OZNT</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZECNTS1")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZECNTS1 {
	
	/**
	 * <p>Campo <code>TITULAR</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "TITULAR", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 40, longitudMaxima = 40)
	private String titular;
	
}