package com.bbva.czic.customers.dao.model.oznq;


import java.util.Date;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * Formato de datos <code>OZECNQE0</code> de la transacci&oacute;n <code>OZNQ</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZECNQE0")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZECNQE0 {

	/**
	 * <p>Campo <code>IDUSUAR</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "IDUSUAR", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 8, longitudMaxima = 8)
	private String idusuar;
	
	/**
	 * <p>Campo <code>FECHAIN</code>, &iacute;ndice: <code>2</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 2, nombre = "FECHAIN", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fechain;
	
	/**
	 * <p>Campo <code>FECHAFI</code>, &iacute;ndice: <code>3</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 3, nombre = "FECHAFI", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fechafi;
	
}