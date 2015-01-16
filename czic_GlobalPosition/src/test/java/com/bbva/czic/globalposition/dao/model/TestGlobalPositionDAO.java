package com.bbva.czic.globalposition.dao.model;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.bbva.czic.dto.net.EnumProductType;
import com.bbva.czic.globalposition.business.dto.DTOIntBalance;
import com.bbva.czic.globalposition.business.dto.DTOIntProduct;
import com.bbva.czic.globalposition.business.dto.DTOIntProducts;
import com.bbva.jee.arq.spring.core.servicing.test.BusinessServiceTestContextLoader;
import com.bbva.jee.arq.spring.core.servicing.utils.Money;

/**
 * Created by Administrador on 26/12/2014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = BusinessServiceTestContextLoader.class, locations = {
		"classpath*:/META-INF/spring/applicationContext-*.xml", "classpath:/META-INF/spring/business-service.xml",
		"classpath:/META-INF/spring/business-service-test.xml" })
@TestExecutionListeners(listeners = {
// MockInvocationContextTestExecutionListener.class,
DependencyInjectionTestExecutionListener.class })
public class TestGlobalPositionDAO {

	@Test
	public void testMapInternalDTOtoHost() {

	}

	/******************************** GENERATE JSON MOCK FILES **********************************/

	public static void main(final String[] args) {

		final DTOIntProducts products = new DTOIntProducts();
		final List<DTOIntProduct> productList = new ArrayList<DTOIntProduct>();

		DTOIntProduct product = new DTOIntProduct();
		product.setAlias("Cuenta 1");
		DTOIntBalance balance = new DTOIntBalance();
		balance.setAvailableBalance(new Money(Currency.getInstance(Locale.US), new BigDecimal("1120.00")));
		balance.setTotal(new Money(Currency.getInstance(Locale.US), new BigDecimal("1320.00")));
		balance.setTradeBalance(new Money(Currency.getInstance(Locale.US), new BigDecimal("120.00")));
		product.setBalance(balance);
		product.setId("1233-1232-4564-4565");
		product.setName("Cuenta Personal 1");
		product.setOperable(true);
		product.setVisible(true);
		product.setProductType(EnumProductType.PC);
		productList.add(product);

		product = new DTOIntProduct();
		product.setAlias("Cuenta 1");
		balance = new DTOIntBalance();
		balance.setAvailableBalance(new Money(Currency.getInstance(Locale.US), new BigDecimal("120.00")));
		balance.setTotal(new Money(Currency.getInstance(Locale.US), new BigDecimal("320.00")));
		balance.setTradeBalance(new Money(Currency.getInstance(Locale.US), new BigDecimal("120.00")));
		product.setBalance(balance);
		product.setId("2982-1222-4569-4567");
		product.setName("Cuenta Personal 1");
		product.setOperable(true);
		product.setVisible(true);
		product.setProductType(EnumProductType.PC);
		productList.add(product);

		product = new DTOIntProduct();
		product.setAlias("Tarjeta 1");
		balance = new DTOIntBalance();
		balance.setAvailableBalance(new Money(Currency.getInstance(Locale.US), new BigDecimal("120.00")));
		balance.setTotal(new Money(Currency.getInstance(Locale.US), new BigDecimal("320.00")));
		balance.setTradeBalance(new Money(Currency.getInstance(Locale.US), new BigDecimal("120.00")));
		product.setBalance(balance);
		product.setId("2982-1222-4569-4567");
		product.setName("Tarjeta Personal 1");
		product.setOperable(true);
		product.setVisible(true);
		product.setProductType(EnumProductType.TC);
		productList.add(product);

		product = new DTOIntProduct();
		product.setAlias("Tarjeta 2");
		balance = new DTOIntBalance();
		balance.setAvailableBalance(new Money(Currency.getInstance(Locale.US), new BigDecimal("120.00")));
		balance.setTotal(new Money(Currency.getInstance(Locale.US), new BigDecimal("320.00")));
		balance.setTradeBalance(new Money(Currency.getInstance(Locale.US), new BigDecimal("120.00")));
		product.setBalance(balance);
		product.setId("2982-1222-4569-4898");
		product.setName("Tarjeta Personal 2");
		product.setOperable(true);
		product.setVisible(true);
		product.setProductType(EnumProductType.TC);
		productList.add(product);

		product = new DTOIntProduct();
		product.setAlias("Fondo 1");
		balance = new DTOIntBalance();
		balance.setAvailableBalance(new Money(Currency.getInstance(Locale.US), new BigDecimal("120.00")));
		balance.setTotal(new Money(Currency.getInstance(Locale.US), new BigDecimal("320.00")));
		balance.setTradeBalance(new Money(Currency.getInstance(Locale.US), new BigDecimal("120.00")));
		product.setBalance(balance);
		product.setId("9877-1222-4569-4898");
		product.setName("Fondo Personal 1");
		product.setOperable(true);
		product.setVisible(true);
		product.setProductType(EnumProductType.LI);
		productList.add(product);

		products.setProducts(productList);

		ObjectMapper mapper = new ObjectMapper();
		try {
			mapper.writeValue(new File("src/main/resources/mock/DTOIntProducts.json"), products);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		DTOIntProducts productsReaded = new DTOIntProducts();
		try {
			productsReaded = new ObjectMapper().readValue(new File("src/main/resources/mock/DTOIntProducts.json"),
					DTOIntProducts.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("FIIIIIIIIIIIIIN");
	}
}
