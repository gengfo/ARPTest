package com.oocl.ir4.arp.service.invadj;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.springframework.test.context.ContextConfiguration;

import com.oocl.ir4.arp.domain.support.MyDaoTestCase;

@ContextConfiguration(locations = { "classpath:/invadj-context-test.xml" })
public class DefaultInvoiceAdjustmentServiceTest extends MyDaoTestCase {

    // @Resource
    // private InvoiceService invoiceService;

    @Ignore
    public void testSearchInv4InvAdjustment() {

        assertTrue(true);

        // SearchInvoiceBeanNoPaging invCriteria = new SearchInvoiceBeanNoPaging();
        //
        // List<Invoice> invList = invoiceService.searchInvoiceList(invCriteria);
        //
        // if (null != invList && invList.size() > 0) {
        //
        // SearchInvoiceBeanNoPaging adjCriteria = new SearchInvoiceBeanNoPaging();
        // LogManager.getInstance().getLogger(getClass()).info(adjCriteria);
        //
        // }

    }
}
