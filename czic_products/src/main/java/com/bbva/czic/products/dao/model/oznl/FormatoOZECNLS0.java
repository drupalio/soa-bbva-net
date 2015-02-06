package com.bbva.czic.products.dao.model.oznl;

import java.util.Date;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;


/**
 * Formato de datos <code>OZECNLS0</code> de la transacci&oacute;n <code>OZNL</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZECNLS0")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZECNLS0 {
	
	/**
	 * <p>Campo <code>NUMOPER</code>, &iacute;ndice: <code>1</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 1, nombre = "NUMOPER", tipo = TipoCampo.ENTERO, longitudMinima = 9, longitudMaxima = 9)
	private Integer numoper;
	
	/**
	 * <p>Campo <code>FECHOPE</code>, &iacute;ndice: <code>2</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 2, nombre = "FECHOPE", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fechope;
	
	/**
	 * <p>Campo <code>DESCOPR</code>, &iacute;ndice: <code>3</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 3, nombre = "DESCOPR", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 30, longitudMaxima = 30)
	private String descopr;
	
	/**
	 * <p>Campo <code>VALOROP</code>, &iacute;ndice: <code>4</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 4, nombre = "VALOROP", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 18, longitudMaxima = 18)
	private String valorop;
	
	/**
	 * <p>Campo <code>BALANCE</code>, &iacute;ndice: <code>5</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 5, nombre = "BALANCE", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 18, longitudMaxima = 18)
	private String balance;
	
	/**
	 * <p>Campo <code>CONCEPT</code>, &iacute;ndice: <code>6</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 6, nombre = "CONCEPT", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String concept;
	
	/**
	 * <p>Campo <code>TIPOOPR</code>, &iacute;ndice: <code>7</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 7, nombre = "TIPOOPR", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 3, longitudMaxima = 3)
	private String tipoopr;
	
}