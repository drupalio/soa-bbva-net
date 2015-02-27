package com.bbva.czic.loan.dao.model.oznk;

import java.util.Date;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import com.bbva.jee.arq.spring.core.host.Formato;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;


/**
 * Formato de datos <code>OZNCSNK0</code> de la transacci&oacute;n <code>OZNK</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZNCSNK0")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZNCSNK0 {
	
	/**
	 * <p>Campo <code>NUMEMOV</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "NUMEMOV", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 8, longitudMaxima = 8)
	private String numemov;
	
	/**
	 * <p>Campo <code>FECHAOP</code>, &iacute;ndice: <code>2</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 2, nombre = "FECHAOP", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fechaop;
	
	/**
	 * <p>Campo <code>RESTO</code>, &iacute;ndice: <code>3</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 3, nombre = "RESTO", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 2, longitudMaxima = 2)
	private String resto;
	
	/**
	 * <p>Campo <code>IMPORTE</code>, &iacute;ndice: <code>4</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 4, nombre = "IMPORTE", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 12, longitudMaxima = 12)
	private String importe;
	
	/**
	 * <p>Campo <code>BALANCE</code>, &iacute;ndice: <code>5</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 5, nombre = "BALANCE", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 12, longitudMaxima = 12)
	private String balance;
	
	/**
	 * <p>Campo <code>DESCOP</code>, &iacute;ndice: <code>6</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 6, nombre = "DESCOP", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 30, longitudMaxima = 30)
	private String descop;
	
	/**
	 * <p>Campo <code>COUTAF</code>, &iacute;ndice: <code>7</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 7, nombre = "COUTAF", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 4, longitudMaxima = 4)
	private String coutaf;
	
	/**
	 * <p>Campo <code>COUTAT</code>, &iacute;ndice: <code>8</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 8, nombre = "COUTAT", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 4, longitudMaxima = 4)
	private String coutat;
	
	/**
	 * <p>Campo <code>ESTADO</code>, &iacute;ndice: <code>9</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 9, nombre = "ESTADO", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 80, longitudMaxima = 80)
	private String estado;
	
}