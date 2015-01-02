package com.bbva.czic.loan.dao.model.ozni;

import java.math.BigDecimal;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * Formato de datos <code>OZNCSNI0</code> de la transacci&oacute;n <code>OZNI</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZNCSNI0")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZNCSNI0 {

	/**
	 * <p>
	 * Campo <code>NUMEOPE</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "NUMEOPE", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String numeope;

	/**
	 * <p>
	 * Campo <code>FECHAOP</code>, &iacute;ndice: <code>2</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 2, nombre = "FECHAOP", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private String fechaop;

	/**
	 * <p>
	 * Campo <code>RESTO</code>, &iacute;ndice: <code>3</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 3, nombre = "RESTO", tipo = TipoCampo.DECIMAL, longitudMinima = 15, longitudMaxima = 15, signo = true, decimales = 2)
	private BigDecimal resto;

	/**
	 * <p>
	 * Campo <code>VALOROP</code>, &iacute;ndice: <code>4</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 4, nombre = "VALOROP", tipo = TipoCampo.DECIMAL, longitudMinima = 15, longitudMaxima = 15, signo = true, decimales = 2)
	private BigDecimal valorop;

	/**
	 * <p>
	 * Campo <code>BALANCE</code>, &iacute;ndice: <code>5</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 5, nombre = "BALANCE", tipo = TipoCampo.DECIMAL, longitudMinima = 15, longitudMaxima = 15, signo = true, decimales = 2)
	private BigDecimal balance;

	/**
	 * <p>
	 * Campo <code>TIPOPE</code>, &iacute;ndice: <code>6</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 6, nombre = "TIPOPE", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String tipope;

}