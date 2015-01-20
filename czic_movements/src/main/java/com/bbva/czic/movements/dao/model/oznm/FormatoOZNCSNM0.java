package com.bbva.czic.movements.dao.model.oznm;

import java.math.BigDecimal;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import com.bbva.jee.arq.spring.core.host.Formato;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;


/**
 * Formato de datos <code>OZNCSNM0</code> de la transacci&oacute;n <code>OZNM</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZNCSNM0")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZNCSNM0 {
	
	/**
	 * <p>Campo <code>NUMECTA</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "NUMECTA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 23, longitudMaxima = 23)
	private String numecta;
	
	/**
	 * <p>Campo <code>NOMOVIM</code>, &iacute;ndice: <code>2</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 2, nombre = "NOMOVIM", tipo = TipoCampo.ENTERO, longitudMinima = 9, longitudMaxima = 9, signo = true)
	private Integer nomovim;
	
	/**
	 * <p>Campo <code>FCHOPER</code>, &iacute;ndice: <code>3</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 3, nombre = "FCHOPER", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String fchoper;
	
	/**
	 * <p>Campo <code>FCHVALR</code>, &iacute;ndice: <code>4</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 4, nombre = "FCHVALR", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String fchvalr;
	
	/**
	 * <p>Campo <code>HRAOPER</code>, &iacute;ndice: <code>5</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 5, nombre = "HRAOPER", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 8, longitudMaxima = 8)
	private String hraoper;
	
	/**
	 * <p>Campo <code>VALOR</code>, &iacute;ndice: <code>6</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 6, nombre = "VALOR", tipo = TipoCampo.DECIMAL, longitudMinima = 17, longitudMaxima = 17, signo = true, decimales = 2)
	private BigDecimal valor;
	
	/**
	 * <p>Campo <code>SALDO</code>, &iacute;ndice: <code>7</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 7, nombre = "SALDO", tipo = TipoCampo.DECIMAL, longitudMinima = 17, longitudMaxima = 17, signo = true, decimales = 2)
	private BigDecimal saldo;
	
	/**
	 * <p>Campo <code>CHEQUE</code>, &iacute;ndice: <code>8</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 8, nombre = "CHEQUE", tipo = TipoCampo.ENTERO, longitudMinima = 9, longitudMaxima = 9, signo = true)
	private Integer cheque;
	
	/**
	 * <p>Campo <code>CODIGO</code>, &iacute;ndice: <code>9</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 9, nombre = "CODIGO", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 3, longitudMaxima = 3)
	private String codigo;
	
	/**
	 * <p>Campo <code>DESCODI</code>, &iacute;ndice: <code>10</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 10, nombre = "DESCODI", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 30, longitudMaxima = 30)
	private String descodi;
	
	/**
	 * <p>Campo <code>OBSERVA</code>, &iacute;ndice: <code>11</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 11, nombre = "OBSERVA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 30, longitudMaxima = 30)
	private String observa;
	
	/**
	 * <p>Campo <code>CTROORG</code>, &iacute;ndice: <code>12</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 12, nombre = "CTROORG", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 30, longitudMaxima = 30)
	private String ctroorg;
	
	/**
	 * <p>Campo <code>PLAZA</code>, &iacute;ndice: <code>13</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 13, nombre = "PLAZA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 30, longitudMaxima = 30)
	private String plaza;
	
	/**
	 * <p>Campo <code>CTATRAS</code>, &iacute;ndice: <code>14</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 14, nombre = "CTATRAS", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 23, longitudMaxima = 23)
	private String ctatras;
	
	/**
	 * <p>Campo <code>TIPO</code>, &iacute;ndice: <code>15</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 15, nombre = "TIPO", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 2, longitudMaxima = 2)
	private String tipo;
	
}