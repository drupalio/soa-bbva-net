package com.bbva.czic.customers.dao.model.oznw;


import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * Formato de datos <code>OZECNWE0</code> de la transacci&oacute;n <code>OZNW</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZECNWE0")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZECNWE0 {

	/**
	 * <p>Campo <code>USUARIO</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "USUARIO", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 8, longitudMaxima = 8)
	private String usuario;
	
	/**
	 * <p>Campo <code>CANAL</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "CANAL", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 4, longitudMaxima = 4)
	private String canal;
	
}