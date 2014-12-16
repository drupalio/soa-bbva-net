
package com.bbva.czic.dto.net;

import com.bbva.czic.core.test.AbstractBbvaDTOTest;

public class CurrencyTest extends AbstractBbvaDTOTest<Currency>
{

	@Override
	protected Currency getInstance() {
		return new Currency();
	}

}
