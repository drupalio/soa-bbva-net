
package com.bbva.czic.dto.net;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



import com.bbva.czic.core.test.AbstractBbvaDTOTest;
import com.wordnik.swagger.annotations.ApiModelProperty;

public class OfficeTest extends AbstractBbvaDTOTest<Office>
{

	@Override
	protected Office getInstance() {
		return new Office();
	}

}
