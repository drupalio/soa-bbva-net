package com.bbva.czic.accounts.dao.model.ozns;

import java.util.Date;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import com.bbva.jee.arq.spring.core.host.Formato;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;


/**
 * Formato de datos <code>OZECNSS0</code> de la transacci&oacute;n <code>OZNS</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZECNSS0")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZECNSS0 {
	
	/**
	 * <p>Campo <code>PRIMCHQ</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "PRIMCHQ", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String primchq;
	
	/**
	 * <p>Campo <code>ULTICHQ</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "ULTICHQ", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String ultichq;
	
	/**
	 * <p>Campo <code>TOTACHQ</code>, &iacute;ndice: <code>3</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 3, nombre = "TOTACHQ", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 3, longitudMaxima = 3)
	private String totachq;
	
	/**
	 * <p>Campo <code>FECEMIS</code>, &iacute;ndice: <code>4</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 4, nombre = "FECEMIS", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fecemis;
	
	/**
	 * <p>Campo <code>FECENTR</code>, &iacute;ndice: <code>5</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 5, nombre = "FECENTR", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fecentr;
	
	/**
	 * <p>Campo <code>ESTACHQ</code>, &iacute;ndice: <code>6</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 6, nombre = "ESTACHQ", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String estachq;
	
}