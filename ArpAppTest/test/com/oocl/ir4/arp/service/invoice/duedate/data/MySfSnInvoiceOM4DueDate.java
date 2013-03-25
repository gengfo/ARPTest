package com.oocl.ir4.arp.service.invoice.duedate.data;

import java.util.Date;

import com.oocl.frm.common.date.FWAbsoluteDateTime;
import com.oocl.frm.model.date.PFWAbsoluteDateTime;
import com.oocl.frm.model.date.PFWIODTUtil;
import com.oocl.frm.model.date.PFWRelativeDateTime;
import com.oocl.ir4.arp.entity.doc.BLInfo;
import com.oocl.ir4.arp.entity.invoice.Invoice;
import com.oocl.ir4.arp.service.invoice.impl.due.DueDateCalculationConstants;
import com.oocl.ir4.arp.suppdata.util.CustomerConstants;
import com.oocl.ir4.arp.utils.DateUtils;
import com.oocl.ir4.cus.model.Credit;
import com.oocl.ir4.cus.model.CreditTerm;
import com.oocl.ir4.cus.model.Customer;
import com.oocl.ir4.cus.model.FixedCreditTermSpecification;
import com.oocl.ir4.cus.model.SegmentSpecification;

public class MySfSnInvoiceOM4DueDate {

    public final static String BOUND_IB = "IB";

    public final static String TRADE_NAT = "NAT";

    public static Invoice createSfInvoiceWithNoFixedPaymentDate() {

        Invoice invoice = new Invoice();
        invoice.setFinancialType("SF");
        invoice.setBound(BOUND_IB);
        invoice.setTrade(TRADE_NAT);

        String pfwRdtStr = "";
        pfwRdtStr = "20121022044932.925";
        invoice.setInvoiceDate(new PFWRelativeDateTime(pfwRdtStr));

        BLInfo blInfo1 = new BLInfo();
        String pfwRdtStr4Eta1 = "20121021044932.925";
        blInfo1.setArrivalDate(new PFWRelativeDateTime(pfwRdtStr4Eta1));
        invoice.getBls().add(blInfo1);
        BLInfo blInfo2 = new BLInfo();
        String pfwRdtStr4Eta2 = "20121023044932.925";
        blInfo2.setArrivalDate(new PFWRelativeDateTime(pfwRdtStr4Eta2));
        invoice.getBls().add(blInfo2);

        Customer customer = new Customer();
        invoice.setCustomer(customer);
        customer.setAccountingIdentifier(001L);
        customer.setInheritCreditTermAssignmentsIndicator(false);
        customer.setStatus(CustomerConstants.CUSTOMER_STATUS_ACTIVE);

        Credit credit = new Credit();
        customer.setCredit(credit);
        credit.setStatus(CustomerConstants.CREDIT_STATUS_Y);
        credit.setFixedDatePaymentIndicator(false);

        CreditTerm creditTerm = new CreditTerm();
        credit.getCreditTerms().add(creditTerm);
        creditTerm.setCreditTermStatus(CustomerConstants.CREDIT_TERM_STATUS_ACTIVE);
        creditTerm.setNumberOfDays(7);

        SegmentSpecification segmentSepcification = new SegmentSpecification();
        creditTerm.setCreditTermSpecification(segmentSepcification);
        segmentSepcification.setBound(BOUND_IB);
        segmentSepcification.setTrade(TRADE_NAT);

        return invoice;

    }

