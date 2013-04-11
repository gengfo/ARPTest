package com.oocl.ir4.arp.domain.support;

import com.oocl.csc.frm.config.loader.FWIInitConfig;

public class MyInitConfig implements FWIInitConfig {

	public String getApplicationName() {
	    
		return "ARPUT";
	}

	public String getAppServerInstanceName() {
		return null;
	}

	public String getConfigFilePath() {
		return "config.xml";
	}

}