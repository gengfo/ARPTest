package com.oocl.ir4.arp.openservice.invadj;

import java.math.BigDecimal;

import com.oocl.ir4.arp.openservice.invadj.dto.InvoiceAdjustItemDTO;
import com.oocl.ir4.arp.openservice.invadj.dto.InvoiceAdjustmentDTO;

public class DefaultInvoiceAdjustmentOpenService4AddOM {
    
    

    public static InvoiceAdjustItemDTO setupInvoiceAdjustItemDTO() {

        InvoiceAdjustItemDTO itemDto = new InvoiceAdjustItemDTO();

        itemDto.setTscCur("CNY");

        itemDto.setAmtInTscCur(new BigDecimal("10.5"));

        itemDto.setInvOid(Long.parseLong("4501"));

        itemDto.setInvVersion(1);

        return itemDto;

    }

    public static InvoiceAdjustmentDTO setupInvoiceAdjustmentDTO() {

        InvoiceAdjustmentDTO invAdjDto = new InvoiceAdjustmentDTO();

        String random = String.valueOf(System.currentTimeMillis()).substring(3, 8);
        // invAdjDto.set(String.valueOf(System.currentTimeMillis()));

        invAdjDto.setBadDebtRef("baddebt-" + random);

        invAdjDto.setRefundVenderNo("refund-" + random);

        invAdjDto.setRemark("remark-" + random);

        invAdjDto.setAdjReason("BD");

        InvoiceAdjustItemDTO[] items = new InvoiceAdjustItemDTO[1];
        items[0] = setupInvoiceAdjustItemDTO();

        invAdjDto.setInvAdjItemDtos(items);

        return invAdjDto;

    }

}
