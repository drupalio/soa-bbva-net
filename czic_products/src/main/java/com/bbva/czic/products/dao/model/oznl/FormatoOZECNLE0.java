package com.bbva.czic.products.dao.model.oznl;


import java.math.BigDecimal;
import java.util.Date;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * Formato de datos <code>OZECNLE0</code> de la transacci&oacute;n <code>OZNL</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZECNLE0")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZECNLE0 {

	/**
	 * <p>Campo <code>NUMCUEN</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "NUMCUEN", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String numcuen;
	
	/**
	 * <p>Campo <code>INDPAGI</code>, &iacute;ndice: <code>2</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 2, nombre = "INDPAGI", tipo = TipoCampo.ENTERO, longitudMinima = 9, longitudMaxima = 9)
	private Integer indpagi;
	
	/**
	 * <p>Campo <code>TAMPAGI</code>, &iacute;ndice: <code>3</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 3, nombre = "TAMPAGI", tipo = TipoCampo.ENTERO, longitudMinima = 3, longitudMaxima = 3)
	private Integer tampagi;
	
	/**
	 * <p>Campo <code>FECINI</code>, &iacute;ndice: <code>4</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 4, nombre = "FECINI", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fecini;
	
	/**
	 * <p>Campo <code>FECFIN</code>, &iacute;ndice: <code>5</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 5, nombre = "FECFIN", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fecfin;
	
	/**
	 * <p>Campo <code>SALINC</code>, &iacute;ndice: <code>6</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 6, nombre = "SALINC", tipo = TipoCampo.DECIMAL, longitudMinima = 15, longitudMaxima = 15, signo = true, decimales = 2)
	private BigDecimal salinc;
	
	/**
	 * <p>Campo <code>SALFIN</code>, &iacute;ndice: <code>7</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 7, nombre = "SALFIN", tipo = TipoCampo.DECIMAL, longitudMinima = 15, longitudMaxima = 15, signo = true, decimales = 2)
	private BigDecimal salfin;
	
}