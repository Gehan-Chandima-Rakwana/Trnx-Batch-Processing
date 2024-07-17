package com.redowl.batch_processing.services.impl.transaction;


import com.redowl.batch_processing.exceptions.BadRequestAlertException;
import com.redowl.batch_processing.models.transaction.TReport;
import com.redowl.batch_processing.models.transaction.TTransaction;
import com.redowl.batch_processing.services.transaction.TReportModelService;
import com.redowl.batch_processing.services.transaction.XmlReportTagRenderService;
import com.redowl.batch_processing.services.transaction.XmlTransactionTagRenderService;
import com.redowl.batch_processing.xmlProceser.utils.EnumTagVerifier;
import com.redowl.batch_processing.xmlProceser.xmlDto.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hibernate.id.IdentifierGenerator.ENTITY_NAME;

@Slf4j
@Service
public class XmlReportTagRenderServiceImpl implements XmlReportTagRenderService {

    private final TReportModelService tReportModelService;
    private final XmlTransactionTagRenderService xmlTransactionTagRenderService;

    public XmlReportTagRenderServiceImpl(TReportModelService tReportModelService, XmlTransactionTagRenderService xmlTransactionTagRenderService) {
        this.tReportModelService = tReportModelService;
        this.xmlTransactionTagRenderService = xmlTransactionTagRenderService;
    }

    @Override
    public xmlReportDto getRenderedReport(String reportCode) {
        log.info("Inside XmlReportTagRenderService: getRenderedReport method");
        try {
            xmlReportDto xmlReportDto = new xmlReportDto();
            TReport tReportDto = tReportModelService.getReportDetailsByReportCode(reportCode);
            if (tReportDto != null) {
                xmlReportDto.setRentityId(tReportDto.getRentityId());
                xmlReportDto.setRentityBranch(tReportDto.getRentityBranch());
                xmlReportDto.setSubmissionCode(tReportDto.getSubmissionCode());
                xmlReportDto.setReportCode(tReportDto.getReportCode());
                xmlReportDto.setEntityReference(tReportDto.getEntityReference());
                xmlReportDto.setFiuRefNumber(tReportDto.getFiuRefNumber());
                xmlReportDto.setSubmissionDate(LocalDateTime.now());
                xmlCurrencyTypeDto xmlCurrencyTypeDto = new xmlCurrencyTypeDto();
                xmlCurrencyTypeDto.setCurrencyCode("LKR");
                xmlReportDto.setCurrencyCodeLocal(xmlCurrencyTypeDto);
                xmlReportDto.setReason(tReportDto.getReason());
                xmlReportDto.setAction(tReportDto.getAction());

                if (tReportDto.getTTransactions() != null) {
                    List<xmlTransactionDto> transactionList = new ArrayList<>();
                    for (TTransaction transaction : tReportDto.getTTransactions()) {
                        if (EnumTagVerifier.isTagValid("TRANSACTION",transaction.getTrxNo())) {
                            xmlTransactionDto xmlTransactionDto = xmlTransactionTagRenderService.getRenderedTransaction(transaction);
                            transactionList.add(xmlTransactionDto);
                        }
                    }
                    xmlReportDto.setTransaction(transactionList);
                }

//                xmlReportDto.setTransaction(tReportDto.getTransaction());
//                xmlReportDto.setActivity(tReportDto.getActivity());

                //Report Indicators
                xmlReportIndicatorsDto xmlReportIndicatorsDto = new xmlReportIndicatorsDto();
                List<xmlReportIndicatorTypeDto> indicator = new ArrayList<>();
                xmlReportIndicatorTypeDto xmlReportIndicatorTypeDto = new xmlReportIndicatorTypeDto();
                xmlReportIndicatorTypeDto.setValue("CTR");
                indicator.add(xmlReportIndicatorTypeDto);
                xmlReportIndicatorsDto.setIndicator(indicator);
                xmlReportDto.setReportIndicators(xmlReportIndicatorsDto);

            }else{
                xmlReportDto = null;
            }

            return xmlReportDto;

        }catch (Exception e){
            e.printStackTrace();
            log.error("Error while getRenderedReport: {}", e.getMessage());
            throw new BadRequestAlertException(e.getMessage(), ENTITY_NAME, "error");
        }
    }


    public static LocalDateTime convertToLocalDateTime(LocalDate date) {
        return date.atStartOfDay();
    }

    public static String formatLocalDateTime(LocalDateTime localDateTime, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(formatter);
    }

    public static LocalDateTime convertToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }
}
