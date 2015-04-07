package com.bbva.zic.loan.dao.model.ozni;


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
	 * <p>Campo <code>INDPANE</code>, &iacute;ndice: <code>4</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 4, nombre = "INDPANE", tipo = TipoCampo.ENTERO, longitudMinima = 4, longitudMaxima = 4)
	private Integer indpane;
	
	/**
	 * <p>Campo <code>INDPANO</code>, &iacute;ndice: <code>5</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 5, nombre = "INDPANO", tipo = TipoCampo.ENTERO, longitudMinima = 6, longitudMaxima = 6)
	private Integer indpano;
	
	/**
	 * <p>Campo <code>POSPAG</code>, &iacute;ndice: <code>6</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 6, nombre = "POSPAG", tipo = TipoCampo.ENTERO, longitudMinima = 3, longitudMaxima = 3)
	private Integer pospag;
	
}