package com.redowl.batch_processing.services.transaction;

import com.redowl.batch_processing.models.transaction.TReport;

import java.util.List;

public interface TReportModelService {
    TReport getReportDetailsByReportCode(String reportCode);

}
