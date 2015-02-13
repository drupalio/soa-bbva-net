package com.bbva.czic.globalposition.dao.utils.converters;

import com.bbva.czic.routine.mapper.metadata.Type;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.anyString;

public class StringVisibilityConverterTest {


	@InjectMocks
	private StringVisibilityConverter stringVisibilityConverter;

	@Before
	public void init(){
		stringVisibilityConverter = new StringVisibilityConverter();
	}

	@Test
	public void callConvertToTest(){
		Type<Boolean> a = null;
		stringVisibilityConverter.convertTo(anyString(), a);
	}

	@Test
	public void callconvertFromTest(){
		Type<String> a = null;
		stringVisibilityConverter.convertFrom(anyBoolean(), a);
	}


}
