package com.oocl.ir4.arp.openservice.audit;

import java.lang.reflect.Field;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.oocl.csc.frm.config.loader.FWConfigLoadingException;
import com.oocl.csc.frm.integration.configuration.loader.FWConfigurationLoader;
import com.oocl.frm.model.date.PFWAbsoluteDateTime;
import com.oocl.frm.model.date.PFWLocalizedDateTime;
import com.oocl.frm.persistence.impl.FrmPersistenceEntityManagerAccessor;
import com.oocl.ir4.arp.openservice.audit.AuditTrailOpenService;
import com.oocl.ir4.arp.openservice.audit.dto.SearchAuditTrailListDTO;
import com.oocl.ir4.arp.openservice.audit.dto.SearchAuditTrailListResultDTO;
import com.oocl.ir4.arp.openservice.common.dto.DTOConverter.DateFormatEnum;
import com.oocl.ir4.arp.utils.DateUtils;

public class DefaultAuditTrailOpenServiceTest {

    /**
     * Unit test usage: 1. in java build path\ porjects 1.1. add domain project 1.2. add servcie test porject 2. in java
     * build path \ libraries 2.1 add domain/config to eclipse
     */

    // private static Log log =
    // LogManager.getInstance().getLogger(DefaultAuditTrailOpenServiceTest.class);
    private static Logger log = LogManager.getLogger(DefaultAuditTrailOpenServiceTest.class);
    // must set while invoke BI publisher jar
    static {

        System.setProperty("javax.xml.parsers.DocumentBuilderFactory",
                "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl");
        System.setProperty("javax.xml.transform.TransformerFactory",
                "com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl");

    }

    private AuditTrailOpenService auditTrailOpenService;

    @Ignore
    public void testPowerSearch() {

        try {
            log.debug("autoEDIInvMatching start ...");

            FWConfigurationLoader.initConfig("config.xml", "TIR", "TIR");
            System.setProperty("tangosol.coherence.localhost", "127.0.0.1"); // NOPMD
            System.setProperty("tangosol.coherence.ttl", "0");
            FrmPersistenceEntityManagerAccessor fpe = FrmPersistenceEntityManagerAccessor.getAccessor();

            Field emfField = FrmPersistenceEntityManagerAccessor.class.getDeclaredField("emf");
            emfField.setAccessible(true);

            EntityManagerFactory localEmf = Persistence.createEntityManagerFactory("ARPUT");

            emfField.set(fpe, localEmf);
            // fpe.createFrmEntityManager();

            ApplicationContext ctx = new FileSystemXmlApplicationContext(
                    "/WebContent/WEB-INF/spring/root-context.xml");

            SearchAuditTrailListDTO searchDto = new SearchAuditTrailListDTO();
            // String className = "com.oocl.ir4.arp.entity.invoice.Invoice";
            // String bizKey = "Invoice1";

            String className = "com.oocl.ir4.arp.entity.edi.RejectedEDIInvoiceMatch";
            String bizKey = "101";

            searchDto.setClassName(className);
            searchDto.setBizKey(bizKey);

            auditTrailOpenService = (AuditTrailOpenService) ctx.getBean("auditTrailOpenService");
            SearchAuditTrailListResultDTO result = auditTrailOpenService.searchAuditTrailList(searchDto);

            result.getActionLogs();

            log.debug("Done");

        } catch (FWConfigLoadingException e) {
            log.debug(e);
            e.printStackTrace();
        } catch (SecurityException e) {
            log.debug(e);
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            log.debug(e);
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            log.debug(e);
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // catch (NamingException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }

    }

    @Ignore
    public void testTimeZone() {
        String timeZone1 = "Asia/Shanghai";
        String tiemZone2 = "Europe/Paris";
        // String tiemZone2 = "America/New_York";
        PFWLocalizedDateTime testPfwLdt = DateUtils.getCurrentTimeInLocal(timeZone1);

        log.debug(convertDateTime(testPfwLdt, DateFormatEnum.dd_MMM_yyy_HH_mm));

        if (!StringUtils.isEmpty(timeZone1)) {
            PFWLocalizedDateTime pfwLdt = testPfwLdt;
            if (tiemZone2.equals(pfwLdt.getTimezone())) {
                log.debug(convertDateTime(pfwLdt, DateFormatEnum.dd_MMM_yyy_HH_mm));
            } else {
                PFWAbsoluteDateTime pfwAdt = pfwLdt.getDateInLocalizedTimeZone(timeZone1);
                PFWLocalizedDateTime triggerTime = DateUtils.getTimeInLocal(pfwAdt, tiemZone2);
                log.debug(convertDateTime(triggerTime, DateFormatEnum.dd_MMM_yyy_HH_mm));
            }
        } else {
            log.debug(convertDateTime(testPfwLdt, DateFormatEnum.dd_MMM_yyy_HH_mm));
        }
    }

    public String convertDateTime(PFWAbsoluteDateTime creationTime, DateFormatEnum format) {
        return DateUtils.formatDateTime(creationTime, format.getFmt());
    }
}
