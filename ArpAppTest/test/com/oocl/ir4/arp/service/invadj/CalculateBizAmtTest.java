package com.oocl.ir4.arp.service.invadj;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.oocl.ir4.arp.bean.invoice.AmountBean;
import com.oocl.ir4.arp.domain.support.MyDaoTestCase;
import com.oocl.ir4.arp.entity.invoice.Invoice;
import com.oocl.ir4.arp.service.invadj.data.CalculateBizAmtTestOm;
import com.oocl.ir4.arp.utils.CalculationUtils;

@ContextConfiguration(locations = { "classpath:domain-context-test.xml",
		"classpath:spring/root-context.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class CalculateBizAmtTest extends MyDaoTestCase {

	// @Test
	public void testCalculateBizAmtTscCurSameAsInvCur() {

		InvoiceAdjustmentService invAdjService = (InvoiceAdjustmentService) applicationContext
				.getBean("invAdjService");

		Invoice invoice = CalculateBizAmtTestOm.createInovice();
		String tscCur = "USD";
		BigDecimal tscAmt = new BigDecimal("100.00");

		AmountBean bizAmtBean = invAdjService.calculateBizAmt(invoice, tscCur,
				tscAmt);
		assertEquals(bizAmtBean.getAmtInInvCur().getAmount(), new BigDecimal(
				"100.00"));

		assertNotNull(invAdjService);

	}

	//@Test
	public void ptestCalculateBizAmtTscCurNotSameAsInvCur() {

		InvoiceAdjustmentService invAdjService = (InvoiceAdjustmentService) applicationContext
				.getBean("invAdjService");

		Invoice invoice = CalculateBizAmtTestOm.createInovice();
		String tscCur = "CNY";
		BigDecimal tscAmt = new BigDecimal("100.00");

		invAdjService.calculateBizAmt(invoice, tscCur, tscAmt);

		assertNotNull(invAdjService);

	}

	// @Test
	public void testCalculateBizAmtWithTscAmtZero() {

		InvoiceAdjustmentService invAdjService = (InvoiceAdjustmentService) applicationContext
				.getBean("invAdjService");

		// invAdjService.calculateBizAmt(invoice, tscCur, tscAmt);

		assertNotNull(invAdjService);

	}

	@Test
	public void tesCalcAmtInProportion() {

		BigDecimal tscAmt = new BigDecimal(50.00);
		BigDecimal ostAmtInTscCur = new BigDecimal(1000.00);
		BigDecimal ostAmtInCur = new BigDecimal(100.00);
		int curDigitInInvCur = 2;

		BigDecimal amt = calcAmtInProportion(tscAmt, ostAmtInTscCur,
				ostAmtInCur, curDigitInInvCur);
		

		assertNotNull(amt);
		assertEquals(amt, new BigDecimal(5.00) );
		

	}

	public BigDecimal calcAmtInProportion(BigDecimal tscAmt,
			BigDecimal ostAmtInTscCur, BigDecimal ostAmtInCur,
			int curDigitInInvCur) {

		BigDecimal rdAmt = CalculationUtils.round(
				tscAmt.divide(ostAmtInTscCur, CalculationUtils.DIVISION_SCALE,
						CalculationUtils.ROUND_MODE).multiply(ostAmtInCur),
				curDigitInInvCur);

		return rdAmt;

	}

}
