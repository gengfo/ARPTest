package com.oocl.ir4.arp.service.audittrail.data;

import com.oocl.frm.model.date.PFWLocalizedDateTime;
import com.oocl.ir4.arp.entity.common.audittrail.AuditTrail;
import com.oocl.ir4.arp.service.audit.AuditTrailConstants;
import com.oocl.ir4.arp.utils.DateUtils;

public class AuditTrailDTOConvertorDataOM {

    public static AuditTrail createInvoiceAuditTrial() {
        AuditTrail at = new AuditTrail();
        
        
        at.setBizKey("188");
        at.setClassName(AuditTrailConstants.CLASS_NAME_INVOIC);
        // skip field name/from/to to AuditDetail
        at.setRemarks("remarks");
        //resultDto.setTransactionId(at.getTransactionId());
        at.setTriggerAction("cancel");
        // Used triggerById but not triggerBy
        at.setTriggerById("GENGFO");
        at.setTriggerReason("reason");
        
        
        
        PFWLocalizedDateTime pfwLocDt = DateUtils.getCurrentTimeInLocal("Asia/Shanghai");
        at.setTriggerTime(pfwLocDt);
        

        return at;
    }
    
    
    
    
    

}
