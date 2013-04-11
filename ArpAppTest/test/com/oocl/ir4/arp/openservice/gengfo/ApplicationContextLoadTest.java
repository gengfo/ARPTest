package com.oocl.ir4.arp.openservice.gengfo;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.oocl.ir4.arp.domain.support.MyDaoTestCase;

@ContextConfiguration(locations = { "classpath:spring/my-domain-context-test.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class ApplicationContextLoadTest extends MyDaoTestCase {

    @Test
    public void testLoadApplicationContext() {

        assertNotNull(applicationContext);

    }

}
