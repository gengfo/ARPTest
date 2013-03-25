/**
 * 
 */
package com.oocl.ir4.arp.domain.support;

import java.lang.reflect.Field;

import com.oocl.ir4.arp.entity.common.ExchRateSourceType;
import com.oocl.ir4.cmn.model.ARCharge;
import com.oocl.ir4.cmn.model.Currency;
import com.oocl.ir4.cmn.model.Trade;
import com.oocl.ir4.cus.model.Customer;
import com.oocl.ir4.cus.model.Regulatory;
import com.oocl.ir4.gsp.exch.model.ExchangeRateSource;
import com.oocl.ir4.gsp.org.model.OrganizationHierarchyNode;

/**
 * @author YANGMA5 Aug 6, 2012
 *
 */
public class MyCommonOM {

    public static Currency getCurrency(String code) {
        Currency currency = new Currency();
        currency.setCode("CNY");
        return currency;
    }
    
    public static ARCharge getChargeCode(String code) {
        ARCharge charge = new ARCharge();
        charge.setActive(true);
        charge.setCode(code);
        return charge;
    }
    
    public static Customer getCustomer(long cpfId) {
        Customer cust = new Customer();
        cust.setActiveIndicator(true);
        cust.setAutoBill(false);
        cust.setCustomerInternalIdentifier(cpfId);
        Regulatory reg = new Regulatory();
        reg.setValueAddedTaxNumber("123123");
        cust.setRegulatory(reg);
        return cust;
    }

    /**
     * @param i
     * @return
     */
    public static OrganizationHierarchyNode getPaymentOffice(long orgHNOid) {
        OrganizationHierarchyNode ou = new OrganizationHierarchyNode();
        try {
            Field field = OrganizationHierarchyNode.class.getDeclaredField("id");
            field.setAccessible(true);
            field.set(ou, orgHNOid);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return ou;
    }

    /**
     * @param l
     * @return
     */
    public static ExchangeRateSource getExchangeRateSource(final long l) {
        ExchangeRateSource ers = new ExchangeRateSource();
        try {
            Field field = ExchangeRateSource.class.getDeclaredField("rateSourceID");
            field.setAccessible(true);
            field.set(ers, l);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ers.setSourceType(ExchRateSourceType.VOYAGE.toString());
        return ers;
    }

    /**
     * @param string
     * @return
     */
    public static Trade getTrade(String code) {
        Trade trade = new Trade();
        trade.setCode(code);
        return trade;
    }
}
