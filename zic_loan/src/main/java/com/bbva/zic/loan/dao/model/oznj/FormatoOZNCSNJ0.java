package com.bbva.zic.loan.dao.model.oznj;

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
	 * <p>Campo <code>NUMCONT</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "NUMCONT", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String numcont;
	
	/**
	 * <p>Campo <code>TIPPROD</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "TIPPROD", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 2, longitudMaxima = 2)
	private String tipprod;
	
	/**
	 * <p>Campo <code>DESCTAR</code>, &iacute;ndice: <code>3</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 3, nombre = "DESCTAR", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String desctar;
	
	/**
	 * <p>Campo <code>SALDOTO</code>, &iacute;ndice: <code>4</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 4, nombre = "SALDOTO", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 12, longitudMaxima = 12)
	private String saldoto;
	
	/**
	 * <p>Campo <code>SALDODI</code>, &iacute;ndice: <code>5</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 5, nombre = "SALDODI", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 12, longitudMaxima = 12)
	private String saldodi;
	
	/**
	 * <p>Campo <code>PAGOMIN</code>, &iacute;ndice: <code>6</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 6, nombre = "PAGOMIN", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 12, longitudMaxima = 12)
	private String pagomin;
	
	/**
	 * <p>Campo <code>MNTOSOL</code>, &iacute;ndice: <code>7</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 7, nombre = "MNTOSOL", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 12, longitudMaxima = 12)
	private String mntosol;
	
	/**
	 * <p>Campo <code>SALDOPE</code>, &iacute;ndice: <code>8</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 8, nombre = "SALDOPE", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 12, longitudMaxima = 12)
	private String saldope;
	
	/**
	 * <p>Campo <code>FECHACA</code>, &iacute;ndice: <code>9</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 9, nombre = "FECHACA", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fechaca;
	
	/**
	 * <p>Campo <code>FECHALI</code>, &iacute;ndice: <code>10</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 10, nombre = "FECHALI", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fechali;
	
	/**
	 * <p>Campo <code>FECHACO</code>, &iacute;ndice: <code>11</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 11, nombre = "FECHACO", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fechaco;
	
	/**
	 * <p>Campo <code>HONORAR</code>, &iacute;ndice: <code>12</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 12, nombre = "HONORAR", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 12, longitudMaxima = 12)
	private String honorar;
	
	/**
	 * <p>Campo <code>CUOTATO</code>, &iacute;ndice: <code>13</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 13, nombre = "CUOTATO", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 3, longitudMaxima = 3)
	private String cuotato;
	
	/**
	 * <p>Campo <code>ESTADOT</code>, &iacute;ndice: <code>14</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 14, nombre = "ESTADOT", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 80, longitudMaxima = 80)
	private String estadot;
	
}