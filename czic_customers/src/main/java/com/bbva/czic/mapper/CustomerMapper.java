package com.bbva.czic.mapper;

import ma.glasnost.orika.MapperFactory;

import com.bbva.czic.core.stereotype.AbstractConfigurableMapper;
import com.bbva.czic.core.stereotype.Mapper;
import com.bbva.czic.customers.business.dto.DTOIntAccMovementsResume;
import com.bbva.czic.customers.business.dto.DTOIntCardCharge;
import com.bbva.czic.customers.business.dto.DTOIntUser;
import com.bbva.czic.customers.dao.model.oznq.FormatoOZECNQE0;
import com.bbva.czic.customers.dao.model.ozno.FormatoOZECNOE0;
import com.bbva.czic.customers.dao.model.ozno.FormatoOZECNOS0;
import com.bbva.czic.customers.dao.model.oznq.FormatoOZECNQS0;
import com.bbva.czic.dto.net.AccMovementsResume;
import com.bbva.czic.dto.net.CardCharge;
import com.bbva.czic.dto.net.User;

@Mapper(value = "customerMapper")
public class CustomerMapper extends AbstractConfigurableMapper {

	@Override
	protected void configure(MapperFactory factory) {
// ***************************datos de entrada listAccountsMovementsResume OZECNQE0***************
		factory.classMap(DTOIntUser.class, FormatoOZECNQE0.class)
		.field("customerId", "idusuar")
		.byDefault().register();
		factory.classMap(User.class, DTOIntUser.class)
		.field("", "customerId")
		.byDefault().register();

		// factory.classMap(aType, bType)
//***************************datos de salida listAccountsMovementsResume OZECNQS0*********
		factory.classMap(DTOIntAccMovementsResume.class, FormatoOZECNQS0.class)
		.field("income", "valdepo")
		.field("outcome", "valcarg")
		.field("balance", "saltota")
		.field("month", "mes")
		.byDefault().register();
	    factory.classMap(AccMovementsResume.class, DTOIntAccMovementsResume.class)
		.field("", "income")
		.field("", "outcome")
		.field("", "balance")
		.field("", "month")
		.byDefault().register();
	    
	 // ***************************datos de entrada listCardCharges***************
	 		factory.classMap(DTOIntUser.class, FormatoOZECNOE0.class)
	 		.field("customerId", "numprod")
	 		.byDefault().register();
	 		factory.classMap(User.class, DTOIntUser.class)
	 		.field("", "customerId")
	 		.byDefault().register();

	 		// factory.classMap(aType, bType)
	 //***************************datos de salida listCardCharges*********
	 		factory.classMap(DTOIntAccMovementsResume.class, FormatoOZECNOS0.class)
	 		.field("category", "categor")
	 		.field("amount", "valcate")
	 		.byDefault().register();
	 	    factory.classMap(CardCharge.class, DTOIntCardCharge.class)
	 		.field("", "category")
	 		.field("", "amount")
	 		.byDefault().register();
	 	    
	    
	    
	}
	
	
	

	/*public static void main(String... args) {
		DTOIntProduct dto = new DTOIntProduct();
		FormatoOZECN1E0 format = new FormatoOZECN1E0();
		dto.setId("1234");
		format.setNumclie("12345678765");

		FormatoOZECN1E0 result = new CustomerMapper().map(dto, FormatoOZECN1E0.class);

		DTOIntProduct result2 = new CustomerMapper().map(format, DTOIntProduct.class);

		System.out.println(result2.getId());

	}*/
	
}
