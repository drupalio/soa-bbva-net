
package com.bbva.czic.dto.net;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


import com.wordnik.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "Currency", namespace = "urn:com:bbva:czic:dto:net")
@XmlType(name = "Currency", namespace = "urn:com:bbva:czic:dto:net")
@XmlAccessorType(XmlAccessType.FIELD)
public class Currency
    implements Serializable
{

    public final static long serialVersionUID = 1L;
    @ApiModelProperty(value = "C\u00f3digo ISO alfab\u00e9tico de la divisa", required = true)
    private String id;
    @ApiModelProperty("C\u00f3digo ISO num\u00e9rico de la divisa")
    private String code;
    @ApiModelProperty("Nombre de la divisa")
    private String name;

    public Currency() {
        //default constructor
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
