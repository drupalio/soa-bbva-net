package com.bbva.czic.globalposition.dao.model.ozn1;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import com.bbva.jee.arq.spring.core.host.Formato;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;


/**
 * Formato de datos <code>OZECN1S1</code> de la transacci&oacute;n <code>OZN1</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZECN1S1")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZECN1S1 {
	
	/**
	 * <p>Campo <code>TIPPROD</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "TIPPROD", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 2, longitudMaxima = 2)
	private String tipprod;
	
	/**
	 * <p>Campo <code>NUMPROD</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "NUMPROD", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String numprod;
	
	/**
	 * <p>Campo <code>SALTOTA</code>, &iacute;ndice: <code>3</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 3, nombre = "SALTOTA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 18, longitudMaxima = 18)
	private String saltota;
	
	/**
	 * <p>Campo <code>SALDISP</code>, &iacute;ndice: <code>4</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 4, nombre = "SALDISP", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 18, longitudMaxima = 18)
	private String saldisp;
	
	/**
	 * <p>Campo <code>INDVISI</code>, &iacute;ndice: <code>5</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 5, nombre = "INDVISI", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String indvisi;
	
	/**
	 * <p>Campo <code>INDOPER</code>, &iacute;ndice: <code>6</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 6, nombre = "INDOPER", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String indoper;
	
	/**
	 * <p>Campo <code>ALIAS</code>, &iacute;ndice: <code>7</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 7, nombre = "ALIAS", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String alias;
	
	/**
	 * <p>Campo <code>NOMPROD</code>, &iacute;ndice: <code>8</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 8, nombre = "NOMPROD", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String nomprod;
	
	/**
	 * <p>Campo <code>FINSTAT</code>, &iacute;ndice: <code>9</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 9, nombre = "FINSTAT", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String finstat;
	
	/**
	 * <p>Campo <code>NUMTARJ</code>, &iacute;ndice: <code>10</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 10, nombre = "NUMTARJ", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 16, longitudMaxima = 16)
	private String numtarj;
	
	/**
	 * <p>Campo <code>NUMCONT</code>, &iacute;ndice: <code>11</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 11, nombre = "NUMCONT", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String numcont;
	
	/**
	 * <p>Campo <code>NUMCELU</code>, &iacute;ndice: <code>12</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 12, nombre = "NUMCELU", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String numcelu;
	
}