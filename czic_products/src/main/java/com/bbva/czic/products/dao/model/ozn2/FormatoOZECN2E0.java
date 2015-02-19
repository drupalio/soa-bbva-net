package com.bbva.czic.products.dao.model.ozn2;


import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import com.bbva.czic.products.dao.mapper.TxProductsMapper;
import com.bbva.jee.arq.spring.core.host.Campo;
import com.bbva.jee.arq.spring.core.host.Formato;
import com.bbva.jee.arq.spring.core.host.TipoCampo;

/**
 * Formato de datos <code>OZECN2E0</code> de la transacci&oacute;n <code>OZN2</code>
 * 
 * @author Arquitectura Spring BBVA
 */
@Formato(nombre = "OZECN2E0")
@RooJavaBean
@RooToString
@RooSerializable
public class FormatoOZECN2E0 {

	/**
	 * <p>Campo <code>LONGTRA</code>, &iacute;ndice: <code>1</code>, tipo: <code>ENTERO</code>
	 */
	@Campo(indice = 1, nombre = "LONGTRA", tipo = TipoCampo.ENTERO, longitudMinima = 4, longitudMaxima = 4)
	private Integer longtra;
	
	/**
	 * <p>Campo <code>SUBTRM1</code>, &iacute;ndice: <code>2</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 2, nombre = "SUBTRM1", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 100, longitudMaxima = 100)
	private String subtrm1=TxProductsMapper.FILLER;
	
	/**
	 * <p>Campo <code>SUBTRM2</code>, &iacute;ndice: <code>3</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 3, nombre = "SUBTRM2", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 100, longitudMaxima = 100)
	private String subtrm2=TxProductsMapper.FILLER;  
	
	/**
	 * <p>Campo <code>SUBTRM3</code>, &iacute;ndice: <code>4</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 4, nombre = "SUBTRM3", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 100, longitudMaxima = 100)
	private String subtrm3=TxProductsMapper.FILLER;  
	
	/**
	 * <p>Campo <code>SUBTRM4</code>, &iacute;ndice: <code>5</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 5, nombre = "SUBTRM4", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 100, longitudMaxima = 100)
	private String subtrm4=TxProductsMapper.FILLER;  
	
	/**
	 * <p>Campo <code>SUBTRM5</code>, &iacute;ndice: <code>6</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 6, nombre = "SUBTRM5", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 100, longitudMaxima = 100)
	private String subtrm5=TxProductsMapper.FILLER;  
	
	/**
	 * <p>Campo <code>SUBTRM6</code>, &iacute;ndice: <code>7</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 7, nombre = "SUBTRM6", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 100, longitudMaxima = 100)
	private String subtrm6=TxProductsMapper.FILLER;  
	
	/**
	 * <p>Campo <code>SUBTRM7</code>, &iacute;ndice: <code>8</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 8, nombre = "SUBTRM7", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 100, longitudMaxima = 100)
	private String subtrm7=TxProductsMapper.FILLER;  
	
	/**
	 * <p>Campo <code>SUBTRM8</code>, &iacute;ndice: <code>9</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 9, nombre = "SUBTRM8", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 100, longitudMaxima = 100)
	private String subtrm8=TxProductsMapper.FILLER;  
	
	/**
	 * <p>Campo <code>SUBTRM9</code>, &iacute;ndice: <code>10</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 10, nombre = "SUBTRM9", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 100, longitudMaxima = 100)
	private String subtrm9=TxProductsMapper.FILLER;  
	
	/**
	 * <p>Campo <code>SUBTRM0</code>, &iacute;ndice: <code>11</code>, tipo: <code>ALFANUMERICO</code>
	 */
	@Campo(indice = 11, nombre = "SUBTRM0", tipo = TipoCampo.ALFANUMERICO, longitudMinima = 100, longitudMaxima = 100)
	private String subtrm0=TxProductsMapper.FILLER;  
	
}