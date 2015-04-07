package com.bbva.zic.accounts.dao.model.oznv;


import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * Formato de datos <code>OZECNVE0</code> de la transacci&oacute;n <code>OZNV</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZECNVE0")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZECNVE0 {

	/**
	 * <p>Campo <code>NUMCTA</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "NUMCTA", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String numcta;
	
	/**
	 * <p>Campo <code>MESINI</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "MESINI", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 6, longitudMaxima = 6)
	private String mesini;
	
	/**
	 * <p>Campo <code>MESFIN</code>, &iacute;ndice: <code>3</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 3, nombre = "MESFIN", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 6, longitudMaxima = 6)
	private String mesfin;
	
}