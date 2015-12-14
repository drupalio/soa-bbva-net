package com.bbva.czic.currency.facade.v01.mapper.impl;

import com.bbva.czic.currency.business.ISrvIntCurrency;
import com.bbva.czic.currency.business.dto.DTOIntCurrency;
import com.bbva.czic.currency.facade.v01.mapper.IMapper;
import com.bbva.czic.dto.net.Currency;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;
import com.bbva.jee.arq.spring.core.servicing.test.MockInvocationContextTestExecutionListener;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import java.util.ArrayList;
import java.util.List;


public class MapperTest {

	IMapper iMapper;

	@Before
	public void init() {
		iMapper = new Mapper();
	}

	@Test
	public void MapOutListCurrency() {

		List<DTOIntCurrency> dtoIntCurrencyList=new ArrayList<DTOIntCurrency>();
		List<Currency> currencyListExpected=new ArrayList<Currency>();
		String currencyString="COP";
		for(int i=0;i<10;i++){
			DTOIntCurrency dtoIntCurrency=new DTOIntCurrency();
			dtoIntCurrency.setId(String.valueOf(i));
			dtoIntCurrency.setName(currencyString + i);
			Currency currency=new Currency();
			currency.setId(String.valueOf(i));
			currency.setName(currencyString + i);
			dtoIntCurrencyList.add(dtoIntCurrency);
			currencyListExpected.add(currency);
		}

		List<Currency> currencyList=iMapper.MapOutListCurrency(dtoIntCurrencyList);

		Assert.assertNotNull(currencyList);

		for(int i=0;i<currencyList.size();i++){
			Assert.assertEquals(currencyListExpected.get(i).getId(),currencyList.get(i).getId());
			Assert.assertEquals(currencyListExpected.get(i).getName(),currencyList.get(i).getName());
		}
	}

	
	
}

