package com.oocl.ir4.arp.openservice.invadj;

import javax.annotation.Resource;

import org.junit.Ignore;

import com.oocl.ir4.arp.frm.core.logging.LogManager;
import com.oocl.ir4.arp.openservice.invadj.InvoiceAdjustmentOpenService;
import com.oocl.ir4.arp.openservice.invadj.dto.InvoiceAdjustResultDTO;
import com.oocl.ir4.arp.openservice.invadj.dto.InvoiceAdjustmentDTO;

public class DefaultInvoiceAdjustmentOpenService4AddTest extends DefaultInvoiceAdjustmentOpenServiceBaseTest {

    @Resource
    private InvoiceAdjustmentOpenService invAdjOpenService;

    @Ignore
    public void testAddInvAdjustment() {

        InvoiceAdjustmentDTO invAdjDto = DefaultInvoiceAdjustmentOpenService4AddOM.setupInvoiceAdjustmentDTO();

        InvoiceAdjustResultDTO resultDto = invAdjOpenService.addInvAdjustment(invAdjDto);
        LogManager.getInstance().getLogger(getClass()).info(resultDto);  
        // getEntityManager().flush();

    }

}
