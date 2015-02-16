package com.bbva.czic.accounts.dao.model.oznv;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import com.bbva.jee.arq.spring.core.host.Formato;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;


/**
 * Formato de datos <code>OZECNVS0</code> de la transacci&oacute;n <code>OZNV</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZECNVS0")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZECNVS0 {
	
	/**
	 * <p>Campo <code>SALDDIS</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "SALDDIS", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 19, longitudMaxima = 19)
	private String salddis;
	
	/**
	 * <p>Campo <code>MES</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "MES", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 6, longitudMaxima = 6)
	private String mes;
	
}