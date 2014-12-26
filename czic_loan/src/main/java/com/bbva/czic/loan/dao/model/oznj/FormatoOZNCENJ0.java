package com.bbva.czic.loan.dao.model.oznj;


import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * Formato de datos <code>OZNCENJ0</code> de la transacci&oacute;n <code>OZNJ</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZNCENJ0")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZNCENJ0 {

	/**
	 * <p>Campo <code>NOOPERA</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "NOOPERA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String noopera;
	
}