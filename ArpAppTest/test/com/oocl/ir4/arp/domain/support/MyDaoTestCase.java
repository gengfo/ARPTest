package com.oocl.ir4.arp.domain.support;

import javax.persistence.EntityManager;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.oocl.csc.frm.config.loader.FWConfigLoader;
import com.oocl.frm.persistence.FrmPersistenceIEntityManager;
import com.oocl.frm.persistence.impl.FrmPersistenceEntityManagerAccessor;
import com.oocl.ir4.arp.frm.spring.ApplicationContextHolder;

public class MyDaoTestCase extends AbstractTransactionalJUnit4SpringContextTests {

    private static boolean inited;
    //public static Logger logger = LogManager.getLogger(MyDaoTestCase.class);
    /**
     * To avoid BI Publisher Impact
     */
    static {
        
        
        System.setProperty("user.timezone", "Asia/Shanghai");
        // -Duser.timezone="Asia/Shanghai"
        System.setProperty("javax.xml.parsers.DocumentBuilderFactory",
                "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl");
        System.setProperty("javax.xml.transform.TransformerFactory",
                "com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl");
    }

    @BeforeClass
    public synchronized static void init() throws Exception {
        
        if (!inited) {
            //logger.debug("init started");
            FWConfigLoader.loadConfig(new MyInitConfig());
            // to avoid coherence impact
            System.setProperty("tangosol.coherence.localhost", "127.0.0.1"); // NOPMD
            System.setProperty("tangosol.coherence.ttl", "0");
            replacePfwEm();
            inited = true;
            //logger.debug("init done");
        }
        
    }

    @Before
    public void prepareData() {
        ApplicationContextHolder.getInstance().setApplicationContext(applicationContext);
    }

    public static void replacePfwEm() throws Exception {
        FrmPersistenceEntityManagerAccessor fpe = FrmPersistenceEntityManagerAccessor.getAccessor();
        fpe.createAllFrmEntityManager();
    }

    public EntityManager getEntityManager() {
        FrmPersistenceEntityManagerAccessor fpe = FrmPersistenceEntityManagerAccessor.getAccessor();
        return fpe.getJPAEntityManager();
    }

    public FrmPersistenceIEntityManager getFrmEntityManager() {
        FrmPersistenceEntityManagerAccessor fpe = FrmPersistenceEntityManagerAccessor.getAccessor();
        return fpe.getFrmEntityManager();
    }
}
