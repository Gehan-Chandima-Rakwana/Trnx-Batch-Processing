package com.redowl.batch_processing.daos.transaction;


import com.redowl.batch_processing.models.transaction.TReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TReportDao extends JpaRepository<TReport, Integer>, JpaSpecificationExecutor<TReport> {
    Optional<TReport> findByReportCodeAndIsActive(String reportCode, boolean b);

}