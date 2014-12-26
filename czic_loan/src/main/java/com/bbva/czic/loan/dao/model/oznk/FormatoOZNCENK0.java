package com.bbva.czic.loan.dao.model.oznk;


import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * Formato de datos <code>OZNCENK0</code> de la transacci&oacute;n <code>OZNK</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZNCENK0")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZNCENK0 {

	/**
	 * <p>Campo <code>NOMOPER</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "NOMOPER", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String nomoper;
	
}