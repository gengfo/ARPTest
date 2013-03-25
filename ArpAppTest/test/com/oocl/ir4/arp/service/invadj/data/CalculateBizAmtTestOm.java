package com.oocl.ir4.arp.service.invadj.data;

import java.math.BigDecimal;

import com.oocl.ir4.arp.entity.common.Money;
import com.oocl.ir4.arp.entity.invoice.Invoice;
import com.oocl.ir4.cmn.model.Currency;
import com.oocl.ir4.cus.model.Customer;

public class CalculateBizAmtTestOm {

	public static Invoice createInovice() {

		Invoice invoice = new Invoice();

		invoice.setOstAmt(new BigDecimal(100.00));
		invoice.setOstLocalAmt(new BigDecimal(100.00));
		invoice.setOstUsdAmt(new BigDecimal(100.00));

		Currency invCur = new Currency();
		invCur.setCode("USD");
		invCur.setDigitsPastDecimal(2);
		Money amtInInvCur = new Money(invCur, new BigDecimal(100.00));
		invoice.setTotalAmt(amtInInvCur);

		Currency locCur = new Currency();
		locCur.setCode("USD");
		locCur.setDigitsPastDecimal(2);
		Money amtInLocCur = new Money(locCur, new BigDecimal(100.00));
		invoice.setLocalAmt(amtInLocCur);

		invoice.setUsdAmt(new BigDecimal(100.00));
		
		Customer customer = new Customer();
		invoice.setCustomer(customer);
		customer.setCustomerInternalIdentifier(1L);

		return invoice;

	}

}
