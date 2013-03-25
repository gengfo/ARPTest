package com.oocl.ir4.arp.service.audittrail;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.springframework.test.context.ContextConfiguration;

import com.oocl.ir4.arp.domain.support.MyDaoTestCase;
import com.oocl.ir4.arp.service.audit.AuditTrailService;

@ContextConfiguration(locations = { "classpath:/biz-audit-context-test.xml" })
public class DefaultAuditTrailServiceTest extends MyDaoTestCase {

    @Resource
    private AuditTrailService auditTrailService;

    // @Resource(name = "auditTrailDao")
    // private AuditTrailDao auditTrailDao;

    @Ignore
    public void testSearchAuditTrail() {
        String className = "com.oocl.ir4.arp.entity.invoice.Invoice";
        String bizKey = "Invoice1";
        auditTrailService.searchAuditTrail(className, bizKey);

    }

}
