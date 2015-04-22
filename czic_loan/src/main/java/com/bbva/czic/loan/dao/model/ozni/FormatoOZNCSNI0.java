package com.bbva.czic.loan.dao.model.ozni;

import java.util.Date;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import com.bbva.jee.arq.spring.core.host.Formato;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;


/**
 * Formato de datos <code>OZNCSNI0</code> de la transacci&oacute;n <code>OZNI</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZNCSNI0")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZNCSNI0 {
	
	/**
	 * <p>Campo <code>NUMEOPE</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "NUMEOPE", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 6, longitudMaxima = 6)
	private String numeope;
	
	/**
	 * <p>Campo <code>NUMEEXT</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "NUMEEXT", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 4, longitudMaxima = 4)
	private String numeext;
	
	/**
	 * <p>Campo <code>FECHAOP</code>, &iacute;ndice: <code>3</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 3, nombre = "FECHAOP", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fechaop;
	
	/**
	 * <p>Campo <code>RESTO</code>, &iacute;ndice: <code>4</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 4, nombre = "RESTO", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 25, longitudMaxima = 25)
	private String resto;
	
	/**
	 * <p>Campo <code>VALOROP</code>, &iacute;ndice: <code>5</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 5, nombre = "VALOROP", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 12, longitudMaxima = 12)
	private String valorop;
	
	/**
	 * <p>Campo <code>BALANCE</code>, &iacute;ndice: <code>6</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 6, nombre = "BALANCE", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 12, longitudMaxima = 12)
	private String balance;
	
	/**
	 * <p>Campo <code>TIPOPE</code>, &iacute;ndice: <code>7</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 7, nombre = "TIPOPE", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 2, longitudMaxima = 2)
	private String tipope;
	
}