package com.bbva.zic.executives.dao.model.oznr;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import com.bbva.jee.arq.spring.core.host.Formato;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;


/**
 * Formato de datos <code>OZECNRS0</code> de la transacci&oacute;n <code>OZNR</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZECNRS0")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZECNRS0 {
	
	/**
	 * <p>Campo <code>IDEJECU</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "IDEJECU", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 15, longitudMaxima = 15)
	private String idejecu;
	
	/**
	 * <p>Campo <code>NOMEJEC</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "NOMEJEC", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 40, longitudMaxima = 40)
	private String nomejec;
	
	/**
	 * <p>Campo <code>TELEJEC</code>, &iacute;ndice: <code>3</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 3, nombre = "TELEJEC", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 10, longitudMaxima = 10)
	private String telejec;
	
	/**
	 * <p>Campo <code>OFIEJEC</code>, &iacute;ndice: <code>4</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 4, nombre = "OFIEJEC", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 4, longitudMaxima = 4)
	private String ofiejec;
	
	/**
	 * <p>Campo <code>EMAILEJ</code>, &iacute;ndice: <code>5</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 5, nombre = "EMAILEJ", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 50, longitudMaxima = 50)
	private String emailej;
	
}