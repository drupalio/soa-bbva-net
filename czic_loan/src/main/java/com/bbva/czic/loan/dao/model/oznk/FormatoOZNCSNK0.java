package com.bbva.czic.loan.dao.model.oznk;

import java.math.BigDecimal;
import java.util.Date;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import com.bbva.jee.arq.spring.core.host.Formato;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;


/**
 * Formato de datos <code>OZNCSNK0</code> de la transacci&oacute;n <code>OZNK</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZNCSNK0")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZNCSNK0 {
	
	/**
	 * <p>Campo <code>FECHAO</code>, &iacute;ndice: <code>1</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 1, nombre = "FECHAO", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fechao;
	
	/**
	 * <p>Campo <code>RESTO</code>, &iacute;ndice: <code>2</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 2, nombre = "RESTO", tipo = TipoCampo.DECIMAL, longitudMinima = 15, longitudMaxima = 15, signo = true, decimales = 2)
	private BigDecimal resto;
	
	/**
	 * <p>Campo <code>IMPORTE</code>, &iacute;ndice: <code>3</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 3, nombre = "IMPORTE", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String importe;
	
	/**
	 * <p>Campo <code>BALANCE</code>, &iacute;ndice: <code>4</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 4, nombre = "BALANCE", tipo = TipoCampo.DECIMAL, longitudMinima = 15, longitudMaxima = 15, signo = true, decimales = 2)
	private BigDecimal balance;
	
	/**
	 * <p>Campo <code>DESCOP</code>, &iacute;ndice: <code>5</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 5, nombre = "DESCOP", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 50, longitudMaxima = 50)
	private String descop;
	
	/**
	 * <p>Campo <code>COUTAS</code>, &iacute;ndice: <code>6</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 6, nombre = "COUTAS", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String coutas;
	
	/**
	 * <p>Campo <code>COUTAT</code>, &iacute;ndice: <code>7</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 7, nombre = "COUTAT", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String coutat;
	
	/**
	 * <p>Campo <code>ESTADO</code>, &iacute;ndice: <code>8</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 8, nombre = "ESTADO", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 2, longitudMaxima = 2)
	private String estado;
	
}