package com.redowl.batch_processing.daos.transaction;

import com.redowl.batch_processing.models.transaction.TTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TTransactionDao extends JpaRepository<TTransaction, Integer>, JpaSpecificationExecutor<TTransaction> {
}