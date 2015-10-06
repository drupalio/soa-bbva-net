package com.bbva.czic.products.dao.model.oznm;

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
	@Campo(indice = 1, nombre = "NUMECTA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String numecta;
	
	/**
	 * <p>Campo <code>TIPO</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "TIPO", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 2, longitudMaxima = 2)
	private String tipo;
	
	/**
	 * <p>Campo <code>NUMMOV</code>, &iacute;ndice: <code>3</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 3, nombre = "NUMMOV", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 9, longitudMaxima = 9)
	private String nummov;
	
	/**
	 * <p>Campo <code>FCHOPER</code>, &iacute;ndice: <code>4</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 4, nombre = "FCHOPER", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 15, longitudMaxima = 15)
	private String fchoper;
	
	/**
	 * <p>Campo <code>RESTO</code>, &iacute;ndice: <code>5</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 5, nombre = "RESTO", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 30, longitudMaxima = 30)
	private String resto;
	
	/**
	 * <p>Campo <code>VALOR</code>, &iacute;ndice: <code>6</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 6, nombre = "VALOR", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 16, longitudMaxima = 16)
	private String valor;
	
	/**
	 * <p>Campo <code>BALOPER</code>, &iacute;ndice: <code>7</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 7, nombre = "BALOPER", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 16, longitudMaxima = 16)
	private String baloper;
	
	/**
	 * <p>Campo <code>CODOPER</code>, &iacute;ndice: <code>8</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 8, nombre = "CODOPER", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 2, longitudMaxima = 2)
	private String codoper;
	
	/**
	 * <p>Campo <code>DESCODI</code>, &iacute;ndice: <code>9</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 9, nombre = "DESCODI", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 30, longitudMaxima = 30)
	private String descodi;
	
	/**
	 * <p>Campo <code>FCHVALR</code>, &iacute;ndice: <code>10</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 10, nombre = "FCHVALR", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String fchvalr;
	
	/**
	 * <p>Campo <code>PLAZA</code>, &iacute;ndice: <code>11</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 11, nombre = "PLAZA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 30, longitudMaxima = 30)
	private String plaza;
	
	/**
	 * <p>Campo <code>SALDO</code>, &iacute;ndice: <code>12</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 12, nombre = "SALDO", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 16, longitudMaxima = 16)
	private String saldo;
	
	/**
	 * <p>Campo <code>CTROORG</code>, &iacute;ndice: <code>13</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 13, nombre = "CTROORG", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 30, longitudMaxima = 30)
	private String ctroorg;
	
	/**
	 * <p>Campo <code>NUMCLIE</code>, &iacute;ndice: <code>14</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 14, nombre = "NUMCLIE", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 8, longitudMaxima = 8)
	private String numclie;
	
}