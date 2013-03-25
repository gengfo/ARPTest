package com.oocl.ir4.arp.openservice.invadj;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.oocl.ir4.arp.bean.invoice.AmountBean;
import com.oocl.ir4.arp.domain.support.MyDaoTestCase;
import com.oocl.ir4.arp.entity.invoice.Invoice;
import com.oocl.ir4.arp.service.invadj.InvoiceAdjustmentService;
import com.oocl.ir4.arp.service.invadj.data.CalculateBizAmtTestOm;

@ContextConfiguration(locations = { "classpath:domain-context-test.xml",
		"classpath:spring/root-context.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class CalculateBizAmtTest extends MyDaoTestCase {

	@Test
	public void testCalculateBizAmtTscCurSameAsInvCur() {

		InvoiceAdjustmentService invAdjService = (InvoiceAdjustmentService) applicationContext
				.getBean("invAdjService");

		Invoice invoice = CalculateBizAmtTestOm.createInovice();
		String tscCur = "USD";
		BigDecimal tscAmt = new BigDecimal("100.00");

		AmountBean bizAmtBean = invAdjService.calculateBizAmt(invoice, tscCur,
				tscAmt);
		assertEquals(bizAmtBean.getAmtInInvCur().getAmount(), new BigDecimal("100.00"));

		assertNotNull(invAdjService);

	}

	@Test
	public void testCalculateBizAmtTscCurNotSameAsInvCur() {

		InvoiceAdjustmentService invAdjService = (InvoiceAdjustmentService) applicationContext
				.getBean("invAdjService");

		Invoice invoice = CalculateBizAmtTestOm.createInovice();
		String tscCur = "CNY";
		BigDecimal tscAmt = new BigDecimal("100.00");

		invAdjService.calculateBizAmt(invoice, tscCur, tscAmt);

		assertNotNull(invAdjService);

	}

}
