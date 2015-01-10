package com.bbva.czic.customers.dao.model.ozno;


import java.util.Date;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * Formato de datos <code>OZECNOE0</code> de la transacci&oacute;n <code>OZNO</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZECNOE0")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZECNOE0 {

	/**
	 * <p>Campo <code>NUMPROD</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "NUMPROD", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 16, longitudMaxima = 16)
	private String numprod;
	
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

	public void setFechafi(String fechain2) {
		// TODO Auto-generated method stub
		
	}
	
}