package com.bbva.zic.accounts.dao.model.ozna;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import com.bbva.jee.arq.spring.core.host.Formato;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;


/**
 * Formato de datos <code>OZNCSNA0</code> de la transacci&oacute;n <code>OZNA</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZNCSNA0")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZNCSNA0 {
	
	/**
	 * <p>Campo <code>NUMPROD</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "NUMPROD", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String numprod;
	
	/**
	 * <p>Campo <code>TIPPROD</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "TIPPROD", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 2, longitudMaxima = 2)
	private String tipprod;
	
	/**
	 * <p>Campo <code>NOMPROD</code>, &iacute;ndice: <code>3</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 3, nombre = "NOMPROD", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 50, longitudMaxima = 50)
	private String nomprod;
	
	/**
	 * <p>Campo <code>SALTOTA</code>, &iacute;ndice: <code>4</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 4, nombre = "SALTOTA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 18, longitudMaxima = 18)
	private String saltota;
	
	/**
	 * <p>Campo <code>SDDISPO</code>, &iacute;ndice: <code>5</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 5, nombre = "SDDISPO", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 18, longitudMaxima = 18)
	private String sddispo;
	
	/**
	 * <p>Campo <code>SDCANJE</code>, &iacute;ndice: <code>6</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 6, nombre = "SDCANJE", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 18, longitudMaxima = 18)
	private String sdcanje;
	
	/**
	 * <p>Campo <code>IDCHEQ0</code>, &iacute;ndice: <code>7</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 7, nombre = "IDCHEQ0", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String idcheq0;
	
	/**
	 * <p>Campo <code>IDCHEQ1</code>, &iacute;ndice: <code>8</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 8, nombre = "IDCHEQ1", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String idcheq1;
	
	/**
	 * <p>Campo <code>IDCHEQ2</code>, &iacute;ndice: <code>9</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 9, nombre = "IDCHEQ2", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String idcheq2;
	
	/**
	 * <p>Campo <code>IDCHEQ3</code>, &iacute;ndice: <code>10</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 10, nombre = "IDCHEQ3", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String idcheq3;
	
	/**
	 * <p>Campo <code>IDCHEQ4</code>, &iacute;ndice: <code>11</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 11, nombre = "IDCHEQ4", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String idcheq4;
	
	/**
	 * <p>Campo <code>IDCHEQ5</code>, &iacute;ndice: <code>12</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 12, nombre = "IDCHEQ5", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String idcheq5;
	
	/**
	 * <p>Campo <code>IDCHEQ6</code>, &iacute;ndice: <code>13</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 13, nombre = "IDCHEQ6", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String idcheq6;
	
	/**
	 * <p>Campo <code>IDCHEQ7</code>, &iacute;ndice: <code>14</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 14, nombre = "IDCHEQ7", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String idcheq7;
	
	/**
	 * <p>Campo <code>IDCHEQ8</code>, &iacute;ndice: <code>15</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 15, nombre = "IDCHEQ8", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String idcheq8;
	
	/**
	 * <p>Campo <code>IDCHEQ9</code>, &iacute;ndice: <code>16</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 16, nombre = "IDCHEQ9", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String idcheq9;
	
}