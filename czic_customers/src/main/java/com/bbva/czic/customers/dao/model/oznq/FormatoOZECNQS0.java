package com.bbva.czic.customers.dao.model.oznq;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import com.bbva.jee.arq.spring.core.host.Formato;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;


/**
 * Formato de datos <code>OZECNQS0</code> de la transacci&oacute;n <code>OZNQ</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZECNQS0")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZECNQS0 {
	
	/**
	 * <p>Campo <code>VALDEPO</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "VALDEPO", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 18, longitudMaxima = 18)
	private String valdepo;
	
	/**
	 * <p>Campo <code>VALCARG</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "VALCARG", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 18, longitudMaxima = 18)
	private String valcarg;
	
	/**
	 * <p>Campo <code>SALTOTA</code>, &iacute;ndice: <code>3</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 3, nombre = "SALTOTA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 18, longitudMaxima = 18)
	private String saltota;
	
	/**
	 * <p>Campo <code>MES</code>, &iacute;ndice: <code>4</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 4, nombre = "MES", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 2, longitudMaxima = 2)
	private String mes;
	
}