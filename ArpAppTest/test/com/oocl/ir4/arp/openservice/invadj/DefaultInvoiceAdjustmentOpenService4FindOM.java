package com.oocl.ir4.arp.openservice.invadj;

import com.oocl.ir4.arp.dao.invoice.impl.InvoiceConstants;
import com.oocl.ir4.arp.openservice.invadj.dto.SearchInvoice4AdjustDTO;

public class DefaultInvoiceAdjustmentOpenService4FindOM {

    public static SearchInvoice4AdjustDTO setupSearchInvoice4AdjustDTO() {

        SearchInvoice4AdjustDTO invAdjDto = new SearchInvoice4AdjustDTO();

        String type = InvoiceConstants.INV_NUM.name();
        String no = "12345678";

        invAdjDto.setRefType(type);
        invAdjDto.setRefNo(no);
        
        return invAdjDto;

    }

   

}
