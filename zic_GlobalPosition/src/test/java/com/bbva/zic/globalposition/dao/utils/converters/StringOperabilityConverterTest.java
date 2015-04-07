package com.bbva.zic.globalposition.dao.utils.converters;

import com.bbva.zic.routine.mapper.metadata.Type;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Matchers.anyString;

/**
 * @author Entelgy Colombia.
 */
public class StringOperabilityConverterTest  {


	@Mock
	private StringOperabilityConverter stringOperabilityConverter;

	@Before
	public void init(){
		stringOperabilityConverter = new StringOperabilityConverter();
	}

	@Test
	public void callconvertFromTest(){
		Type<String> a = null;
		stringOperabilityConverter.convertFrom(true, a);
	}

	@Test
	public void callconvertToTest(){
		Type<Boolean> a = null;
		stringOperabilityConverter.convertTo(anyString(), a);
	}

}
