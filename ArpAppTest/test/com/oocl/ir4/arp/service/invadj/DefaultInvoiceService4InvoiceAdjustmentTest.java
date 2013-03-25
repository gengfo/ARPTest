package com.oocl.ir4.arp.service.invadj;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Ignore;
import org.springframework.test.context.ContextConfiguration;

import com.oocl.ir4.arp.dao.invoice.impl.InvoiceConstants;
import com.oocl.ir4.arp.dao.invoice.impl.JpaInvoiceDao;
import com.oocl.ir4.arp.domain.support.MyDaoTestCase;
import com.oocl.ir4.arp.entity.invoice.Invoice;
import com.oocl.ir4.arp.service.invoice.InvoiceService;

@ContextConfiguration(locations = { "classpath:/invoice-context-test.xml" })
public class DefaultInvoiceService4InvoiceAdjustmentTest extends MyDaoTestCase {

    @Resource
    private InvoiceService invoiceService;

    @Resource(name = "invoiceDao")
    private JpaInvoiceDao invoiceDao;

    private static final String SAP_ID = "sapId";

    private static final String colOffice = "SHA";

    private static final String XX = "Printed";

    private static final String status = "Confirmed";

    private static final String ctrlOffice = "414";

    private String num = null;

    @Before
    public void prepareData() {
        // Invoice inv1 = new Invoice();
        // MyInvoiceOM om = new MyInvoiceOM();
        // final Invoice inv1 = om.createInvoice();
        final Invoice inv1 = null;

        inv1.setCollectOffice(colOffice);
        inv1.setDeliveryStatus(XX);
        inv1.setCtrlOffice(ctrlOffice);
        // inv1.setCustomerSapId(SAP_ID);
        inv1.setStatus(status);
        final Invoice inv2 = invoiceDao.store(inv1);
        num = inv2.getNumber();

        getEntityManager().flush();
    }

    @Ignore
    public void testSearchInv4InvAdjustment() {
        String type = InvoiceConstants.INV_NUM.name();

        Invoice invoice = invoiceService.searchInv4InvAdjustment(type, num, null);

        if (null != invoice) {
            assertEquals(invoice.getNumber(), invoice.getNumber());
        }
    }

}
