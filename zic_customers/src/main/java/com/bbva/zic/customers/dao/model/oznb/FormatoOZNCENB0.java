package com.bbva.zic.customers.dao.model.oznb;


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
	 * <p>Campo <code>CLVEACC</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "CLVEACC", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 35, longitudMaxima = 35)
	private String clveacc;
	
}