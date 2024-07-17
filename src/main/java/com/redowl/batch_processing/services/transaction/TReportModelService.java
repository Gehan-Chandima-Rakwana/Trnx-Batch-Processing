package com.redowl.batch_processing.services.transaction;


import com.redowl.batch_processing.dtos.transaction.TReportDto;
import com.redowl.batch_processing.models.transaction.TReport;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TReportModelService {
    TReport getReportDetailsByReportCode(String reportCode);

}
