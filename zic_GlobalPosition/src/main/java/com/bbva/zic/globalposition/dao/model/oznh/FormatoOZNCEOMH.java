package com.bbva.zic.globalposition.dao.model.oznh;


import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * Formato de datos <code>OZNCEOMH</code> de la transacci&oacute;n <code>OZNH</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZNCEOMH")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZNCEOMH {

	/**
	 * <p>Campo <code>NUMCTA</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "NUMCTA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String numcta;
	
	/**
	 * <p>Campo <code>CODBLQ</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "CODBLQ", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String codblq;
	
}