    public static Invoice createSfInvoiceWithMonthlyFixedPaymentDate() {

        Invoice invoice = new Invoice();
        invoice.setFinancialType("SF");
        invoice.setBound(BOUND_IB);
        invoice.setTrade(TRADE_NAT);

        String pfwRdtStr = "";
        pfwRdtStr = "20121022044932.925";
        invoice.setInvoiceDate(new PFWRelativeDateTime(pfwRdtStr));

        BLInfo blInfo1 = new BLInfo();
        String pfwRdtStr4Eta1 = "20121021044932.925";
        blInfo1.setArrivalDate(new PFWRelativeDateTime(pfwRdtStr4Eta1));
        invoice.getBls().add(blInfo1);
        BLInfo blInfo2 = new BLInfo();
        String pfwRdtStr4Eta2 = "20121023044932.925";
        blInfo2.setArrivalDate(new PFWRelativeDateTime(pfwRdtStr4Eta2));
        invoice.getBls().add(blInfo2);

        Customer customer = new Customer();
        invoice.setCustomer(customer);
        customer.setAccountingIdentifier(001L);
        customer.setInheritCreditTermAssignmentsIndicator(false);
        customer.setStatus(CustomerConstants.CUSTOMER_STATUS_ACTIVE);

        Credit credit = new Credit();
        customer.setCredit(credit);
        credit.setStatus(CustomerConstants.CREDIT_STATUS_Y);
        credit.setFixedDatePaymentIndicator(true);

        CreditTerm creditTerm = new CreditTerm();
        credit.getCreditTerms().add(creditTerm);
        creditTerm.setCreditTermStatus(CustomerConstants.CREDIT_TERM_STATUS_ACTIVE);
        creditTerm.setNumberOfDays(7);
        creditTerm.setPaymentRecurrenceType(DueDateCalculationConstants.PAYMENT_RECURRENCE_TYPE_MONTHLY);

        SegmentSpecification segmentSepcification = new SegmentSpecification();
        creditTerm.setCreditTermSpecification(segmentSepcification);
        segmentSepcification.setBound(BOUND_IB);
        segmentSepcification.setTrade(TRADE_NAT);

        FixedCreditTermSpecification fixedCreditTermSpecification = new FixedCreditTermSpecification();
        fixedCreditTermSpecification.setDueCurrentMonth(true);
        fixedCreditTermSpecification.setDueCurrentWeek(false);
        fixedCreditTermSpecification.setDueOrdinalWeek(0);
        fixedCreditTermSpecification.setCutoffBefore(true);
        fixedCreditTermSpecification.setDueAfter(false);
        fixedCreditTermSpecification.setCutOffDate(15);
        fixedCreditTermSpecification.setDueDate(30);
        creditTerm.getFixedCreditTermSpecifications().add(fixedCreditTermSpecification);

        return invoice;

    }

    public static Invoice createSfInvoiceWithBiMonthlyFixedPaymentDate() {

        Invoice invoice = new Invoice();
        invoice.setFinancialType("SF");
        invoice.setBound(BOUND_IB);
        invoice.setTrade(TRADE_NAT);

        String pfwRdtStr = "";
        pfwRdtStr = "20121022044932.925";
        invoice.setInvoiceDate(new PFWRelativeDateTime(pfwRdtStr));

        BLInfo blInfo1 = new BLInfo();
        String pfwRdtStr4Eta1 = "20121021044932.925";
        blInfo1.setArrivalDate(new PFWRelativeDateTime(pfwRdtStr4Eta1));
        invoice.getBls().add(blInfo1);
        BLInfo blInfo2 = new BLInfo();
        String pfwRdtStr4Eta2 = "20121023044932.925";
        blInfo2.setArrivalDate(new PFWRelativeDateTime(pfwRdtStr4Eta2));
        invoice.getBls().add(blInfo2);

        Customer customer = new Customer();
        invoice.setCustomer(customer);
        customer.setAccountingIdentifier(001L);
        customer.setInheritCreditTermAssignmentsIndicator(false);
        customer.setStatus(CustomerConstants.CUSTOMER_STATUS_ACTIVE);

        Credit credit = new Credit();
        customer.setCredit(credit);
        credit.setStatus(CustomerConstants.CREDIT_STATUS_Y);
        credit.setFixedDatePaymentIndicator(true);

        CreditTerm creditTerm = new CreditTerm();
        credit.getCreditTerms().add(creditTerm);
        creditTerm.setCreditTermStatus(CustomerConstants.CREDIT_TERM_STATUS_ACTIVE);
        creditTerm.setNumberOfDays(7);
        creditTerm.setPaymentRecurrenceType(DueDateCalculationConstants.PAYMENT_RECURRENCE_TYPE_BI_MONTHLY);

        SegmentSpecification segmentSepcification = new SegmentSpecification();
        creditTerm.setCreditTermSpecification(segmentSepcification);
        segmentSepcification.setBound(BOUND_IB);
        segmentSepcification.setTrade(TRADE_NAT);

        FixedCreditTermSpecification cts1 = new FixedCreditTermSpecification();
        cts1.setDueCurrentMonth(true);
        cts1.setDueCurrentWeek(false);
        cts1.setDueOrdinalWeek(0);
        cts1.setCutoffBefore(true);
        cts1.setDueAfter(false);
        cts1.setCutOffDate(10);
        cts1.setDueDate(20);
        creditTerm.getFixedCreditTermSpecifications().add(cts1);
        FixedCreditTermSpecification cts2 = new FixedCreditTermSpecification();
        cts2.setDueCurrentMonth(true);
        cts2.setDueCurrentWeek(false);
        cts2.setDueOrdinalWeek(0);
        cts2.setCutoffBefore(true);
        cts2.setDueAfter(false);
        cts2.setCutOffDate(20);
        cts2.setDueDate(30);
        creditTerm.getFixedCreditTermSpecifications().add(cts2);

        return invoice;

    }

