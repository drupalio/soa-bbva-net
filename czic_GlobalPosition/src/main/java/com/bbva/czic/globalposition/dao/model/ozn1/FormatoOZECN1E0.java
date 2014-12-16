package com.bbva.czic.globalposition.dao.model.ozn1;


import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * Formato de datos <code>OZECN1E0</code> de la transacci&oacute;n <code>OZN1</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZECN1E0")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZECN1E0 {

	/**
	 * <p>Campo <code>NUMCLIE</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "NUMCLIE", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 8, longitudMaxima = 8)
	private String numclie;
	
}