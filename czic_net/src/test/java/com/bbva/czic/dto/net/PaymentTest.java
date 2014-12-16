
package com.bbva.czic.dto.net;

import com.bbva.czic.core.test.AbstractBbvaDTOTest;

public class PaymentTest extends AbstractBbvaDTOTest<Payment>
{

	@Override
	protected Payment getInstance() {
		return new Payment();
	}

}
