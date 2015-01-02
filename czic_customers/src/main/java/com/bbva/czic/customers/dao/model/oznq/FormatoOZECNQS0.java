package com.bbva.czic.customers.dao.model.oznq;

import java.math.BigDecimal;

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
	 * <p>Campo <code>VALDEPO</code>, &iacute;ndice: <code>1</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 1, nombre = "VALDEPO", tipo = TipoCampo.DECIMAL, longitudMinima = 17, longitudMaxima = 17, decimales = 2)
	private BigDecimal valdepo;
	
	/**
	 * <p>Campo <code>VALCARG</code>, &iacute;ndice: <code>2</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 2, nombre = "VALCARG", tipo = TipoCampo.DECIMAL, longitudMinima = 17, longitudMaxima = 17, decimales = 2)
	private BigDecimal valcarg;
	
	/**
	 * <p>Campo <code>SALTOTA</code>, &iacute;ndice: <code>3</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 3, nombre = "SALTOTA", tipo = TipoCampo.DECIMAL, longitudMinima = 17, longitudMaxima = 17, decimales = 2)
	private BigDecimal saltota;
	
	/**
	 * <p>Campo <code>MES</code>, &iacute;ndice: <code>4</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 4, nombre = "MES", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 2, longitudMaxima = 2)
	private String mes;
	
}