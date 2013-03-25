package com.oocl.ir4.arp.dao.invadj;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Ignore;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.oocl.ir4.arp.dao.invadj.impl.JpaInvoiceAdjustmentDao;
import com.oocl.ir4.arp.domain.support.MyDaoTestCase;
import com.oocl.ir4.arp.entity.common.Money;
import com.oocl.ir4.arp.entity.invoiceadj.InvoiceAdjustment;
import com.oocl.ir4.arp.entity.invoiceadj.InvoiceAdjustmentItem;
import com.oocl.ir4.arp.frm.core.logging.LogManager;

@ContextConfiguration(locations = { "classpath:invadj-context-test.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class JpaInvoiceAdjustmentDaoTest extends MyDaoTestCase {
    @Resource(name = "invAdjDao")
    private JpaInvoiceAdjustmentDao invAdjDao;

    InvoiceAdjustment invAdj = null;

    public InvoiceAdjustment prepareInvoiceAdjustmentData() {
        invAdj = new InvoiceAdjustment();

        invAdj.setAdjustNumber(String.valueOf(System.currentTimeMillis()));
        invAdj.setAdjustType("CI");

        InvoiceAdjustmentItem invAdjItem = new InvoiceAdjustmentItem();

        // Money m1 = new Money(CommonOM.getCurrency("USD"), new BigDecimal(100));
        Money m1 = null;
        invAdjItem.setInvAmt(m1);

        // Money m2 = new Money(CommonOM.getCurrency("USD"), new BigDecimal(100));
        Money m2 = null;
        invAdjItem.setTransactionAmt(m2);

        invAdjItem.setNote(invAdj);

        return invAdj;

    }

    @Ignore
    public void testAddInvoiceAdjustment() {

        InvoiceAdjustment invAdj = prepareInvoiceAdjustmentData();

        invAdjDao.addInvAdjustment(invAdj);

    }

    @Ignore
    public void testFindInAdjsutmentItemsByInvoiceOid() {

        List<InvoiceAdjustmentItem> itemList = invAdjDao.findInAdjsutmentItemsByInvoiceOid("4501");
        LogManager.getInstance().getLogger(getClass()).info(itemList);
    }

    @Ignore
    public void testSearchInvAdjustmentByPmtAdjEntryOid() {

        List<InvoiceAdjustment> itemList = invAdjDao.searchInvAdjustmentByPmtAdjEntryOid("4501");
        LogManager.getInstance().getLogger(getClass()).info(itemList);
    }

    @Ignore
    public void testSearchInvAdjustmentByPmtEntryOid() {

        List<InvoiceAdjustment> itemList = invAdjDao.searchInvAdjustmentByPmtEntryOid("4501");
        LogManager.getInstance().getLogger(getClass()).info(itemList);
    }

}
