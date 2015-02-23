package com.bbva.czic.accounts.dao.model.ozny;

import java.util.Date;

import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.TipoCampo;
import com.bbva.jee.arq.spring.core.host.Formato;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;


/**
 * Formato de datos <code>OZECNYS0</code> de la transacci&oacute;n <code>OZNY</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZECNYS0")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZECNYS0 {
	
	/**
	 * <p>Campo <code>NUMCHEQ</code>, &iacute;ndice: <code>1</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 1, nombre = "NUMCHEQ", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 9, longitudMaxima = 9)
	private String numcheq;
	
	/**
	 * <p>Campo <code>FECHEMI</code>, &iacute;ndice: <code>2</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 2, nombre = "FECHEMI", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fechemi;
	
	/**
	 * <p>Campo <code>VALCHEQ</code>, &iacute;ndice: <code>3</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 3, nombre = "VALCHEQ", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 18, longitudMaxima = 18)
	private String valcheq;
	
	/**
	 * <p>Campo <code>ESTCHEQ</code>, &iacute;ndice: <code>4</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 4, nombre = "ESTCHEQ", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 1, longitudMaxima = 1)
	private String estcheq;
	
	/**
	 * <p>Campo <code>FECMODI</code>, &iacute;ndice: <code>5</code>, tipo: <code>FECHA</code>
	 */
	@Campo(indice = 5, nombre = "FECMODI", tipo = TipoCampo.FECHA, longitudMinima = 10, longitudMaxima = 10, formato = "yyyy-MM-dd")
	private Date fecmodi;
	
}