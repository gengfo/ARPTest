package com.oocl.ir4.arp.openservice.audit;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.oocl.ir4.arp.domain.support.MyDaoTestCase;
import com.oocl.ir4.arp.entity.common.audittrail.AuditTrail;
import com.oocl.ir4.arp.entity.common.audittrail.AuditTrailDetail;
import com.oocl.ir4.arp.openservice.audit.dto.AuditTrailDTOConvertor;
import com.oocl.ir4.arp.openservice.audit.dto.InvoiceActionLogResultDTO;
import com.oocl.ir4.arp.service.audit.AuditTrailService;
import com.oocl.ir4.arp.service.invoice.InvoiceService;
import com.oocl.ir4.arp.service.invoicematching.InvoiceMatchingService;
import com.oocl.ir4.arp.service.payment.PaymentService;
import com.oocl.ir4.arp.service.suppdata.OrganizationService;

//@ContextConfiguration(locations = { "classpath:*test.xml,biz*.xml" })
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)

@ContextConfiguration(locations = { "classpath:spring/domain-context-test.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class AuditTrailDTOConvertorTest extends MyDaoTestCase {

    @Resource(name = "auditTrailService")
    AuditTrailService auditTrailService;

    @Resource(name = "invoiceMatchingService")
    InvoiceMatchingService invoiceMatchingService;

    @Resource(name = "invoiceService")
    InvoiceService invoiceService;

    @Resource(name = "paymentService")
    PaymentService paymentService;

    @Resource(name = "orgService")
    OrganizationService orgService;

    @Test
    public void testSearchInvoiceAudit() {

        assertNotNull(auditTrailService);
        assertNotNull(invoiceMatchingService);
        assertNotNull(invoiceService);
        assertNotNull(paymentService);
        assertNotNull(orgService);

        AuditTrailDTOConvertor atDtoConvertor = new AuditTrailDTOConvertor(null);
        atDtoConvertor.setInvoiceMatchingService(invoiceMatchingService);
        atDtoConvertor.setInvoiceService(invoiceService);
        atDtoConvertor.setPaymentService(paymentService);
        atDtoConvertor.setOrganizationService(orgService);

        InvoiceActionLogResultDTO resultDto = atDtoConvertor.outputInvoiceConvert(buildInvoiceAudits());
        assertNotNull(resultDto);

    }

    public static List<AuditTrail> buildInvoiceAudits() {

        List<AuditTrail> invAList = new ArrayList<AuditTrail>();

        invAList.add(buildInvoiceAudit1());

        return invAList;
    }

    public static AuditTrail buildInvoiceAudit1() {
        AuditTrail at = new AuditTrail();

        at.setBizKey("3578");
        at.setClassName("com.oocl.ir4.arp.entity.invoice.Invoice");
        at.setCreatedBy("LIYI");
        at.setCreatedClientID("10.222.1.142");
        at.setLastUpdateClientID("");
        at.setRemarks("Status Change");
        at.setTransactionId("");
        at.setTriggerAction("Add");
        at.setTriggerBy("GENGFO");
        at.setTriggerById("GENGFO");
        at.setTriggerReason("Reason");
        at.setTriggerTime(null);
        
        at.getDetails().add(buildInvoiceAuditDetail1_1());

        return at;

    }
    
    public static AuditTrailDetail buildInvoiceAuditDetail1_1() {
        
        AuditTrailDetail atd = new AuditTrailDetail();
        atd.setCreatedBy("GENGFO");
        
        
        return null;
        
    }

    // com.oocl.ir4.arp.entity.invoice.Invoice

}
