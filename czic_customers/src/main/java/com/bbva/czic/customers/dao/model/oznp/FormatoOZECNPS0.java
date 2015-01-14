package com.bbva.czic.customers.dao.model.oznp;

import java.math.BigDecimal;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import com.bbva.jee.arq.spring.core.host.Formato;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;


/**
 * Formato de datos <code>OZECNPS0</code> de la transacci&oacute;n <code>OZNP</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZECNPS0")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZECNPS0 {
	
	/**
	 * <p>Campo <code>CATEGOR</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "CATEGOR", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 35, longitudMaxima = 35)
	private String categor;
	
	/**
	 * <p>Campo <code>VALCATE</code>, &iacute;ndice: <code>2</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 2, nombre = "VALCATE", tipo = TipoCampo.DECIMAL, longitudMinima = 17, longitudMaxima = 17, decimales = 2)
	private BigDecimal valcate;
	
}