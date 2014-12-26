package com.bbva.czic.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

import com.bbva.czic.core.stereotype.AbstractConfigurableMapper;
import com.bbva.czic.core.stereotype.Mapper;
import com.bbva.czic.loan.business.dto.DTOIntLoan;
import com.bbva.czic.loan.dao.model.ozni.FormatoOZNCENI0;

@Mapper(value = "loanMapper")
public class LoanMapper extends AbstractConfigurableMapper {

	@Override
	protected void configure(MapperFactory factory) {

		factory.classMap(DTOIntLoan.class, FormatoOZNCENI0.class).field("NOTARJE", "id").

		byDefault().register();

	}

	public Object getMapper(Class<?> dtoEnt, Class<?> dtoSal) {

		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

		dtoSal = mapperFactory.getMapperFacade().map(dtoEnt, dtoSal.getClass());
		return dtoSal;
	}

	public static void main(String... args) {

		/*
		 * DTOIntProduct dto = new DTOIntProduct(); FormatoOZECN1E0 format = new FormatoOZECN1E0(); dto.setId("1234");
		 * format.setNumclie("12345678765"); FormatoOZECN1E0 result = new LoanMapper().map(dto, FormatoOZECN1E0.class);
		 * DTOIntProduct result2 = new LoanMapper().map(format, DTOIntProduct.class); System.out.println(result2.getId());
		 */
	}
}
