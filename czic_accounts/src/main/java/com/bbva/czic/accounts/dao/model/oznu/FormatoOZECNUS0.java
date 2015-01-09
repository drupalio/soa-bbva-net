package com.bbva.czic.accounts.dao.model.oznu;

import java.math.BigDecimal;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import com.bbva.jee.arq.spring.core.host.Formato;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;


/**
 * Formato de datos <code>OZECNUS0</code> de la transacci&oacute;n <code>OZNU</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZECNUS0")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZECNUS0 {
	
	/**
	 * <p>Campo <code>VALDEPO</code>, &iacute;ndice: <code>1</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 1, nombre = "VALDEPO", tipo = TipoCampo.DECIMAL, longitudMinima = 15, longitudMaxima = 15, signo = true, decimales = 2)
	private BigDecimal valdepo;
	
	/**
	 * <p>Campo <code>VALCARG</code>, &iacute;ndice: <code>2</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 2, nombre = "VALCARG", tipo = TipoCampo.DECIMAL, longitudMinima = 15, longitudMaxima = 15, signo = true, decimales = 2)
	private BigDecimal valcarg;
	
	/**
	 * <p>Campo <code>SALDTOT</code>, &iacute;ndice: <code>3</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 3, nombre = "SALDTOT", tipo = TipoCampo.DECIMAL, longitudMinima = 15, longitudMaxima = 15, signo = true, decimales = 2)
	private BigDecimal saldtot;
	
	/**
	 * <p>Campo <code>MES</code>, &iacute;ndice: <code>4</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 4, nombre = "MES", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 2, longitudMaxima = 2)
	private String mes;
	
}