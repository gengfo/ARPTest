package com.oocl.ir4.arp.domain.support;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;
import org.springframework.transaction.support.DefaultTransactionStatus;

import com.oocl.frm.persistence.impl.FrmPersistenceEntityManagerAccessor;

/**
 * Use PersistenceFramework and Spring Framework Together
 * 
 * @author Harper Jiang
 * 
 */
public class MyPFWUnitTestTransactionManager extends
		AbstractPlatformTransactionManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6520713576779728201L;

	@Override
	protected Object doGetTransaction() throws TransactionException {
		return getEm().getTransaction();
	}

	@Override
	protected void doBegin(Object transaction, TransactionDefinition definition)
			throws TransactionException {
		EntityTransaction et = (EntityTransaction)transaction;
		et.begin();
	}

	@Override
	protected void doCommit(DefaultTransactionStatus status)
			throws TransactionException {
		EntityTransaction et = (EntityTransaction)status.getTransaction();
		et.commit();
	}

	@Override
	protected void doRollback(DefaultTransactionStatus status)
			throws TransactionException {
		EntityTransaction et = (EntityTransaction)status.getTransaction();
		et.rollback();
	}

	protected EntityManager getEm() {
		FrmPersistenceEntityManagerAccessor fpe = FrmPersistenceEntityManagerAccessor
				.getAccessor();
		fpe.createAllFrmEntityManager();		
		return fpe.getJPAEntityManager();
	}

}
