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

        List<AuditTrail> atList = buildInvoiceAudit();
        InvoiceActionLogResultDTO resultDto = atDtoConvertor.outputInvoiceConvert(buildInvoiceAudit());
        assertNotNull(resultDto);

    }

    public static List<AuditTrail> buildInvoiceAudit() {

        List<AuditTrail> invAList = new ArrayList<AuditTrail>();

        return invAList;
    }

}
