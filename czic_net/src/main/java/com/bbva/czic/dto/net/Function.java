
package com.bbva.czic.dto.net;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Function", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "Function", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Function
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty(value = "C\u00f3digo del tipo de funci\u00f3n", required = true)
    private String id;
    @ApiModelProperty(value = "Descripcion de la funcion", required = true)
    private EnumFunctionType type;

    public Function() {
        //default constructor
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public EnumFunctionType getType() {
		return type;
	}

	public void setType(EnumFunctionType type) {
		this.type = type;
	}

    
    
}
