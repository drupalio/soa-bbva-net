package com.bbva.zic.customers.dao.model.oznb;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import com.bbva.jee.arq.spring.core.host.Formato;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;


/**
 * Formato de datos <code>OZNCSNB0</code> de la transacci&oacute;n <code>OZNB</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZNCSNB0")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZNCSNB0 {
	
	/**
	 * <p>Campo <code>NUMCLIE</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "NUMCLIE", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 8, longitudMaxima = 8)
	private String numclie;
	
	/**
	 * <p>Campo <code>NOMCLIE</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "NOMCLIE", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 50, longitudMaxima = 50)
	private String nomclie;
	
	/**
	 * <p>Campo <code>SEGMENT</code>, &iacute;ndice: <code>3</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 3, nombre = "SEGMENT", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String segment;
	
	/**
	 * <p>Campo <code>CORREO</code>, &iacute;ndice: <code>4</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 4, nombre = "CORREO", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 50, longitudMaxima = 50)
	private String correo;
	
	/**
	 * <p>Campo <code>DESCVIA</code>, &iacute;ndice: <code>5</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 5, nombre = "DESCVIA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 50, longitudMaxima = 50)
	private String descvia;
	
	/**
	 * <p>Campo <code>CIUDVIA</code>, &iacute;ndice: <code>6</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 6, nombre = "CIUDVIA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 3, longitudMaxima = 3)
	private String ciudvia;
	
	/**
	 * <p>Campo <code>DEPAVIA</code>, &iacute;ndice: <code>7</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 7, nombre = "DEPAVIA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 2, longitudMaxima = 2)
	private String depavia;
	
	/**
	 * <p>Campo <code>PAISVIA</code>, &iacute;ndice: <code>8</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 8, nombre = "PAISVIA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 4, longitudMaxima = 4)
	private String paisvia;
	
	/**
	 * <p>Campo <code>ESTRATO</code>, &iacute;ndice: <code>9</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 9, nombre = "ESTRATO", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 2, longitudMaxima = 2)
	private String estrato;
	
	/**
	 * <p>Campo <code>ANOSVDA</code>, &iacute;ndice: <code>10</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 10, nombre = "ANOSVDA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 2, longitudMaxima = 2)
	private String anosvda;
	
	/**
	 * <p>Campo <code>NROPNAS</code>, &iacute;ndice: <code>11</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 11, nombre = "NROPNAS", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 3, longitudMaxima = 3)
	private String nropnas;
	
	/**
	 * <p>Campo <code>TPOVVDA</code>, &iacute;ndice: <code>12</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 12, nombre = "TPOVVDA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String tpovvda;
	
	/**
	 * <p>Campo <code>DESCOFI</code>, &iacute;ndice: <code>13</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 13, nombre = "DESCOFI", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 50, longitudMaxima = 50)
	private String descofi;
	
	/**
	 * <p>Campo <code>CIUDOFI</code>, &iacute;ndice: <code>14</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 14, nombre = "CIUDOFI", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 3, longitudMaxima = 3)
	private String ciudofi;
	
	/**
	 * <p>Campo <code>DEPAOFI</code>, &iacute;ndice: <code>15</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 15, nombre = "DEPAOFI", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 2, longitudMaxima = 2)
	private String depaofi;
	
	/**
	 * <p>Campo <code>PAISOFI</code>, &iacute;ndice: <code>16</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 16, nombre = "PAISOFI", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 4, longitudMaxima = 4)
	private String paisofi;
	
	/**
	 * <p>Campo <code>ULTCONX</code>, &iacute;ndice: <code>17</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 17, nombre = "ULTCONX", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 43, longitudMaxima = 43)
	private String ultconx;
	
}