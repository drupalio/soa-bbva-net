package com.bbva.czic.accounts.dao.model.oznx;

import com.bbva.czic.routine.commons.rm.utils.tx.IFormatNotApply;
import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import java.math.BigDecimal;
import java.util.Date;


/**
 * Formato de datos <code>OZECNXS0</code> de la transacci&oacute;n <code>OZNX</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZECNXS0")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZECNXS0 implements IFormatNotApply {
	
	/**
	 * <p>Campo <code>INDPAGI</code>, &iacute;ndice: <code>1</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 1, nombre = "INDPAGI", tipo = TipoCampo.ENTERO, longitudMinima = 3, longitudMaxima = 3, signo = true)
	private Integer indpagi;
	
	/**
	 * <p>Campo <code>NUMPROD</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "NUMPROD", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 20, longitudMaxima = 20)
	private String numprod;
	
	/**
	 * <p>Campo <code>NUMCHEQ</code>, &iacute;ndice: <code>3</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 3, nombre = "NUMCHEQ", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 9, longitudMaxima = 9)
	private String numcheq;
	
	/**
	 * <p>Campo <code>FECHEMI</code>, &iacute;ndice: <code>4</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 4, nombre = "FECHEMI", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fechemi;
	
	/**
	 * <p>Campo <code>VALCHEQ</code>, &iacute;ndice: <code>5</code>, tipo: <code>DECIMAL</code>
	 */
	@Campo(indice = 5, nombre = "VALCHEQ", tipo = TipoCampo.DECIMAL, longitudMinima = 17, longitudMaxima = 17, signo = true, decimales = 2)
	private BigDecimal valcheq;
	
	/**
	 * <p>Campo <code>ESTCHEQ</code>, &iacute;ndice: <code>6</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 6, nombre = "ESTCHEQ", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String estcheq;
	
	/**
	 * <p>Campo <code>FECHMOD</code>, &iacute;ndice: <code>7</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 7, nombre = "FECHMOD", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fechmod;
	
}