package com.oocl.ir4.arp.dao.audit;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.oocl.ir4.arp.dao.audit.impl.JpaAuditTrailDao;
import com.oocl.ir4.arp.domain.support.MyDaoTestCase;

@ContextConfiguration(locations = { "classpath:invadj-context-test.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class JpaAuditTrailDaoTest extends MyDaoTestCase {
	@Resource(name = "invAdjDao")
	private JpaAuditTrailDao auditTrailDao;

}
