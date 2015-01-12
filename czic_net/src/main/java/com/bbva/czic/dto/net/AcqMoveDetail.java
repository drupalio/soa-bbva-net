package com.bbva.czic.dto.net;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.bbva.jee.arq.spring.core.servicing.utils.MoneyAdapter;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;
import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "AcqMoveDetail", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "AcqMoveDetail", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class AcqMoveDetail extends Movement implements Serializable {

	public final static long serialVersionUID = 1L;
	@ApiModelProperty(value = "Campo alfanum\u00e9rico que permite identificar la red utilizada para la operaci\u00f3n", required = true)
	private EnumNetType net;
	@ApiModelProperty(value = "Campo num\u00e9rico que informa el c\u00f3digo que describe la operaci\u00f3n", required = true)
	private String code;
	@ApiModelProperty(value = "Campo que informa la ciudad en donde se realiza la operaci\u00f3n", required = true)
	private City city;
	@ApiModelProperty(value = "Campo alfab\u00e9tico el cual identifica el estado de la operaci\u00f3n", required = true)
	private EnumAcqSituation situation;
	@ApiModelProperty("Campo num\u00e9rico que informa la cantidad de documentos utilizados en la operaci\u00f3n")
	private Integer docsCount;
	@XmlJavaTypeAdapter(MoneyAdapter.class)
	@XmlElement(type = Money.class)
	@ApiModelProperty("Campo num\u00e9rico que indica el monto del Impuesto de Valor Agregado con respecto a la operaci\u00f3n")
	private Money iva;
	@XmlJavaTypeAdapter(MoneyAdapter.class)
	@XmlElement(type = Money.class)
	@ApiModelProperty("Campo num\u00e9rico que indica el monto del Impuesto al consumo con respecto a la operaci\u00f3n")
	private Money iconsumo;
	@XmlJavaTypeAdapter(MoneyAdapter.class)
	@XmlElement(type = Money.class)
	@ApiModelProperty("Campo num\u00e9rico que indica el monto del valor de la propina con respecto a la operaci\u00f3n")
	private Money tips;
	@XmlJavaTypeAdapter(MoneyAdapter.class)
	@XmlElement(type = Money.class)
	@ApiModelProperty("Campo num\u00e9rico que informa el valor de la comisi\u00f3n aplicada a la operaci\u00f3n")
	private Money comision;
	@XmlJavaTypeAdapter(MoneyAdapter.class)
	@XmlElement(type = Money.class)
	@ApiModelProperty("Campo num\u00e9rico que informa el descuento aplicado por concepto de reteiva")
	private Money reteiva;
	@XmlJavaTypeAdapter(MoneyAdapter.class)
	@XmlElement(type = Money.class)
	@ApiModelProperty("Campo num\u00e9rico que informa el descuento aplicado por concepto de retefuente")
	private Money retefuente;
	@XmlJavaTypeAdapter(MoneyAdapter.class)
	@XmlElement(type = Money.class)
	@ApiModelProperty("Campo num\u00e9rico que informa la aplicaci\u00f3n de un cargo en espec\u00edfico")
	private Money charge;
	@ApiModelProperty(value = "Informacion relacionada a la consignacion", required = true)
	private Consignment consignment;

	public AcqMoveDetail() {
		// default constructor
	}

	public EnumNetType getNet() {
		return net;
	}

	public void setNet(EnumNetType net) {
		this.net = net;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public EnumAcqSituation getSituation() {
		return situation;
	}

	public void setSituation(EnumAcqSituation situation) {
		this.situation = situation;
	}

	public Integer getDocsCount() {
		return docsCount;
	}

	public void setDocsCount(Integer docsCount) {
		this.docsCount = docsCount;
	}

	public Money getIva() {
		return iva;
	}

	public void setIva(Money iva) {
		this.iva = iva;
	}

	public Money getIconsumo() {
		return iconsumo;
	}

	public void setIconsumo(Money iconsumo) {
		this.iconsumo = iconsumo;
	}

	public Money getTips() {
		return tips;
	}

	public void setTips(Money tips) {
		this.tips = tips;
	}

	public Money getComision() {
		return comision;
	}

	public void setComision(Money comision) {
		this.comision = comision;
	}

	public Money getReteiva() {
		return reteiva;
	}

	public void setReteiva(Money reteiva) {
		this.reteiva = reteiva;
	}

	public Money getRetefuente() {
		return retefuente;
	}

	public void setRetefuente(Money retefuente) {
		this.retefuente = retefuente;
	}

	public Money getCharge() {
		return charge;
	}

	public void setCharge(Money charge) {
		this.charge = charge;
	}

	public Consignment getConsignment() {
		return consignment;
	}

	public void setConsignment(Consignment consignment) {
		this.consignment = consignment;
	}

}
