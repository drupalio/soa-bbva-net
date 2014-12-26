package com.bbva.czic.loan.dao.model.oznj;

import java.math.BigDecimal;
import java.util.Date;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import com.bbva.jee.arq.spring.core.host.Formato;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;


/**
 * Formato de datos <code>OZNCSNJ0</code> de la transacci&oacute;n <code>OZNJ</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZNCSNJ0")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZNCSNJ0 {
	
	/**
	 * <p>Campo <code>TIPPROD</code>, &iacute;ndice: <code>1</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 1, nombre = "TIPPROD", tipo = TipoCampo.ENTERO, longitudMinima = 2, longitudMaxima = 2)
	private Integer tipprod;
	
	/**
	 * <p>Campo <code>NOMPROD</code>, &iacute;ndice: <code>2</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 2, nombre = "NOMPROD", tipo = TipoCampo.ENTERO, longitudMinima = 10, longitudMaxima = 10)
	private Long nomprod;
	
	/**
	 * <p>Campo <code>SALDOTO</code>, &iacute;ndice: <code>3</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 3, nombre = "SALDOTO", tipo = TipoCampo.DECIMAL, longitudMinima = 15, longitudMaxima = 15, signo = true, decimales = 2)
	private BigDecimal saldoto;
	
	/**
	 * <p>Campo <code>SALDODI</code>, &iacute;ndice: <code>4</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 4, nombre = "SALDODI", tipo = TipoCampo.DECIMAL, longitudMinima = 15, longitudMaxima = 15, signo = true, decimales = 2)
	private BigDecimal saldodi;
	
	/**
	 * <p>Campo <code>MONTOSO</code>, &iacute;ndice: <code>5</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 5, nombre = "MONTOSO", tipo = TipoCampo.DECIMAL, longitudMinima = 15, longitudMaxima = 15, signo = true, decimales = 2)
	private BigDecimal montoso;
	
	/**
	 * <p>Campo <code>SALDOPE</code>, &iacute;ndice: <code>6</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 6, nombre = "SALDOPE", tipo = TipoCampo.DECIMAL, longitudMinima = 15, longitudMaxima = 15, signo = true, decimales = 2)
	private BigDecimal saldope;
	
	/**
	 * <p>Campo <code>FECHAVE</code>, &iacute;ndice: <code>7</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 7, nombre = "FECHAVE", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fechave;
	
	/**
	 * <p>Campo <code>FECHAPA</code>, &iacute;ndice: <code>8</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 8, nombre = "FECHAPA", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fechapa;
	
	/**
	 * <p>Campo <code>FECHACO</code>, &iacute;ndice: <code>9</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 9, nombre = "FECHACO", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fechaco;
	
	/**
	 * <p>Campo <code>HONORAR</code>, &iacute;ndice: <code>10</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 10, nombre = "HONORAR", tipo = TipoCampo.DECIMAL, longitudMinima = 15, longitudMaxima = 15, signo = true, decimales = 2)
	private BigDecimal honorar;
	
	/**
	 * <p>Campo <code>NUMCOUT</code>, &iacute;ndice: <code>11</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 11, nombre = "NUMCOUT", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 2, longitudMaxima = 2)
	private String numcout;
	
	/**
	 * <p>Campo <code>ESTADO</code>, &iacute;ndice: <code>12</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 12, nombre = "ESTADO", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 2, longitudMaxima = 2)
	private String estado;
	
	/**
	 * <p>Campo <code>NUMERO</code>, &iacute;ndice: <code>13</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 13, nombre = "NUMERO", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String numero;
	
}