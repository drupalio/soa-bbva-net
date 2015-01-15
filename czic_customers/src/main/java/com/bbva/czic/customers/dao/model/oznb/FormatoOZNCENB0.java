package com.bbva.czic.customers.dao.model.oznb;


import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * Formato de datos <code>OZNCENB0</code> de la transacci&oacute;n <code>OZNB</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZNCENB0")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZNCENB0 {

	/**
	 * <p>Campo <code>NUMCLIE</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "NUMCLIE", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 8, longitudMaxima = 8)
	private String numclie;
	
	/**
	 * <p>Campo <code>NOMCLIE</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "NOMCLIE", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 50, longitudMaxima = 50)
	private String nomclie;
	
}