package com.oocl.ir4.arp.openservice.tir;

import java.lang.reflect.Field;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.oocl.csc.frm.config.loader.FWConfigLoadingException;
import com.oocl.csc.frm.integration.configuration.loader.FWConfigurationLoader;
import com.oocl.frm.persistence.impl.FrmPersistenceEntityManagerAccessor;
import com.oocl.ir4.arp.openservice.tir.TIROpenService;
import com.oocl.ir4.arp.openservice.tir.dto.TirPowerSearchDTO;
import com.oocl.ir4.arp.openservice.tir.dto.TirPowerSearchResultDTO;

public class DefaultTIROpenServiceTest {

    private static Logger log = LogManager.getLogger(DefaultTIROpenServiceTest.class);

    // must set while invoke BI publisher jar
    static {
        System.setProperty("javax.xml.parsers.DocumentBuilderFactory",
                "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl");
        System.setProperty("javax.xml.transform.TransformerFactory",
                "com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl");
    }

    private TIROpenService tirOpenService;

    @Ignore
    public void testPowerSearch() {

        try {

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

            TirPowerSearchDTO searchDto = new TirPowerSearchDTO();

            // searchDto.setSearchNos("12345"); //invoice
            // searchDto.setSearchNos("411R000000"); //payment
            // searchDto.setSearchNos("BL00000001"); // invoice matching
            searchDto.setSearchNos("12345;411R000000;BL00000001"); // all

            String searchNos = searchDto.getSearchNos();

            tirOpenService = (TIROpenService) ctx.getBean("tirOpenService");
            TirPowerSearchResultDTO result = tirOpenService.searchBizObjects(searchNos);

            result.getInvoiceSearchResult();
            result.getPaymentSearchResult();
            result.getInvoiceMatchSerachResult();

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

}
