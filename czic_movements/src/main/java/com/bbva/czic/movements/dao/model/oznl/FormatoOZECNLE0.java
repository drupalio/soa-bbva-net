package com.bbva.czic.movements.dao.model.oznl;


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
	@Campo(indice = 1, nombre = "NUMCUEN", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 18, longitudMaxima = 18)
	private String numcuen;
	
	/**
	 * <p>Campo <code>NUMCLIE</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "NUMCLIE", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 8, longitudMaxima = 8)
	private String numclie;
	
	/**
	 * <p>Campo <code>FECINI</code>, &iacute;ndice: <code>3</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 3, nombre = "FECINI", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fecini;
	
	/**
	 * <p>Campo <code>FECFIN</code>, &iacute;ndice: <code>4</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 4, nombre = "FECFIN", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fecfin;
	
	/**
	 * <p>Campo <code>SALINI</code>, &iacute;ndice: <code>5</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 5, nombre = "SALINI", tipo = TipoCampo.ENTERO, longitudMinima = 15, longitudMaxima = 15, signo = true)
	private Long salini;
	
	/**
	 * <p>Campo <code>SALFIN</code>, &iacute;ndice: <code>6</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 6, nombre = "SALFIN", tipo = TipoCampo.ENTERO, longitudMinima = 15, longitudMaxima = 15, signo = true)
	private Long salfin;
	
	/**
	 * <p>Campo <code>INDPAGI</code>, &iacute;ndice: <code>7</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 7, nombre = "INDPAGI", tipo = TipoCampo.ENTERO, longitudMinima = 9, longitudMaxima = 9)
	private Integer indpagi;
	
}