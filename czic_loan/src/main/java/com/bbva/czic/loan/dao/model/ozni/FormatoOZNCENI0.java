package com.bbva.czic.loan.dao.model.ozni;


import java.util.Date;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * Formato de datos <code>OZNCENI0</code> de la transacci&oacute;n <code>OZNI</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZNCENI0")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZNCENI0 {

	/**
	 * <p>Campo <code>NOTARJE</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "NOTARJE", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String notarje;
	
	/**
	 * <p>Campo <code>FECHINI</code>, &iacute;ndice: <code>2</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 2, nombre = "FECHINI", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fechini;
	
	/**
	 * <p>Campo <code>FECHAFI</code>, &iacute;ndice: <code>3</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 3, nombre = "FECHAFI", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fechafi;
	
	/**
	 * <p>Campo <code>INDPAG</code>, &iacute;ndice: <code>4</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 4, nombre = "INDPAG", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String indpag;
	
	/**
	 * <p>Campo <code>POSPAG</code>, &iacute;ndice: <code>5</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 5, nombre = "POSPAG", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 50, longitudMaxima = 50)
	private String pospag;
	
}