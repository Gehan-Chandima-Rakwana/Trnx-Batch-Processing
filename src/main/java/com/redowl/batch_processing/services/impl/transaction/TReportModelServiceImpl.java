package com.redowl.batch_processing.services.impl.transaction;

import com.redowl.batch_processing.daos.transaction.TReportDao;
import com.redowl.batch_processing.dtos.transaction.TReportDto;
import com.redowl.batch_processing.exceptions.BadRequestAlertException;
import com.redowl.batch_processing.models.transaction.TReport;
import com.redowl.batch_processing.services.transaction.TReportModelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.hibernate.id.IdentifierGenerator.ENTITY_NAME;

@Slf4j
@Service
public class TReportModelServiceImpl implements TReportModelService {
    private final TReportDao tReportDao;

    public TReportModelServiceImpl(TReportDao tReportDao) {
        this.tReportDao = tReportDao;
    }

    @Override
    public TReport getReportDetailsByReportCode(String reportCode) {
        log.info("Inside TReportModelService: getReportDetailsByReportCode method");
        try {
            Optional<TReport> resultOp = tReportDao.findByReportCodeAndIsActive(reportCode, true);
            System.out.println("Transaction Count"+ resultOp.get().getTTransactions().size());
            TReport response = null;
            TReportDto responseDto = null;
            if (resultOp.isPresent()) {
                response = resultOp.get();
            }

            return response;

        }catch (Exception e){
            e.printStackTrace();
            log.error("Error while ReportDetailsByReportCode: {}", e.getMessage());
            throw new BadRequestAlertException(e.getMessage(), ENTITY_NAME, "error");
        }
    }

}
