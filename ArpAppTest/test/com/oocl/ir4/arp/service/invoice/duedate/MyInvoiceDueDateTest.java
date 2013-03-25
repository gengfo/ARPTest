package com.oocl.ir4.arp.service.invoice.duedate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.oocl.frm.model.date.PFWRelativeDateTime;
import com.oocl.ir4.arp.domain.support.MyDaoTestCase;
import com.oocl.ir4.arp.entity.invoice.Invoice;
import com.oocl.ir4.arp.frm.spring.ApplicationContextHolder;
import com.oocl.ir4.arp.service.invoice.InvoiceService;
import com.oocl.ir4.arp.service.invoice.duedate.data.MySfSnInvoiceOM4DueDate;

@ContextConfiguration(locations = { "classpath:domain-context-test.xml", "classpath:spring/root-context.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class MyInvoiceDueDateTest extends MyDaoTestCase {

    @Before
    public void setup() {
        ApplicationContextHolder.getInstance().setApplicationContext(applicationContext);
    }

    //@Test
    public void ptestInvoiceDueDate4SFInvoiceWithNoFixedPaymentDate() {

        Invoice sfInvoice = MySfSnInvoiceOM4DueDate.createSfInvoiceWithNoFixedPaymentDate();

        InvoiceService invoiceService = (InvoiceService) applicationContext.getBean("invoiceService");
        assertNotNull(invoiceService);
        PFWRelativeDateTime pfwRdt = invoiceService.calcInvoiceDueDate(sfInvoice);
        assertNotNull(pfwRdt);

        String pfwRdtStrResult = "20121028000000.000";
        assertEquals(pfwRdtStrResult, pfwRdt.getDateStr());

        logger.debug(sfInvoice.getOid());

    }

    //@Test
    public void ptestInvoiceDueDate4SFInvoiceWithMonthlyFixedPaymentDate() {

        Invoice sfInvoice = MySfSnInvoiceOM4DueDate.createSfInvoiceWithMonthlyFixedPaymentDate();

        InvoiceService invoiceService = (InvoiceService) applicationContext.getBean("invoiceService");
        assertNotNull(invoiceService);
        PFWRelativeDateTime pfwRdt = invoiceService.calcInvoiceDueDate(sfInvoice);
        assertNotNull(pfwRdt);

        String pfwRdtStrResult = "20121130000000.000";
        assertEquals(pfwRdtStrResult, pfwRdt.getDateStr());

        logger.debug(sfInvoice.getOid());

    }
    
    //@Test
    public void ptestInvoiceDueDate4SFInvoiceWithBiMonthlyFixedPaymentDate() {

        Invoice sfInvoice = MySfSnInvoiceOM4DueDate.createSfInvoiceWithBiMonthlyFixedPaymentDate();

        InvoiceService invoiceService = (InvoiceService) applicationContext.getBean("invoiceService");
        assertNotNull(invoiceService);
        PFWRelativeDateTime pfwRdt = invoiceService.calcInvoiceDueDate(sfInvoice);
        assertNotNull(pfwRdt);

        String pfwRdtStrResult = "20121120000000.000";
        assertEquals(pfwRdtStrResult, pfwRdt.getDateStr());

        logger.debug(sfInvoice.getOid());

    }
    
    //@Test
    public void ptestInvoiceDueDate4SFInvoiceWithTriMonthlyFixedPaymentDate() {

        Invoice sfInvoice = MySfSnInvoiceOM4DueDate.createSfInvoiceWithTriMonthlyFixedPaymentDate();

        InvoiceService invoiceService = (InvoiceService) applicationContext.getBean("invoiceService");
        assertNotNull(invoiceService);
        PFWRelativeDateTime pfwRdt = invoiceService.calcInvoiceDueDate(sfInvoice);
        assertNotNull(pfwRdt);

        String pfwRdtStrResult = "20121115000000.000";
        assertEquals(pfwRdtStrResult, pfwRdt.getDateStr());

        logger.debug(sfInvoice.getOid());

    }
    
    //@Test
    public void ptestInvoiceDueDate4SFInvoiceWithWeeklyFixedPaymentDate() {

        Invoice sfInvoice = MySfSnInvoiceOM4DueDate.createSfInvoiceWithWeeklyFixedPaymentDate();

        InvoiceService invoiceService = (InvoiceService) applicationContext.getBean("invoiceService");
        assertNotNull(invoiceService);
        PFWRelativeDateTime pfwRdt = invoiceService.calcInvoiceDueDate(sfInvoice);
        assertNotNull(pfwRdt);

        String pfwRdtStrResult = "20121102000000.000";
        assertEquals(pfwRdtStrResult, pfwRdt.getDateStr());

        logger.debug(sfInvoice.getOid());

    }
    
    @Test
    public void ptestInvoiceDueDate4SFInvoiceWithAltWeeklyFixedPaymentDate() {

        Invoice sfInvoice = MySfSnInvoiceOM4DueDate.createSfInvoiceWithAltWeeklyFixedPaymentDate();

        InvoiceService invoiceService = (InvoiceService) applicationContext.getBean("invoiceService");
        assertNotNull(invoiceService);
        PFWRelativeDateTime pfwRdt = invoiceService.calcInvoiceDueDate(sfInvoice);
        assertNotNull(pfwRdt);

        String pfwRdtStrResult = "20121109000000.000";
        assertEquals(pfwRdtStrResult, pfwRdt.getDateStr());

        logger.debug(sfInvoice.getOid());

    }


}
