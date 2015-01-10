package com.bbva.czic.checkbooks.dao.model.ozny;


import java.util.Date;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * Formato de datos <code>OZECNYE0</code> de la transacci&oacute;n <code>OZNY</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZECNYE0")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZECNYE0 {

	/**
	 * <p>Campo <code>INDPAGI</code>, &iacute;ndice: <code>1</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 1, nombre = "INDPAGI", tipo = TipoCampo.ENTERO, longitudMinima = 3, longitudMaxima = 3, signo = true)
	private Integer indpagi;
	
	/**
	 * <p>Campo <code>TAMPAGI</code>, &iacute;ndice: <code>2</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 2, nombre = "TAMPAGI", tipo = TipoCampo.ENTERO, longitudMinima = 3, longitudMaxima = 3, signo = true)
	private Integer tampagi;
	
	/**
	 * <p>Campo <code>NUMCTA</code>, &iacute;ndice: <code>3</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 3, nombre = "NUMCTA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String numcta;
	
	/**
	 * <p>Campo <code>NUMCHEQ</code>, &iacute;ndice: <code>4</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 4, nombre = "NUMCHEQ", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 9, longitudMaxima = 9)
	private String numcheq;
	
	/**
	 * <p>Campo <code>FECHINI</code>, &iacute;ndice: <code>5</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 5, nombre = "FECHINI", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fechini;
	
	/**
	 * <p>Campo <code>FECHFIN</code>, &iacute;ndice: <code>6</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 6, nombre = "FECHFIN", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fechfin;
	
	/**
	 * <p>Campo <code>ESTCHEQ</code>, &iacute;ndice: <code>7</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 7, nombre = "ESTCHEQ", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String estcheq;
	
}