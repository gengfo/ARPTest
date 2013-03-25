package com.oocl.ir4.arp.openservice.lts;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.oocl.csc.frm.config.loader.FWConfigLoadingException;
import com.oocl.csc.frm.integration.configuration.loader.FWConfigurationLoader;
import com.oocl.frm.mif.sender.exception.MIFSenderException;
import com.oocl.frm.persistence.impl.FrmPersistenceEntityManagerAccessor;
import com.oocl.ir4.arp.openservice.lts.JobOpenService;

public class DefaultJobOpenServiceTest {

	private static Logger log = LogManager
			.getLogger(DefaultJobOpenServiceTest.class);

	// must set while invoke BI publisher jar
	static {
		System.setProperty("javax.xml.parsers.DocumentBuilderFactory",
				"com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl");
		System.setProperty("javax.xml.transform.TransformerFactory",
				"com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl");
	}

	private JobOpenService jobOpenService;

	@Ignore
	public void testPowerSearch() {

		try {

			FWConfigurationLoader.initConfig("config.xml", "TIR", "TIR");
			System.setProperty("tangosol.coherence.localhost", "127.0.0.1"); // NOPMD
			System.setProperty("tangosol.coherence.ttl", "0");
			FrmPersistenceEntityManagerAccessor fpe = FrmPersistenceEntityManagerAccessor
					.getAccessor();
	        fpe.createAllFrmEntityManager();

//			Field emfField = FrmPersistenceEntityManagerAccessor.class
//					.getDeclaredField("emf");
//			emfField.setAccessible(true);

//			EntityManagerFactory localEmf = Persistence
//					.createEntityManagerFactory("ARP");
//
//			emfField.set(fpe, localEmf);
			// fpe.createFrmEntityManager();

			ApplicationContext ctx = new FileSystemXmlApplicationContext(
					"/WebContent/WEB-INF/spring/root-context.xml");

			jobOpenService = (JobOpenService) ctx.getBean("jobOpenService");
			jobOpenService.autoEDIInvMatching();

			log.debug("Done");

		} catch (FWConfigLoadingException e) {
			log.debug(e);
			e.printStackTrace();
		} catch (SecurityException e) {
			log.debug(e);
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			log.debug(e);
			e.printStackTrace();
		} catch (MIFSenderException e) {
			// TODO Auto-generated catch block
			log.debug(e);
			e.printStackTrace();
		}
		// catch (NamingException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}

}