    public static Invoice createSfInvoiceWithTriMonthlyFixedPaymentDate() {

        Invoice invoice = new Invoice();
        invoice.setFinancialType("SF");
        invoice.setBound(BOUND_IB);
        invoice.setTrade(TRADE_NAT);

        String pfwRdtStr = "";
        pfwRdtStr = "20121022044932.925";
        invoice.setInvoiceDate(new PFWRelativeDateTime(pfwRdtStr));

        BLInfo blInfo1 = new BLInfo();
        String pfwRdtStr4Eta1 = "20121021044932.925";
        blInfo1.setArrivalDate(new PFWRelativeDateTime(pfwRdtStr4Eta1));
        invoice.getBls().add(blInfo1);
        BLInfo blInfo2 = new BLInfo();
        String pfwRdtStr4Eta2 = "20121023044932.925";
        blInfo2.setArrivalDate(new PFWRelativeDateTime(pfwRdtStr4Eta2));
        invoice.getBls().add(blInfo2);

        Customer customer = new Customer();
        invoice.setCustomer(customer);
        customer.setAccountingIdentifier(001L);
        customer.setInheritCreditTermAssignmentsIndicator(false);
        customer.setStatus(CustomerConstants.CUSTOMER_STATUS_ACTIVE);

        Credit credit = new Credit();
        customer.setCredit(credit);
        credit.setStatus(CustomerConstants.CREDIT_STATUS_Y);
        credit.setFixedDatePaymentIndicator(true);

        CreditTerm creditTerm = new CreditTerm();
        credit.getCreditTerms().add(creditTerm);
        creditTerm.setCreditTermStatus(CustomerConstants.CREDIT_TERM_STATUS_ACTIVE);
        creditTerm.setNumberOfDays(7);
        creditTerm.setPaymentRecurrenceType(DueDateCalculationConstants.PAYMENT_RECURRENCE_TYPE_TRI_MONTHLY);

        SegmentSpecification segmentSepcification = new SegmentSpecification();
        creditTerm.setCreditTermSpecification(segmentSepcification);
        segmentSepcification.setBound(BOUND_IB);
        segmentSepcification.setTrade(TRADE_NAT);

        FixedCreditTermSpecification cts1 = new FixedCreditTermSpecification();
        cts1.setDueCurrentMonth(true);
        cts1.setDueCurrentWeek(false);
        cts1.setDueOrdinalWeek(0);
        cts1.setCutoffBefore(true);
        cts1.setDueAfter(false);
        cts1.setCutOffDate(5);
        cts1.setDueDate(15);
        creditTerm.getFixedCreditTermSpecifications().add(cts1);
        FixedCreditTermSpecification cts2 = new FixedCreditTermSpecification();
        cts2.setDueCurrentMonth(true);
        cts2.setDueCurrentWeek(false);
        cts2.setDueOrdinalWeek(0);
        cts2.setCutoffBefore(true);
        cts2.setDueAfter(false);
        cts2.setCutOffDate(15);
        cts2.setDueDate(25);
        creditTerm.getFixedCreditTermSpecifications().add(cts2);
        FixedCreditTermSpecification cts3 = new FixedCreditTermSpecification();
        cts3.setDueCurrentMonth(false);
        cts3.setDueCurrentWeek(false);
        cts3.setDueOrdinalWeek(0);
        cts3.setCutoffBefore(true);
        cts3.setDueAfter(false);
        cts3.setCutOffDate(25);
        cts3.setDueDate(5);
        creditTerm.getFixedCreditTermSpecifications().add(cts3);

        return invoice;

    }
    
    
    public static Invoice createSfInvoiceWithWeeklyFixedPaymentDate() {

        Invoice invoice = new Invoice();
        invoice.setFinancialType("SF");
        invoice.setBound(BOUND_IB);
        invoice.setTrade(TRADE_NAT);

        String pfwRdtStr = "";
        pfwRdtStr = "20121022044932.925";
        invoice.setInvoiceDate(new PFWRelativeDateTime(pfwRdtStr));

        BLInfo blInfo1 = new BLInfo();
        String pfwRdtStr4Eta1 = "20121021044932.925";
        blInfo1.setArrivalDate(new PFWRelativeDateTime(pfwRdtStr4Eta1));
        invoice.getBls().add(blInfo1);
        BLInfo blInfo2 = new BLInfo();
        String pfwRdtStr4Eta2 = "20121023044932.925";
        blInfo2.setArrivalDate(new PFWRelativeDateTime(pfwRdtStr4Eta2));
        invoice.getBls().add(blInfo2);

        Customer customer = new Customer();
        invoice.setCustomer(customer);
        customer.setAccountingIdentifier(001L);
        customer.setInheritCreditTermAssignmentsIndicator(false);
        customer.setStatus(CustomerConstants.CUSTOMER_STATUS_ACTIVE);

        Credit credit = new Credit();
        customer.setCredit(credit);
        credit.setStatus(CustomerConstants.CREDIT_STATUS_Y);
        credit.setFixedDatePaymentIndicator(true);

        CreditTerm creditTerm = new CreditTerm();
        credit.getCreditTerms().add(creditTerm);
        creditTerm.setCreditTermStatus(CustomerConstants.CREDIT_TERM_STATUS_ACTIVE);
        creditTerm.setNumberOfDays(7);
        creditTerm.setPaymentRecurrenceType(DueDateCalculationConstants.PAYMENT_RECURRENCE_TYPE_WEEKLY);

        SegmentSpecification segmentSepcification = new SegmentSpecification();
        creditTerm.setCreditTermSpecification(segmentSepcification);
        segmentSepcification.setBound(BOUND_IB);
        segmentSepcification.setTrade(TRADE_NAT);

        FixedCreditTermSpecification cts = new FixedCreditTermSpecification();
        cts.setDueCurrentWeek(true);
        cts.setCutoffBefore(true);
        cts.setDueAfter(false);
        cts.setCutOffDay(DueDateCalculationConstants.WEEKDAY_WEDNESDAY);
        cts.setDueDay(DueDateCalculationConstants.WEEKDAY_FRIDAY);
        creditTerm.getFixedCreditTermSpecifications().add(cts);

        return invoice;

    }
    
    
    public static Invoice createSfInvoiceWithAltWeeklyFixedPaymentDate() {

        Invoice invoice = new Invoice();
        invoice.setFinancialType("SF");
        invoice.setBound(BOUND_IB);
        invoice.setTrade(TRADE_NAT);

        String pfwRdtStr = "";
        pfwRdtStr = "20121022044932.925";
        invoice.setInvoiceDate(new PFWRelativeDateTime(pfwRdtStr));

        BLInfo blInfo1 = new BLInfo();
        String pfwRdtStr4Eta1 = "20121021044932.925";
        blInfo1.setArrivalDate(new PFWRelativeDateTime(pfwRdtStr4Eta1));
        invoice.getBls().add(blInfo1);
        BLInfo blInfo2 = new BLInfo();
        String pfwRdtStr4Eta2 = "20121023044932.925";
        blInfo2.setArrivalDate(new PFWRelativeDateTime(pfwRdtStr4Eta2));
        invoice.getBls().add(blInfo2);

        Customer customer = new Customer();
        invoice.setCustomer(customer);
        customer.setAccountingIdentifier(001L);
        customer.setInheritCreditTermAssignmentsIndicator(false);
        customer.setStatus(CustomerConstants.CUSTOMER_STATUS_ACTIVE);

        Credit credit = new Credit();
        customer.setCredit(credit);
        credit.setStatus(CustomerConstants.CREDIT_STATUS_Y);
        credit.setFixedDatePaymentIndicator(true);

        CreditTerm creditTerm = new CreditTerm();
        credit.getCreditTerms().add(creditTerm);
        creditTerm.setCreditTermStatus(CustomerConstants.CREDIT_TERM_STATUS_ACTIVE);
        creditTerm.setNumberOfDays(7);
        creditTerm.setPaymentRecurrenceType(DueDateCalculationConstants.PAYMENT_RECURRENCE_TYPE_ALT_WEEKLY);

        SegmentSpecification segmentSepcification = new SegmentSpecification();
        creditTerm.setCreditTermSpecification(segmentSepcification);
        segmentSepcification.setBound(BOUND_IB);
        segmentSepcification.setTrade(TRADE_NAT);

        FixedCreditTermSpecification cts = new FixedCreditTermSpecification();
        cts.setDueCurrentWeek(false);
        cts.setCutoffBefore(true);
        cts.setDueAfter(false);
        Date date = DateUtils.createDate(2010, 4, 21);
        FWAbsoluteDateTime fwEffectiveDate = new FWAbsoluteDateTime(date);
        PFWAbsoluteDateTime pfwEffectiveDate = PFWIODTUtil
                .getPFWDateTime(fwEffectiveDate);
        cts.setEffectiveDate(pfwEffectiveDate);
        cts.setCutOffDay(DueDateCalculationConstants.WEEKDAY_WEDNESDAY);
        cts.setDueDay(DueDateCalculationConstants.WEEKDAY_FRIDAY);
        creditTerm.getFixedCreditTermSpecifications().add(cts);

        return invoice;

    }
}
