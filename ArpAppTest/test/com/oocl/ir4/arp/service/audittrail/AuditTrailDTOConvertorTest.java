package com.oocl.ir4.arp.service.audittrail;

import junit.framework.TestCase;

import org.junit.Ignore;

import com.oocl.frm.model.date.PFWLocalizedDateTime;
import com.oocl.ir4.arp.entity.common.audittrail.AuditTrail;
import com.oocl.ir4.arp.openservice.audit.dto.AuditTrailDTOConvertor;
import com.oocl.ir4.arp.service.audittrail.data.AuditTrailDTOConvertorDataOM;
import com.oocl.ir4.arp.utils.DateUtils;

public class AuditTrailDTOConvertorTest extends TestCase {

    public void testConvertInvoiceAuditTrail() {

        AuditTrailDTOConvertor atDtoConvertor = new AuditTrailDTOConvertor(null);
        AuditTrail at = AuditTrailDTOConvertorDataOM.createInvoiceAuditTrial();
        String currentTimeZone = "";
        atDtoConvertor.convertAuditTrail(at, currentTimeZone, false);

        assertTrue(true);

    }

    @Ignore
    public void testFormatFWLocalizedDateTime2AuditStr1() {

        String origTimeZone = "America/Montreal";
        PFWLocalizedDateTime pfwLocDt = DateUtils.getCurrentTimeInLocal(origTimeZone);

        AuditTrailDTOConvertor atDtoConvertor = new AuditTrailDTOConvertor(null);
        String currTimeZone = "Asia/Shanghai";
        String timePoint = atDtoConvertor.formatFWLocalizedDateTime2AuditStr(pfwLocDt, currTimeZone);

        assertTrue(true);
        // iatb.setTriggerTime(com.oocl.ir4.arp.utils.DateUtils.getCurrentTimeInLocal(getOrganizationService()
        // .findFinancialOrganization(inv.getCollectOffice()).getCompanyOffice().getLocation().getTimeZone()
        // .getJavaTimezoneName()));

    }

    @Ignore
    public void testFormatFWLocalizedDateTime2AuditStr2() {

        String origTimeZone = "Asia/Shanghai";
        PFWLocalizedDateTime pfwLocDt = DateUtils.getCurrentTimeInLocal(origTimeZone);

        AuditTrailDTOConvertor atDtoConvertor = new AuditTrailDTOConvertor(null);

        String currTimeZone = "America/Montreal";
        String timePoint = atDtoConvertor.formatFWLocalizedDateTime2AuditStr(pfwLocDt, currTimeZone);

        assertTrue(true);
        // iatb.setTriggerTime(com.oocl.ir4.arp.utils.DateUtils.getCurrentTimeInLocal(getOrganizationService()
        // .findFinancialOrganization(inv.getCollectOffice()).getCompanyOffice().getLocation().getTimeZone()
        // .getJavaTimezoneName()));

    }

}
