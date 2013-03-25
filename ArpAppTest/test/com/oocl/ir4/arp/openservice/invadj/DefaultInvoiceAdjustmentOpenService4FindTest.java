package com.oocl.ir4.arp.openservice.invadj;

import javax.annotation.Resource;

import junit.framework.TestCase;

import org.junit.Ignore;

import com.oocl.ir4.arp.frm.core.logging.LogManager;
import com.oocl.ir4.arp.openservice.invadj.InvoiceAdjustmentOpenService;
import com.oocl.ir4.arp.openservice.invadj.dto.SearchInvoice4AdjustDTO;
import com.oocl.ir4.arp.openservice.invadj.dto.SearchInvoice4AdjustResultDTO;

public class DefaultInvoiceAdjustmentOpenService4FindTest extends TestCase {

    @Resource
    private InvoiceAdjustmentOpenService invAdjOpenService;

    public void testfind() {

        assertTrue(true);

    }

    @Ignore
    public void testfindInvoiceToApplyInvoiceAdjustment() {

        assertTrue(true);

        // SearchInvoice4AdjustDTO invAdjDto = DefaultInvoiceAdjustmentOpenService4FindOM
        // .setupSearchInvoice4AdjustDTO();

        // SearchInvoice4AdjustResultDTO resultDto = invAdjOpenService.findInvoiceToApplyInvoiceAdjustment(invAdjDto);
        // LogManager.getInstance().getLogger(getClass()).info(resultDto);
    }

}
