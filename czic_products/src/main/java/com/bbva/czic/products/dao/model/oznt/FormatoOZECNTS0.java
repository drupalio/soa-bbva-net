package com.bbva.czic.products.dao.model.oznt;

import java.util.Date;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;


/**
 * Formato de datos <code>OZECNTS0</code> de la transacci&oacute;n <code>OZNT</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZECNTS0")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZECNTS0 {
	
	/**
	 * <p>Campo <code>TIPPROD</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "TIPPROD", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 2, longitudMaxima = 2)
	private String tipprod;
	
	/**
	 * <p>Campo <code>TIALIAS</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "TIALIAS", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 30, longitudMaxima = 30)
	private String tialias;
	
	/**
	 * <p>Campo <code>CATEGOR</code>, &iacute;ndice: <code>3</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 3, nombre = "CATEGOR", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String categor;
	
	/**
	 * <p>Campo <code>DESPROD</code>, &iacute;ndice: <code>4</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 4, nombre = "DESPROD", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 40, longitudMaxima = 40)
	private String desprod;
	
	/**
	 * <p>Campo <code>FECHAPE</code>, &iacute;ndice: <code>5</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 5, nombre = "FECHAPE", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fechape;
	
	/**
	 * <p>Campo <code>COMPROD</code>, &iacute;ndice: <code>6</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 6, nombre = "COMPROD", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 9, longitudMaxima = 9)
	private String comprod;
	
	/**
	 * <p>Campo <code>CONPROD</code>, &iacute;ndice: <code>7</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 7, nombre = "CONPROD", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 30, longitudMaxima = 30)
	private String conprod;
	
	/**
	 * <p>Campo <code>NOMOFIC</code>, &iacute;ndice: <code>8</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 8, nombre = "NOMOFIC", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String nomofic;
	
	/**
	 * <p>Campo <code>DIROFIC</code>, &iacute;ndice: <code>9</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 9, nombre = "DIROFIC", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 40, longitudMaxima = 40)
	private String dirofic;
	
	/**
	 * <p>Campo <code>CIUDOFI</code>, &iacute;ndice: <code>10</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 10, nombre = "CIUDOFI", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String ciudofi;
	
	/**
	 * <p>Campo <code>PAISOFI</code>, &iacute;ndice: <code>11</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 11, nombre = "PAISOFI", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String paisofi;
	
	/**
	 * <p>Campo <code>FECOPER</code>, &iacute;ndice: <code>12</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 12, nombre = "FECOPER", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fecoper;
	
	/**
	 * <p>Campo <code>FECEJEC</code>, &iacute;ndice: <code>13</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 13, nombre = "FECEJEC", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fecejec;
	
	/**
	 * <p>Campo <code>TIPFUNC</code>, &iacute;ndice: <code>14</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 14, nombre = "TIPFUNC", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 2, longitudMaxima = 2)
	private String tipfunc;
	
	/**
	 * <p>Campo <code>DESFUNC</code>, &iacute;ndice: <code>15</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 15, nombre = "DESFUNC", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 50, longitudMaxima = 50)
	private String desfunc;
	
	/**
	 * <p>Campo <code>CANTDAD</code>, &iacute;ndice: <code>16</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 16, nombre = "CANTDAD", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 17, longitudMaxima = 17)
	private String cantdad;
	
	/**
	 * <p>Campo <code>REFFUNC</code>, &iacute;ndice: <code>17</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 17, nombre = "REFFUNC", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 60, longitudMaxima = 60)
	private String reffunc;
	
}