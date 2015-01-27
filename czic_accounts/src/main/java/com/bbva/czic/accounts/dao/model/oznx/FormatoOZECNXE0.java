package com.bbva.czic.accounts.dao.model.oznx;


import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import java.util.Date;

/**
 * Formato de datos <code>OZECNXE0</code> de la transacci&oacute;n <code>OZNX</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZECNXE0")
@RooJavaBean
@RooToString
@RooSerializable
public class
		FormatoOZECNXE0 {

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
	 * <p>Campo <code>NUMPROD</code>, &iacute;ndice: <code>3</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 3, nombre = "NUMPROD", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String numprod;
	
	/**
	 * <p>Campo <code>FECHINI</code>, &iacute;ndice: <code>4</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 4, nombre = "FECHINI", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fechini;
	
	/**
	 * <p>Campo <code>FECHFIN</code>, &iacute;ndice: <code>5</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 5, nombre = "FECHFIN", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fechfin;
	
	/**
	 * <p>Campo <code>ESTCHEQ</code>, &iacute;ndice: <code>6</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 6, nombre = "ESTCHEQ", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String estcheq;


	public void setId(String id) {
	}
}