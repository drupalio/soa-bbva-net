package com.bbva.czic.dto.net;

import org.junit.Test;

import com.bbva.czic.core.test.TestUtils;

public class EnumTests {

	@Test
	public void checkEnums() {
		TestUtils.enumCodeCoverage(EnumAccountType.class);
		TestUtils.enumCodeCoverage(EnumAcqSituation.class);
		TestUtils.enumCodeCoverage(EnumCheckStatus.class);
		TestUtils.enumCodeCoverage(EnumConsignmentType.class);
		TestUtils.enumCodeCoverage(EnumContactSourceType.class);
		TestUtils.enumCodeCoverage(EnumDocumentType.class);
		TestUtils.enumCodeCoverage(EnumFinancialStatusType.class);
		TestUtils.enumCodeCoverage(EnumLoanStatus.class);
		TestUtils.enumCodeCoverage(EnumMessageType.class);
		TestUtils.enumCodeCoverage(EnumMonth.class);
		TestUtils.enumCodeCoverage(EnumNetType.class);
		TestUtils.enumCodeCoverage(EnumPhoneNumberType.class);
		TestUtils.enumCodeCoverage(EnumProductType.class);
		TestUtils.enumCodeCoverage(EnumProductType.class);
		TestUtils.enumCodeCoverage(EnumRotaryMoveStatus.class);
	}

}
